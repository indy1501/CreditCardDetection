package com.indrayanicmpe202;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.List;

public class Output {
    private String cardNumber;
    private String cardType;
    private String validity;

    public Output() {
    }

    public Output(String cardNumber, String cardType, String validity) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.validity = validity;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getCardType() {
        return cardType;
    }

    public String getValidity() {
        return validity;
    }

    @Override
    public String toString() {
        return cardNumber +"," + cardType + "," + validity;
    }

    public static void writeCSV(String outputFile, List cardList) throws IOException {

        List<Output> cards = cardList;
        FileWriter fw = new FileWriter(outputFile, false);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        String header = "CardNumber,CardType,Error";
        String delimiter = ",";
        pw.append(header);
        pw.append("\n");

        for (Object card : cards) {
            pw.append(card.toString());
            pw.append("\n");
            System.out.println("current card = " + card);
        }

        pw.flush();
        pw.close();
    }


    public static void writeXML(String outputFile, List cardList) {

        DocumentBuilderFactory ccFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder ccBuilder;
        List<Output> cards = cardList;

        try {
            ccBuilder = ccFactory.newDocumentBuilder();
            Document doc = ccBuilder.newDocument();
            Element mainRootElement = doc.createElement("CreditCards");
            doc.appendChild(mainRootElement);

            for (int i = 0; i < cards.size(); i++) {
                mainRootElement.appendChild(getCard(doc, cards.get(i).getCardNumber(), cards.get(i).getCardType(), cards.get(i).getValidity()));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult file = new StreamResult(new File(outputFile));
            transformer.transform(source, file);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Node getCard(Document doc, String cardNumber, String cardType, String validity) {
        Element card = doc.createElement("Card");
        card.appendChild(getCardElements(doc, card, "CardNumber", cardNumber));
        card.appendChild(getCardElements(doc, card, "CardType", cardType));
        card.appendChild(getCardElements(doc, card, "Error", validity));
        return card;
    }

    // utility method to create text node
    private static Node getCardElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}
