package school21.spring.contest.Render;

import school21.spring.contest.Processor.PreProcessor;

public class RendererErrImpl implements Renderer {
    PreProcessor proc;
    public RendererErrImpl(PreProcessor proc){
        this.proc = proc;
    }
    public void PrintRender(String print){
        System.out.println(print);
    }
}
