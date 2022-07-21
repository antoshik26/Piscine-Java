package school21.spring.contest.Render;

import school21.spring.contest.Processor.PreProcessor;

public class RendererStandardImpl implements Renderer{
    PreProcessor proc;

    public RendererStandardImpl(PreProcessor proc){
        this.proc = proc;
    }
    public void PrintRender(String print){
        System.out.println(proc.preProcess(print));
    }
}
