package com.aop_basics.proxy;

import org.springframework.stereotype.Component;

@Component
 public class Magician {
		public void doMagic(){
			System.out.println("abra ka dabra...");
		}

	public void doEat(){
		System.out.println("cantenn food is ok ok...");
	}
}