package com.example.demo.concurrency;

import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {

	public static ThreadLocal<SimpleDateFormat> dateFormatter = ThreadLocal
			.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));
	
	static ThreadLocal<Integer> tI = new ThreadLocal();

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		
		for (int i=0;i<10;i++) {
			//LocalDate birthDate = LocalDate.now();
			
			executorService.execute(() -> {
				final SimpleDateFormat df = ThreadLocalExample.dateFormatter.get();
				System.out.println(df.getInstance().toString());
			});
		}
		
	}

}
