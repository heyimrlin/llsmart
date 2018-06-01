/**
 * @作者:xiaoxl by male
 * @时间:20182018年5月4日下午3:24:23
 * @包名:com.leelen.common.json
 * @描述:TODO
 */
package com.leelen.common.json;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author xiaoxl
 *
 */
public class JsonReturnHandler implements HandlerMethodReturnValueHandler {

	/* (non-Javadoc)
	 * @see org.springframework.web.method.support.HandlerMethodReturnValueHandler#supportsReturnType(org.springframework.core.MethodParameter)
	 */
	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		// TODO Auto-generated method stub
		// 如果有我们自定义的 JSON 注解 就用我们这个Handler 来处理
        boolean hasJsonAnno= returnType.getMethodAnnotation(JSON.class) != null;
        return hasJsonAnno;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.method.support.HandlerMethodReturnValueHandler#handleReturnValue(java.lang.Object, org.springframework.core.MethodParameter, org.springframework.web.method.support.ModelAndViewContainer, org.springframework.web.context.request.NativeWebRequest)
	 */
	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest) throws Exception {
		// TODO Auto-generated method stub
	        // 设置这个就是最终的处理类了，处理完不再去找下一个类进行处理
	        mavContainer.setRequestHandled(true);
	        
	        // 获得注解并执行filter方法 最后返回
	        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
	        Annotation[] annos = returnType.getMethodAnnotations();
	        CustomerJsonSerializer jsonSerializer = new CustomerJsonSerializer();
	        Arrays.asList(annos).forEach(a -> { // 解析注解，设置过滤条件
	            if (a instanceof JSON) {
	                JSON json = (JSON) a;
	                jsonSerializer.filter(json);
	            } else if (a instanceof JSONS) { // 使用多重注解时，实际返回的是 @Repeatable(JSONS.class) 内指定的 @JSONS 注解
	                JSONS jsons = (JSONS) a;
	                Arrays.asList(jsons.value()).forEach(json -> {
	                    jsonSerializer.filter(json);
	                });
	            }
	        });

	        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
	        String json = jsonSerializer.toJson(returnValue);
	        response.getWriter().write(json);
	}
}
