package com.indrayanicmpe202;


public class FileParser {
    // this is the parent fileParser class
    // it will take the input and check the extension whether its xml/csv
    //if its csv it will call the CsvFileParser or XMLFileParser

    public String verifyFileExtension(String inputFile, String outputFile) {
        String inputExt = checkInputFile(inputFile); //returns input file extension
        String outputExt = checkOutputFile(outputFile); //returns output file extension
        String format = matchFileType(inputExt, outputExt); //matches both
        return format;
    }


    private static String checkInputFile(String inputFile) {
        String extension;
        System.out.println("Input file: " + inputFile);

        if (inputFile.contains(".csv")) {

            System.out.println("This is a csv file");
            extension = ".csv";

        } else if (inputFile.contains(".xml")) {

            System.out.println("This is an xml file");
            extension = ".xml";

        } else if (inputFile.contains(".json")) {
            System.out.println("This is a json file");
            extension = ".json";

        } else {
            System.out.println("Invalid input format!");
            extension = "invalid";
        }
        return extension;
    }

    private static String checkOutputFile(String outputFile) {
        String extension;
        System.out.println("Output file: " + outputFile);

        if(outputFile.contains(".csv")){

            System.out.println("This is a csv file");
            extension  = ".csv";

        } else if (outputFile.contains(".xml")) {

            System.out.println("This is an xml file");
            extension = ".xml";

        } else if (outputFile.contains(".json")) {

            System.out.println("This is a json file");
            extension = ".json";

        } else {
            System.out.println("Invalid input format!");
            extension = "invalid";
        }
        return extension;
    }

    private String matchFileType(String inputExt, String outputExt) {
        String extension;
        if(inputExt.equals(outputExt)){
            System.out.println("The chosen format is: " + inputExt);
            extension = inputExt;
        } else {
            System.out.println("Mismatched input and output file format");
            extension = "mismatch";
        }
        return extension;
    }

}
