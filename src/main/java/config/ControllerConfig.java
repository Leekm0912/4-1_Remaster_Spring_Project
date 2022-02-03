package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.HomeController;
import controller.join.JoinController;
import controller.join.JoinService;
import controller.login.LoginController;
import controller.login.LoginService;
import controller.logout.LogOutController;


@Configuration
public class ControllerConfig {
	@Bean
	public HomeController homeController() {
		HomeController c = new HomeController();
		return c;
	}
	
	@Bean
	public LoginController loginController() {
		return new LoginController();
	}
	
	@Bean
	public LoginService loginService() {
		return new LoginService();
	}
	
	@Bean
	public LogOutController logOutController() {
		return new LogOutController();
	}
	
	@Bean
	public JoinController joinController() {
		return new JoinController();
	}
	
	@Bean
	public JoinService joinService() {
		return new JoinService();
	}
}
