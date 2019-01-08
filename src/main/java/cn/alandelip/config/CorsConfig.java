package cn.alandelip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * cross origin settings, modify it according to requirements
 *
 * @author Alan on 2017/2/19
 */
@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // allow all host origin
        corsConfiguration.addAllowedHeader("*"); // allow all headers
        corsConfiguration.addAllowedMethod("*"); // allow all request methods
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); //register under all apis
        return new CorsFilter(source);
    }
}
