package com.harman.blockingQueue;

public class Accolite implements A,B,C {
	
	

	public Accolite()  {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int min = Math.min(112, 400);
		int max = Math.max(112, 400);
		System.out.println(" minimum value "+ min +" max value "+max);
		
		
		
		char[] ch = {'a','c','d',5};
		char ca=97;
		System.out.println((char)ca);
		
		Accolite ac = new Accolite();
		System.out.println(ac);
	    Animal a = new Hourse();
	    Animal h = new Hourse();
	    Animal a1 = new Animal();
	    
	    ac.method(a);
	    ac.method(h);
	    ac.method(a1);
	    
	    System.out.println(new Hourse().i);
	}

	@Override
	public int getNum() {
		
		return 0;
	}
	public  void method(Animal a)
	{
		System.out.println("animal version");
	}
	
	public void method(Hourse h)
	{
		System.out.println("Hourse version");
	}

}

interface A {
	int a=5;
	int getNum();
	
}

interface B {
	int a=5;
	int getNum();
}

interface C {
	int a=5;
	int getNum();
}

class Animal {
	public int i=5;
	
	public final void getFinal()
	{
		
	}
}

class Hourse extends Animal {

	public int i=10;

}
