//This is a LinkedList I already wrote in a previous lab so there are many extra methods
//including a size method. The one I wrote for the quiz is the uncommented size method.
//The original size method has been commented out.
import java.util.*;
public class LinkedList {
  private Node head;
  private int length;
  public LinkedList() {
    this.head=new Node(1);
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
  public void add(int o) {
    Node current=head;
    while(current.getNext()!=null)
      current=current.getNext();
    Node newNode=new Node(current,o,null);
    current.setNext(newNode);
    length++;
  }
  //pre:index<length;
//  public void remove(int index) {
//    if(size()==1) {
//      head.setPrev(null);
//      head.setNext(null);
//    }
//    if(size()==2){
//      if(index==0){
//        head=head.getNext();
//        head.setPrev(null);
//      }
//      if(index==1)
//        head.setNext(null);
//    }
//    else{
//      if(index==0) {
//        Node next=head.getNext();
//        head=next;
//        head.setPrev(null);
//      }
//      else if(index==size()-1){
//        Node current=getNode(size()-1);
//        Node prev=current.getPrev();
//        current.setPrev(null);
//        prev.setNext(null);
//      }
//      else{
//        Node n=getNode(index);
//        Node prev=null;
//        Node next=null;
//        if(n.getPrev()!=null)
//          prev=n.getPrev();
//        if(n.getNext()!=null)
//          next=n.getNext();
//        if(prev!=null)
//          prev.setNext(next);
//        if(next!=null)
//          next.setPrev(prev);
//        n.setPrev(null);
//        n.setNext(null);
//      }
//    }
//    length--;
//  }
//  public int search(int data) {
//    Node current=head;
//    for(int i=0;i<size();i++) {
//      if(current.getData()==data)
//        return i;
//      else
//        current=current.getNext();
//    }
//    return -1;
//  }
//  public int size() {
//    return length;
//  }
  public LinkedList size(LinkedList newList) {
    Node current=newList.getNode(0);
    if(current==null) {
      System.out.println("The LinkedList has size 0.");
    }
    if(current.getNext()==null) {
      System.out.println("The LinkedList has size "+length);
      return newList;
    }
    while(current.getNext()!=null)
      current=current.getNext();
    Node last=current.getPrev();
    current.setPrev(null);
    last.setNext(null);
    length++;
    length=length/2+1;
    return size(newList);
  }
  public static void main(String[]args) {
    LinkedList l=new LinkedList();
    //default list has one element already. size method should return 2.
    l.add(2);
    l.add(3);
    LinkedList newList=l;
    l.size(newList);
  }
}