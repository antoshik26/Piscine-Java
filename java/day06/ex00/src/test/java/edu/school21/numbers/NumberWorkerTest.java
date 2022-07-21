package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NumberWorkerTest {
    private final NumbersWorker numbersWorker = new NumbersWorker();

    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7, 13})
    public void Test1(int candidate) throws NumbersWorker.IllegalNumberException
    {
        Assertions.assertTrue(numbersWorker.isPrime(candidate));
    }

    @ParameterizedTest
    @ValueSource(ints = {12, 4, 6, 10})
    public void Test2(int candidate) throws NumbersWorker.IllegalNumberException{
        Assertions.assertFalse(numbersWorker.isPrime(candidate));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    public void Test3(int candidate) throws NumbersWorker.IllegalNumberException
    {
        Assertions.assertThrows(NumbersWorker.IllegalNumberException.class, () -> {numbersWorker.isPrime(candidate);});
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void Test4(int candidate, int result)
    {
        Assertions.assertEquals(numbersWorker.digitsSum(candidate), result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data_fails.csv")
    public void Test5(int candidate, int result){
        Assertions.assertEquals(numbersWorker.digitsSum(candidate), result);
    }
}
