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
package com.imooc.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.base.ApiDataTableResponse;
import com.imooc.base.ApiResponse;
import com.imooc.service.ServiceMultiResult;
import com.imooc.service.house.HouseDTO;
import com.imooc.service.house.IHouseService;
import com.imooc.web.form.DatatableSearch;

/**   
 * @ClassName:  AdminController   
 * @Description:(管理员后台管理)   
 * @author: 公司名称 
 * @date:   2018年12月13日 下午4:29:48   
 *     
 * @Copyright: 2018 www.xxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目 
 */
@Controller
public class AdminController {
	@Autowired
	public IHouseService houseService;
	/**   
	 * @Title: adminCenterPage   
	 * @Description: (管理员管理房屋的后台中心页面)   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	@GetMapping("/admin/center")
	public String adminCenterPage(){
		return "admin/center";
	}
	/**   
	 * @Title: welcomePage   
	 * @Description:(后台管理欢迎页面)   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	@GetMapping("/admin/welcome")
	public String welcomePage(){
		return "admin/welcome";
	}
	
	/**   
	 * @Title: houseListPage   
	 * @Description: (房源列表页面)   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	@GetMapping("admin/house/list")
	public String houseListPage(){
		return "admin/house-list";
	}
	
	
	/**   
	 * @Title: houses   
	 * @Description: (拉取房源列表页面数据)   
	 * @param: @return      
	 * @return: String      
	 * @throws   
	 */
	@PostMapping("/admin/houses")
	@ResponseBody
	public ApiDataTableResponse houses(
			@ModelAttribute DatatableSearch searchBody){
		
		ServiceMultiResult<HouseDTO> multiResult = houseService.adminQuery(searchBody);
		
		ApiDataTableResponse response = new ApiDataTableResponse(ApiResponse.Status.SUCESS);
		response.setData(multiResult.getResult());
		response.setRecordsFiltered(multiResult.getTotal());
		response.setDraw(searchBody.getDraw());
		return response;
	}
	
	
}
