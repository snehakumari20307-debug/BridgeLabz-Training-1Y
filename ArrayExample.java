
import java.util.*;
public class ArrayExample{
public static void main(String args[]){
int marks[] = {12,14,16,18,20};
System.out.println("Using for each loop");
for(int i:marks){
	System.out.println(""+i);
}
System.out.println(marks[1]);
System.out.println("update Array Elements:");
marks[3]=100;
for(int i=0;i<marks.length;i++){
System.out.println(marks[i]);
}
System.out.println("Enter your number:");
Scanner ab=new Scanner(System.in);

int m= ab.nextInt();
for(int i=0;i<marks.length;i++){
	if(marks[i]==m){
		System.out.println("number found at index:"+i);
	}
}
}
}
