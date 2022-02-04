package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import db.SpringDAO;

@Configuration
@EnableTransactionManagement
public class DBConfig {
	@Autowired
	DataSource ds;
	
	@Configuration
	@Profile("home")
	public static class HomeDataSourceConfig {
		@Value("${db.driver}")
		private String driver;
		@Value("${db.url}")
		private String url;
		@Value("${db.url.args}")
		private String url_args;
		@Value("${db.home.schema}")
		private String schema;
		@Value("${db.home.id}")
		private String id;
		@Value("${db.home.pw}")
		private String pw;
		@Bean(destroyMethod = "close")
		public DataSource dataSource() {
			DataSource ds = new DataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url+schema+url_args);
			ds.setUsername(id);
			ds.setPassword(pw);		
			ds.setInitialSize(2);
			ds.setMaxActive(10);
			ds.setTestWhileIdle(true);
			ds.setMinEvictableIdleTimeMillis(60000 * 3);
			ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
			return ds;
		}
	}
	
	@Configuration
	@Profile("school")
	public class DBSchoolConfig {
		@Value("${db.driver}")
		private String driver;
		@Value("${db.url}")
		private String url;
		@Value("${db.url.args}")
		private String url_args;
		@Value("${db.school.schema}")
		private String schema;
		@Value("${db.school.id}")
		private String id;
//		@Value("${db.school.pw}")
//		private String pw;
		
		@Bean(destroyMethod = "close")
		public DataSource dataSource() {
			DataSource ds = new DataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url+schema+url_args);
			ds.setUsername(id);
			ds.setInitialSize(2);
			ds.setMaxActive(10);
			ds.setTestWhileIdle(true);
			ds.setMinEvictableIdleTimeMillis(60000 * 3);
			ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
			return ds;
		}
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(ds);
		return tm;
	}
	
	@Bean
	public SpringDAO springDAO() {
		return new SpringDAO(ds);
	}
}
