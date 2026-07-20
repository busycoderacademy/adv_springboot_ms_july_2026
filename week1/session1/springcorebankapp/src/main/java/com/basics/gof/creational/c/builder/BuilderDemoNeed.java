package com.basics.gof.creational.c.builder;

public class BuilderDemoNeed {

	public static void main(String[] args) {
		//what parameter stand for what?
//		Food1 food=new Food1("PG", 100, 0, 100, 0, 0, 0);
//		food.setName("cold drink");
//		food.setUnit(400);
//		food.setVitB12(0);
//		food.setVitB5(300);
		
		
	//	System.out.println(food);
		Food food=new Food.Builder("PG", 100)
				.vitA(120)
				.vitB12(1200)
				.build();
		
		
	}
}
