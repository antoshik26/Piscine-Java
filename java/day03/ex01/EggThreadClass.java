public class EggThreadClass extends Thread{
    private int _count;
    private Object _obj;
    EggThreadClass(int count, Object obj)
    {
        this._count = count;
        this._obj = obj;
    }

    public void run() {
        int i = 0;
        try {
            while (i < _count) {
                synchronized (_obj) {
                    while (Program.isFlag()) {
                        _obj.wait();
                    }
                    System.out.println("Egg");
                    Program.setFlag(true);
                    _obj.notify();
                }
                i++;
            }
        }
        catch (Exception e){

        }
    }
}
