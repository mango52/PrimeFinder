package me.mango.primefinder;

public class MathThread implements Runnable {

	private int primes;
	private int start;
	private int stop;

	public MathThread(int start, int stop) {
		this.start = start;
		this.stop = stop;
	}

	public void run() {
		for (int i = start; i <= stop; i++) {
			boolean prime = true;
			for (int a = i - 1; a >= 2; a--) {
				if (((int) ((double) i / (double) a) * (double) a) == i) {
					prime = false;
					break;
				}
			}
			if (prime) {
				primes++;
				System.out.println(i);
			}
		}
		PrimeFinder.record(primes);
	}
}