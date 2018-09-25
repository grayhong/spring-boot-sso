package com.grayground.server.config

import com.grayground.server.entity.EmailUser
import com.grayground.server.repository.UserRepository
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@EntityScan(basePackageClasses = [EmailUser::class])
@EnableJpaRepositories(basePackageClasses = [UserRepository::class])
@EnableTransactionManagement(order = 20)
@Configuration
class JpaConfig {

}