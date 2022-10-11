package com.zookeeper;

public class Bat extends Mammal {
	
	public Bat(int energyLevel) {
		super(energyLevel);
	}
	
	public void fly() {
		System.out.print("REEEEEEEEEEEE woosh");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.print("MUNCH MUNCH MUNCH MUNCH");
		this.energyLevel += 50;
	}
	
	public void attackTown() {
		System.out.print("AHHHHHHHHH WERE ALL GOING TO DIE BY GIANT BAT MONSTER. Then the furry said, 'im okay with that'");
		this.energyLevel -= 100;
	}
}
