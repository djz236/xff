/*********************************************************
 *********************************************************
 ********************                  *******************
 *************                                ************
 *******                  _oo0oo_                  *******
 ***                     o8888888o                     ***
 *                       88" . "88                       *
 *                       (| -_- |)                       *
 *                       0\  =  /0                       *
 *                     ___/`---'\___                     *
 *                   .' \\|     |// '.                   *
 *                  / \\|||  :  |||// \                  *
 *                 / _||||| -:- |||||- \                 *
 *                |   | \\\  -  /// |   |                *
 *                | \_|  ''\---/''  |_/ |                *
 *                \  .-\__  '-'  ___/-. /                *
 *              ___'. .'  /--.--\  `. .'___              *
 *           ."" '<  `.___\_<|>_/___.' >' "".            *
 *          | | :  `- \`.;`\ _ /`;.`/ - ` : | |          *
 *          \  \ `_.   \_ __\ /__ _/   .-` /  /          *
 *      =====`-.____`.___ \_____/___.-`___.-'=====       *
 *                        `=---='                        *
 *      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~      *
 *********__佛祖保佑__永无BUG__验收通过__钞票多多__*********
 *********************************************************/
package com.imooc.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

/**
 * @ClassName: WebMvcConfig
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 公司名称
 * @date: 2019年3月13日 下午8:49:31
 * 
 * @Copyright: 2019 www.xxx.com Inc. All rights reserved.
 *             注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter
		implements ApplicationContextAware {// 帮助获取spring上下文
	 @Value("${spring.thymeleaf.cache}")
	    private boolean thymeleafCacheEnable = true;
	private ApplicationContext applicationContext;

	/**
	 * <p>
	 * Title: setApplicationContext
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param arg0
	 * @throws BeansException
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	 /**
     * 静态资源加载配置
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

	/**
	 * @Title: templateResolver @Description: 模板资源解析器 @param: @return @return:
	 * SpringResourceTemplateResolver @throws
	 */
	@Bean
	 @ConfigurationProperties(prefix = "spring.thymeleaf")
	public SpringResourceTemplateResolver templateResolver() {
		 SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
	        templateResolver.setApplicationContext(this.applicationContext);
	        templateResolver.setCharacterEncoding("UTF-8");
	        templateResolver.setCacheable(thymeleafCacheEnable);
	        return templateResolver;
	}

	/**   
	 * @Title: templateEngine   
	 * @Description: thymeleaf 标准方言解释器   
	 * @param: @return      
	 * @return: SpringTemplateEngine      
	 * @throws   
	 */
	@Bean
	public SpringTemplateEngine templateEngine(){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		//支持spring El表达式
		templateEngine.setEnableSpringELCompiler(true);
		//支持springSecurity方言
		SpringSecurityDialect securityDialect = new SpringSecurityDialect();
		templateEngine.addDialect(securityDialect);
		
		return templateEngine;
	}
	
	/**   
	 * @Title: viewResolver   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return      
	 * @return: ThymeleafViewResolver      
	 * @throws   
	 */
	@Bean
	public ThymeleafViewResolver viewResolver(){
		 ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	        viewResolver.setTemplateEngine(templateEngine());
	        return viewResolver;
	}
	  /**
     * Bean Util
     * @return
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
