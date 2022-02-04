package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import controller.HomeController;
import controller.join.JoinController;
import controller.join.JoinService;
import controller.login.LoginController;
import controller.login.LoginService;
import controller.logout.LogOutController;


@Configuration
@ComponentScan(
		basePackages = "controller"
		,excludeFilters = @Filter(type=FilterType.REGEX, pattern = "controller\\..*Exception")
)
public class ControllerConfig {
//	@Bean
//	public HomeController homeController() {
//		return new HomeController();
//	}
//	
//	@Bean
//	public LoginController loginController() {
//		return new LoginController();
//	}
//	
//	@Bean
//	public LoginService loginService() {
//		return new LoginService();
//	}
//	
//	@Bean
//	public LogOutController logOutController() {
//		return new LogOutController();
//	}
//	
//	@Bean
//	public JoinController joinController() {
//		return new JoinController();
//	}
//	
//	@Bean
//	public JoinService joinService() {
//		return new JoinService();
//	}
}
