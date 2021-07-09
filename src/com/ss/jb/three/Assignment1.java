
package com.ss.jb.three;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

/**
 * The Assignment1 class prompts a user for a directory path, verifies if the
 * path is valid, then recursively lists all subdirectories and files.
 */
public class Assignment1{
    // Get directory name from user.
    public String getDirectoryName(){
        Scanner scanner = new Scanner(System.in);
        String prompt = "\nEnter the absolute path of a directory: ";
        StringBuilder absPath = new StringBuilder();
        Pattern pattern = Pattern.compile("\\\\");

        System.out.print("\n" + prompt);
        absPath.append(scanner.nextLine());

        // Check if the user entered a trailing '\'. If the user did not,
        // append a '\'.
        String lastChar = String.valueOf(absPath.charAt(absPath.length() - 1));
        Matcher matcher = pattern.matcher(lastChar);

        if(!matcher.matches()){
            absPath.append("\\");
        }

        return absPath.toString();
    }

    // Check if a valid path was entered.
    public Boolean isValidPath(String absPath){
        File directoryPath = new File(absPath);
        if(directoryPath.isDirectory()){
            return true;
        }else{
            return false;
        }
    }

    // Check if directory is valid and if it contains contents.
    public Boolean isEmptyDirectory(String absPath){
        File directoryPath = new File(absPath);
        if(directoryPath.isDirectory() && directoryPath.list().length > 0){
            return false;
        }else{
            return true;
        }
    }

    // Display all files and directories in the validated directory.
    public void displayDirectory(String absPath){
        File directoryPath = new File(absPath);
        String contents[] = directoryPath.list();
        StringBuilder fullPath = new StringBuilder();

        for(String item: contents){
            fullPath.append(absPath);
            fullPath.append(item);
            System.out.println(fullPath);
            if(!isEmptyDirectory(fullPath.toString())){
                fullPath.append("\\");
                displayDirectory(fullPath.toString());
            }
            fullPath.setLength(0);
        }
    }

    // Call class functions to get directory name and display contents if a
    // valid path was entered.
    public void getDirectoryContents(){
        String invalidPathMessage = "\nAn invalid path was entered.";
        String absPath = getDirectoryName();
        if(isValidPath(absPath)){
            System.out.println("\n");
            System.out.println(absPath);
            displayDirectory(absPath);
        }else{
            System.out.println(invalidPathMessage);
        }
    }

    // Driver to run directory display functions.
    public static void main(String[] args){
        Assignment1 obj = new Assignment1();
        obj.getDirectoryContents();
    }
}
