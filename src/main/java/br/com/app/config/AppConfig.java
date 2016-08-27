package br.com.app.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.app.config.web.WebAppConfig;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan( basePackages = {"br.com.app.*"})
@EnableJpaRepositories( basePackages = {"br.com.app.*"} )
@EnableTransactionManagement
@Import( { WebAppConfig.class } )
public class AppConfig {


	private static final Logger logger = Logger.getLogger(AppConfig.class);
	
	@Autowired
	private Environment env;

	
	/**
	 * Esse método pega o DataSource de Desenvolvimento
	 * @return
	 */
	@Bean( destroyMethod = "close" )
	@Profile("default")
	public DataSource getDataSourceDesenvolvimento()
	{
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName( env.getRequiredProperty( "dev.db.driver" ) );
		dataSourceConfig.setJdbcUrl( env.getRequiredProperty( "dev.db.url" ) );
		dataSourceConfig.setUsername( env.getRequiredProperty( "dev.db.username" ) );
		dataSourceConfig.setPassword( env.getRequiredProperty( "dev.db.password" ) );
		
		logger.info( "DataSource Conectado em Desenvolvimento" );

		return new HikariDataSource( dataSourceConfig );
	}

	
	/**
	 * Esse método pega o DataSource de Produção
	 * @return
	 */
	@Bean( destroyMethod = "close" )
	@Profile("prod")
	public DataSource getDataSourceProducao()
	{
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName( env.getRequiredProperty( "prod.db.driver" ) );
		dataSourceConfig.setJdbcUrl( env.getRequiredProperty( "prod.db.url" ) );
		dataSourceConfig.setUsername( env.getRequiredProperty( "prod.db.username" ) );
		
		dataSourceConfig.setPassword( env.getRequiredProperty( "prod.db.password" ) );

		logger.info( "DataSource Conectado em Produção" );
		
		return new HikariDataSource( dataSourceConfig );
	}


	@Autowired
	private DataSource dataSource;
	
	/**
	 * Pegando o Factory do EntityManager.
	 * 
	 * Mesmo usando JPA dá pra usar o Session do Hibernate.
	 * 
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		DataSource ds = this.dataSource;

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource( ds );
		entityManagerFactoryBean.setPackagesToScan( "br.com.app.model" );
		entityManagerFactoryBean.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );
		entityManagerFactoryBean.setLoadTimeWeaver( new InstrumentationLoadTimeWeaver() );

		Properties jpaProperties = new Properties();

		jpaProperties.put( "hibernate.dialect", env.getRequiredProperty( "hibernate.dialect" ) );
		jpaProperties.put( "hibernate.hbm2ddl.auto", env.getRequiredProperty( "hibernate.hbm2ddl.auto" ) );
		jpaProperties.put( "hibernate.show_sql", env.getRequiredProperty( "hibernate.show_sql" ) );
		jpaProperties.put( "hibernate.format_sql", env.getRequiredProperty( "hibernate.format_sql" ) );
		jpaProperties.put( "hibernate.enable_lazy_load_no_trans", env.getRequiredProperty( "hibernate.enable_lazy_load_no_trans" ) );
		jpaProperties.put( "hibernate.jdbc.batch_size", env.getRequiredProperty( "hibernate.jdbc.batch_size" ) );

		entityManagerFactoryBean.setJpaProperties( jpaProperties );

		return entityManagerFactoryBean;
	}


	@Bean
	public JpaTransactionManager transactionManager( EntityManagerFactory entityManagerFactory )
	{

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory( entityManagerFactory );

		return transactionManager;
	}

	/**
	 * Isso é pra facilitar com Exceções lançadas pelos Repository (os DAOs)
	 * @return
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor()
	{

		PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor = new PersistenceExceptionTranslationPostProcessor();

		return exceptionTranslationPostProcessor;
	}

	/**
	 * Messages
	 * @return
	 */
	@Bean  
    public ResourceBundleMessageSource messageSource() {  
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();  
        source.setBasename("application");  
        source.setUseCodeAsDefaultMessage(true);  
        return source;  
    }  

}
