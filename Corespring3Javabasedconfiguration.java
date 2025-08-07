//Use java based configuration for injecting beans
//Appconfig.java
package com.example1.demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Appconfig {
@Bean
public Sim sim() {
	return new Jio();
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
		Sim sim1 = (Sim) context.getBean(Sim.class);
		sim1.calling();
		sim1.data();
	}

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
