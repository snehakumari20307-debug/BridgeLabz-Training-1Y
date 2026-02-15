import java.util.*;
public class TableStart6to9{
public static void main(String args[]){
Scanner s = new Scanner(System.in);
int n = s.nextInt();
int[] multiplicationResult=new int[4];
for(int i=6;i<=9;i++){
multiplicationResult[i-6]=n*i;
}
for(int i=6;i<=9;i++){
System.out.println(n+"*"+i+"="+multiplicationResult[i-6]);
}
}
}