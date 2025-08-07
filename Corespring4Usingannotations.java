//Using annotations for Dependency injection

//Enable @ComponentScan in Appconfig.class
//Annotate beans with @Component annotation
//Sim.java
package com.example1.demo1;

public interface Sim {
	void calling();
	void data();
}


//Airtel.java
package com.example1.demo1;

import org.springframework.stereotype.Component;

@Component
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

import org.springframework.stereotype.Component;

@Component
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
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
		Sim sim1 = (Sim) context.getBean(Airtel.class);
		sim1.calling();
		sim1.data();
	}

}

//Appconfig.java
package com.example1.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.example1")
public class Appconfig {
}

