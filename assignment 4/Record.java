package bank;
//This class is designed in order to have objects to use in the bank class
public class Record {
    private String fName;
    private String lName;
    private double balance;
    public Record() {
        this.fName=null;
        this.lName=null;
        this.balance=0;
    }
    public Record(String fName, String lName, double balance) {
        this.fName=fName;
        this.lName=lName;
        this.balance=balance;
    }
    //pre: true
    //post: changes fName to the given parameter
    public void setFirst(String fName) {
        this.fName=fName;
    }
    //pre: true
    //post: returns fName
    public String getFirst() {
        return fName;
    }
    //pre: true
    //post: changes lName to the given parameter
    public void setLast(String lName) {
        this.lName=lName;
    }
    //pre: true
    //post: returns lName
    public String getLast() {
        return lName;
    }
    //pre: true
    //post: adds parameter to the balance
    public void deposit(double balance) {
        this.balance+=balance;
    }
    //pre: balance<this.balance
    //post: subtracts parameter from the balance
    public void withdraw(double balance) {
        this.balance-=balance;
    }
    //pre: true
    //post: returns balance
    public double getBalance() {
        return balance;
    }
}