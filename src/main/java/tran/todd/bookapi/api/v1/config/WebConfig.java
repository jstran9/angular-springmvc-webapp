package tran.todd.bookapi.api.v1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration // tell Spring this is a configuration file.
@EnableWebMvc
@ComponentScan(basePackages = {"tran.todd.bookapi.api.v1.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {
    /*
     * If we don't extend WebMvcConfigurerAdapter then we are not able to achieve "Web MVC".
     * Tells Spring Container that we are using MVC architecture.
     */
}
