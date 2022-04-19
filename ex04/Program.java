import java.util.Scanner;

class Program{
    public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String text = in.next();
		String letters = "";
		String count_letters = "";
		int ch_len[] = new int[65535];
		int count = 0;
		int i = 0;
		int key = 0;
		while (i < 65535)
		{
			ch_len[i] = 0;
			i++;
		}
		for (char ch : text.toCharArray())
		{	
			key = 0;
			i = 0;
			for (char ch_2 : letters.toCharArray())
			{
				if (ch_2 == ch)
				{
					ch_len[i] = ch_len[i] + 1;
					key = 1;
					break;
				}
				i++;
			}
			if (key == 0)
			{
				letters = letters + ch;
				ch_len[i] = 1;
			}
		}
		char ch_3[] = letters.toCharArray();
		boolean sorted = false;
		int temp;
		char temp_2;
		while(!sorted) 
		{
			sorted = true;
			for (int j = 0; j < letters.length() - 1; j++) 
			{
				if (ch_len[j] < ch_len[j+1]) 
				{
					temp = ch_len[j];
					ch_len[j] = ch_len[j+1];
					ch_len[j+1] = temp;
					sorted = false;
					temp_2 = ch_3[j];
					ch_3[j] = ch_3[j+1];
					ch_3[j+1] = temp_2;
				}
				if (ch_len[j] == ch_len[j+1])
				{
					if (ch_3[j] < ch_3[j+1])
					{
						temp = ch_len[j];
						ch_len[j] = ch_len[j+1];
						ch_len[j+1] = temp;
						sorted = false;
						temp_2 = ch_3[j];
						ch_3[j] = ch_3[j+1];
						ch_3[j+1] = temp_2;
					}
				}
			}
		}
		// i = 0;
		// while (i < letters.length())
		// {
		// 	System.out.print(ch_3[i]);
		// 	System.out.print(ch_len[i]);
		// 	System.out.println();
		// 	i++;
		// }
		double koef = (double)ch_len[0] / 10.0;
		i = 0;
		int j = 0;
		int k = 0;
		if (letters.length() > 10)
			count = 11;
		else
			count = letters.length();
		while(i < count)
		{
			j = 0;
			while (j < k)
			{
				System.out.print("  #");
				// System.out.print(" ");
				j++;
			}
			while (j < count - 1)
			{
				if (koef * (10.0 - i) <= ch_len[j])
				{
					if (ch_len[j] / 10 > 0)
					{
						System.out.print(" ");
						System.out.print(ch_len[j]);
					}
					else
					{
						System.out.print("  ");
						System.out.print(ch_len[j]);
					}
					k++;
				}	
				j++;
			}
			i++;
			System.out.println();
		}
		i = 0;
		System.out.print("  ");
		while (i < count - 1)
		{
			System.out.print(ch_3[i]);
			System.out.print("  ");
			i++;
		}
	}
}