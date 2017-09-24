package com.hejianlin.springbootProject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.hejianlin.springbootProject.service")
@EnableAspectJAutoProxy
public class AopConfig {

}
