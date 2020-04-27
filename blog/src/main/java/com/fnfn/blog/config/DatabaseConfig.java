package com.fnfn.blog.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 클래스명: <code>DatabaseConfig</code><br>
 *
 * Database, JPA, MyBatis, Transaction 설정
 *
 * @author fnfnk
 * @since 2020. 4. 24.
 *
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * hikariCP 설정 파일 생성
     *
     * @since 2020. 4. 24.
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    /**
     * hikariCP 설정 파일을 이용해서
     * database와 연결하는 dataSource 생성
     *
     * @since 2020. 4. 24.
     * @return
     * @throws Exception
     */
    @Bean
    public DataSource dataSource() throws Exception {
        return new HikariDataSource(hikariConfig());
    }

    /**
     * mybatis sqlSessionFactory 설정
     *
     * @since 2020. 4. 24.
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/mapper/**/*Mapper.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    /**
     * mybatis sqlSessionTemplate 설정
     *
     * @since 2020. 4. 24.
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * spring이 제공하는 transactionManager 등록
     *
     * @since 2020. 4. 24.
     * @return
     * @throws Exception
     */
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }
}
