//Injecting dependencies through setter methods
//Course.java
package com.example1.demo1;

//Dependency class
public class Course {
	private String coursename;

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	public void displaydetails() {
		System.out.println("Enrolled in course name" +coursename);
	}
}
//Student.java
package com.example1.demo1;

import org.springframework.beans.factory.annotation.Autowired;

//Main bean(setter injection with @Autowired)
public class Student {
	private String name;
	private Course course;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Autowired
	public void setCourse(Course course) {
		this.course = course;
	}
	public void display() {
		System.out.println("Student name=>" +name);
		System.out.println("Course details");
		course.displaydetails();
	}
}
//Mainapp.java
package com.example1.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mainapp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Student student1 = (Student) context.getBean("student1");
		student1.display();
	}
}
//beans.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
           http://www.springframework.org/schema/beans 
           http://www.springframework.org/schema/beans/spring-beans.xsd
           http://www.springframework.org/schema/context 
           http://www.springframework.org/schema/context/spring-context.xsd">

    <!-- Enable annotation-based configuration -->
    <context:annotation-config/>

    <!-- Dependency Bean -->
    <bean id="course1" class="com.example1.demo1.Course">
        <property name="coursename" value="Springcore"/>
    </bean>

    <!-- Main Bean -->
    <bean id="student1" class="com.example1.demo1.Student">
        <property name="name" value="Chandana HR"/>
    </bean>

</beans>
//Demo1Application.java
package com.example1.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
