import java.util.Scanner;

class Program{
    public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int i = 0;
		int j = 0;
		int k = 0;
		long l = 0;
		int x = 0;
		int z = 0;
		while(i != 42)
		{
			z = 0;
			i = in.nextInt();
			k = 0;
			x = i;
			if (i == 1)
				z = 1;
			while (x > 0)
			{
				k = k + x % 10;
				x = x / 10;
			}
			l = 2;
			while (l * l <= k)
			{
				if (k % l == 0)
				{
					z = 1;
					break;
				}
				l++;
			}
			if (z == 0)
			{
				j = j + 1;
			}
		}
		System.out.print("Count of coffee - request - " + j);
	}
}