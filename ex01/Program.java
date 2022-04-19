import java.util.Scanner;

class Program{
    public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int j = 0;
		int i = 2;
		if (a <= 0)
		{
			System.out.print("IllegalArgument");
			System.exit(-1);
		}
		else
		{
			while (i * i <= a)
			{
				if (a % i == 0)
				{
					System.out.print(false + " " + (i - 1));
					j = 1;
					break;
				}
				i++;
			}
			if (a == 1)
			{
				System.out.print(false + " " + (i - 1));
			}
			else if (j == 0)
			{
				System.out.println(true + " " + (i - 1));
			}
		}
	}
}