package com.example.demoZero;

// import org.apache.catalina.core.ApplicationContext;
// Catalina is the core servlet container for Apache Tomcat
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoZeroApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DemoZeroApplication.class, args);
		// SpringApplication.run(DemoZeroApplication.class, args); - this returns a object of type ApplicationContext
		// ApplicationContext is the IoC container of Spring
		// It stores and manages all Spring-managed objects (Beans)

		// Traditionally I would do this
		// Dev obj = new Dev();
		// obj.build();

		Dev obj = context.getBean(Dev.class);
		obj.build(); // calling the build method of the class Dev

	}

}
