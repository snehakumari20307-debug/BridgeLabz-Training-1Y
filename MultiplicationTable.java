import java.util.*;
public class MultiplicationTable{
public static void main(String args[]){
Scanner ab = new Scanner(System.in);
int n = ab.nextInt();
int[] table = new int[10];
for(int i=1;i<=10;i++){
table[i-1]=n*i;
}
System.out.println("MultiplicationTable");
for(int i=1;i<=10;i++){
System.out.println(n+"*"+i+"="+table[i-1]);
}
}
}