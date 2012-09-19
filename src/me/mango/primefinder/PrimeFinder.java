package me.mango.primefinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrimeFinder {

	private static int maxNumber;
	private static int primes = 0;
	private static ArrayList<Thread> threads = new ArrayList<Thread>();

	public static void main(String args[]) throws IOException,
	InterruptedException {
		try {
			maxNumber = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.print("How many numbers do you want to check? ");
			InputStreamReader consoleReader = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(consoleReader);
			maxNumber = Integer.parseInt(reader.readLine()); // exception thrown here if the input isn't an integer
			consoleReader.close();
			reader.close();
		}
		dispatchThreads(maxNumber);
		for (Thread t : threads) { // wait for all threads to complete
			t.join();
		}
		System.out.println("Calculations complete");
		System.out.println("Found " + primes + " primes in " + maxNumber + " numbers (" + (((double) primes / (double) maxNumber) * 100) + "%)");
	}

	private static void dispatchThreads(int max) throws InterruptedException { // multi-threading base
		// TODO: multi-core support
		for (int i = 0; i < 1; i++) { // 0 here means we will only use one core
			Thread thread = new Thread(new MathThread(2, max));
			thread.start();
			threads.add(thread);
		}
	}

	public synchronized static void record(int result) {
		primes = primes + result;
	}
}