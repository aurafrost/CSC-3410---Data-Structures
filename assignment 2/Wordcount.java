/*Jimmy Tran
Objective: To gain experience with string objects, generic algorithms,
and opening and reading files for input and output.

Algorithm: No algorithm is needed for this program.

Data Structures: Strings will be used in the program as an aid to opening
the file.

Input/Output: The user will input a file name of a file located in the
folder with the program. The program will output the word, line,
alphanumeric character, sentence, vowel, and punctuation counts of the
file. It will also output a text file with the same information.
 */
package wordcount;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
/*
This class is designed to open and read a file then print the word, line,
alphanumeric character, sentence, vowel, and punctuation counts of the
file given and named in the folder with the program. Then it creates
an output file with the same printed information.
 */
public class Wordcount {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        System.out.println("What is file path of the file you wish to "
                + "open? Please ignore the quotation marks at the ends.");
        String filePath=keyboard.nextLine();
        count(filePath);
    }
    /*
    returns word,line,alphanumeric char,sentence,vowel,and punctuation counts
    pre:none
    post:prints out all counts and creates an output file with counts
    */
    public static void count(String fileName) {
        String input;
        String currentLine;
        Scanner fileinput = null;
        int wordCount = 0;
        int lineCount = 0;
        int charCount = 0;
        int sentenceCount = 0;
        int vowelCount = 0;
        int punctuationCount = 0;
        try {
            BufferedReader file=new BufferedReader(new FileReader(fileName)); 
            while(file.ready()) {
                currentLine = file.readLine();
                lineCount++;
                //finds words
                StringTokenizer wordT=new StringTokenizer(currentLine);
                while (wordT.hasMoreTokens()) {
                    wordCount++;
                    String token = wordT.nextToken();
                }
                //finds alphanumeric characters,sentences,vowels,punctuation
                String charLine=currentLine.replaceAll("\\s+","");
                for(int i=0;i<charLine.length();i++) {
                    String current=charLine.substring(i,i+1);
                    if(current!=null)
                        charCount++;
                    if(current.equals("."))
                        sentenceCount++;
                    if(current.equals("!"))
                        sentenceCount++;
                    if(current.equals("?"))
                        sentenceCount++;
                    if(current.equalsIgnoreCase("a"))
                        vowelCount++;
                    if(current.equalsIgnoreCase("e"))
                        vowelCount++;
                    if(current.equalsIgnoreCase("i"))
                        vowelCount++;
                    if(current.equalsIgnoreCase("o"))
                        vowelCount++;
                    if(current.equalsIgnoreCase("u"))
                        vowelCount++;
                    if(current.equals("'"))
                        punctuationCount++;
                    if(current.equals(","))
                        punctuationCount++;
                    if(current.equals("\""))
                        punctuationCount++;
                    if(current.equals("("))
                        punctuationCount++;
                    if(current.equals(")"))
                        punctuationCount++;
                    if(current.equals("-"))
                        punctuationCount++;
                    if(current.equals("..."))
                        punctuationCount++;
                    if(current.equals(":"))
                        punctuationCount++;
                    if(current.equals(";"))
                        punctuationCount++;
                    if(current.equals("."))
                        punctuationCount++;
                    if(current.equals("!"))
                        punctuationCount++;
                    if(current.equals("?"))
                        punctuationCount++;
                }
                if(currentLine == null)
                    break;
            } 
            fileinput.close();
        }
        catch(FileNotFoundException f){
            System.out.println("File not found or invalid file path.");
            System.exit(1);
        }
        catch(IOException io) {
            System.out.println(io);
            System.out.println("There was a null pointer exception.");
            System.out.println("Word count: "+wordCount);
            System.out.println("Line count: "+lineCount);
            System.out.println("Alphanumeric character count: "+charCount);
            System.out.println("Sentence count: "+sentenceCount);
            System.out.println("Vowel count: "+vowelCount);
            System.out.println("Punctuation count: "+punctuationCount);
            System.exit(1);
        }
        catch(NullPointerException n) {
            System.out.println(n);
            if(wordCount==0&&lineCount==0&&charCount==0
                    &&sentenceCount==0&&vowelCount==0&&punctuationCount==0)
                System.out.println("The file is empty.");
            else{
                System.out.println("Word count: "+wordCount);
                System.out.println("Line count: "+lineCount);
                System.out.println("Alphanumeric char count: "+charCount);
                System.out.println("Sentence count: "+sentenceCount);
                System.out.println("Vowel count: "+vowelCount);
                System.out.println("Punctuation count: "+punctuationCount);
                try (Writer w = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("output.txt")))) {
                    w.write("Word count: "+wordCount+"   "+
                            "Line count: "+lineCount+"   "+
                            "Alphanumeric char count: "+charCount+"   "+
                            "Sentence count: "+sentenceCount+"   "+
                            "Vowel count: "+vowelCount+"   "+
                            "Punctuation count: "+punctuationCount);
                    w.close();
                }
                catch (IOException io2){
                    System.out.println("Cannot create output.txt.");
                }
            }
            System.exit(1);
        }
        finally {
            fileinput.close();
        }
    }
}