package com.zookeeper;

public class Gorilla extends Mammal{
	public Gorilla(int energyLevel) {
		super(energyLevel);
	}
	
	public void throwSomething() {
		System.out.print("The Gorilla finna tossed you");
		this.energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.print("The Gorilla has finna munched a banana");
		this.energyLevel += 10;
	}
	
	public void climb() {
		System.out.print("The Gorilla has finna climbed a tree");
		this.energyLevel -= 10;
	}
}
