/**  
* All rights Reserved, Designed By www.leelen.com
* @Title:  CheckCenterController.java   
* @Package com.leelen.mysocket   
* @Description:    TODO(用一句话描述该文件做什么)   
* @author: leelen科技(xiaoxl)     
* @date:   2018年6月29日 上午9:07:40   
* @version V1.0 
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* 注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目
*/

package com.leelen.mysocket;

import java.io.IOException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.leelen.entitys.RespCode;
import com.leelen.entitys.RespEntity;
import com.leelen.my.mycontroller.LeelenController;

/**
 * @ClassName: CheckCenterController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: leelen科技(xiaoxl)
 * @date: 2018年6月29日 上午9:07:40
 * 
 * @Copyright: 2018 www.leelen.com Inc. All rights reserved.
 *             注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目
 */
@LeelenController
@RequestMapping("/checkcenter")
@Api(value = "CheckCenter-API", description = "数据推送接口")
public class CheckCenterController {

	// 页面请求
	@GetMapping("/socket/{cid}")
	@ApiOperation(value = "页面请求")
	public ModelAndView socket(@PathVariable String cid) {
		ModelAndView mav = new ModelAndView("/login");
		mav.addObject("cid", cid);
		return mav;
	}

	// 推送数据接口
	@ResponseBody
	@RequestMapping(value = "/socket/push/{cid}", method = {RequestMethod.GET, RequestMethod.POST})
	@ApiOperation(value = "数据推送")
	public RespEntity pushToWeb(@PathVariable String cid, String message) {
		try {
			WebSocketServer.sendInfo(message, cid);
		} catch (IOException e) {
			e.printStackTrace();
			return new RespEntity(RespCode.ERROR, cid + "#" + e.getMessage());
			// return ApiReturnUtil.error(cid + "#" + e.getMessage());
		}
		return new RespEntity(RespCode.SUCCESS, cid);
		// return ApiReturnUtil.success(cid);
	}

}

/*
 * <script> var socket; if(typeof(WebSocket) == "undefined") {
 * console.log("您的浏览器不支持WebSocket"); }else{ console.log("您的浏览器支持WebSocket");
 * //实现化WebSocket对象，指定要连接的服务器地址与端口 建立连接 //等同于socket = new
 * //WebSocket("ws://localhost:8083/checkcentersys/websocket/20");*socket=new
 * WebSocket("${basePath}websocket/${cid}".replace("http","ws")); // 打开事件
 * socket.onopen=
 * 
 * function() { console.log("Socket 已打开"); //socket.send("这是来自客户端的消息" +
 * location.href + new Date()); }; //获得消息事件 socket.onmessage = function(msg) {
 * console.log(msg.data); //发现消息进入 开始处理前端触发逻辑 }; //关闭事件 socket.onclose =
 * function() { console.log("Socket已关闭"); }; //发生了错误事件 socket.onerror =
 * function() { alert("Socket发生了错误"); //此时可以尝试刷新页面 } //离开页面时，关闭socket
 * //jquery1.8中已经被废弃，3.0中已经移除 // $(window).unload(function(){ // socket.close();
 * //}); } </script>
 */