package com.basics.gof.structural.a.adaptor;

//adaptoing roundpeg to square pag
public class Demo {

	public static void main(String[] args) {
		
		RoundPeg peg=new RoundPeg();
		PegAdaptor adpt=new PegAdaptor(peg);
		adpt.insert("hello");
	}
}
