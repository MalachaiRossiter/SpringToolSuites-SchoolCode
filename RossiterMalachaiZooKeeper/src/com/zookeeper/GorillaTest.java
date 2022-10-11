package com.zookeeper;

public class GorillaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gorilla gorilla1 = new Gorilla(100);
		
		gorilla1.throwSomething();
		gorilla1.throwSomething();
		gorilla1.throwSomething();
		gorilla1.eatBananas();
		gorilla1.eatBananas();
		gorilla1.climb();
		
		Gorilla gorilla2 = new Gorilla(100000);
		gorilla2.climb();
		gorilla1.displayEnergy();
		
		Bat bat1 = new Bat(3000);
		bat1.attackTown();
		bat1.eatHumans();
		bat1.fly();
	}

}
