package school21.spring.contest.printer;

import school21.spring.contest.Render.Renderer;

import java.time.LocalDateTime;

public class PrinterWithPrefixImpl implements  Printer{
    Renderer renderer;
    String pref;
    public PrinterWithPrefixImpl(Renderer renderer){
        this.renderer = renderer;
    }

    public void setPref(String pref) {
        this.pref = pref;
    }

    public void Print(String PrintString){
        renderer.PrintRender(pref + PrintString);
    }
}
