package com.indrayanicmpe202;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {

        private String cardNumber;
        private String expirationDate;
        private String nameOfCardholder;

        public CSVFile(String cardNumber, String expirationDate, String nameOfCardholder) {
            this.cardNumber = cardNumber;
            this.expirationDate = expirationDate;
            this.nameOfCardholder = nameOfCardholder;
        }

    @Override
    public String toString() {
        return
                cardNumber;
    }

    public static List readCSV(String inputFile) throws IOException{

        List<CSVFile> creditCards = new ArrayList<>();
        //BufferedReader br = new BufferedReader(new FileReader("/Users/maverick/Downloads/Sample1.csv"));
        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        String line = br.readLine();

        while((line = br.readLine()) != null && !line.isEmpty()) {
            String[] rows = line.split(",");
            String cardNumber = rows[0];
            String expirationDate = rows[1];
            String nameOfCardholder = rows[2];
            CSVFile creditCard = new CSVFile(cardNumber, expirationDate, nameOfCardholder );
            creditCards.add(creditCard);
        }
        br.close();
        return creditCards;
    }

}
