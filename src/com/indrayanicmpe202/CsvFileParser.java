package com.indrayanicmpe202;

import java.io.IOException;
import java.util.List;
import static com.indrayanicmpe202.CSVFile.readCSV;

public class CsvFileParser extends FileParser {

    public static void processFile(String inputFile, String outputFile) throws IOException {
        List cards = readCSV(inputFile);
        List cardList = TestChain.testHandlers(cards);
        Output.writeCSV(outputFile, cardList);
    }

}
