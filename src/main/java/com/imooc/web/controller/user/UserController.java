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
package com.imooc.web.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**   
 * @ClassName:  UserController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 公司名称 
 * @date:   2019年3月25日 下午10:10:42   
 *     
 * @Copyright: 2019 www.xxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目 
 */
@Controller
public class UserController {

	/**   
	 * @Title: loginPage   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	@GetMapping("/user/login")
	public String loginPage(){
		return "user/login";
	}
	/**   
	 * @Title: centerPage   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	@GetMapping("/user/center")
	public String centerPage(){
		return "user/center";
	}
	
}
