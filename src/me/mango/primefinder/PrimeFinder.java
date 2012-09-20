/*
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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

	private static void dispatchThreads(int max) throws InterruptedException {
		// TODO: better work division
		final int cores = Runtime.getRuntime().availableProcessors();
		int numbersPerCore = max/cores;
		for (int i = 0; i < cores; i++) {
			if (i == 0) {
				Thread thread = new Thread(new MathThread(2, numbersPerCore));
				thread.start();
				threads.add(thread);
			} else if ((i+1 == cores) && (((i+1)*numbersPerCore) != max)) { // rounding fix
				Thread thread = new Thread(new MathThread((i*numbersPerCore+1), max));
				thread.start();
				threads.add(thread);
			} else {
				Thread thread = new Thread(new MathThread((i*numbersPerCore+1), ((i+1)*numbersPerCore)));
				thread.start();
				threads.add(thread);
			}
		}
	}

	public synchronized static void record(int result) {
		primes = primes + result;
	}
}