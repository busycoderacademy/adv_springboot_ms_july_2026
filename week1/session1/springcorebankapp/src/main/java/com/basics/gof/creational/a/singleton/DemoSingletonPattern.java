package com.basics.gof.creational.a.singleton;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.io.Serializable;

/*
 	" one object per application" ex logging , db connection etc

	=> lazy vs eager
	=> threading issue, double locking
	=> What if clonned
	=> What if deserilized?
	=> What if used java reflection?
	=> what if 2 class loader load that class twice
	=> best practices, effective java
	=> using enum
 */



final class Singleton implements Cloneable, Serializable {
	private static volatile  Singleton singleton = null;

	private Singleton() {
		if (singleton != null)
			throw new IllegalStateException("someone trying to create another object");
		System.out.println("dare to call it outside the class");
	}

	private Object readResolve() {
		return singleton;
	}

	// race condition: t1 t2, double lock checking?
	public static Singleton getInstance() {
		if (singleton == null) { 
			synchronized (Singleton.class) {
				if (singleton == null) { 
					singleton = new Singleton(); //happen before*
					//1. ctr  and empty object, 2. call ctr , 3. assigned that create object to singleton
					//but it can be re arrange as this 
					//1. ctr  and empty object,  3. assigned that create object to singleton 2. call ctr ,
					//and it will spoil our singleton pattern and if we apply volatile it dont all reordering and 
					//somehow it fix it
					//but volatile keyword introducted in java 1.4 but it was fixed in java 5 (ie before java 5 its behviour is not gurneted)
				}
			}
		}
		return singleton;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("dare not to call clone method");
	}

}

//int i=5;
//long i=5;read in two step
public class DemoSingletonPattern {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, CloneNotSupportedException, FileNotFoundException, IOException {
//		Singleton singletonOb = Singleton.getSingleton();
//
//		System.out.println(singletonOb.hashCode());
//
//		// ser
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("data.ser")));
//		oos.writeObject(singletonOb);
//
//		// de-ser
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("data.ser")));
//		Singleton singleton2 = (Singleton) ois.readObject();
//
//		System.out.println(singleton2.hashCode());

		// ser and de-ser :RMI, distrbuted computing, EJB

		// cloning*
//		Singleton singletonOb2 = (Singleton) singletonOb.clone();
//		System.out.println(singletonOb2.hashCode());

		// java reflection
//		Class<?>clazz=Class.forName("com.dp.creational.a.singleton.Singleton");
//	
//		Constructor[]constructors=clazz.getDeclaredConstructors();
//		constructors[0].setAccessible(true);
//		Singleton singletonOb3 = (Singleton) constructors[0].newInstance();
//		System.out.println(singletonOb3.hashCode());

	}
}
