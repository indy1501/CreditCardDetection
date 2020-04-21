package com.indrayanicmpe202;

import java.text.MessageFormat;

public class AmexHandler extends Processor {
    public AmexHandler(Processor processor){
        super(processor);

    }

    public String process(CreditCard request)
    {
        String cardNumber = request.getCardNumber();
        String firstDigit = cardNumber.substring(0,1);
        String secondDigit = cardNumber.substring(1,2);
        request.setCardType("Amex");

        if ((firstDigit.equals("3")) && (secondDigit.equals("4") || secondDigit.equals("7")) && (cardNumber.length() == 15)){
            System.out.println(MessageFormat.format("valid amex card first Digit: {0} valid amex card second Digit: {1} and length: {2}",
                    firstDigit,
                    secondDigit,
                    cardNumber.length()));

            System.out.println("Amex : " + request.getCardNumber());
        }
        else
        {
            super.process(request);
        }
        return request.getCardType();
    }
}