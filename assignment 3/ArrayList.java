/*
Purpose: This program is designed to teach how to create
and implement the ArrayList data structure.
Solution: Arrays will be used to create the Array Lists and
contain objects. For loops will be used to create the Array List
functions.
Data Structures: Arrays
The program cannot be directly used. However, a provided test class 
will test all of its functions.
The ArrayList class will contain the constructors for the ArrayList
as well as all of its functions(add,remove,etc).
The Card class is used to create card objects to test the ArrayList
class in the TestArray class.
 */
package arraylist;
public class ArrayList {
    private Object[]aList=new Object[10];
    //default constructor
    public ArrayList() {
        aList=new Object[10];
    }
    //constructor that accepts an int for the array list size
    public ArrayList(int n) {
        aList=new Object[n];
    }
    //pre: object x must be the same as objects specified for the array list
    //post: adds x to the array list at first null position or the end
    public void add(Object x) {
        int i=0;
        int check=0;
        while(i<aList.length) {
            if(aList[i]!=null) {
                i++;
                check++;
            }
            else {
                aList[i]=x;
                break;
            }
        }
        if(check==aList.length) {
            Object[]bList=new Object[aList.length+1];
            for(int j=0;j<aList.length;j++) {
                bList[j]=aList[j];
            }
            bList[aList.length+1]=x;
            aList=bList;
        }
        System.out.println("Add(Object x)method successful.");
    }
    //pre: aList.length > index > -1
    //post: adds x to the array list at position index
    public void add(int index,Object x) {
        Object[]bList=new Object[aList.length+1];
        for(int i=0;i<index;i++) {
            bList[i]=aList[i];
        }
        bList[index]=x;
        for(int i=index;i<aList.length;i++) {
            bList[i+1]=aList[i];
        }
        aList=bList;
        System.out.println("Add(int index,Object x)method successful.");
    }
    //pre: aList.length > index > -1
    //post: returns the object contained at index or the failed statement
    public Object get(int index) {
        if(aList[index]!=null)
            return aList[index];
        return "There is no object at index " + index + ".";
    }
    //pre: always true
    //post: returns the number of objects contained in aList, NOT length
    public int size() {
        int size=0;
        if(aList!=null) {
            for (Object aList1 : aList) {
                if (aList1 != null)
                    size++;
            }
        }
        return size;
    }
    //pre: always true
    //post: returns true if aList is empty, false if not empty
    public boolean isEmpty() {
        return aList==null;
    }
    //pre: aList is instantiated
    //post: returns true if ob is in the arraylist. false otherwise
    public boolean isIn(Object ob) {
        for (Object aList1 : aList) {
            if(aList1==ob)
                return true;
        }
        return false;
    }
    //pre: always true
    //post: returns first index n occurs in or -1
    public int find(Object n) {
        for(int i=0;i<aList.length;i++) {
            if(aList[i]==n)
                return i;
        }
        return -1;
    }
    //pre: object n exists in aList
    //post: removes object n from aList
    public void remove(Object n) {
        Object[]bList=new Object[aList.length-1];
        for(int i=0;i<aList.length;i++) {
            if(aList[i]==n) {
                for(int j=0;j<i;j++) {
                    bList[j]=aList[j];
                }
                for(int j=i;j<aList.length-1;j++) {
                    bList[j]=aList[j+1];
                }
                aList=bList;
                System.out.println("Remove method successful");
                break;
            }
        }
    }
    //pre: always true
    //post: randomly shuffles all objects in the aList
    public void shuffle() {
        for(int i=0;i<52;i++) {
            int newPos=(int)Math.ceil(Math.random()*52-1);
            Object temp=aList[newPos];
            aList[newPos]=aList[i];
            aList[i]=temp;
        }            
    }
}
