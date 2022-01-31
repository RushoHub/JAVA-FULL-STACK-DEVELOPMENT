package com.simplilearn.EmailID;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmailValidation {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		ArrayList<String> address = new ArrayList<>();
		
		System.out.println("Enter the no of emails you want to add");
		int n = sc.nextInt();
		
		System.out.println("Enter the mail ids you want to add ");
		for(int i=0; i<n; i++)
		{
            address.add(sc.next());
		}
		
		System.out.println("Enter your mail id -");
		String a = sc.next();
        sc.close();
        
        boolean mail = address.contains(a);
        
        if(EmailIsValid(a) && mail)
             System.out.println("Email is valid and ready for login !");
        else if(EmailIsValid(a))
        	 System.out.println("Email is not registed !");
        else
        	System.out.println("Email is not valid !");
	}
	
    public static boolean EmailIsValid(String email)
	
    {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+"[a-zA-Z0-9_+&*-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }
}
