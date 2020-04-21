package com.indrayanicmpe202;

public class Chain {
    Processor chain;

    public Chain(){
        buildChain();
    }

    private void buildChain(){
        chain = new MasterHandler(new VisaHandler(new AmexHandler(new DiscoverHandler(new InvalidHandler(null)))));
    }

    public String process(CreditCard request) {
        String cardType = chain.process(request);
        return cardType;
    }

}