package com.jin.config;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;

@Configuration
public class MyBatisConfig implements TransactionManagementConfigurer{
	
	
	@Autowired
	private AppConfig appConfig;
	@Bean("dataSource")
	public DataSource getDataSource() throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		//设置驱动及用户名和密码
		dataSource.setDriverClassName(appConfig.getDriverName());
		dataSource.setUrl(appConfig.getJdbcUrl());
		dataSource.setUsername(appConfig.getUsername());
		dataSource.setPassword(appConfig.getPwd());
		
		dataSource.setFilters("stat");
        List<String> initSqls = new ArrayList<>();
        initSqls.add("set names utf8");
        dataSource.setConnectionInitSqls(initSqls);
        
        return dataSource;
	}
	
	@Bean("sessionFactory")
	public SqlSessionFactory getSessionFactory() throws SQLException {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		
		factoryBean.setDataSource(getDataSource());
		factoryBean.setTypeAliasesPackage("com.jin.mapper");
		//设置分页插件
		PageHelper pageHelper = new PageHelper();
		
		Properties prop = new Properties();
		prop.setProperty("dialect", "mysql");
		prop.setProperty("reasonable", "false");
		prop.setProperty("returnPageInfo", "check");
		prop.setProperty("params", "pageNum=start;count=countSql");
        pageHelper.setProperties(prop);
        // 添加插件
        factoryBean.setPlugins(new Interceptor[]{pageHelper});
        // 添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            factoryBean
                .setMapperLocations(resolver.getResources("classpath*:/META-INF/mybatis/*.xml"));
            return factoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
		
	}
	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		try {
            return new DataSourceTransactionManager(getDataSource());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	
}
