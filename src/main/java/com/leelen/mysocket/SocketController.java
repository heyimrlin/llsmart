/**  
* All rights Reserved, Designed By www.leelen.com
* @Title:  SocketController.java   
* @Package com.leelen.mysocket   
* @Description:    TODO(用一句话描述该文件做什么)   
* @author: leelen科技(xiaoxl)     
* @date:   2018年6月29日 上午8:57:55   
* @version V1.0 
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* 注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目
*/

package com.leelen.mysocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.Session;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leelen.my.mycontroller.LeelenRestController;

/**
 * @ClassName: SocketController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: leelen科技(xiaoxl)
 * @date: 2018年6月29日 上午8:57:55
 * 
 * @Copyright: 2018 www.leelen.com Inc. All rights reserved.
 *             注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目
 */
@LeelenRestController
@RequestMapping("/socket")
//@Api(value = "Socket-API", description = "Socket接口")
public class SocketController {

	// 用本地线程保存session
	private static Session session;

	@RequestMapping(value = "/pushVideoListToWeb", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody Map<String, Object> pushVideoListToWeb(@RequestBody Map<String, Object> param) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			// WebSocketServer.sendInfo("有新客户呼入,sltAccountId:"+CommonUtils.getValue(param,
			// "sltAccountId"));
			WebSocketServer.sendInfo("有新客户呼入,sltAccountId:", "ceshi");
			result.put("operationResult", true);
		} catch (IOException e) {
			result.put("operationResult", true);
		}
		return result;
	}

	public void sendMessage(Session session, String message) throws IOException {
		SocketController.session.getBasicRemote().sendText(message);
	}

}
