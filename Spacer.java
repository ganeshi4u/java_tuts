import java.io.*;
import java.util.*;

class Spacer {
	int n, m, i = 1, l;

	Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
	Vector<Integer> vt = new Vector<Integer>();

	public void input() {
		try {
			System.out.println("Please enter a number");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}

	public void modulus() {
		do {
			m = n % 10;
			n = n / 10;
			ht.put(i, m);
			i++;
		} while (n > 10);
		/* debug msg */
		ht.put(i, n);
		System.out.println("I=" + i);

		reverse(i);
	}

	public void reverse(int i) {
		/* debug msg */
		System.out.println("I in reverse=" + i);

		for (int l = i; l >= 1; l--) {
			vt.addElement((int) ht.get(l));
		}
	}

	public void out() {
		Enumeration e = vt.elements();
		while (e.hasMoreElements()) {
			System.out.print(e.nextElement() + " ");
		}
	}
}

class Main {
	public static void main(String args[]) {
		Spacer s1 = new Spacer();
		s1.input();
		s1.modulus();
		// s1.reverse();
		s1.out();
	}
}