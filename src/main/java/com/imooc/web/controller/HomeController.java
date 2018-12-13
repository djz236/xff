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
package com.imooc.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: HouseController
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 公司名称
 * @date: 2018年12月10日 上午10:18:31
 * 
 * @Copyright: 2018 www.xxx.com Inc. All rights reserved.
 *             注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
public class HomeController {

	/**
	 * @Title: index @Description: 打开主页面 @param: @param
	 *         request @param: @return @return: String @throws
	 */
	@GetMapping("/")
	public String index(HttpServletRequest request) {
		request.setAttribute("name", request.getParameter("name"));
		return "index";
	}

	/**
	 * @Title: notFoundPage @Description:无法找到文件 访问路径出现异常
	 * 向用户友好展示 @param: @return @return: String @throws
	 */
	@GetMapping("/404")
	public String notFoundPage() {
		return "404";
	}

	/**
	 * @Title: accessError @Description: 禁止访问 无权限
	 * 向用户友好展示 @param: @return @return: String @throws
	 */
	@GetMapping("/403")
	public String accessError() {
		return "403";
	}

	/**
	 * @Title: internalError @Description: 内部服务器 处理异常错误
	 * 向用户友好展示 @param: @return @return: String @throws
	 */
	@GetMapping("/500")
	public String internalError() {
		return "500";
	}
}
