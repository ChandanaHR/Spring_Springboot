//Demo1Application.java
package com.example1.demo1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
		Student student1 = context.getBean(Student.class);
		System.out.println(student1);
//		SpringApplication.run(Demo1Application.class, args);
	}

}

//Appconfig.java
package com.example1.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {
	@Bean
	public Student student() {
		return new Student("Chandana",25, "cse");
	}
}

//Student.java
package com.example1.demo1;

public class Student {
	private String name;
	private int rollno;
	private String qualification;
	
	public Student() {}
	
	public Student(String name, int rollno, String qualification) {
		super();
		this.name = name;
		this.rollno = rollno;
		this.qualification = qualification;
	}
	
	@Override
	public String toString() {
		return "Student name is" +name+ "with roll no" +rollno+ "and qualification is" +qualification;
	}
	
	
	
}
