package com.simplilearn.calculator;

import java.util.Scanner;

public class ArithmeticCalculator 
{


	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner(System.in);
		int b=1;
		
		while(b == 1)
		{
		System.out.println("Enter + for addition");
		System.out.println("Enter - for substraction");
		System.out.println("Enter * for Multiplication");
		System.out.println("Enter / for Division");
		
		char a = scan.next().charAt(0);
		double num1,num2,ans;
		
		System.out.println("Enter your First Number :");
		num1 = scan.nextDouble();
		System.out.println("Enter your Second number :");
		num2 = scan.nextDouble();
		
		if(a=='+') 
		{
			ans = num1+num2;
			System.out.println("The addition of two number is : " +ans);
		}
		
		else if(a=='-') 
		{ 
			ans = num1-num2;
			System.out.println("The substraction of two number is : " +ans);
		}
		
		else if(a=='*') 
		{
			ans = num1*num2;
			System.out.println("The multiplication of two number is : " +ans);
		}
		
		else if(a=='/') 
		{
			ans = num1/num2;
			if(num2 ==0) 
			{
				System.out.println("For a division divident can't be 0");
			}
			
			else 
			{
				System.out.println("The division of two number is : "+ans);
			}
		}
		
		else 
		{
			System.out.println("Wrong Operator !"+a);
		}
		
		System.out.println("Enter 1 to continue or 2 to exit ");
		b = scan.nextInt();
		
		}
		scan.close();
    }	
}
