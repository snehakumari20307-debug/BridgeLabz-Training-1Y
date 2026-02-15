import java.util.*;
public class Maximum10{
public static void main(String args[]){
double[] number = new double[10];
double total = 0.0;
int index=0;
Scanner in = new Scanner(System.in);
while(true){
System.out.print("Enter a number (0 or negative to stop): ");
double value = in.nextDouble();
if(value<=0){
	break;
}
if(index==10){
break;
}
number[index]=value;
index++;
}
System.out.println("\nNumbers entered:");
 for(int i=0;i<index;i++){
 System.out.println(number[i]);
 total+=number[i];
 }
 System.out.println(total);
 }
 }