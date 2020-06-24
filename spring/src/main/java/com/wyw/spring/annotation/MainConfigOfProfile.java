package com.wyw.spring.annotation;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * ${Description}
 *
 * @Profile
 * 根据当前环境动态激活和切换一系列组件（bean）
 *
 * 以数据源为例
 * @Profile  指定组件在哪个环境的情况下才能被注册到容器中，不指定时，任何环境下都能注册
 * 加了环境标识后，只有被激活才能注册到容器中
 * @Profile ("default")可以不指定而被注册
 * 也可以作用于类上，只有为指定环境时整个类中的配置才能生效
 *
 *
 * @author wyw
 * @date 2020/06/23
 */
//@Profile("test")
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private StringValueResolver valueResolver;

    private String driver;

    @Profile("test")
    @Bean("test")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test1");
        dataSource.setDriverClass(driver);
        return dataSource;
    }

    @Profile("dev")
    @Bean("dev")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test2");
        dataSource.setDriverClass(driver);
        return dataSource;
    }

    @Profile("pro")
    @Bean("pro")
    public DataSource dataSourcePro(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test3");
        dataSource.setDriverClass(driver);
        return dataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.valueResolver = valueResolver;
        driver = valueResolver.resolveStringValue("${db.driverClass}");
    }
}
