/**  
* All rights Reserved, Designed By www.leelen.com
* @Title:  SwaggerConfig.java   
* @Package com.leelen.swagger.config   
* @Description:    TODO(用一句话描述该文件做什么)   
* @author: leelen科技(xiaoxl)     
* @date:   2018年7月27日 上午11:25:08   
* @version V1.0 
* @Copyright: 2018 www.leelen.com Inc. All rights reserved. 
* 注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
*/

package com.leelen.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: SwaggerConfig
 * @Description:TODO Swagger配置config
 * @author: leelen科技(xiaoxl)
 * @date: 2018年7月27日 上午11:25:08
 * 
 * @Copyright: 2018 www.leelen.com Inc. All rights reserved.
 *             注意：本内容仅限于立林科技内部传阅，禁止外泄以及用于其他的商业目的
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
	}
}
