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
package com.imooc.service.house;

import com.imooc.service.ServiceMultiResult;
import com.imooc.service.ServiceResult;
import com.imooc.web.form.DatatableSearch;
import com.imooc.web.form.HouseForm;

/**
 * @ClassName: IHouseService
 * @Description:(房屋管理服务接口)
 * @author: 公司名称
 * @date: 2018年12月13日 下午6:17:49
 * 
 * @Copyright: 2018 www.xxx.com Inc. All rights reserved.
 *             注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
 */
public interface IHouseService {

	/**   
	 * @Title: save   
	 * @Description: 新增房源   
	 * @param: @param houseForm
	 * @param: @return      
	 * @return: ServiceResult<HouseDTO>      
	 * @throws   
	 */
	ServiceResult<HouseDTO> save(HouseForm houseForm);

	/**   
	 * @Title: adminQuery   
	 * @Description:  管理员查询房源
	 * @param: @param searchBody
	 * @param: @return      
	 * @return: ServiceMultiResult<HouseDTO>      
	 * @throws   
	 */
	ServiceMultiResult<HouseDTO> adminQuery(DatatableSearch searchBody);

}
