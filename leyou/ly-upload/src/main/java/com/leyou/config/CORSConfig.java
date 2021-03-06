package com.leyou.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CORSConfig {
    @Bean
    public CorsFilter corsFilter(){

        //cors配置
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("OPTIONS");
        configuration.addAllowedMethod("POST");
        configuration.addAllowedOrigin("http://manage.leyou.com");

        configuration.setAllowCredentials(true);

        //过滤地址
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuration);

        return  new CorsFilter(source);
    }
}
