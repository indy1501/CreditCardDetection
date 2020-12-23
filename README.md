# Credit Card Detection
The Credit Card Problem involves reading credit card records from csv, xml and json files. 
These records are then validated and post processing they are written to the provided output file of chosen format.

The Credit Card Problem - Solution description:

This project will accept 2 files in one of the three formats - csv, json or xml. The input and output files are expected to be in the same format/extension.
The credit card records in the input file are being processed/validated using Chain of Responsibility Design Pattern. 
For every credit card the appropriate object is created using the Factory Pattern at run time. 
Reading the input file and writing to the output file has been done using Strategy Pattern. 
After the credit card records are successfully validated the output file will contain the type/provider (Amex, Visa, MasterCard or Discover) of that particular card and the card number. 
In case of an invalid card number the output file will report an error associated with that particular record.

To run the project - 
1. The jar file is located in the project structure at - out/artifacts/CreditCardSolution_jar
2. The project can be run by navigating to the above folder and using the following command - 

 java -jar CreditCardSolution.jar <input file path> <output file path>
 
3. The project has been tested using jUnit with 92% coverage (excluding getters and setters)

The following conditions are being tested in the project:

1. It is first validated that there are 2 files given as input.
2. Next, the extension of the input file and output file is validated to be of the same format.
3. If the input file is empty, the program will prompt the user to provide a valid input file.
4. If the output file does not exist the program will create the file at the given path/location.
5. All valid credit card records will be written in the output file with no error. While, the invalid records will report an Invalid Card Type error.
