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