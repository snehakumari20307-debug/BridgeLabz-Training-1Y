import java.util.Arrays;
public class ArraysMethodExample{
public static void main(String args[]){
int[] arr={40,10,30,20};
System.out.println("Original Array:");
System.out.println(arr);
System.out.println(Arrays.toString(arr));
int index=Arrays.binarySearch(arr, 30);
System.out.println("Index of 30 :"+index);

}
}
