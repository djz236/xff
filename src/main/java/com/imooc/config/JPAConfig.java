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
package com.imooc.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**   
 * @ClassName:  JPAConfig   
 * @Description:TODO(这里用一句话描述这个类的作用)   
 * @author: 公司名称 
 * @date:   2019年3月8日 下午9:42:01   
 *     
 * @Copyright: 2019 www.xxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目 
 */
@Configuration
@EnableJpaRepositories(basePackages="com.imooc.repository")
@EnableTransactionManagement
public class JPAConfig {
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
		HibernateJpaVendorAdapter jpaVendor=new HibernateJpaVendorAdapter();
		jpaVendor.setGenerateDdl(false);//是否生成sql 不生成 把所有的sql生成权限 掌握在自己手里
		
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setJpaVendorAdapter(jpaVendor);//设置jpa适配器
		entityManagerFactoryBean.setPackagesToScan("com.imooc.entity");
		return entityManagerFactoryBean;
		
	}

	/**   
	 * @Title: transactionManager   
	 * @Description: TODO(事务)   
	 * @param: @param factory
	 * @param: @return      
	 * @return: PlatformTransactionManager      
	 * @throws   
	 */
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory factory){
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(factory);
		return transactionManager;
	}
}
