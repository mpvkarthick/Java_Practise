package com.example.demo.lambdas;

public class RunnableExample {

	public static void main(String[] args) {
		Thread myThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello thread");
				
			}
		});
		
		myThread.run();
		
		Thread thread = new Thread(()-> System.out.println("Hello Lambda thread"));
		thread.run();
		
	}
}
