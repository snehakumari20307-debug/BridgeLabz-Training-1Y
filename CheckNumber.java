import java.util.*;
public class CheckNumber{
public static void main(String args[]){
Scanner ab = new Scanner(System.in);
int[] num = new int[5];
for(int i=0;i<num.length;i++){
System.out.print(i+1);
num[i] = ab.nextInt();
}
for(int i=0;i<num.length;i++){
if(num[i]>0){
if(num[i]%2==0){
System.out.println(num[i]+"is a positive even");
}
else{
System.out.println(num[i]+"is a positive odd ");
}
}
else if(num[i]<0){
System.out.println(num[i]+"is a neg");
}
else{
System.out.println(num[i]+"is a zero");
}
if(num[0]==num[num.length-1]){
System.out.println("First and last element are equal.");
}
else if(num[0]>num[num.length-1]){
System.out.println("First is greater.");
}
else{
System.out.println("Second is greater.");
}
}
}
}