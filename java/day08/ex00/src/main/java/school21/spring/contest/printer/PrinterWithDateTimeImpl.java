package school21.spring.contest.printer;

import school21.spring.contest.Render.Renderer;

import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer{
    Renderer renderer;
    public PrinterWithDateTimeImpl(Renderer renderer){
        this.renderer = renderer;
    }
    public void Print(String PrintString){
        renderer.PrintRender(PrintString + " " + LocalDateTime.now().toString());
    }
}
