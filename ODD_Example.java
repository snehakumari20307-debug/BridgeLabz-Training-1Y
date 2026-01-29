import java.util.*;
public class ODD_Example{
public static void main(String args[]){
Scanner sc=new Scanner(System.in);
System.out.println("Enter the number:");
int n=sc.nextInt();
for(int i=1;i<=n;i++){
if(i%2==0){
continue;
}
else{
System.out.println(i);
}
}
}
}