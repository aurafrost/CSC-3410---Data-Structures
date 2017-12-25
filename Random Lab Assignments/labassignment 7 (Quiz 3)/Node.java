public class Node {
  private int data;
  private Node prev;
  private Node next;
  public Node(int data) {
    this.data=data;
    this.prev=null;
    this.next=null;
  }
  public Node(Node prev, int data, Node next) {
    this.prev=prev;
    this.data=data;
    this.next=next;
  }
  public void setPrev(Node prev) {
    this.prev=prev;
  }
  public void setData(int data) {
    this.data=data;
  }
  public void setNext(Node next) {
    this.next=next;
  }
  public Node getPrev() {
    return prev;
  }
  public int getData() {
    return data;
  }
  public Node getNext() {
    return next;
  }
}