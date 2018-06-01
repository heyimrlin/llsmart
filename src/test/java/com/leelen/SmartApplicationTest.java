/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月18日下午3:53:53
 * @包名:com.leelen
 * @描述:TODO
 */
package com.leelen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xiaoxl
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmartApplicationTest {

	// @Resource
	// UserService userService;
	//
	// @Resource
	// AdminUserService adminUserService;
	//
	// @Autowired
	// private UserThreeRepository userThreeRepository;

	@Test // 控制台输出~~哈哈
	public void test() {
		System.out.println("测试");
	}

	// @Rule
	// public ContiPerfRule i = new ContiPerfRule();

	/**
	 * 性能测试 10万次查询，100个线程同时操作findAll方法
	 */
	@Test
	// @PerfTest(invocations = 100000, threads = 100)
	public void contextLoads() {
		// userService.findAll();
	}

	// @Test
	// //@PerfTest(invocations = 100000, threads = 100)
	// public void selectData() {
	// User user = userService.findUserById(1);
	// System.out.println(user);
	// }

	@Test
	public void testUpDate() {
		// userThreeRepository.updateTime(new Date().toString(), "002");
		System.out.println("i:");
	}

	// 添加管理员
	// @Test
	// public void addManage() {
	// AdminUser adminUser =new AdminUser();
	// adminUser.setAid(Ramdata.ramdaSw(8));
	// adminUser.setAccount("cs"+Ramdata.ramdaSw(3));
	// adminUser.setPassword(MD5Tools.MD5(Ramdata.ramdaSw(6)));
	// adminUser.setHostname(Ramdata.ramdaSw(3)+"cs");
	// adminUser.setTell("1365"+Ramdata.ramdaSw(7));
	// adminUser.setRoleid(1);
	// adminUser.setToken(Config.GetGUID());
	// adminUserService.save(adminUser);
	// }

}
