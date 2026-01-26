class VariableExample{


int id = 10; //instance Variable
String name = "Sneha"; //instance Variable
static int age= 20; //static variable
  
  void display(){ //method
  
  String status="Active"; //local variable
  System.out.println("Status"+status); //printing Statment
  }
public static void main(String args[]){
	//main method
	Variable__Example var= new Variable__Example();
}
}
String name = "Sneha"; 
int rollno;
static int age= 20; //static variable
  
  void display(){ //method
  
  String status="Active"; //local variable
  System.out.println("Status"+status); //printing Statment
  }
public static void main(String args[]){
	//main method
	VariableExample var= new VariableExample();
	var.display(); //non static method we have to create object
	var.rollno=20; //static method we have to access
	
	
	System.out.println(age);
	

}
}