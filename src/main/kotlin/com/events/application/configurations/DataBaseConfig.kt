package com.events.application.configurations

import com.events.application.Application
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.annotation.TransactionManagementConfigurer
import java.util.*
import javax.sql.DataSource


/**
 * @author SutulovAI
 *
 * Configuration of DataBase and JPA
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = arrayOf(Application::class))
class DataBaseConfig : TransactionManagementConfigurer {

    @Value("\${dataSource.driverClassName}")
    private val driver: String? = null

    @Value("\${dataSource.url}")
    private val url: String? = null

    @Value("\${dataSource.username}")
    private val username: String? = null

    @Value("\${dataSource.password}")
    private val password: String? = null

    @Value("\${hibernate.dialect}")
    private val dialect: String? = null

    @Bean
    fun configureEntityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val entityManagerFactoryBean = LocalContainerEntityManagerFactoryBean()
        entityManagerFactoryBean.dataSource = configureDataSource()
        entityManagerFactoryBean.setPackagesToScan("com.events.application")
        entityManagerFactoryBean.jpaVendorAdapter = HibernateJpaVendorAdapter()

        val jpaProperties = Properties()
        jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, dialect)
        entityManagerFactoryBean.setJpaProperties(jpaProperties)

        return entityManagerFactoryBean
    }

    @Bean
    fun configureDataSource(): DataSource {
        val config = DriverManagerDataSource()
        config.setDriverClassName(driver)
        config.url = url
        config.username = username
        config.password = password
        return config
    }

    override fun annotationDrivenTransactionManager() = JpaTransactionManager()
}