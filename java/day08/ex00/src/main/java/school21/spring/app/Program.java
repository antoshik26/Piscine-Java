package school21.spring.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.contest.Processor.PreProcessor;
import school21.spring.contest.Processor.PreProcessorToLower;
import school21.spring.contest.Processor.PreProcessorToUpperImpl;
import school21.spring.contest.Render.Renderer;
import school21.spring.contest.Render.RendererErrImpl;
import school21.spring.contest.Render.RendererStandardImpl;
import school21.spring.contest.printer.Printer;
import school21.spring.contest.printer.PrinterWithDateTimeImpl;
import school21.spring.contest.printer.PrinterWithPrefixImpl;

public class Program {
    public static void main(String[] args) {

        PreProcessor preProcessor = new PreProcessorToUpperImpl();
        Renderer renderer = new RendererErrImpl(preProcessor);
        PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);
        printer.setPref("Prefix ");
        printer.Print("Hello!");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Printer prefixPrinter1 = context.getBean("PrinterWithPrefixImpl", Printer.class);
        prefixPrinter1.Print("Hello!"); ;

        PreProcessor preProcessor1 = new PreProcessorToLower();
        Renderer rendererErr = new RendererErrImpl(preProcessor1);
        PrinterWithPrefixImpl prefixPrinter2 = new PrinterWithPrefixImpl(rendererErr);
        prefixPrinter2.setPref("12313423423341231)");
        prefixPrinter2.Print("asdasdasdasdsdfgdsfgsadf");

        PreProcessor preProcessor2 = new PreProcessorToUpperImpl();
        Renderer rendererStd = new RendererStandardImpl(preProcessor2);
        PrinterWithDateTimeImpl dateAndTimePrinter1 = new PrinterWithDateTimeImpl(rendererStd);
        dateAndTimePrinter1.Print("Hello");
    }
}
