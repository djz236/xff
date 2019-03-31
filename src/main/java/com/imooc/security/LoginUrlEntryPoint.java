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
package com.imooc.security;
 
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**   
 * @ClassName:  LoginUrlEntryPoint   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 公司名称 
 * @date:   2019年3月25日 下午10:13:45   
 *     
 * @Copyright: 2019 www.xxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目 
 */
public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint{

	private PathMatcher pathMatcher=new AntPathMatcher();
	private final Map<String,String> authEntryPointMap;
	/**   
	 * @Title:  LoginUrlEntryPoint   
	 * @Description:    TODO(这里用一句话描述这个方法的作用)   
	 * @param:  @param loginFormUrl  
	 * @throws   
	 */
	public LoginUrlEntryPoint(String loginFormUrl) {
		super(loginFormUrl);
		authEntryPointMap=new HashMap<>();
		//普通会员登陆入口映射
		authEntryPointMap.put("/user/**", "/user/login");
		//管理员登陆入口映射
		authEntryPointMap.put("/admin/**", "/admin/login");
	}
	/**   
	 * <p>Title: determineUrlToUseForThisRequest</p>   
	 * <p>Description:根据请求跳转到指定的页面，父类是默认使用loginFormUrl </p>   
	 * @param request
	 * @param response
	 * @param exception
	 * @return   
	 * @see org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint#determineUrlToUseForThisRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.AuthenticationException)   
	 */
	@Override
	protected String determineUrlToUseForThisRequest(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception) {
		
		String uri = request.getRequestURI().replace(
				request.getContextPath(), "");
		for(Entry<String,String> authEntry:this.authEntryPointMap.entrySet()){
			if(this.pathMatcher.match(authEntry.getKey(),
					uri)){//匹配预设url
				return authEntry.getValue();
			}
		}
		
		return super.determineUrlToUseForThisRequest(request, response, exception);
	}
	

}
