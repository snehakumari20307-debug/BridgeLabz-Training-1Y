import java.util.*;
public class StudentCanVote{
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
int[] age = new int[10];
for(int i=0;i<10;i++){
System.out.println(i+1);
age[i] = sc.nextInt();
}
for(int i=0;i<10;i++){
if(age[i]>=18){
System.out.println("Student"+(i+1)+"is eligible.");
}
else{
System.out.println("Student"+(i+1)+"is not eligible.");
}
}
}
}