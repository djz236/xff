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
package com.imooc.service;

/**
 * @ClassName: ServiceResult
 * @Description:通用单一结果Service返回结构
 * @author: 公司名称
 * @date: 2018年12月13日 下午6:18:48
 * 
 * @Copyright: 2018 www.xxx.com Inc. All rights reserved.
 *             注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class ServiceResult<T> {
	private boolean success;
	private String message;
	private T result;

	public ServiceResult(boolean success) {
		this.success = success;
	}

	public ServiceResult(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public ServiceResult(boolean success, String message, T result) {
		this.success = success;
		this.message = message;
		this.result = result;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public static <T> ServiceResult<T> success() {
		return new ServiceResult<>(true);
	}
	
	public static<T> ServiceResult<T> of(T result){
		ServiceResult<T> serviceResult=new ServiceResult<>(true);
		serviceResult.setResult(result);
		return serviceResult;
	}
	
	public static<T> ServiceResult<T> notFound(){
		return new ServiceResult<>(false,Message.NOT_FOUND.getValue());
	}
	public enum Message{
		NOT_FOUND("Not Found Resource");
		private String value;

		private Message(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
		
	}
}
