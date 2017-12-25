public class Card {
  private int r=0;
  private String s="";
  public Card(){
    r=13;
    s="S";
  }
  public Card(int r, String s){
    r=this.r;
    s=this.s;
  }
  public void setCard(){
    r=(int)Math.ceil(Math.random()*13);
    String suit="";
    int i=(int)Math.ceil(Math.random()*4);
    if(i==1)
      suit="H";
    if(i==2)
      suit="D";
    if(i==3)
      suit="C";
    if(i==4)
      suit="S";
    s=suit;
  }
  public void setCard(int r, String s){
    r=this.r;
    s=this.s;
  }
  public int getRank(){
    return r;
  }
  public String getSuit(){
    return s;
  }
  public void printCard(){
    System.out.println("Your card is the: "+getRank()+getSuit());
  }
}