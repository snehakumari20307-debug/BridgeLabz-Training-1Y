import java.util.*;
public class MultiDToOneDArray{
public static void main(String args[]){
Scanner ab = new Scanner(System.in);
int r = ab.nextInt();
int c = ab.nextInt();
int[][] matrix = new int[r][c];
System.out.println("Enter matrix elements:");
for(int i=0;i<r;i++){
for(int j=0;j<c;j++){
matrix[i][j]=ab.nextInt();
}
}
int[]array = new int[r*c];
int index=0;
for(int i=0;i<r;i++){
for(int j=0;j<c;j++){
array[index]=matrix[i][j];
index++;
}
}
System.out.println("\nElements in 1D array:");
for(int i=0;i<array.length;i++){
System.out.println(array[i]+" ");
}
}
}