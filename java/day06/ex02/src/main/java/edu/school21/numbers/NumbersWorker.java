package edu.school21.numbers;

import java.math.BigInteger;

public class NumbersWorker {

    public boolean isPrime(int number) throws IllegalNumberException
    {
        boolean probablePrime = false;
        BigInteger bigInteger = BigInteger.valueOf(number);
        probablePrime = bigInteger.isProbablePrime((int) Math.log(number));
        if (number <= 1) {
            throw new IllegalNumberException();
        }
        return probablePrime;
    }

    public int digitsSum(int number)
    {
        int sum = 0;
        try {
            while (number > 0)
            {
                sum = sum + number % 10;
                number = number / 10;
            }
            return (sum);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        return (sum);
    }
    public static class IllegalNumberException extends Exception {
        public IllegalNumberException() {
            super();
        }
    }
}
