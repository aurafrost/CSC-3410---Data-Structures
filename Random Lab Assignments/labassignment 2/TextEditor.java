import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TextEditor{
  public static void main(String[]args){
    int count=0;
    File f=new File("testFile.txt");
    //writes file
    try (Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("testFile.txt"), "utf-8"))){
      w.write("This is nonsense.\n" + "But it works at least.");
      w.close();
    }
    catch (IOException e){
      System.err.println("Cannot create/write to testFile.txt.");
    }
    
    //reads file
    try (BufferedReader br = new BufferedReader(new FileReader("testFile.txt"))){
      String sCurrentLine;
      while ((sCurrentLine = br.readLine()) != null) {
        System.out.println(sCurrentLine);
        for(int i=1;i<sCurrentLine.length();i++){
          if(sCurrentLine.substring(i-1,i).equals(null)||sCurrentLine.substring(i-1,i).equals(".")){
            count++;
          }
        }
      }
      count++;
    }
    catch (IOException e2){
      e2.printStackTrace();
    }
    System.out.println("Word count: "+count);
  }  
}