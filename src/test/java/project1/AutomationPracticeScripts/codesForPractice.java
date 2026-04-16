package project1.AutomationPracticeScripts;

public class codesForPractice {

	public static void main(String[] args) {
		//  Reverse a string without using built-in reverse methods
		 String name="Madam";
	       String str="";
	       for(int i=name.length()-1;i>=0;i--)
	       {
	           str=str+name.charAt(i);
	       }
	           if(str.equalsIgnoreCase(name))
	           {
	               System.out.println("String is palindrome");
	           }
	           else
	           {
	               System.out.println("String is not palindrome");
	           }
	       
		
		
		

	}

}
