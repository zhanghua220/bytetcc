package com.bytesvc.consumer.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.bytesoft.bytejta.supports.jdbc.LocalXADataSource;
import org.bytesoft.bytetcc.supports.springcloud.config.SpringCloudConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Import(SpringCloudConfiguration.class)
@Configuration
public class ConsumerConfig {

    @Autowired
    SpringDataBaseConfigEntity springDataBaseConfigEntity;

	@Bean(name = "mybatisDataSource")
	public DataSource getDataSourceForMybatis() {
		LocalXADataSource dataSource = new LocalXADataSource();
		dataSource.setDataSource(this.invokeGetDataSource());
		return dataSource;
	}
	public DataSource invokeGetDataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(springDataBaseConfigEntity.getMasterDriverClass());
        bds.setUrl(springDataBaseConfigEntity.getMasterUrl());
        bds.setUsername(springDataBaseConfigEntity.getMasterUser());
        bds.setPassword(springDataBaseConfigEntity.getMasterPassword());
		bds.setMaxTotal(50);
		bds.setInitialSize(20);
		bds.setMaxWaitMillis(60000);
		bds.setMinIdle(6);
		bds.setLogAbandoned(true);
		bds.setRemoveAbandonedOnBorrow(true);
		bds.setRemoveAbandonedOnMaintenance(true);
		bds.setRemoveAbandonedTimeout(1800);
		bds.setTestWhileIdle(true);
		bds.setTestOnBorrow(false);
		bds.setTestOnReturn(false);
		bds.setValidationQuery("select 'x' ");
		bds.setValidationQueryTimeout(1);
		bds.setTimeBetweenEvictionRunsMillis(30000);
		bds.setNumTestsPerEvictionRun(20);
		return bds;
	}

}
