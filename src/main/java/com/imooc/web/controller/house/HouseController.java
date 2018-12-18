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
package com.imooc.web.controller.house;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.base.ApiResponse;
import com.imooc.service.ServiceMultiResult;

/**   
 * @ClassName:  HouseController   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 公司名称 
 * @date:   2018年12月10日 上午10:20:54   
 *     
 * @Copyright: 2018 www.xxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目 
 */
@Controller
public class HouseController {
	/**
	 * 获取支持城市列表
	 * 
	 * @return
	 */
	@GetMapping("address/support/cities")
	@ResponseBody
	public ApiResponse getSupportCities() {
	 
		return  null;
	}

	/**
	 * 获取对应城市支持区域列表
	 * 
	 * @param cityEnName
	 * @return
	 */
	@GetMapping("address/support/regions")
	@ResponseBody
	public ApiResponse getSupportRegions(@RequestParam(name = "city_name") String cityEnName) {
		 
		return null;
	}
}
