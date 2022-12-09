package com.petrovic.fooddeliveryapi.security;

import com.petrovic.fooddeliveryapi.filter.CORSFilter;
import com.petrovic.fooddeliveryapi.filter.CustomAuthenticationFilter;
import com.petrovic.fooddeliveryapi.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter =
                new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/users/login");
        http.csrf().disable();
        http.cors().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeRequests().antMatchers("/index.html", "*.js", "/", "*.css", "/static/**").permitAll();
        http.authorizeRequests().antMatchers(POST, "/api/users/login").permitAll();
        http.authorizeRequests().antMatchers(POST, "/api/users/register").permitAll();
        http.authorizeRequests().antMatchers(POST, "/api/token/refresh/**").permitAll();
//        http.authorizeRequests().antMatchers(GET, "/api/users/**").hasAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/api/users/name/**").hasAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers(GET, "/api/users/name/").hasAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers(GET, "/api/users/name").hasAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers(POST, "/api/products/**").hasAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(DELETE, "/api/products/**").hasAuthority("ROLE_ADMIN");
        http.authorizeRequests().antMatchers(GET, "/api/products/**").hasAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers( "/api/cart-items/**").hasAuthority("ROLE_USER");
        http.authorizeRequests().antMatchers( "/api/order_request/test").permitAll();
        http.authorizeRequests().antMatchers( "/api/order_request/**").hasAuthority("ROLE_USER");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), CustomAuthenticationFilter.class);
        //http.addFilter(new CORSFilter());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(List.of("x-auth-token"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
