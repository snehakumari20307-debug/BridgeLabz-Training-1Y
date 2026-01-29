
import java.util.*;
public class TriangleChecker{
public static void main(String args[]){
Scanner input = new Scanner(System.in);
int x = input.nextInt();
int y = input.nextInt();
int z = input.nextInt();
int sumofAngle=x+y+z;
System.out.println("the given angles"+x+","+y+","+z+"add to"+sumofAngle);
if(sumofAngle == 180){
System.out.println("The given angle are internal angle of a "+"Triangle");
}
else{
System.out.println("The given angle are not internal angle of a "+"Triangle");
}
}
}
