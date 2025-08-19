//Demo1Application.java
package com.example1.demo1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("beans.xml");
		Student student = (Student) factory.getBean("student"); //id name defined in xml file
		System.out.println(student);
//		SpringApplication.run(Demo1Application.class, args);
	}

}

//beans.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="student" class="com.example1.demo1.Student">
    	<constructor-arg name="name" value="Chandana"/>
    	<constructor-arg name="rollno" value="26"/>
    	<constructor-arg name="qualification" value="cse"/>
    </bean>

</beans>

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
