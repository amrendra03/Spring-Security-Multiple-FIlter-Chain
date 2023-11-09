// package com.authentication.authentication.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import
// org.springframework.security.web.authentication.AuthenticationFailureHandler;

// import com.authentication.authentication.service.UserAService;

// @Configuration
// @EnableWebSecurity
// public class ASecurityConfig {

// private final UserAService userDetailService;

// public ASecurityConfig(UserAService userDetailService) {
// this.userDetailService = userDetailService;
// }

// @Bean
// public SecurityFilterChain securityFilterChainA(HttpSecurity httpSecurity)
// throws Exception {
// httpSecurity.authorizeHttpRequests(authorize -> authorize
// .requestMatchers("/signup_a").permitAll()
// .anyRequest().authenticated())
// .formLogin(formLogin -> formLogin
// .loginPage("/login_a")
// .defaultSuccessUrl("/welcome_a", true)
// .failureHandler(authenticationFailureHandlerA())
// .permitAll())
// .logout(logout -> logout.logoutUrl("/logout") // Custom logout URL
// .logoutSuccessUrl("/login_a") // Custom logout success page URL
// .permitAll());

// return httpSecurity.build();
// }

// @Bean
// public AuthenticationFailureHandler authenticationFailureHandlerA() {
// return ((request, response, exception) -> {
// response.sendRedirect("/failed");
// });
// }

// @Bean
// public BCryptPasswordEncoder bCryptPasswordEncoderA() {
// return new BCryptPasswordEncoder();
// }

// @Bean
// public DaoAuthenticationProvider authenticationProviderA() {
// DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
// authProvider.setUserDetailsService(userDetailService);
// authProvider.setPasswordEncoder(bCryptPasswordEncoderA());

// return authProvider;
// }

// }
