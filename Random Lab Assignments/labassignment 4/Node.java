public class Node {
  private Object data;
  private Node prev;
  private Node next;
  public Node(Object data) {
    this.data=data;
    this.prev=null;
    this.next=null;
  }
  public Node(Node prev, Object data, Node next) {
    this.prev=prev;
    this.data=data;
    this.next=next;
  }
  public void setPrev(Node prev) {
    this.prev=prev;
  }
  public void setData(Object data) {
    this.data=data;
  }
  public void setNext(Node next) {
    this.next=next;
  }
  public Node getPrev() {
    return prev;
  }
  public Object getData() {
    return data;
  }
  public Node getNext() {
    return next;
  }
}