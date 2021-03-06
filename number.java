import java.io.*;
import java.util.*;
import java.lang.*;


class number{
	int n,m,i=1,l,en;
	String o,h,t;

	Hashtable ht = new Hashtable();
	Hashtable one = new Hashtable() {{ put(1,"one"); put(2,"two"); put(3,"three"); put(4,"four"); put(5,"five"); put(6,"six"); put(7,"seven"); put(8,"eight"); put(9,"nine"); put(10,"ten"); }};
	Hashtable teen = new Hashtable() {{ put(1,"eleven"); put(2,"twelve"); put(3,"thirteen"); put(4,"fourteen"); put(5,"fifteen"); put(6,"sixteen"); put(7,"seventeen"); put(8,"eighteen"); put(9,"nineteen"); }};
	Hashtable ten = new Hashtable() {{ put(2,"twenty"); put(3,"thrity"); put(4,"forty"); put(5,"fifty"); put(6,"sixty"); put(7,"seventy"); put(8,"eighty"); put(9,"ninety"); put(10,"hundred"); }};

	public void input()
	{
		try
		{
		System.out.println("Please enter a number");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		}
		catch(Exception e)
		{
			System.out.println("Invalid input");
		}
	}

	public void modulus()
	{
		do{
			m=n%10;
			n=n/10;
			ht.put(i,m);
			i++;
		}while(n>10);
		ht.put(i,n);
		reverse(i);
	}

	public void reverse(int i)
	{
		for (int l=i; l>=1; l--) {
			TeenCheck(l);
			en=(int)ht.get(l);
			//System.out.print(en+" ");
			check(l,en);
		}
	}

	public void check(int l, int en)
	{
		if (l==1) {
			ones(en);
		} else if(l==2) {
			tens(en);
		} else if(l==3) {
			hundreds(en);
		} else if(l==4) {
			thousands(en);
		} else{
			//notyet();
			System.out.println("PLEASE ENTER A VALUE BELOW THOUSANDS");
			System.exit(0);
		}
	}

	public void TeenCheck(int l)
	{
		if(l==2){
			en=(int)ht.get(l);
			if(en==1)
			{
				l=1;
				en=(int)ht.get(l);
				teens(en);
			}	
		}

	}

	public void ones(int en)
	{
		o=(String)one.get(en);
		System.out.print(o+" ");	
	}

	public void teens(int en)
	{
		t=(String)teen.get(en);
		System.out.print(t+" ");
		System.exit(0); 
	}

	public void tens(int en)
	{
		t=(String)ten.get(en);
		System.out.print(t+" ");
	}

	public void hundreds(int en)
	{
		if (en==10) {
			System.out.print("one thousand");
			System.exit(0);
		}
		System.out.print(one.get(en)+" hundred and"+" ");
	}

	public void thousands(int en)
	{
		System.out.print(one.get(en)+" thousand"+" ");
	}
}

class main{
	public static void main(String args[])
	{
		number n1 = new number();
		n1.input();
		n1.modulus();
	}
}