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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName: House
 * @Description:房屋
 * @author: 公司名称
 * @date: 2018年12月10日 上午9:47:04
 * 
 * @Copyright: 2018 www.xxx.com Inc. All rights reserved.
 *             注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Entity
@Table(name = "house")
public class House extends BaseEntity {
	/**
	 * @Fields id :主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * @Fields title :标题
	 */
	private String title;
	/**
	 * @Fields adminId :管理员的id
	 */
	@Column(name = "admin_id")
	private Long adminId;
	/**
	 * @Fields price :价格
	 */
	private int price;

	/**
	 * @Fields area :面积
	 */
	private int area;
	/**
	 * @Fields room : 房间
	 */
	private int room;
	/**
	 * @Fields parlour :客厅
	 */
	private int parlour;

	/**
	 * @Fields bathroom :卫生间
	 */
	private int bathroom;

	/**
	 * @Fields floor : 层
	 */
	private int floor;

	/**
	 * @Fields totalFloor : 总共层数
	 */
	@Column(name = "total_floor")
	private int totalFloor;
	/**
	 * @Fields watchTimes : 被看次数
	 */
	@Column(name = "watch_times")
	private int watchTimes;
	/**
	 * @Fields buildYear : 建立年限
	 */
	@Column(name = "build_year")
	private int buildYear;
	/**
	 * @Fields status :房屋状态 0-未审核 1-审核通过 2-已出租 3-逻辑删除
	 */
	private int status;
	/**
	 * @Fields cityEnName : 城市标记缩写 如 北京bj
	 */
	@Column(name = "city_en_name")
	private String cityEnName;

	/**
	 * @Fields regionEnName : 区域标记缩写 如 朝阳区cyq
	 */
	@Column(name = "region_en_name")
	private String regionEnName;
	/**
	 * @Fields street : 街道
	 */
	private String street;
	/**
	 * @Fields district : 所在小区
	 */
	private String district;
	/**
	 * @Fields direction : 朝向
	 */
	private int direction;
	/**
	 * @Fields cover : 封面
	 */
	private String cover;
	/**
	 * @Fields distanceToSubway : 距地铁距离 默认-1 附近无地铁
	 */
	@Column(name = "distance_to_subway")
	private int distanceToSubway;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getParlour() {
		return parlour;
	}

	public void setParlour(int parlour) {
		this.parlour = parlour;
	}

	public int getBathroom() {
		return bathroom;
	}

	public void setBathroom(int bathroom) {
		this.bathroom = bathroom;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getTotalFloor() {
		return totalFloor;
	}

	public void setTotalFloor(int totalFloor) {
		this.totalFloor = totalFloor;
	}

	public int getWatchTimes() {
		return watchTimes;
	}

	public void setWatchTimes(int watchTimes) {
		this.watchTimes = watchTimes;
	}

	public int getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCityEnName() {
		return cityEnName;
	}

	public void setCityEnName(String cityEnName) {
		this.cityEnName = cityEnName;
	}

	public String getRegionEnName() {
		return regionEnName;
	}

	public void setRegionEnName(String regionEnName) {
		this.regionEnName = regionEnName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getDistanceToSubway() {
		return distanceToSubway;
	}

	public void setDistanceToSubway(int distanceToSubway) {
		this.distanceToSubway = distanceToSubway;
	}
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
}
