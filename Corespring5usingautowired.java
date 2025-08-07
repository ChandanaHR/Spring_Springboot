//Inject the dependency using @Autowired
//Mobile.java
package com.example1.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {
	
	@Autowired
	private Sim sim;
	
	public void usesim() {
		sim.calling();
		sim.data();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
		Mobile mobile1 = context.getBean(Mobile.class);
		mobile1.usesim();
	}

}
//When we run the above code, Spring will throw a NoUniqueBeanDefinitionException because it finds two beans (Airtel and Jio) of type Sim. To resolve this, we need to specify which bean to inject.
//Fixing The NoUniqueBeanDefinitionException
//Use @Primary annotation
//Mobile.java
package com.example1.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
	
	@Autowired
	private Sim sim;
	
	public void usesim() {
		sim.calling();
		sim.data();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
		Mobile mobile1 = context.getBean(Mobile.class);
		mobile1.usesim();
	}

}
//Airtel.java
package com.example1.demo1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
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
//Appconfig.java
package com.example1.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.example1.demo1")
public class Appconfig {
}

//Use @Qualifier annotation
//Mobile.java
package com.example1.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Mobile {
	
	@Autowired
	@Qualifier("j")
	private Sim sim;
	
	public void usesim() {
		sim.calling();
		sim.data();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
		Mobile mobile1 = context.getBean(Mobile.class);
		mobile1.usesim();
	}

}
//Jio.java
package com.example1.demo1;

import org.springframework.stereotype.Component;

@Component("j")
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
//Apconfig.java
package com.example1.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com.example1.demo1")
public class Appconfig {
}
