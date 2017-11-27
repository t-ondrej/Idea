package configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Created by Tomas on 22.11.2017.
 */
@Configuration
@ComponentScan({"services", "dao"})
public class JpaProdConfig extends JpaConfig {

    @Override
    public LocalEntityManagerFactoryBean entityManagerFactory() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("prod");
        return factoryBean;
    }

    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder
                .create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:6844/root")
                .username("root")
                .password("root")
                .build();
    }
}
