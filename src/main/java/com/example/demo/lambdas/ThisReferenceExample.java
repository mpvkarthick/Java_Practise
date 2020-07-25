package com.example.demo.lambdas;

public class ThisReferenceExample {

	public void doProcess(int i, Process p) {
		p.process(i);
	}
	
	public void execute() {
		
		System.out.println(this);
		doProcess(10, p->System.out.println(this));
		
	}
	
	public static void main(String[] args) {
		ThisReferenceExample example =  new ThisReferenceExample();
		//will not work
		//example.doProcess(10, p -> {System.out.println(this)});
		example.doProcess(10, p->System.out.println(p));
		example.execute();
	}
	interface Process{
		
		void process(int i);
	}
	@Override
	public String toString() {
		return "ThisReferenceExample []";
	}
	
	
}
