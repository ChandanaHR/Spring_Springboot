//Injecting dependencies through constructor
//Course.java
package com.example1.demo1;

//Dependency class
public class Course {
	private String coursename;
	
	public Course(String coursename) {
		this.coursename = coursename;
	}

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

//Main bean(constructor injection with @Autowired)
public class Student {
	private String name;
	private Course course;
	public Student(String name, Course course) {
		this.name = name;
		this.course = course;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	@Autowired
//	public void setCourse(Course course) {
//		this.course = course;
//	}
	public void display() {
		System.out.println("Student name=>" +name);
		System.out.println("Course details");
		course.displaydetails();
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
        <constructor-arg value="Spring Framework"></constructor-arg>
    </bean>

    <!-- Main Bean -->
    <bean id="student1" class="com.example1.demo1.Student">
        <constructor-arg value="Krishna"/>
        <constructor-arg ref="course1"/>
    </bean>

</beans>
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
