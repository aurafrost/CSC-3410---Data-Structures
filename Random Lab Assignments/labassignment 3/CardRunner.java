public class CardRunner {
  public static void main(String[]args){
    Card[]deck=new Card[52];
    Card c=new Card();
    for(int i=0;i<13;i++){
      deck[i]=c;
    }
    for(int i=0;i<13;i++){
      System.out.println(deck[i]);
    }
    c.printCard();
  }
}
