package config;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import db.SpringDAO;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = {"db.mybatis"})
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
			ds.setUrl(url + schema + url_args);
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
			ds.setUrl(url + schema + url_args);
			ds.setUsername(id);
			ds.setInitialSize(2);
			ds.setMaxActive(10);
			ds.setTestWhileIdle(true);
			ds.setMinEvictableIdleTimeMillis(60000 * 3);
			ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
			return ds;
		}
	}

	@Configuration
	@Profile("docker")
	public static class DockerDataSourceConfig {
		@Value("${db.driver}")
		private String driver;
		@Value("${db.docker.url}")
		private String url;
		@Value("${db.url.args}")
		private String url_args;
		@Value("${db.docker.schema}")
		private String schema;
		@Value("${db.docker.id}")
		private String id;
		@Value("${db.docker.pw}")
		private String pw;

		@Bean(destroyMethod = "close")
		public DataSource dataSource() {
			DataSource ds = new DataSource();
			ds.setDriverClassName(driver);
			ds.setUrl(url + schema + url_args);
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

	// Spring JDBC 설정
//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		DataSourceTransactionManager tm = new DataSourceTransactionManager();
//		tm.setDataSource(ds);
//		return tm;
//	}

	// 마이바티스 설정
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(ds);
	}

	@Autowired
	ApplicationContext applicationContext;

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws IOException {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(ds);
		factoryBean.setConfigLocation(applicationContext.getResource("classpath:/db/mybatis/mybatis-config.xml"));
		factoryBean.setMapperLocations(applicationContext.getResources("classpath:/db/mybatis/mappers/*.xml"));
		return factoryBean;
	}

	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	@Bean
	public SpringDAO springDAO() {
		return new SpringDAO(ds);
	}
}
