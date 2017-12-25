//Jimmy Tran
//Bhola
//CSC 3410
public class SelectionSort{
  public static void main(String[]args){
    int[]a = new int[5];
    System.out.println("Randomized array:");
    for(int i=0;i<5;i++){
      a[i]=(int) Math.ceil(Math.random()*100);
    }
    for(int i=0;i<5;i++){
      System.out.print(a[i]+", ");
    }
    System.out.println("");
    int[]b = new int[5];
    
    //ascending sort
    System.out.println("Ascending array:");
    b=a;
    for(int i=0;i<5;i++){
      for(int j=0;j<5;j++){
        int max=b[i];
        int maxIndex=j;
        int temp;
        if(b[j]>max){
          max=b[j];
          maxIndex=j;
          temp=b[i];
          b[i]=max;
          b[maxIndex]=temp;
        }
      }
    }
    for(int i=0;i<5;i++){
      System.out.print(b[i]+", ");
    }
    System.out.println("");
    
    //descending sort
    System.out.println("Descending array:");
    b=a;
    for(int i=0;i<5;i++){
      for(int j=0;j<5;j++){
        int min=b[i];
        int minIndex=j;
        int temp;
        if(b[j]<min){
          min=b[j];
          minIndex=j;
          temp=b[i];
          b[i]=min;
          b[minIndex]=temp;
        }
      }
    }
    for(int i=0;i<5;i++){
      System.out.print(b[i]+", ");
    }
  }
}