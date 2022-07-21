public class HenThreadClass extends Thread{
    private int _count;
    private Object _obj;
    HenThreadClass(int count, Object obj)
    {
        this._count = count;
        this._obj = obj;
    }
    public void run() {
        int i = 0;
        try {
            while (i < _count)
            {
                synchronized (_obj) {
                    while (!Program.isFlag()) {
                        _obj.wait();
                    }
                    System.out.println("Hen");
                    Program.setFlag(false);
                    _obj.notify();
                }
                i++;
            }
        }
        catch (Exception e){

        }
    }
}
