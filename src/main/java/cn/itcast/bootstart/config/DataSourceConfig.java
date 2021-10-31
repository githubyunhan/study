package cn.itcast.bootstart.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;/*使用jta分布式管理，避免了数据脏读*/
@Configuration
public class DataSourceConfig {/*访问多个数据库前，连接配文件，生成数据源*/

    @Bean(initMethod = "init",destroyMethod = "close",name = "primaryDataSource")
    @Primary
    @ConfigurationProperties(prefix = "primarydb")
    public DataSource primaryDataSource(){
        return new AtomikosDataSourceBean();/*AtomikosDataSourceBean属于DataSourceBean的子类*/
    }

    //jta数据源
    @Bean(initMethod = "init",destroyMethod = "close",name = "secondaryDataSource")
    @ConfigurationProperties(prefix = "secondarydb")
    public DataSource secondaryDataSource(){
            return new AtomikosDataSourceBean();
    }

    @Bean
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource primaryDataSource){
        return new JdbcTemplate(primaryDataSource);
    }

    @Bean
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource secondaryJdbcTemplate){
        return new JdbcTemplate(secondaryJdbcTemplate);
    }
}
