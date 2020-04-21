package com.indrayanicmpe202;

abstract class Processor
{
    private Processor processor;


    public Processor(Processor processor){
        this.processor = processor;
    };

    public String process(CreditCard request){
        if(processor != null)
            processor.process(request);
        return null;
    };
}
