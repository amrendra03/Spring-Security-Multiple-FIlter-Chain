package com.authentication.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.authentication.authentication.service.UserAService;
import com.authentication.authentication.service.UserBService;

@Configuration
@EnableWebSecurity
public class GlobalConfig {

   /*
    * @Configuration
    * 
    * @EnableWebSecurity
    * 
    * public class configA {
    * 
    * @Bean
    * public SecurityFilterChain securityFilterChainA(HttpSecurity http) throws
    * Exception {
    * 
    * http.authorizeHttpRequests(authorize -> authorize
    * .requestMatchers("/signup_a", "/login_a")
    * .permitAll().anyRequest().authenticated())
    * .formLogin(formLogin -> formLogin
    * .loginPage("/login_a")
    * .defaultSuccessUrl("/welcome_a", true)
    * .failureHandler(authenticationFailureHandlerA())
    * .permitAll())
    * .logout(logout -> logout.logoutUrl("/logout") // Custom logout URL
    * .logoutSuccessUrl("/login_a") // Custom logout success page URL
    * .permitAll())
    * .authenticationProvider(authenticationProviderA(userAService));
    * return http.build();
    * }
    * 
    * @Bean
    * public AuthenticationFailureHandler authenticationFailureHandlerA() {
    * return ((request, response, exception) -> {
    * response.sendRedirect("/failed");
    * });
    * }
    * 
    * @Bean
    * public BCryptPasswordEncoder bCryptPasswordEncoderA() {
    * return new BCryptPasswordEncoder();
    * }
    * 
    * private final UserAService userAService;
    * 
    * public configA(UserAService userAService) {
    * this.userAService = userAService;
    * }
    * 
    * @Bean
    * public DaoAuthenticationProvider authenticationProviderA(UserAService
    * userDetailService) {
    * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    * authProvider.setUserDetailsService(userAService);
    * authProvider.setPasswordEncoder(bCryptPasswordEncoderA());
    * return authProvider;
    * }
    * }
    * 
    * @Configuration
    * 
    * @EnableWebSecurity
    * public class configB {
    * 
    * @Bean
    * public SecurityFilterChain securityFilterChainB(HttpSecurity http) throws
    * Exception {
    * 
    * http.authorizeHttpRequests(authorize -> authorize
    * .requestMatchers("/signup_b", "/login_b")
    * .permitAll().anyRequest().authenticated())
    * .formLogin(formLogin -> formLogin
    * .loginPage("/login_b")
    * .defaultSuccessUrl("/welcome_b", true)
    * .failureHandler(authenticationFailureHandlerB())
    * .permitAll())
    * .logout(logout -> logout.logoutUrl("/logout_b") // Custom logout URL
    * .logoutSuccessUrl("/login_b") // Custom logout success page URL
    * .permitAll());
    * return http.build();
    * }
    * 
    * @Bean
    * public AuthenticationFailureHandler authenticationFailureHandlerB() {
    * return ((request, response, exception) -> {
    * response.sendRedirect("/failed");
    * });
    * }
    * 
    * @Bean
    * public BCryptPasswordEncoder bCryptPasswordEncoderB() {
    * return new BCryptPasswordEncoder();
    * }
    * 
    * private final UserBService userBService;
    * 
    * public configB(UserBService userBService) {
    * this.userBService = userBService;
    * }
    * 
    * @Bean
    * public DaoAuthenticationProvider authenticationProviderB(UserBService
    * userDetailService) {
    * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    * authProvider.setUserDetailsService(userBService);
    * authProvider.setPasswordEncoder(bCryptPasswordEncoderB());
    * return authProvider;
    * }
    * }
    * 
    * @Configuration
    * 
    * @EnableWebSecurity
    * 
    * @Order(1)
    * public class configG {
    * 
    * @Bean
    * public SecurityFilterChain securityFilterChainG(HttpSecurity http) throws
    * Exception {
    * 
    * http
    * .authorizeHttpRequests(authorize -> authorize
    * .requestMatchers("/signup_a", "/login_a").permitAll()
    * .requestMatchers("/signup_b", "/login_b").permitAll()
    * .anyRequest().authenticated());
    * return http.build();
    * }
    * }
    * }
    */

   @Bean
   public SecurityFilterChain securityFilterChainA(HttpSecurity http) throws Exception {
      http.securityMatcher("/a/**")
            .authorizeHttpRequests(authorize -> authorize
                  .requestMatchers("/a/signup_a")
                  .permitAll().anyRequest().authenticated())
            .formLogin(formLogin -> formLogin
                  .loginPage("/a/login_a")
                  .defaultSuccessUrl("/a/welcome_a", true)
                  .failureHandler(authenticationFailureHandlerA())
                  .permitAll())
            .logout(logout -> logout.logoutUrl("/a/logout_a") // Custom logout URL
                  .logoutSuccessUrl("/a/login_a") // Custom logout success page URL
                  .permitAll())
            .authenticationProvider(authenticationProviderA(userAService));
      return http.build();
   }

   @Bean
   public SecurityFilterChain securityFilterChainB(HttpSecurity http) throws Exception {
      http.securityMatcher("/b/**")
            .authorizeHttpRequests(authorize -> authorize
                  .requestMatchers("/b/signup_b").permitAll()
                  .anyRequest().authenticated())
            .formLogin(formLogin -> formLogin
                  .loginPage("/b/login_b")
                  .defaultSuccessUrl("/b/welcome_b", true)
                  .failureHandler(authenticationFailureHandlerB())
                  .permitAll())
            .logout(logout -> logout.logoutUrl("/b/logout_b") // Custom logout URL
                  .logoutSuccessUrl("/b/login_b") // Custom logout success page URL
                  .permitAll())
            .authenticationProvider(authenticationProviderB(userBService));
      return http.build();
   }

   @Bean
   public AuthenticationFailureHandler authenticationFailureHandlerA() {
      return ((request, response, exception) -> {
         response.sendRedirect("/failed");
      });
   }

   @Bean
   public AuthenticationFailureHandler authenticationFailureHandlerB() {
      return ((request, response, exception) -> {
         response.sendRedirect("/failed");
      });
   }

   @Bean
   public BCryptPasswordEncoder bCryptPasswordEncoderA() {
      return new BCryptPasswordEncoder();
   }

   @Bean
   public BCryptPasswordEncoder bCryptPasswordEncoderB() {
      return new BCryptPasswordEncoder();
   }

   private final UserAService userAService;

   private final UserBService userBService;

   public GlobalConfig(UserAService userAService, UserBService userBService) {
      this.userAService = userAService;
      this.userBService = userBService;
   }

   @Bean
   public DaoAuthenticationProvider authenticationProviderA(UserAService userDetailService) {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
      authProvider.setUserDetailsService(userDetailService);
      authProvider.setPasswordEncoder(bCryptPasswordEncoderA());
      return authProvider;
   }

   @Bean
   public DaoAuthenticationProvider authenticationProviderB(UserBService userDetailService) {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
      authProvider.setUserDetailsService(userDetailService);
      authProvider.setPasswordEncoder(bCryptPasswordEncoderB());
      return authProvider;
   }
}
