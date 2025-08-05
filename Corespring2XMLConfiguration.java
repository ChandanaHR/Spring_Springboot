//Add spring-context in pom.xml
<dependency>
    			<groupId>org.springframework</groupId>
    			<artifactId>spring-context</artifactId>
    			<version>6.2.8</version>
		</dependency>

  //Sim.java
  package com.example1.demo1;

public interface Sim {
	void calling();
	void data();
}

//Airtel.java
package com.example1.demo1;

public class Airtel implements Sim {

	@Override
	public void calling() {
		// TODO Auto-generated method stub
		System.out.println("Airtel calling");
	}

	@Override
	public void data() {
		// TODO Auto-generated method stub
		System.out.println("Airtel data");
	}

}

//Jio.java
package com.example1.demo1;

public class Jio implements Sim {

	@Override
	public void calling() {
		// TODO Auto-generated method stub
		System.out.println("Jio calling");
	}

	@Override
	public void data() {
		// TODO Auto-generated method stub
		System.out.println("Jio data");
	}
	
}

//Mobile.java
package com.example1.demo1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Sim sim1 = (Sim) context.getBean(Airtel.class);
		sim1.calling();
		sim1.data();
	}

}

//beans.xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id ="airtel" class="com.example1.demo1.Airtel"></bean>
    <bean id="jio" class="com.example1.demo1.Jio"></bean>

</beans>

  //And now if you want to use the Airtel sim so you have to change only inside the beans.xml file. The main method is going to be the same.
