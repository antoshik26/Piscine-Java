import java.util.Scanner;

class Program{
    public static void main(String[] args){
		int a = 479598;
		int b = 0;
		b = b + a % 10;
		a = a / 10;
		b = b + a % 10;
		a = a / 10;
		b = b + a % 10;
		a = a / 10;
		b = b + a % 10;
		a = a / 10;
		b = b + a % 10;
		a = a / 10;
		b = b + a % 10;
		System.out.print(b);
    }
}