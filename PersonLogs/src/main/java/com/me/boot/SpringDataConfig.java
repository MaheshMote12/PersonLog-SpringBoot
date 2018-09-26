package com.me.boot;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages= {"com.me.boot.repository"})
@EnableJpaAuditing
public class SpringDataConfig {

}
