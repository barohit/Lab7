import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NameValidation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);  
		
		System.out.println("Please enter your name:");
		String name = scan.next(); 
		System.out.println(nameValidation(name)); 
		System.out.println("Please enter your email:");
		String email = scan.next(); 
		System.out.println(emailValidation(email)); 
		System.out.println("Please enter your number:");
		String phoneNumber = scan.next(); 
		System.out.println(phoneNumberValidation(phoneNumber)); 
		System.out.println("Please enter the date:");
		String date = scan.next(); 
		System.out.println(dateValidation(date)); 
		System.out.println("Please enter some HTML tags");  
		String html = scan.next(); 
		System.out.println(htmlValidation(html)); 
		scan.close(); 
	}
	
	public static String nameValidation(String input) { // cannot use try/catch because Strings can take anything. 
		
		boolean isValid = Pattern.matches("[A-Z]{1}[a-z]{0,29}", input);
		if (isValid) {
			return input; 
		} else {
			return "Sorry, invalid name."; 
		}
	}
	
	 public static String emailValidation(String input) {
		boolean isValid = Pattern.matches("\\w{5,30}@\\w{5,10}\\.\\w{2,3}", input); //only validates for emails in the
		//format specified in the lab. 
		if (isValid) {
			return input; 
		} else {
			return "Error, invalid email"; 
		}
		
	} 
	 
	 public static String phoneNumberValidation(String input) {
		 boolean isValid = Pattern.matches("\\d{3}-\\d{3}-\\d{4}", input); 
		 if (isValid)  {
			 return input; 
		 } else {
			 return "Sorry, invalid phone number"; 
		 }
	 }
	 
	 public static String dateValidation(String input) {
		 boolean isValid = Pattern.matches("([0-2][0-9]|[3][0-1])\\/([0][0-9]|[1][0-2])\\/\\d{4}", input); //technically any date could be in the last four digits, so it's simplified with the \\d{4} expression
				 
		 if (isValid)  {
			 return input; 
		 } else {
			 return "Sorry, invalid date"; 
		 }
	 }
	 
	 public static String htmlValidation(String input) {
		 int openingAngleBracketLocation = 0; 
		 int endAngleBracketLocation = 0; 
		 
		 try {
			 openingAngleBracketLocation = input.indexOf('<'); 
			 endAngleBracketLocation = input.indexOf('>');
		 } catch (NoSuchElementException e) {
			 return "Sorry, invalid tag"; 
		 }
		 String tagName = input.substring(openingAngleBracketLocation + 1, endAngleBracketLocation); // gets the name of the element. 
		
		 Pattern p = Pattern.compile("<(" + tagName + ")>([\\w\\W\\s\\S]*)<\\/(" + tagName + ")>"); // this is the
		 //most I can do, I do not know how to allow symbols as the expression in-between the tags as a valid element.
		 
		 Matcher m = p.matcher(input); 
		 boolean isValid = m.matches(); 
		 if (isValid) {
			 return input; 
		 } else {
			 return "Sorry, not a valid HTML tag"; 
		 }
					 
				
	 }
				
	 
		 
	 

}
