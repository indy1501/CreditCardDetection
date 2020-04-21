package com.indrayanicmpe202;


import java.text.MessageFormat;

public class VisaHandler extends Processor {
    public VisaHandler(Processor processor){
        super(processor);
    }

    public String process(CreditCard request)
    {
        String cardNumber = request.getCardNumber();
        String firstDigit = cardNumber.substring(0,1);
        request.setCardType("Visa");

        if ((firstDigit.equals("4")) && (cardNumber.length() == 13 || cardNumber.length() == 16)){

            System.out.println(MessageFormat.format("valid visa card first Digit: {0} and length: {1}", firstDigit, cardNumber.length()));
            System.out.println("Visa : " + request.getCardNumber());
        }
        else
        {
            super.process(request);
        }
        return request.getCardType();
    }
}