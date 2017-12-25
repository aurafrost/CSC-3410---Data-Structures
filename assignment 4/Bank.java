/*
Name: Jimmy Tran
Professor: Bhola
Class: CSC 3410

Purpose: To gain experience with the Linked List class in Java

Solution: Linked lists will be imported from the Java library.
A record class will be created to be the objects contained in
the linked list. The commands will be carried out using methods from both
the Record and Bank classes that will be programmed.

Data Structures: Linked lists are to be used for this program

Input/Output:User inputs the listed commands with a keyboard. The output
will vary heavily depending on the input. Most inputs will cause the 
output to change in some manner. Outputs will include displaying the
linked list, removing an element, changing variables (fName, lName, balance)
contained in the Records, adding elements, selecting elements, and
terminating the program.

Classes: The Bank class is the main class containing the runner and
methods for most of its commands.
The Record class will create the objects contained in the bank class's
linked list. It will also have setters and getters for its variables.
*/
package bank;
import java.util.*;
//main class
public class Bank {
    private LinkedList<Record> list;
    public Bank() {
        this.list=new LinkedList<>();
    }
    //pre: true
    //post: displays the contents of the linked list in order
    public void showAll() {
        int s=list.size();
        if(s==0)
            System.out.println("No records exist!!");
        else{
            int i=0;
            System.out.println("First Name    Last Name    Current Balance");
            System.out.println("----------    ---------    ---------");
            while(i!=s) {
                Record r=list.get(i);
                String f=r.getFirst();
                String l=r.getLast();
                double b=r.getBalance();
                System.out.println(f+"           "+l+"            $"+b);
                i++;
            }
        }
    }
    //pre: c exists in the list
    //post: finds and removes the object from the list
    public void remove(Record c) {
        int index=list.indexOf(c);
        list.remove(index);
    }
    //pre: true
    //post: creates a Record from the parameters, compares String values
    //to find where Record belongs in the list, and adds at that index.
    public void add(String fName, String lName, double balance) {
        Record r=new Record(fName, lName, balance);
        int s=list.size();
        if(s==0)
            list.add(r);
        int i=0;
        while(i<s) {
            Record r1=list.get(i);
            String l1=r1.getLast();
            String f1=r1.getFirst();
            int c=lName.compareToIgnoreCase(l1);
            if(c==0) {
                c=fName.compareToIgnoreCase(f1);
            }
            if(c<0) {
                list.add(i,r);
                i++;
            }
            else
                i++;
        }
        if(i==s&&s==list.size()) {
            list.add(r);
        }
    }
    //pre: true
    //post: returns record if found from given parameters. 
    //Otherwise, returns null.
    public Record select(String fName, String lName) {
        int i=0;
        Record r=new Record();
        while(i<list.size()) {
            Record check=list.get(i);
            if(lName.equals(check.getLast())) {
                if(fName.equals(check.getFirst()))
                    r=check;
            }
            i++;
        }
        return r;
    }
    //pre: true
    //post: displays all possible commands and asks for input
    public void menu() {
        System.out.println();
        System.out.println("a  Show all records");
        System.out.println("r  Remove the current record");
        System.out.println("f  Change the first name in the current record");
        System.out.println("l  Change the last name in the current record");
        System.out.println("n  Add a new record");
        System.out.println("d  Add a deposit to the current record");
        System.out.println("w  Make a withdrawal from the current record");
        System.out.println("q  Quit");
        System.out.println("s  Select a record from the record list "
                + "to become the current record");
        System.out.println();
        System.out.println("Enter a command from "
                + "the list above(q to quit): ");
    }
    public static void main(String [] args) {
        Bank b=new Bank();
        Scanner k=new Scanner(System.in);
        Record c=new Record();
        String i="repeat";
        while(i.equals("repeat")) {
            if(c.getFirst()==null)
                System.out.println("No current record.");
            else
                System.out.println("Current record is: "
                        +c.getFirst()+" "+c.getLast()+" $"+c.getBalance());
            b.menu();
            i=k.next();
            if(i.equals("a"))
                b.showAll();
            if(i.equals("r")) {
                System.out.println("Deleted: "+c.getFirst()+" "+c.getLast());
                b.remove(c);
                c=new Record();
            }
            if(i.equals("f")) {
                Record temp=c;
                b.remove(c);
                System.out.println("Enter first name: ");
                String first=k.next();
                temp.setFirst(first);
                b.add(temp.getFirst(),temp.getLast(),temp.getBalance());
                c=b.select(temp.getFirst(),temp.getLast());
            }
            if(i.equals("l")) {
                Record temp=c;
                b.remove(c);
                System.out.println("Enter last name: ");
                String last=k.next();
                temp.setLast(last);
                b.add(temp.getFirst(),temp.getLast(),temp.getBalance());
                c=b.select(temp.getFirst(),temp.getLast());
            }
            if(i.equals("n")){
                System.out.println("Enter first name: ");
                String first=k.next();
                System.out.println("Enter last name: ");
                String last=k.next();
                System.out.println();
                System.out.println("Enter balance: ");
                double balance=k.nextDouble();
                b.add(first,last,balance);
                c=b.select(first,last);
            }
            if(i.equals("d")) {
                System.out.println("Enter the deposited amount: ");
                double d=k.nextDouble();
                c.deposit(d);
                System.out.println("$"+d+" deposited.");
            }
            if(i.equals("w")) {
                System.out.println("Enter the withdrawn amount: ");
                double w=k.nextDouble();
                c.withdraw(w);
                System.out.println("$"+w+" withdrawn.");
            }
            if(i.equals("q"))
                System.exit(1);
            if(i.equals("s")) {
                System.out.println("Enter first name: ");
                String first=k.next();
                System.out.println("Enter last name: ");
                String last=k.next();
                c=b.select(first,last);
                if(c.getFirst()==null)
                    System.out.println("Object does not exist.");
            }
            i="repeat";
        }
    }
}