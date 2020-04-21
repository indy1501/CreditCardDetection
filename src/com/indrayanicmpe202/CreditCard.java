package com.indrayanicmpe202;

public class CreditCard {

    private String cardNumber;
    private String cardType;

    public CreditCard(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {return cardType;}

//    private String cardNumber;
// //   private String handlerWanted;
//
//    public CreditCard(String cardNumber, String handlerWanted) {
//        this.cardNumber = cardNumber;
////        this.handlerWanted = handlerWanted;
//    }
//
//    public String getCardNumber() {
//        return cardNumber;
//    }
//
////    public String getCardType() {
////        return cardNumber;
////    }
//
// //   public String getHandlerWanted() {
// //       return handlerWanted;
// //   }

}
