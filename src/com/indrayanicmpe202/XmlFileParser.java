package com.indrayanicmpe202;

import java.io.IOException;
import java.util.List;

import static com.indrayanicmpe202.XMLFile.readXML;

public class XmlFileParser extends FileParser {

    public static void processFile(String inputFile, String outputFile) throws IOException {

        List cards = readXML(inputFile);
        List cardList = TestChain.testHandlers(cards);
        Output.writeXML(outputFile, cardList);
        System.out.println("In XML File parser back from chain of R" + cardList);
    }

}
