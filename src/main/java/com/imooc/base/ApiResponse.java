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
package com.imooc.base;

/**
 * @ClassName: ApiResponse
 * @Description:( API格式封装响应实体)
 * @author: 公司名称
 * @date: 2018年12月13日 下午4:54:15
 * 
 * @Copyright: 2018 www.xxx.com Inc. All rights reserved.
 *             注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class ApiResponse {
	/**   
	 * @Fields code : (响应编码)   
	 */
	private int code;
	/**   
	 * @Fields message : (响应提示文本信息)   
	 */
	private String message;
	/**   
	 * @Fields data : (响应数据)   
	 */
	private Object data;
	/**   
	 * @Fields more : (是否存在更多)   
	 */
	private boolean more;
	 
	public ApiResponse(int code, String message, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	public ApiResponse() {
		super();
		this.code = Status.SUCESS.getCode();
		this.message = Status.SUCESS.getMessage();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public boolean isMore() {
		return more;
	}
	public void setMore(boolean more) {
		this.more = more;
	}
	public static ApiResponse ofMessage(int code,String message){
		return new ApiResponse(code, message, null);
	}
	public static ApiResponse ofSuccess(Object data){
		return new ApiResponse(Status.SUCESS.getCode(),
				Status.SUCESS.getMessage(),data);
	}
	public static ApiResponse ofStatus(Status status){
		return new ApiResponse(status.getCode(),
				status.getMessage(), null);
	}
	
	
	public enum Status{
		SUCESS(200,"OK"),
		BAD_REQUEST(400,"Bad Request"),
		NOT_FOUND(404,"Not Found"),
		INTERNAL_SERVER_ERROR(500,"Unknow Internal Error"),
		NOT_VALID_PARAM(40005,"Not valid Params"),
		NOT_SUPPORTED_OPERATION(40006,"Operation not supported"),
		NOT_LOGIN(50000,"Not Login");
		
		private int code;
		private String message;
		
		Status(int code,String message){
			this.code=code;
			this.message=message;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
	}
}
