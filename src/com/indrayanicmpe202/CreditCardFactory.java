package com.indrayanicmpe202;

public class CreditCardFactory {

    public ICreditCard getCard(String cardType) {
        ICreditCard card = null;
        if (cardType.equalsIgnoreCase("Amex"))
            card = new AmexCC();
         else if (cardType.equalsIgnoreCase("Visa"))
            card = new VisaCC();
         else if (cardType.equalsIgnoreCase("Discover"))
            card = new DiscoverCC();
         else if(cardType.equalsIgnoreCase("Master")){
            card = new MasterCC();
        }else if(cardType.equalsIgnoreCase("Invalid")){
             card = new InvalidCC();
        }
        return card;
    }

//    public boolean verifyAcctNbr(long acctNbr){
//        //will take an account number and check whether it is a valid acct number
//        //Credit card numbers cannot exceed 19 digits
//        int length = String.valueOf(acctNbr).length();
//        if(length > 19){
//            System.out.println(length);
//            return false;
//        }
//        return true;
//    }

}
