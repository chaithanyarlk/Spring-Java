// package com.book.connect.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class ProjectSecurityConfig {

//     @Bean
//     SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

//         // Permit All Requests inside the Web Application
//      //    http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll())
//      //            .formLogin(Customizer.withDefaults())
//      //            .httpBasic(Customizer.withDefaults());

//                 /*org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'defaultSecurityFilterChain' defined in class path resource [com/book/connect/config/ProjectSecurityConfig.class]: Failed to instantiate [org.springframework.security.web.SecurityFilterChain]: Factory method 'defaultSecurityFilterChain' threw exception with message: Pattern cannot be null or empty
//         at org.springframework.beans.factory.support.ConstructorResolver.instantiate(ConstructorResolver.java:651) ~[spring-beans-6.1.4.jar:6.1.4]
//         at org.springframework.beans.factory.support.ConstructorResolver.instantiateUsingFactoryMethod(ConstructorResolver.java:639) ~[spring-beans-6.1.4.jar:6.1.4]

//                  * The provided code snippet configures Spring Security using a fluent API introduced in Spring Security 5.0, which allows for concise and readable configuration of security rules.

// Let's break down each part of the configuration:

// 1. **`http.authorizeRequests(requests -> requests.anyRequest().permitAll())`**:
//    - This method configures authorization rules for incoming HTTP requests.
//    - `requests.anyRequest()` specifies that the authorization rule should apply to any request.
//    - `.permitAll()` allows all requests to be permitted without authentication. This effectively disables security for all endpoints, making them accessible to anyone.
//    - This configuration is often used for public endpoints or for testing purposes but is generally not suitable for production use as it bypasses authentication and authorization checks.

// 2. **`.formLogin(Customizer.withDefaults())`**:
//    - This method configures form-based login authentication.
//    - `.formLogin()` specifies that the application should use form-based login for authentication.
//    - `Customizer.withDefaults()` applies default settings for form-based login, such as the login page URL ("/login") and the default login processing URL ("/login" with HTTP POST).
//    - Form-based login allows users to authenticate using a login form where they provide their username and password.

// 3. **`.httpBasic(Customizer.withDefaults())`**:
//    - This method configures HTTP Basic authentication.
//    - `.httpBasic()` specifies that the application should support HTTP Basic authentication.
//    - `Customizer.withDefaults()` applies default settings for HTTP Basic authentication.
//    - HTTP Basic authentication involves sending the username and password in the HTTP headers with each request. It is less common for web applications but can be useful for APIs or non-browser clients.

// In summary, the provided configuration allows all requests to be permitted without authentication (`permitAll()`), configures form-based login authentication (`formLogin()`), and enables HTTP Basic authentication (`httpBasic()`), all with default settings provided by `Customizer.withDefaults()`. This configuration may be suitable for simple applications or testing purposes but should be adjusted based on specific security requirements for production use.
//                  */

//         // Deny All Requests inside the Web Application
//             /*http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll())
//                 .formLogin(Customizer.withDefaults())
//                 .httpBasic(Customizer.withDefaults());*/

//                 http.csrf((csrf) -> csrf.disable())
//                 .authorizeHttpRequests((requests) -> requests.requestMatchers("/dashboard").authenticated()
//                 .requestMatchers("/", "/home").permitAll()
//                 .requestMatchers("/holidays/**").permitAll()
//                 .requestMatchers("/contact").permitAll()
//                 .requestMatchers("/saveMsg").permitAll()
//                 .requestMatchers("/courses").permitAll()
//                 .requestMatchers("/about").permitAll()
//                 .requestMatchers("/login").permitAll()
//                 .requestMatchers("/assets/**").permitAll())
//                 .formLogin(loginConfigurer -> loginConfigurer.loginPage("/login")
//                         .defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll())
//                 .logout(logoutConfigurer -> logoutConfigurer.logoutSuccessUrl("/login?logout=true")
//                         .invalidateHttpSession(true).permitAll())
//                 .httpBasic(Customizer.withDefaults());

//                 return http.build();

//                 /*
//                  * CSRF stands for Cross-Site Request Forgery. It is a type of attack where a malicious website tricks a user's web browser into performing actions on another website without the user's knowledge or consent. CSRF attacks typically target actions that modify data or perform sensitive operations, such as transferring funds, changing passwords, or deleting accounts.

// To prevent CSRF attacks, web applications implement CSRF protection mechanisms. One common approach is to use CSRF tokens. A CSRF token is a unique token generated by the server and included in forms or requests. When the form is submitted or the request is made, the server verifies that the token sent by the client matches the expected value.

// Spring Security provides built-in support for CSRF protection. By default, CSRF protection is enabled in Spring Security configurations. When CSRF protection is enabled, Spring Security automatically generates CSRF tokens and includes them in forms rendered by the application. When a form is submitted, Spring Security verifies that the CSRF token sent by the client matches the expected value.
//                  */

//     }

//     @Bean
//     public InMemoryUserDetailsManager userDetailsService() {

//      UserDetails user = User.builder()
//                 .username("user")
//                 .password("12345")
//                 .roles("USER")
//                 .build();
//      UserDetails admin = User.builder()
//                 .username("admin")
//                 .password("54321")
//                 .roles("USER", "ADMIN")
//                 .build();
//         return new InMemoryUserDetailsManager(user, admin);
//     }

// }
