
package com.ss.jb.three;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.Reader;
import java.util.Scanner;

/**
 * The Assignment3 class contains functions to prompt a user for a single
 * character to search for, get the data from the specified file, then count
 * and display the number of occurrences of the character in the file.
 */
public class Assignment3{
    // Get character from user.
    public String getCharacter() throws Exception{
        Scanner scanner = new Scanner(System.in);
        String prompt = "\nEnter the specified character to search for: ";

        System.out.print(prompt);
        String str = scanner.nextLine();

        if(str.length() == 1){
            return str;
        }else{
            return "";
        }
    }

    // Get all data from a file into a string.
    public String getDataFromFile(String absPath) throws Exception{
        StringBuffer strb = new StringBuffer();
        FileInputStream fis = new FileInputStream(absPath);
        InputStreamReader isr = new InputStreamReader(fis, "UTF8");
        Reader in = new BufferedReader(isr);
        int ch = new Integer(0);

        while((ch = in.read()) > -1){
            strb.append((char)ch);
        }

        in.close();

        return strb.toString();
    }

    // Get the number of occurrences of a character in a string.
    public void getOccurrencesInString(Character target, String data){
        Integer occurrences = new Integer(0);

        for(int i = 0; i < data.length(); i++){
            if(target.equals(data.charAt(i))){
                occurrences++;
            }
        }

        System.out.println("Occurrences of '" + target + "': " + occurrences);
    }

    // Count occurrences of specified character in passed file.
    public void getOccurrencesFromFile(String absPath){
        try{
            Character target = getCharacter().charAt(0);
            String data = getDataFromFile(absPath);
            getOccurrencesInString(target, data);
        }catch(Exception e){
            System.out.println("An exception has occurred.");
        }
    }

    public static void main(String[] args){
        Assignment3 obj = new Assignment3();
        String absPath = "C:\\Users\\Julian\\Documents\\Personal\\Coding\\Smoothstack\\Smoothstack-Essentials\\Module-3\\inputFile.txt";

        obj.getOccurrencesFromFile(absPath);
    }
}
