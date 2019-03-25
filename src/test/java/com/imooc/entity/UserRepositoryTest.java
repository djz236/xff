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
package com.imooc.entity;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.ApplicationTests;
import com.imooc.repository.UserRepository;

import junit.framework.Assert;

/**   
 * @ClassName:  UserRepositoryTest   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 公司名称 
 * @date:   2019年3月8日 下午10:13:41   
 *     
 * @Copyright: 2019 www.xxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目 
 */
public class UserRepositoryTest extends ApplicationTests {

	@Autowired
	private UserRepository userRepository;
	/*@Test*/
	public void testFineOne(){
		/*User user = userRepository.findOne(1L);
		Assert.assertEquals("wali",user.getName());
		System.out.println("----------------------");*/
	}
}
