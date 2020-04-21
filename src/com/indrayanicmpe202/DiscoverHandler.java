package com.indrayanicmpe202;


import java.text.MessageFormat;

public class DiscoverHandler extends Processor {
    public DiscoverHandler(Processor processor){
        super(processor);

    }

    public String process(CreditCard request)
    {
        String cardNumber = request.getCardNumber();
        String fourDigits = cardNumber.substring(0,4);
        request.setCardType("Discover");

        if ((fourDigits.equals("6011")) && (cardNumber.length() == 16)){

            System.out.println(MessageFormat.format("valid Discover card start sequence: {0} and length: {1}",
                    fourDigits,
                    cardNumber.length()));

            System.out.println("Discover : " + request.getCardNumber());

        }
        else
        {
            super.process(request);
        }
        return request.getCardType();
    }
}