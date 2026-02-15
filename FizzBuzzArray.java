import java.util.*;
public class FizzBuzzArray{
public static void main(String args[]){
Scanner ab = new Scanner(System.in);
int num = ab.nextInt();
if(num<=0){
System.out.println("ERROR");
return;
}
String[] result = new String[num];
for(int i=1;i<=num;i++){
if(i%3==0&&i%5==0){
result[i-1]="fizzBuzz";
}
else if(i%3==0){
result[i-1]="fizz";
}
else if(i%5==0){
result[i-1]="Buzz";
}
else{
result[i-1]=String.valueOf(i);
}
}
for(int i=0;i<num;i++){
System.out.println("Positive"+(i+1)+"="+result[i]);
}
}
}
