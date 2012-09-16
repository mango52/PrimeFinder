package me.mango.primefinder;

public class PrimeFinder {
	
	//TODO: Multithreading

	private static int maxNumber;
	private static int primes = 0;

	public static void main(String args[]) {
		try {
			maxNumber = Integer.parseInt(args[0]);
		} catch(Exception e) {
			maxNumber = 100000;
			System.out.println("No max number specified - using 100,000");
		}

		for(int i = 2; i <= maxNumber; i++) {
			boolean prime = true;
			for(int a = i-1; a >= 2; a--) {
				if(((int) ((double) i / (double) a) * (double) a) == i) {
					prime = false;
					break;
				}
			}
			if(prime) {
				primes++;
				System.out.println(i);
			}
		}

		System.out.println("Calculations complete");
		System.out.println("Found " + primes + " primes in " + maxNumber +" numbers (" + ((double) primes / (double) maxNumber) * 100 + "%)");
	}
}