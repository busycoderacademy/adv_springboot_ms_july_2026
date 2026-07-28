package com.bankapp.config;

import com.bankapp.config.filters.JwtAuthFilter;
import com.bankapp.config.filters.MyFilter;
import com.bankapp.config.handlers.CustomAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
@EnableMethodSecurity(prePostEnabled = true) ///spring sec URL + AOP based security (method level security)
public class SecConfig {
    //configure UserDetailsService and some hard coded users

    @Autowired
    private MyFilter myFilter;

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    public AuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);

        provider.setPasswordEncoder(passwordEncoder);
        return provider;
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
                .authorizeHttpRequests(auth->
                        auth.requestMatchers("authenticate").permitAll().anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .httpBasic(httpSecurityHttpBasicConfigurer ->
                        httpSecurityHttpBasicConfigurer.authenticationEntryPoint(customAuthenticationEntryPoint))

                .exceptionHandling(hbc-> hbc.accessDeniedHandler(accessDeniedHandler))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

            return http.build();
    }

    //hey spring security i know u will configure AM but i want to use it so give me if ask
    //if i need AM i can autowire it
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception {
        return config.getAuthenticationManager();
    }
}















//                .authorizeHttpRequests(registry ->
//                        registry.requestMatchers("/admin/**").hasRole("ADMIN")
//                                .requestMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
//                                .requestMatchers("/clerk/**").hasAnyRole("ADMIN","MGR","CLERK")
//                                .requestMatchers("/home/**").permitAll()
//                                .anyRequest().authenticated())


//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
//        UserDetails raj= User.withUsername("raj")
//                .password(passwordEncoder.encode("raj123"))
//                .roles("ADMIN")
//                .build();
//
//        UserDetails ekta= User.withUsername("ekta")
//                .password(passwordEncoder.encode("ekta123"))
//                .roles("MGR")
//                .build();
//
//        UserDetails gun= User.withUsername("gun")
//                .password(passwordEncoder.encode("gun123"))
//                .roles("CLERK")
//                .build();
//
//        return new InMemoryUserDetailsManager(raj,ekta,gun);
//
//    }