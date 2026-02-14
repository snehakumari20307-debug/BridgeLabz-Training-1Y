public  class MethodOverloadingExample{
static int addition(int a,int b){
return a+b;
}
static int addition(int a,int b,int c){
return a+b+c;
}
static double addition(double a,double b){
return a+b;
}
public static void main(String args[]){
int result = addition(10,20,30);
System.out.println(result);
int result2 = addition(10,20);
System.out.println(result2);
double result3 = addition(10,20);
System.out.println(result3);
}
}