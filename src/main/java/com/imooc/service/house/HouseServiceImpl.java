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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.imooc.base.LoginUserUtil;
import com.imooc.entity.House;
import com.imooc.repository.HouseRepository;
import com.imooc.service.ServiceMultiResult;
import com.imooc.service.ServiceResult;
import com.imooc.web.form.DatatableSearch;
import com.imooc.web.form.HouseForm;

/**
 * @ClassName: HouseServiceImpl
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: 公司名称
 * @date: 2018年12月14日 上午11:27:51
 * 
 * @Copyright: 2018 www.xxx.com Inc. All rights reserved.
 *             注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Service
public class HouseServiceImpl implements IHouseService {
	@Autowired
	private HouseRepository mHouseRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Value("${qiniu.cdn.prefix}")
	private String cdnPrefix;

	/**
	 * <p>
	 * Title: save
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param houseForm
	 * @return
	 * @see com.imooc.service.house.IHouseService#save(com.imooc.web.form.HouseForm)
	 */
	@Override
	public ServiceResult<HouseDTO> save(HouseForm houseForm) {
		return null;
	}

	/**
	 * <p>
	 * Title: adminQuery
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param searchBody
	 * @return
	 * @see com.imooc.service.house.IHouseService#adminQuery(com.imooc.web.form.DatatableSearch)
	 */
	@Override
	public ServiceMultiResult<HouseDTO> adminQuery(DatatableSearch searchBody) {
		List<HouseDTO> houseDTOS = new ArrayList<>();
		Sort sort = new Sort(
				Sort.Direction.fromString(searchBody.getDirection()),
				searchBody.getOrderBy());

		int page = searchBody.getStart() / searchBody.getLength();
		Pageable pageable = new PageRequest(page, searchBody.getLength(), sort);

		Specification<House> specification = (root, query, cb) -> {
			Predicate predicate = cb.equal(root.get("adminId"),
					LoginUserUtil.getLoginUserId());
			if (searchBody.getCity() != null) {
				predicate = cb.and(predicate,
						cb.equal(root.get("cityEnName"), searchBody.getCity()));
			}
			if (searchBody.getStatus() != null) {
				predicate = cb.and(predicate,
						cb.equal(root.get("status"), searchBody.getStatus()));
			}
			if (searchBody.getCreateTimeMin() != null) {
				predicate = cb.and(predicate, cb.greaterThanOrEqualTo(
						root.get("createTime"), searchBody.getCreateTimeMin()));
			}
			if (searchBody.getCreateTimeMin() != null) {
				predicate = cb.and(predicate, cb.lessThanOrEqualTo(
						root.get("createTime"), searchBody.getCreateTimeMax()));
			}
			if (searchBody.getTitle() != null) {
				cb.and(predicate, cb.like(root.get("title"),
						"%" + searchBody.getTitle() + "%"));
			}
			return predicate;
		};
		Page<House> houses = mHouseRepository.findAll(specification, pageable);
		houses.forEach(house -> {
			HouseDTO dto = modelMapper.map(house, HouseDTO.class);
			dto.setCover(this.cdnPrefix + house.getCover());
			houseDTOS.add(dto);
		});
		return new ServiceMultiResult<>(houses.getTotalElements(), houseDTOS);
	}

}
