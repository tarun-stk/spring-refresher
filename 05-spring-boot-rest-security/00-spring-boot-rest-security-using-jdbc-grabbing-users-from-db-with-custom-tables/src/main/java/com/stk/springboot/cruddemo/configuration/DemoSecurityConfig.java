package com.stk.springboot.cruddemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

//    Add support for JDBC.. no hardcoding users
//    Spring boot auto configures DataSource
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        Tell spring security to use JDBC authentication with our data source
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
//      define custom query for getting user details based on user_id entered in login form
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where members.user_id=?");
//      Define custom query for getting user roles based on user_id entered in login form
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );
//        use HTTP basic authentication
        http.httpBasic(org.springframework.security.config.Customizer.withDefaults());

//        disable cross site request forgery(CSRF)
//        in general, not required for stateless REST APIs that use POST, PUT, DELTE and/or PATCH
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }


}





















