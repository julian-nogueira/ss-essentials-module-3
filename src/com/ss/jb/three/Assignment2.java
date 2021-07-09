
package com.ss.jb.three;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * The Assignment2 class contains a single function to append data to an
 * existing file. The function takes an absolute path and content as arguments,
 * attempts to open the file, then appends the content accordingly.
 */
public class Assignment2{
    // Try to open the passed file in append mode, then append the contents.
    public void appendToFile(String absPath, String content){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(absPath, true))){
            writer.write(content);
            System.out.printf("%nContent successfully appended to: %s%n", absPath);
        }catch(Exception e){
            System.out.println("\nAn error has occurred. Check the file path.\n");
        }
    }

    public static void main(String[] args){
        Assignment2 obj = new Assignment2();
        String absPath = "C:\\Users\\Julian\\Documents\\Personal\\Coding\\Smoothstack\\Smoothstack-Essentials\\Module-3\\outputFile.txt";
        String content = "\n2021-07-09,20";

        obj.appendToFile(absPath, content);
    }
}
