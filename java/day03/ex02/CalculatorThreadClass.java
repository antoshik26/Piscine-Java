import java.util.ArrayList;
import java.util.List;

public class CalculatorThreadClass extends Thread{
    private List<Integer> _array;
    private int _len;
    private int _start;
    private int _end;
    private int _sum;

    CalculatorThreadClass(List<Integer> array, int len, int start, int end) {
        this._array = array;
        this._len = len;
        this._start = start;
        this._end = end;
    }

    public void run()
    {
        int i = 0;
        int sum = 0;
        while (i < _array.size())
        {
            sum = sum + _array.get(i);
            i++;
        }
        System.out.println("Tread " + this._len + ": from " + this._start + " to " + this._end + "sum is " + sum);
        Program.AddSum(sum);
    }
}
