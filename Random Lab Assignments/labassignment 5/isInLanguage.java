import java.util.*;
public class isInLanguage{
  public static boolean IsInLanguage(String n) {
    int l=n.length();
    if(l>3){
      if(n.substring(0,1).equalsIgnoreCase("a")&&n.substring(1,3).equalsIgnoreCase("bb")) {
        return IsInLanguage(n.substring(3,n.length()));
      }
    }
    if(n.equalsIgnoreCase("ABB"))
      return true;
    return false;
  }
  public static void main(String[]args){
    Scanner k=new Scanner(System.in);
    System.out.println("Enter string: ");
    String n=k.nextLine();
    System.out.println(IsInLanguage(n));
  }
}