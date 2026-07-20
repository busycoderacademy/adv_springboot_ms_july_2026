package com.basics.gof.creational.e.factory2;

import java.util.List;

public class TextParser {
	
		public TextParser(String fileName) {
			System.out.println("creating text parser...");
		}
	
		public List<Record> parse() {
			System.out.println("creating record list using text parser...");
			return null;
		}
	
	}