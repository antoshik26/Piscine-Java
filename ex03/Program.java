import java.util.Scanner;

class Program{
    public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int i = 1;
		int j = 0;
		int weak_count = 0;
		long all_estimation = 0;
		long reverse_all_estimation = 0;
		int min_estimation = 0;
		int estimation = 0;
		String weak;
		while (i <= 18)
		{
			weak = in.next();
			if (weak.equals("42"))
			{
				break;
			}
			if (!(weak.equals("Week")))
			{
				System.out.print("IllegalArgument");
				System.exit(-1);
			}
			weak_count = in.nextInt();
			if (weak_count != i)
			{
				System.out.print("IllegalArgument");
				System.exit(-1);
			}
			j = 0;
			min_estimation = 0;
			while(j < 5)
			{
				estimation = in.nextInt();
				if (estimation <= 0 || estimation > 9)
				{
					System.out.print("IllegalArgument");
					System.exit(-1);
				}
				if (min_estimation == 0)
				{
					min_estimation = estimation;
				}
				else if (estimation < min_estimation)
				{
					min_estimation = estimation;
				}
				j++;
				
			}
			all_estimation = (all_estimation * 10) + min_estimation;
			i++;
		}
		while (all_estimation > 0)
		{
			reverse_all_estimation = reverse_all_estimation * 10 + all_estimation % 10;
			all_estimation = all_estimation / 10;
		}
		i = 0;
		while (reverse_all_estimation > 0)
		{
			System.out.print("Week ");
			System.out.print(i);
			System.out.print(" ");
			j = 0;
			while (j < reverse_all_estimation % 10)
			{
				System.out.print("=");
				j++;
			}
			reverse_all_estimation = reverse_all_estimation / 10;
			System.out.print(">");
			System.out.println();
			i++;
		}
	}
}