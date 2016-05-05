package cz.mendelu.seminar.swi.utils;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.sql.DataSource;

/**
 * Embedded database utility class.
 * Configures necessary beans and provides EmbeddedDatabase.
 *
 * @author Dominik Hanak @domhanak
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@ImportResource("classpath:/appContext.xml")
public class EmbeddedDerbyDatabase {
    
    @Bean
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean jpaFactoryBean = new LocalContainerEntityManagerFactoryBean();
        jpaFactoryBean.setDataSource(db());
        jpaFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        jpaFactoryBean.setLoadTimeWeaver(instrumentationLoadTimeWeaver());
        jpaFactoryBean.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        jpaFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        return jpaFactoryBean;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.DERBY);
        return hibernateJpaVendorAdapter;
    }

    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public LoadTimeWeaver instrumentationLoadTimeWeaver() {
        return new InstrumentationLoadTimeWeaver();
    }

    @Bean
    public DataSource db() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.setName("PokemonLeagueDB");
        return builder.setType(EmbeddedDatabaseType.DERBY).build();
    }

}

