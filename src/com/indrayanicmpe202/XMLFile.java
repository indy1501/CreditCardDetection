package com.indrayanicmpe202;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLFile {

    private String cardNumber;

    public XMLFile(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public static List readXML(String inputFile) throws IOException {
        List<String> creditCards = new ArrayList<>();
        try {

            File fXmlFile = new File(inputFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("row");

            System.out.println("Reading XML input file");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
//                System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
//                    System.out.println("CreditCard id : "
//                            + eElement.getAttribute("id"));
                    String cardNumber = eElement.getElementsByTagName("CardNumber").item(0).getTextContent();
                    System.out.println("Current CardNumber = " + cardNumber);
//                    System.out.println("CardNumber : "
//                            + eElement.getElementsByTagName("CardNumber")
//                            .item(0).getTextContent());
//                    System.out.println("Expiration Date : "
//                            + eElement.getElementsByTagName("ExpirationDate")
//                            .item(0).getTextContent());
//                    System.out.println("Cardholder Name : "
//                            + eElement.getElementsByTagName("NameOfCardholder")
//                            .item(0).getTextContent());
                    System.out.println();
                    XMLFile creditCard = new XMLFile(cardNumber);
                    creditCards.add(creditCard.cardNumber);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return creditCards;
    }

}

