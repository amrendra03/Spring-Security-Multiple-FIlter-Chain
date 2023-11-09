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

// import com.authentication.authentication.service.UserBService;

// @Configuration
// @EnableWebSecurity
// public class BSecurityConfig {

// private final UserBService userDetailService;

// public BSecurityConfig(UserBService userDetailService) {
// this.userDetailService = userDetailService;
// }

// @Bean
// public SecurityFilterChain securityFilterChainB(HttpSecurity httpSecurity)
// throws Exception {
// httpSecurity.authorizeHttpRequests(authorize -> authorize
// .requestMatchers("/signup_b").permitAll()
// .anyRequest().authenticated())
// .formLogin(formLogin -> formLogin
// .loginPage("/login_b")
// .defaultSuccessUrl("/welcome_b", true)
// .failureHandler(authenticationFailureHandlerB())
// .permitAll())
// .logout(logout -> logout.logoutUrl("/logout_b") // Custom logout URL
// .logoutSuccessUrl("/login_b") // Custom logout success page URL
// .permitAll());

// return httpSecurity.build();
// }

// @Bean
// public AuthenticationFailureHandler authenticationFailureHandlerB() {
// return ((request, response, exception) -> {
// response.sendRedirect("/failed");
// });
// }

// @Bean
// public BCryptPasswordEncoder bCryptPasswordEncoderB() {
// return new BCryptPasswordEncoder();
// }

// @Bean
// public DaoAuthenticationProvider authenticationProviderB() {
// DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
// authProvider.setUserDetailsService(userDetailService);
// authProvider.setPasswordEncoder(bCryptPasswordEncoderB());

// return authProvider;
// }

// }
