package com.indrayanicmpe202;

import java.text.MessageFormat;

public class MasterHandler extends Processor {
    public MasterHandler(Processor processor){
        super(processor);

    }

    public String process(CreditCard request)
    {
        String cardNumber = request.getCardNumber();
        String firstDigit = cardNumber.substring(0,1);
        String secondDigit = cardNumber.substring(1,2);
        int secDigit = Integer.parseInt(secondDigit);
        request.setCardType("Master");

        if((firstDigit.equals("5") && (secDigit >= 1 && secDigit <= 5)) && (cardNumber.length() == 16)){

             System.out.println(MessageFormat.format("valid master card first Digit: {0} and second digit: {1} and length: {2}",
                firstDigit,
                secondDigit,
                cardNumber.length()));

             System.out.println("Master : " + request.getCardNumber());
        }
        else
        {
            super.process(request);
        }
        return request.getCardType();
    }
}
