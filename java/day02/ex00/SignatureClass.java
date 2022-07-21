import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class SignatureClass {
    private String _SignatureName;
    private byte[] _SignatureValue;

    public  SignatureClass(String Name, byte[] buf)
    {
        _SignatureName = Name;
        _SignatureValue = buf;
    }

    public String get_SignatureName() {
        return _SignatureName;
    }

    public byte[] get_SignatureValue() {
        return _SignatureValue;
    }

}

