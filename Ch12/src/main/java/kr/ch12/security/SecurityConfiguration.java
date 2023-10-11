package kr.ch12.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
			/* 사이트 위변조 방지 비활성 */
			.csrf(CsrfConfigurer::disable) // 메서드 참조 연산자(::)로 람다식을 간결하게 표현
			/* 기본 폼 로그인 설정 */
			.formLogin(config -> config.loginPage("/user/login")
										.defaultSuccessUrl("/")
										.usernameParameter("uid")
										.passwordParameter("pass"))
			/* 로그아웃 설정 */
			.logout(config -> config.logoutUrl("/user/logout")
									.logoutSuccessUrl("/"))
			/* OAuth 설정 */
			.oauth2Login(config -> config.loginPage("/user/login")
										 .defaultSuccessUrl("/"))
			/* 인가 권한 설정 */
			.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
									.requestMatchers("/admin/**").hasAuthority("ADMIN")
									.requestMatchers("/manager/**").hasAnyAuthority("ADMIN","MANAGER")
									.requestMatchers("/user/**").permitAll()
									.anyRequest().permitAll());
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
}