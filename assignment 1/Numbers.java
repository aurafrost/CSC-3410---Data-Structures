/*
 * This program is designed to generate random ints and place them in arrays
 * before printing them out. The numbers are grouped in two subgroups.
 * The first one has numbers from 1 to 69 and the second from 1 to 26.
 * The subgroups are printed in pairs per line after the first subgroups are
 * sorted in ascending order and checked for repetition within the subgroup
 * and between the first subgroups.
 * If there is repetition of any kind, the group as a whole is regenerated.
 * This will be accomplished using if statements and for and while loops.
 * Arrays will be the primary data structure for this program.
 */
package numbers;
import java.util.Scanner;
/**
 * @author Jimmy Tran
 * Bhola
 * CSC 3410
 */
public class Numbers { //The main class
    //generates random numbers for the groups
    public static int[] generate(int[]a) {
        for(int i=0;i<a.length-1;i++)
            a[i]=(int)Math.ceil(Math.random()*69);
        a[a.length-1]=(int)Math.ceil(Math.random()*26);
        sort(a);
        return a;
    }
    //checks for repetition within a subgroup
    public static boolean rep(int[]a) {
        for(int i=0;i<a.length-1;i++) {
            for(int j=i+1;j<a.length-1;j++) {
                if(a[i]==a[j])
                    return true;
            }
        }
        return false;
    }
    //checks if there is exact repetition between two subgroups
    public static boolean groupRep(int[]a, int[]b) {
        int count = 0;
        for(int i = 0;i<a.length;i++) {
            if(a[i]==b[i]) 
                count++;  
        }
        return count==6;
    }
    //sorts first subgroups in ascending order
    public static void sort(int[]a) {
        int temp;
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                if(a[i]<a[j]){
                    temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;
                }
            }
        }
    }
    //main method. numbers are generated here and placed in arrays
    public static void main(String[] args) {
        int[]group1 = new int[6];
        int[]group2 = new int[6];
        int[]group3 = new int[6];
        int[]group4 = new int[6];
        int[]group5 = new int[6];
        String repeat = "y";
        Scanner keyboard = new Scanner(System.in);
        while(repeat.equalsIgnoreCase("y"))
        {
            boolean rep = true;
            boolean groupRep = true;
            //asks user for input and loops error message if out of bounds
            System.out.print("Enter a number from 1 to 5 for the number "
                        + "of groups of numbers you want to generate. ");
            int groups = keyboard.nextInt();
            while(groups<1||groups>5) {
                System.out.print("The number must be from 1 to 5. "
                        + "Try again. ");
                groups = keyboard.nextInt();
            }
            //generates each group, sorting and checking for repetition
            //after each group is generated
            if(groups>0) {
                while(rep==true) {
                    generate(group1);
                    rep = rep(group1);
                }
            }
            rep = true;
            if(groups>1) {
                while(rep==true&&groupRep==true) {
                    generate(group2);
                    rep = rep(group2);
                    groupRep = groupRep(group2,group1);
                }
            }
            rep = true;
            groupRep = true;
            if(groups>2) {
                while(rep==true&&groupRep==true) {
                    generate(group3);
                    rep = rep(group3);
                    groupRep = groupRep(group3,group1);
                    if(groupRep==false)
                        groupRep = groupRep(group3,group2);
                }
            }
            rep = true;
            groupRep = true;
            if(groups>3) {
                while(rep==true&&groupRep==true) {
                    generate(group4);
                    rep = rep(group4);
                    groupRep = groupRep(group4,group1);
                    if(groupRep==false)
                        groupRep = groupRep(group4,group2);
                    else {
                        if(groupRep==false)
                            groupRep = groupRep(group4,group3);
                    }
                }
            }
            rep = true;
            groupRep = true;
            if(groups>4) {
                while(rep==true&&groupRep==true) {
                    generate(group5);
                    rep = rep(group5);
                    groupRep = groupRep(group5,group1);
                    if(groupRep==false)
                        groupRep = groupRep(group5,group2);
                    else {
                        if(groupRep==false)
                            groupRep = groupRep(group5,group3);
                        else {
                            if(groupRep==false)
                                groupRep = groupRep(group5,group4);
                        }
                    }
                }
            }          
            //prints the numbers subgroup 1+subgroup 2 each line
            if(groups>0) {
                for(int i=0;i<group1.length-1;i++)
                    System.out.print(group1[i]+" ");
                System.out.println("   "+group1[group1.length-1]);
            }
            if(groups>1) {
                for(int i=0;i<group2.length-1;i++)
                    System.out.print(group2[i]+" ");
                System.out.println("   "+group2[group2.length-1]);
            }
            if(groups>2) {
                for(int i=0;i<group3.length-1;i++)
                    System.out.print(group3[i]+" ");
                System.out.println("   "+group3[group3.length-1]);
            }
            if(groups>3) {
                for(int i=0;i<group4.length-1;i++)
                    System.out.print(group4[i]+" ");
                System.out.println("   "+group4[group4.length-1]);
            }
            if(groups>4) {
                for(int i=0;i<group5.length-1;i++)
                    System.out.print(group5[i]+" ");
                System.out.println("   "+group5[group5.length-1]);
            }
            groups=0;
            //asks the user if the program should be repeated
            repeat = "N/A";
            while(repeat.equals("N/A")) { //question repeats if not y or n
                System.out.print("Would you like to run the program again"
                        + " -- answer y/n or Y/N? ");
                repeat = keyboard.next();
                if (repeat.equalsIgnoreCase("n")) {
                    System.out.println("Good Bye!!");
                    System.exit(0); //terminates program if n
                }
                else { 
                    if (repeat.equalsIgnoreCase("y"))
                        repeat = "y";
                    else
                        repeat = "N/A"; //changes other input to "N/A" 
                }
            }
        } 
    }
}