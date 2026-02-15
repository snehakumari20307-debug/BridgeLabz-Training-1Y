import java.util.*;
public class MeanHeights{
public static void main(String args[]){
Scanner s = new Scanner(System.in);
double[] heights = new double[11];
double sum = 0.0;
System.out.println("Enter heights of 11 players:");
for(int i =0;i<11;i++){
System.out.println("player"+(i+1)+":");
heights[i]=s.nextDouble();
}
for(int i=0;i<11;i++){
sum+=heights[i];
}
double mean = sum/11;
System.out.println("\nMean height of the football team = " +mean);
}
}