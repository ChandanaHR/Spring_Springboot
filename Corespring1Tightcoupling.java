//Sim.java
package com.example1.demo1;

public interface Sim {
	void calling();
	void data();
}

//Simname.java
package com.example1.demo1;

public class Simname {
	 class Airtel implements Sim {

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
	 class Jio implements Sim {

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
}

//Mobile.java
package com.example1.demo1;

public class Mobile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Simname outer = new Simname();
		Simname.Airtel inner1 = outer.new Airtel();
		inner1.calling();
		inner1.data();
	}

}
//If we want to access Jio class then we have to manullay create Jio object. This is tight coupling
