package com.investree.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true) //secure definition
public class Oauth2ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    /**
     * Manage resource server.
     */

    @Override
    public void configure(ResourceServerSecurityConfigurer resource) throws Exception {
        super.configure(resource);
    }

    /**
     * Manage endpoints.
     */

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/","","/v1/transaksi", "/user-register/**","/forget-password/**", "/oauth/authorize**", "/login**", "/error**")
                .permitAll()
                .antMatchers("/v1/role-test-global/list-transaksi").hasAnyAuthority("ROLE_READ")
                .antMatchers("/v1/role-test-global/post-transaksi").hasAnyAuthority("ROLE_WRITE")
                .antMatchers("/v1/role-test-global/post-transaksi-user").hasAnyAuthority("ROLE_USER")
                .antMatchers("/v1/role-test-global/post-transaksi-admin").hasAnyAuthority("ROLE_ADMIN")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll()
        ;



//        http.cors()
//                .and()
//                .csrf()
//                .disable()
//                .antMatcher("/**")
//                .authorizeRequests()
//                    .antMatchers("/",  "/oauth/authorize**", "/ar/**", "/api/ar/**", "/login**", "/error**")
//                    .permitAll()
//                .and()
//                .authorizeRequests()
//                    .anyRequest()
//                    .authenticated()
////                .and()
////                    .formLogin()
////                    .permitAll()
//        ;






//        http.requestMatchers()
//                .antMatchers("/api/v1/**")
//                .and()
//                .authorizeRequests()
//                    .antMatchers("/api/v1/**", "/oauth/authorize**", "/login**", "/error**")
//                    .permitAll()
//                .and()
//                .authorizeRequests()
//                    .anyRequest()
//                    .authenticated()
//                .and()
//                    .formLogin()
//                    .permitAll()
//        ;
    }
}
