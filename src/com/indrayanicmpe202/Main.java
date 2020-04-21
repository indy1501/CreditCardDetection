package com.indrayanicmpe202;

import java.io.IOException;

public class Main {

        public static void main(String []args) throws IOException {

            //verify if there are 2 input files
            if(args.length == 2){
                String inputFile = args[0];
                String outputFile = args[1];

                FileParser fp = new FileParser();
                String chosenParser = fp.verifyFileExtension(inputFile, outputFile);
                callParser(chosenParser, inputFile, outputFile);

            } else if(args.length == 1){
                System.out.println("This program takes 2 files as input. Please insert one more file");
            } else {
                System.out.println("Invalid number of input files. This program takes 2 files as input.");
            }
        }

    private static void callParser(String chosenParser, String inputFile, String outputFile) throws IOException {

            if(chosenParser.equals(".csv")){
                CsvFileParser.processFile(inputFile, outputFile);
            } else {
                XmlFileParser.processFile(inputFile, outputFile);
            }
    }

}
