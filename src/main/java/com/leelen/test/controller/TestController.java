/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月18日下午2:21:54
 * @包名:com.leelen.test.controller
 * @描述:TODO
 */
package com.leelen.test.controller;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.leelen.app.service.MoblieUserService;
import com.leelen.entity.Msg;
import com.leelen.entitys.Administrator;
import com.leelen.entitys.Leelen;
import com.leelen.entitys.R;
import com.leelen.utils.CurrentUserUtils;

/**
 * @author xiaoxl
 *
 */
@Controller
@EnableConfigurationProperties(Leelen.class)
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired // 自动注入，可以直接省略掉set和get，它会帮我们set和get
	Leelen leelen;

	@Resource
	MoblieUserService moblieUserService;

	@Autowired
	private HttpSession session;

	@Autowired
	// private LoginService loginService;

	@Value("${leelen.name}")
	private String name;

	@Value("${leelen.smart}")
	private String smart;

	@RequestMapping("/hello")
	@ResponseBody
	String home() {
		return "Hello,\t" + name + "\t" + smart + "!!!!!";
	}

	@RequestMapping("/test")
	String indexs(Model model) {
		model.addAttribute("theme", "Hello,\t" + name + "\t" + smart + "!");
		return "index";
	}

	@RequestMapping("/sys")
	String test(Model model) {
		model.addAttribute("theme", "登录成功!");
		return "index_v1";
	}

	/*
	 * 跳转登录页面
	 */
	@RequestMapping(value = { "login", "/" }, method = RequestMethod.GET)
	public String toLogin() {
		return "login";
	}

	/*
	 * 登录成功后跳转页面
	 * 
	 * @param name
	 * 
	 * @param password
	 * 
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public R login(Administrator administrator, RedirectAttributes redirect) {
		// try {
		// //user = loginService.login(user);
		// } catch (ServiceException e) {
		// logger.debug(e.getMessage());
		// redirect.addFlashAttribute("err_code", e.getMessage());
		// redirect.addFlashAttribute("user", user);
		// return "redirect:/login";
		// }
		administrator.setAccount("xiaoxl");// 测试数据 用例
		logger.info("用户登录:" + administrator.getAccount());
		CurrentUserUtils.getInstance().serUser(administrator);
		return R.ok();
	}

	@RequestMapping("/list")
	public String list(Model model) {
		// List<MoblieUser> moblieUser=moblieUserService.getUserList();
		// model.addAttribute("moblieUser", moblieUser);
		return "user/list";
	}

	@RequestMapping("/getUsers")
	@ResponseBody
	public <T, E> Msg<T, E> getUsers() {
		// List<MoblieUser> users=moblieUserService.getUserList();
		Msg<T, E> msg = new Msg<>();
		msg.setCode(101);
		msg.setMsg("获取成功");
		// msg.setAccount(users.size());
		// msg.setDatas(users);
		return msg;
	}

	/**
	 * 生成token 非使用
	 * 
	 * @return
	 */
	public static String GetGUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file, Model model) {

		String contentType = file.getContentType();
		String fileName = file.getOriginalFilename();
		/*
		 * System.out.println("fileName-->" + fileName);
		 * System.out.println("getContentType-->" + contentType);
		 */
		// String filePath =
		// request.getSession().getServletContext().getRealPath("imgupload/");
		// try {
		// FileUtil.uploadFile(file.getBytes(), filePath, fileName);
		// } catch (Exception e) {
		// // TODO: handle exception
		// }
		// // 返回json
		// return "uploadimg success";
		//
		String filename;
		try {
			// 上传目录地址
			String uploadDir = request.getSession().getServletContext().getRealPath("/") + "/upload/";// 获取工程的根路径，这个方法比较好用，可以直接在servlet和jsp中使用
			System.out.println("uploadDir:" + uploadDir + ">>>>>>>>>>>>>>:" + request.getServletPath());
			this.getClass().getClassLoader().getResource("").getPath();// 获取工程classes
																		// 下的路径，这个方法可以在任意jsp，servlet，java文件中使用，因为不管是jsp，servlet其实都是java程序，都是一个
																		// class。所以它应该是一个通用的方法。
			// 如果目录不存在,自动创建文件夹
			File dir = new File(uploadDir);
			if (!dir.exists()) {
				dir.mkdir();
			}
			// 上传文件名
			// String contentType = file.getContentType();
			filename = file.getOriginalFilename();
			System.out.println("filename:" + filename);
			System.out.println("contentType:" + contentType);
			// 服务器端保存文件对象 text/plain
			File fileserver = new File(uploadDir + "/" + filename);
			// 将上传的文件写入服务器文件里
			if (contentType.equals("text/plain")) {
				FileOutputStream writerStream = new FileOutputStream(fileserver);

				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(writerStream, "UTF-8"));
				writer.write(fileserver.toString());
				file.transferTo(fileserver);
			} else {
				file.transferTo(fileserver);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("img", "/upload/" + filename);
		model.addAttribute("theme", filename);
		return "index";
	}

	// 下载文件
	@RequestMapping(value = "/testDownload", method = RequestMethod.GET)
	public void testDownload(HttpServletResponse res) {
		String fileName = "upload.jpg";
		res.setHeader("content-type", "application/octet-stream");
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		BufferedInputStream bis = null;
		OutputStream os = null;
		try {
			os = res.getOutputStream();
			bis = new BufferedInputStream(new FileInputStream(new File("d://" + fileName)));
			int i = bis.read(buff);
			while (i != -1) {
				os.write(buff, 0, buff.length);
				os.flush();
				i = bis.read(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("success");
	}
}
