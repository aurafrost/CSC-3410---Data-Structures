package arraylist;
//class that tests the ArrayList class using the Card class
public class TestArray {
    public static void main(String[]args) {
        ArrayList deck=new ArrayList(52);
        int i=0;
        while(i<52) {
            for(int j=1;j<5;j++) {
                String suit="";
                if(j==1)
                    suit="Hearts";
                if(j==2)
                    suit="Diamonds";
                if(j==3)
                    suit="Clubs";
                if(j==4)
                    suit="Spades";
                for(int k=1;k<14;k++) {
                    Card c=new Card(k,suit);
                    deck.add(i,c);
                    i++;
                }
            }
        }
        //prints default deck
        System.out.println("default deck/ArrayList constructor test:");
        for(int j=0;j<deck.size();j++) {
            Card c=(Card)deck.get(j);
            c.printCard();
        }
        System.out.println();
        
        //add without index and get test
        System.out.println("add(Object x)method and get method test:");
        Card c1=new Card();
        c1.setCard();
        System.out.print("The new card being added is: ");
        c1.printCard();
        deck.add(c1);
        c1=(Card)deck.get(52);
        System.out.print("The card at the end of the deck is: ");
        c1.printCard();
        System.out.println();
        
        //add with index test
        System.out.println("add(int index, Object x) method test:");
        Card c2=new Card();
        c2.setCard();
        System.out.print("The new card being added at position 10 is: ");
        c2.printCard();
        deck.add(10,c2);
        c2=(Card)deck.get(10);
        System.out.print("The card at position 10 is: ");
        c2.printCard();
        System.out.println();
        
        //size test
        System.out.println("size method test:");
        System.out.println("The size of the deck should be 54.");
        System.out.println("The size of the deck is "+deck.size()+".");
        System.out.println();
        
        //isEmpty test
        System.out.println("isEmpty method test:");
        System.out.println(deck.isEmpty());
        System.out.println();
        
        //isIn test
        System.out.println("isIn method test:");
        System.out.println(deck.isIn(c1));
        System.out.println();
        
        //find test
        System.out.println("find method test:");
        System.out.println(deck.find(c1));
        System.out.println();
        
        //remove test
        System.out.println("remove method test");
        Card c3=(Card)deck.get(0);
        deck.remove(c1);
        deck.remove(c2);
        System.out.println();
        
        //shuffles and prints new deck
        deck.shuffle();
        System.out.println("shuffle method test:");
        for(int j=0;j<deck.size();j++) {
            Card c=(Card)deck.get(j);
            c.printCard();
        }
    }
}
