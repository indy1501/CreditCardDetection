package com.indrayanicmpe202;


public class InvalidHandler extends Processor {

    public InvalidHandler(Processor processor){
        super(processor);

    }

    public String process(CreditCard request)
    {
        String cardNumber = request.getCardNumber();
        request.setCardType("Invalid");
        if (!((cardNumber.startsWith("3")) || (cardNumber.startsWith("4")) || (cardNumber.startsWith("5")) || (cardNumber.startsWith("6011"))))
        {

            System.out.println("Invalid : " + request.getCardNumber());

        }
        else
        {
            System.out.println("This is an invalid card type, wont be processed");
        }

        return request.getCardType();
    }
}