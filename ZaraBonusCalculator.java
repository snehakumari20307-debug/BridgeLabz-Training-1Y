import java.util.*;
public class ZaraBonusCalculator{
public static void main(String args[]){
Scanner ab = new Scanner(System.in);
double[][] employeeData = new double[10][2];
double[][] bonusData = new double[10][2];
double totalbonus = 0;
double totalOldSalary = 0;
double totalNewsalary = 0;
for(int i=0;i<10;i++){
System.out.println("enter detail for employee"+(i+1));
System.out.println("enter Salary:");
double Salary = ab.nextInt();
System.out.println("Enter year:");
double Year = ab.nextInt();
if(Salary<=0||Year<0){
System.out.println("invalid input!");
i--;
continue;
}
employeeData[i][0]=Salary;
employeeData[i][1]=Year;
}
for(int i=0;i<10;i++){
double Salary=employeeData[i][0];
double Year=employeeData[i][1];
double bonus;
if(Year>5){
bonus=Salary*0.05;
}
else{
bonus=Salary*0.02;
}
double newSalary = Salary+bonus;
bonusData[i][0]=bonus;
bonusData[i][1]=newSalary;
totalbonus += bonus;
totalOldSalary += Salary;
totalNewsalary += newSalary;
}
System.out.println("\n----- Employee Bonus Details -----");
for(int i=0;i<10;i++){
System.out.println("Employee"+(i+1)+"|Old Salary:"+employeeData[i][0]+"|Bonus:"+bonusData[i][0]+"|New Salary:"+bonusData[i][1]);
}
}
}

