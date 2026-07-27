package com.bankapp.config;

import com.bankapp.config.filters.MyFilter;
import com.bankapp.config.handlers.CustomAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity(debug = true)
@EnableMethodSecurity ///spring sec URL + AOP based security (method level security)
public class SecConfig {
    //configure UserDetailsService and some hard coded users

    @Autowired
    private MyFilter myFilter;

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;


    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails raj= User.withUsername("raj")
                .password(passwordEncoder.encode("raj123"))
                .roles("ADMIN")
                .build();

        UserDetails ekta= User.withUsername("ekta")
                .password(passwordEncoder.encode("ekta123"))
                .roles("MGR")
                .build();

        UserDetails gun= User.withUsername("gun")
                .password(passwordEncoder.encode("gun123"))
                .roles("CLERK")
                .build();

        return new InMemoryUserDetailsManager(raj,ekta,gun);

    }
    //configure PasswordEncode
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //configure HttpSecurity
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(registry ->
                        registry.requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
                                .requestMatchers("/clerk/**").hasAnyRole("ADMIN","MGR","CLERK")
                                .requestMatchers("/home/**").permitAll().anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .httpBasic(httpSecurityHttpBasicConfigurer ->
                        httpSecurityHttpBasicConfigurer.authenticationEntryPoint(customAuthenticationEntryPoint))

                .exceptionHandling(hbc-> hbc.accessDeniedHandler(accessDeniedHandler))

                .addFilterAfter(myFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

            return http.build();
    }
}
