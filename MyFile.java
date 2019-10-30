// Import all modules used
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/**
 * MyFile
 */
public class MyFile {

    public static void main(String[] args) {
        // Initialize the reader and scanner modules
        BufferedReader br = null;
        Scanner input = null;
        PrintWriter outputToFile = null;
        // Initialize all string variables
        String line, 
        lineArrayString, 
        wordArrayString;
        // Array Variables
        String[] numberArray;
        int[] intArray = null;
        // Initialize all number variables
        double minNum = 1, 
        maxNum = 0, 
        avgNum = 0, 
        sumOfArray = 0, 
        pNinety = 0, 
        pSeventy = 0,
        sumOfAvg = 0;
        // Integer variable to count
        int lineIndex = 0, 
        size;
        
        // File Reader
        try {
            // Method to read input text file
            br = new BufferedReader(new FileReader("input.txt"));
            while ((line = br.readLine()) != null) {
                lineIndex++;
            }
            // Reading text file in java
            input = new Scanner(new FileInputStream("input.txt"));
        

            // Catching errors
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        // Output or Filewriter
        try {
            // Creating a new file to write to
            outputToFile = new PrintWriter(new FileOutputStream("output.txt"));
           
            // Catches any errors 
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file");
        }

        /* 
        For loop to loop through each line in the file and also pushes each line into a string array then 
        pushes that array of integers into an int array.
         */
        for (int i = lineIndex; i > 0; i--) {
            // Each line
            line = input.nextLine();
            // Isolates the words
            wordArrayString = line.substring(0, 3);
            // Isolates all the numbers
            lineArrayString = line.substring(4);
            // Pushes the numbers into an array without string commas
            numberArray = lineArrayString.split(",");
            // finds the length of the string array
            size = numberArray.length;
            // Initializes a new integer array with the length of the string array
            intArray = new int[size];
            // turns string array into an int array
            for (int j = 0; j < size; j++) {
                intArray[j] = Integer.parseInt(numberArray[j]);
            }
            /* Switch statement to do all calculations in each case */
            switch (wordArrayString) {
                // Case to calculate the min number
                case "min":
                    for(int in: intArray){
                        minNum = Math.min(minNum, in);
                    }
                    // Writes to output file
                    outputToFile.println("The min of " + Arrays.toString(intArray) + " is " + minNum);
                    break;
                // Case to get the maximum number
                case  "max":
                    for(int in: intArray){
                        maxNum = Math.max(maxNum, in);
                    }
                    // Writes to output file
                    outputToFile.println("The max of " + Arrays.toString(intArray) + " is " + maxNum);
                    break;
                // Case to find the average
                case "avg":
                    for(int in: intArray){
                        sumOfAvg += in; 
                    }
                    avgNum = sumOfAvg/intArray.length;
                    // Writes to output file
                    outputToFile.println("The average of " + Arrays.toString(intArray) + " is " + avgNum);
                    break;
                // Case to calculate the 90th percentile of array
                case "p90":
                    pNinety = Math.floor((0.9) * intArray.length);
                    // Writes to output file
                    outputToFile.println("The 90th percentile of" + Arrays.toString(intArray) + " is " + pNinety);
                    break;
                // Case to get the sum of array
                case "sum":
                    for(int in: intArray) {
                        sumOfArray += in;
                    }
                    // Writes to output file
                    outputToFile.println("The sum of " + Arrays.toString(intArray) + " is " + sumOfArray);
                    break;
                // Case to find tje 70th percentile
                case "p70":
                    pSeventy = Math.floor((0.7) * intArray.length);
                    // Writes to output file
                    outputToFile.println("The 70th percentile of " + Arrays.toString(intArray) + " is " + pSeventy);
            }
        }
        // Closes open modules
        input.close();
        outputToFile.close();
    }
}