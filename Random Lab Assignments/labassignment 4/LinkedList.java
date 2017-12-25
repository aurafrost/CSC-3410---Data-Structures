import java.util.*;
public class LinkedList {
  private Node head;
  private int length;
  public LinkedList() {
    this.head=new Node("Item 1");
    this.length=1;
  }
  //pre:index<length
  public Node getNode(int index) {
    Node n=head;
    while(index>0) {
      n=n.getNext();
      index--;
    }
    return n;
  }
  public void add(Object o) {
    Node current=head;
    while(current.getNext()!=null)
      current=current.getNext();
    Node newNode=new Node(current,o,null);
    current.setNext(newNode);
    length++;
  }
  //pre:index<length;
  public void remove(int index) {
    if(size()==1) {
      head.setPrev(null);
      head.setNext(null);
    }
    if(size()==2){
      if(index==0){
        head=head.getNext();
        head.setPrev(null);
      }
      if(index==1)
        head.setNext(null);
    }
    else{
      if(index==0) {
        Node next=head.getNext();
        head=next;
        head.setPrev(null);
      }
      else if(index==size()-1){
        Node current=getNode(size()-1);
        Node prev=current.getPrev();
        current.setPrev(null);
        prev.setNext(null);
      }
      else{
        Node n=getNode(index);
        Node prev=null;
        Node next=null;
        if(n.getPrev()!=null)
          prev=n.getPrev();
        if(n.getNext()!=null)
          next=n.getNext();
        if(prev!=null)
          prev.setNext(next);
        if(next!=null)
          next.setPrev(prev);
        n.setPrev(null);
        n.setNext(null);
      }
    }
    length--;
  }
  public int search(Object data) {
    Node current=head;
    for(int i=0;i<size();i++) {
      if(current.getData()==data)
        return i;
      else
        current=current.getNext();
    }
    return -1;
  }
  public int size() {
    return length;
  }
  public static void main(String[]args) {
    LinkedList l=new LinkedList();
    l.add("Item 2");
    l.add("Item 3");
    l.add("Item 4");
    l.add("Item 5");
    l.remove(0);
    l.remove(2);
    System.out.println("Item 1 is at index: "+l.search("Item 1")+". It is not in the list.");
    System.out.println("Item 5 is at index: "+l.search("Item 5"));
    for(int i=0;i<l.size();i++) {
      Node n=l.getNode(i);
      System.out.println(n.getData());
    }
  }
}