package com.simplilearn.longest;

import java.util.Scanner;

public class LongestIncreasingSubsq {

	public static void main(String[] args)
    {
  
    	Scanner sc = new Scanner(System.in);
    	System.out.println("How many number you want in the list ?");
    	int n = sc.nextInt();
    	int A[] = new int[n];
    	System.out.println("Enter the numbers: ");
    	for(int i=0;i<n;i++)
    	{
    		A[i] = sc.nextInt();
    	}
    	sc.close();

        System.out.println("Length of Longest Increasing Subsequence is " + LIS(A, n));
    }

	static int CI(int A[], int l, int r, int k)
    {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= k)
                r = m;
            else
                l = m;
        }
 
        return r;
    }

    static int LIS(int A[], int size)
    {
        
 
        int[] Tablee = new int[size];
        int length; 
 
        Tablee[0] = A[0];
        length = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < Tablee[0])
                
            	Tablee[0] = A[i];
 
            else if (A[i] > Tablee[length - 1])
                
                Tablee[length++] = A[i];
 
            else
                
                Tablee[CI(Tablee, -1, length - 1, A[i])] = A[i];
        }
 
        return length;
    }
}
