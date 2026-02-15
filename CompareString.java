
public class CompareString{
public static boolean compareCharAt(String s1,String s2){
if(s1.length()!=s2.length()){
return false;
}
for(int i=0;i<s1.length();i++){
if(s1.charAt(i)!=s2.charAt(i)){
return false;
}

}
return true;
}
public static void main(String args[]){
	String str1="hello";
	String str2="hello";
	boolean charAtResult = compareCharAt(str1, str2);
        boolean equalsResult = str1.equals(str2);
	System.out.println("Compare: "+compareCharAt(str1,str2));
	System.out.println("equals() comparsion:" +equalsResult);
}

}
