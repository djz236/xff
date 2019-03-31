package com.imooc.config;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.imooc.security.AuthProvider;
import com.imooc.security.LoginAuthFailHandler;
import com.imooc.security.LoginUrlEntryPoint;
 
/**   
 * @ClassName:  WebSecurityConfig   
 * @Description:Security权限验证配置  
 * @author: 公司名称 
 * @date:   2019年3月15日 下午9:21:07   
 *     
 * @Copyright: 2019 www.xxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目 
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * HTTP权限控制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      /*  http.addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);
*/
        // 资源访问权限
        http.authorizeRequests()
                .antMatchers("/admin/login").permitAll() // 管理员登录入口
                .antMatchers("/static/**").permitAll() // 静态资源
                .antMatchers("/user/login").permitAll() // 用户登录入口
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/user/**").hasAnyRole("ADMIN",
                "USER")
                .and()
                .formLogin()
                .loginProcessingUrl("/login") // 配置角色登录处理入口
              //  .failureHandler(authFailHandler())//登陆失败的相应
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout/page")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(urlEntryPoint())
                .accessDeniedPage("/403");

        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }
 
    /**
     * @throws Exception    
     * @Title: configGloable   
     * @Description: 自定义认证策略   
     * @param: @param builder      
     * @return: void      
     * @throws   
     */
    @Autowired
    public void configGloable (AuthenticationManagerBuilder auth) throws Exception{
    	//auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN").and();
    	auth.authenticationProvider( authProvider()).eraseCredentials(false);
    }
    @Bean
    public AuthProvider authProvider() {
        return new AuthProvider();
    }/*
  @Bean
    public AuthenticationManager authenticationManager() {
        AuthenticationManager authenticationManager = null;
        try {
            authenticationManager =  super.authenticationManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authenticationManager;
    }*/
    /**   
     * @Title: urlEntryPoint   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @return      
     * @return: LoginUrlEntryPoint      
     * @throws   
     */
    @Bean
    public LoginUrlEntryPoint urlEntryPoint(){
    	return new LoginUrlEntryPoint("/user/login");
    }
    /**   
     * @Title: authFailHandler   
     * @Description: TODO(这里用一句话描述这个方法的作用)   
     * @param: @return      
     * @return: LoginAuthFailHandler      
     * @throws   
     */
   /* @Bean
    public LoginAuthFailHandler authFailHandler(){
    	return new LoginAuthFailHandler(urlEntryPoint());
    }*/
 
}
