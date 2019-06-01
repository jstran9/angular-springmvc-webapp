package tran.todd.bookapi.api.v1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;
import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:db.properties") // tell spring where the db.properties file is.
@EnableTransactionManagement
@ComponentScans(value = {
    @ComponentScan("tran.todd.bookapi.api.v1.dao"),
    @ComponentScan("tran.todd.bookapi.api.v1.service")
})
public class AppConfig {

    @Autowired // Spring container will create this for us.
    private Environment environment;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        // read from properties file.
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        Properties props = new Properties();

        // Setting JDBC properties.
        props.put(DRIVER, environment.getProperty("mysql.driver"));
        props.put(URL, environment.getProperty("mysql.URL"));
        props.put(USER, environment.getProperty("mysql.user"));
        props.put(PASS, environment.getProperty("mysql.password"));

        // Setting hibernate properties
        props.put(SHOW_SQL, environment.getProperty("hibernate.show_sql"));
        props.put(HBM2DDL_AUTO, environment.getProperty("hibernate.hbm2ddl.auto"));

        // Setting C3P0 properties.
        props.put(C3P0_MIN_SIZE, environment.getProperty("hibernate.c3p0.min_size"));
        props.put(C3P0_MAX_SIZE, environment.getProperty("hibernate.c3p0.max_size"));
        props.put(C3P0_ACQUIRE_INCREMENT, environment.getProperty("hibernate.c3p0.acquire_increment"));
        props.put(C3P0_TIMEOUT, environment.getProperty("hibernate.c3p0.timeout"));
        props.put(C3P0_MAX_STATEMENTS, environment.getProperty("hibernate.c3p0.max_statements"));

        // set the properties to the factory bean.
        factoryBean.setHibernateProperties(props);
        // Hibernate creates tables based off the model(s) we are scanning
        factoryBean.setPackagesToScan("tran.todd.bookapi.api.v1.model");

        return factoryBean; // return the localization factory bean.
    }

    // Hibernate TransactionManager.
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager; // return Hibernate TransactionManager.
    }
}
