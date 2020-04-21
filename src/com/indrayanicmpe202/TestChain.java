package com.indrayanicmpe202;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestChain {
    public static List testHandlers(List cards) {
        Chain chain = new Chain();
        List<Output> cardList = new ArrayList<>();
        //Calling chain of responsibility
        for (Object card : cards) {
            String cardNumber = card.toString();
            String cardType = chain.process(new CreditCard(cardNumber));

            //Calling CreditCard Factory to get appropriate objects
            CreditCardFactory ccf = new CreditCardFactory();
            ICreditCard cc = ccf.getCard(cardType);
            String cardsProduced = cc.printCardType();

            Output output = new Output(cardNumber, cardsProduced, "valid");
                if (cardsProduced.equalsIgnoreCase("Invalid")) {
                    output.setValidity("InvalidCardNumber");
                } else {
                    output.setValidity("None");
                }

                System.out.println("current record: "+ output.toString());
                cardList.add(output);
            }
                 Iterator it = cardList.iterator();
                System.out.println("Card List for output: ");
                 while(it.hasNext()){ System.out.println(it.next() + "");
            }

        return cardList;
        }
    }




