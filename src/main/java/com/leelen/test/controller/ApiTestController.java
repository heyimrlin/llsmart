/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月19日下午4:49:09
 * @包名:com.leelen.test.controller
 * @描述:TODO
 */
package com.leelen.test.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.leelen.entity.ManageMsg;
import com.leelen.entity.Msg;
import com.leelen.entity.R;
import com.leelen.entity.UserEntity;
import com.leelen.msg.config.ApiConfigs;
import com.leelen.publicmethod.MyMethod;
import com.leelen.utils.MD5Tools;

/**
 * @author xiaoxl 测试API 数据
 */
@RestController
@RequestMapping("/api")
public class ApiTestController {

	SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();

	// @Resource
	// UserService userService;
	//
	// @Resource
	// UserThreeService userThreeService;
	//
	//
	// @Autowired//自动注入，可以直接省略掉set和get，它会帮我们set和get
	// UserDao userdao;
	//
	// @Autowired//自动注入，可以直接省略掉set和get，它会帮我们set和get
	// UserThreeDao userThreeDao;
	//
	// @Autowired
	// UserThreeRepository userThreeRepository;
	//
	// @Autowired
	// PlotadvRepository plotadvRepository;

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST }, produces = {
			"application/json;charset=UTF-8" }, consumes = {
					"application/json" }, params = { "name=mike", "pwd=123456" }, headers = { "a=1" })
	public String testApi(HttpServletRequest request, String username, String password, String sign) {
		String srt = request.getParameter("str");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", ApiConfigs.SUCCESS_CODE);
		jsonObject.put("msg", "登录成功");
		// jsonObject.put("token", GetGUID());
		jsonObject.put("token", MD5Tools.getToken("001", "123456", "20180419183700"));
		srt = srt == null ? "fail" : jsonObject.toString();
		return srt;
	}

	// 测试

	@RequestMapping("/getUserList")

	public String returnUser() {
		UserEntity userEntity = new UserEntity();
		UserEntity userEntity2 = new UserEntity();
		userEntity.setId(1);
		userEntity.setName("测试01");
		userEntity.setTel("15359253734");
		userEntity2.setId(2);
		userEntity2.setName("测试02");
		userEntity2.setTel("180132345678");
		List<Object> list = new ArrayList<Object>();
		list.add(userEntity);
		list.add(userEntity2);
		Msg<Object, Object> msg = new Msg<Object, Object>(1, "获取成功", list, list.size());
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter(UserEntity.class, "id", "password");
		return JSONObject.toJSONString(list, filter);
	}

	/**
	 * 生成token
	 * 
	 * @return
	 */
	public static String GetGUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	//
	@RequestMapping("/test")
	public String test(@RequestParam @NotNull String appname) {

		return appname;
	}

	/*
	 * 第一种
	 */
	// @RequestMapping("/testUser")
	// public User testUser() {
	// User user = userService.findUserById(1);
	// return user;
	// }

	/*
	 * 第二种
	 */
	// @RequestMapping("/getU")
	// public User getU() {
	// return userdao.findUser(1);
	// }

	@RequestMapping("/testup")
	public Map<String, Object> testUpDate() {

		// userThreeRepository.updateendTime(dateFormater.format(date).toString(),
		// "002");
		System.out.println("i:");
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("code", 1);
		map.put("msg", "登录成功");
		map.put("data", "");
		return R.ok(map);

	}

	// @RequestMapping("/getUserThree")
	// public UserThree getUserThree(@RequestParam String uid) {
	// return userThreeDao.findUserThreeByUid(uid);
	// }

	// @Log("测试")
	// @RequestMapping("/testJson")
	// // @SerializedField(includes =
	// // {"id","password","roleid","useable"},encode=false)
	// public @ResponseBody List<User> testJson() {
	// List<User> users = userService.getUserList();
	// // Response response = new Response();
	// // response.setCode("0");
	// // response.setMessage("successfully");
	// // response.setData((Serializable) BeanMapper.mapList(users, User.class));
	// return users;
	// }

	@RequestMapping("/tt")
	public @ResponseBody ManageMsg tt() {
		ManageMsg manageMsg = new ManageMsg();
		// Response response = new Response();
		// response.setCode("0");
		// response.setMessage("successfully");
		// response.setData((Serializable) BeanMapper.mapList(users, User.class));
		Map<String, Object> map = new HashMap<String, Object>();// HashMap的Key和Value可以为空，线程不安全
		map.put("username", "11");
		Map<String, Object> map2 = new Hashtable<String, Object>();// Hashtable的Key和Value都不能为空，线程安全
		map2.put("notNullKey", "notNullValue");
		return manageMsg.ok("successfully", map);
	}

	@RequestMapping("/ttt")
	public @ResponseBody ManageMsg ttt() {
		ManageMsg manageMsg = new ManageMsg();
		return manageMsg.error(4, "请求失败");
	}

	// @RequestMapping("/getPlotadv")
	// public List<Plotadv> getPlotadv() {
	// List<Plotadv> list = plotadvRepository.findAll();
	// return list;
	// }
	/*
	 * "0 0 12 * * ?"    每天中午十二点触发 "0 15 10 ? * *"    每天早上10：15触发 "0 15 10 * * ?"  
	 *  每天早上10：15触发 "0 15 10 * * ? *"    每天早上10：15触发 "0 15 10 * * ? 2005"  
	 *  2005年的每天早上10：15触发 "0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发 "0 0/5 14 * * ?"
	 *    每天从下午2点开始到2：55分结束每5分钟一次触发 "0 0/5 14,18 * * ?"  
	 *  每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发 "0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发
	 * "0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发 "0 15 10 ? * MON-FRI"  
	 *  每个周一、周二、周三、周四、周五的10：15触发
	 *
	 */

	@Scheduled(cron = "30 * * * * *")
	public void cron() throws Exception {
		String date = MyMethod.getDate();
		System.out.println("测试执行定时任务(每一分钟的第30秒执行):" + date);
	}

}
