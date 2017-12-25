package arraylist;
//class designed to create card objects for testing with ArrayList class
public class Card {
    public int r=0;
    public String s="";
    //default constructor
    public Card() {
        r=13;
        s="Spades";
    }
    //constructor that creates a defined card object
    public Card(int r, String s) {
        this.r=r;
        this.s=s;
    }
    //pre: always true
    //post: randomly sets the rank and suit of a card
    public void setCard() {
        r=(int)Math.ceil(Math.random()*13);
        String suit="";
        int i=(int)Math.ceil(Math.random()*4);
        if(i==1)
            suit="Hearts";
        if(i==2)
            suit="Diamonds";
        if(i==3)
            suit="Clubs";
        if(i==4)
            suit="Spades";
        s=suit;
    }
    //pre: 14>r>0 and s should be Hearts, Diamonds, Clubs, or Spades
    //post: sets the rank and suit to the given parameters
    public void setCard(int r, String s) {
        this.r=r;
        this.s=s;
    }
    //pre: always true
    //post: returns r
    public int getRank() {
        return r;
    }
    //pre: always true
    //post: returns s
    public String getSuit() {
        return s;
    }
    //pre: same as setCard(int r,String s)
    //post: prints out the card rank and suit
    public void printCard(){
        int rank=getRank();
        switch (rank) {
            case 1:
                System.out.println("Ace of "+getSuit());
                break;
            case 11:
                System.out.println("Jack of "+getSuit());
                break;
            case 12:
                System.out.println("Queen of "+getSuit());
                break;
            case 13:
                System.out.println("King of "+getSuit());
                break;
            default:
                System.out.println(getRank()+" of "+getSuit());
                break;
        }
    }
}