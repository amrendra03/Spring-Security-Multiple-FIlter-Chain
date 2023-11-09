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
