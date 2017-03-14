package cn.alandelip.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 允许所有的跨域请求，<b>在真实环节中慎用!</b>
 *
 * @author Alan on 2017/2/19
 */
@Configuration
public class CorsConfiguration {
    private org.springframework.web.cors.CorsConfiguration buildConfig() {
        org.springframework.web.cors.CorsConfiguration corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 允许所有的请求源
        corsConfiguration.addAllowedHeader("*"); // 允许所有的Header
        corsConfiguration.addAllowedMethod("*"); // 允许所有的方法
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); //注册这个配置
        return new CorsFilter(source);
    }
}
