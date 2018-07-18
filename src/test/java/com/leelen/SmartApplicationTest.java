/**
 * @作者:xiaoxl by male
 * @时间:20182018年4月18日下午3:53:53
 * @包名:com.leelen
 * @描述:TODO
 */
package com.leelen;

import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.leelen.test.controller.Task;

/**
 * @author xiaoxl
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
// @SpringApplicationConfiguration(SmartApplication.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootConfiguration
@EnableAsync
@SpringBootTest(classes = SmartApplication.class)
public class SmartApplicationTest {

	@Autowired
	private Task task;

	// @Autowired
	// private StringRedisTemplate stringRedisTemplate;

	// @Autowired
	// private RedisTemplate<String, User> redisTemplate;

	@Test
	public void test() throws Exception {

		// 保存对象
		// User user = new User("超人", 20);
		// redisTemplate.opsForValue().set(user.getUsername(), user);
		//
		// user = new User("蝙蝠侠", 30);
		// redisTemplate.opsForValue().set(user.getUsername(), user);
		//
		// user = new User("蜘蛛侠", 40);
		// redisTemplate.opsForValue().set(user.getUsername(), user);
		//
		// Assert.assertEquals(20,
		// redisTemplate.opsForValue().get("超人").getAge().longValue());
		// Assert.assertEquals(30,
		// redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
		// Assert.assertEquals(40,
		// redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

	}

	// @Resource
	// UserService userService;
	//
	// @Resource
	// AdminUserService adminUserService;
	//
	// @Autowired
	// private UserThreeRepository userThreeRepository;

	@Test // 控制台输出~~哈哈
	public void testt() throws Exception {

		long start = System.currentTimeMillis();

		Future<String> task1 = task.doTaskOne();
		Future<String> task2 = task.doTaskTwo();
		Future<String> task3 = task.doTaskThree();

		while (true) {
			if (task1.isDone() && task2.isDone() && task3.isDone()) {
				// 三个任务都调用完成，退出循环等待
				break;
			}
			Thread.sleep(1000);
		}

		long end = System.currentTimeMillis();

		System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

		// task.doTaskOne();
		// task.doTaskTwo();
		// task.doTaskThree();
		//
		// Thread.currentThread().join();
		// System.out.println("测试");
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
