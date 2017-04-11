package org.bookstore.conf;

import java.util.Properties;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class JPAConfiguration {
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource((javax.sql.DataSource) dataSource());
		em.setPackagesToScan(new String[] { "br.com.casadocodigo.loja.models" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());
		return em;
	}

@Bean
public DataSource dataSource(){
DriverManagerDataSource dataSource =
new DriverManagerDataSource();
dataSource.setDriverClassName("com.mysql.jdbc.Driver");
dataSource.setUrl(
"jdbc:mysql://localhost:3306/casadocodigo");
dataSource.setUsername( "root" );
dataSource.setPassword( "" );
return (DataSource) dataSource;
}

private Properties additionalProperties() {
Properties properties = new Properties();
properties.setProperty("hibernate.hbm2ddl.auto",
"update");
properties.setProperty("hibernate.dialect",
		"org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
		}
		}
