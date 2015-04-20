package hackerrank;

import java.util.Hashtable;
import java.util.Scanner;

public class TwosComplement 
{
	
	
	/**
	 * Calculates the total number of 1's needed to write all numbers in the range (start -> stop) using 2's complement notation.
	 * @param start Start of range (inclusive)
	 * @param end End of range (inclusive)
	 * @return Returns the  number of 1's needed to write all numbers in the given range.
	 */
	public static int numTwosComplementOnesRange(int start, int end)
	{
		Hashtable<Integer, Integer> memoizationTable = new Hashtable<Integer, Integer>();
		int totalOnes = 0;
		int numOnes;
		for(int i = start; i <= end; i++)
		{
			numOnes = numTwosComplementOnes(i, memoizationTable);
			memoizationTable.put(i, numOnes);
			totalOnes += numOnes;
		}
		return totalOnes;
	}
	
	/**
	 * Calculates the number of 1's needed to write the given number using 2's complement notation.
	 * @param num Number to calculate number of 1's for
	 * @return Returns the number of 1's required to write the given number
	 */
	private static int numTwosComplementOnes(int num, Hashtable<Integer, Integer> memoizationTable)
	{
		int numOnes = 0;
		while(num != 0)
		{
			if(memoizationTable.containsKey(num))
				return numOnes + memoizationTable.get(num);
			if(memoizationTable.containsKey(-num - 1))
				return  numOnes + (32 - memoizationTable.get(-num - 1));
			if((num & 1) == 1)
				numOnes++;
			num >>>= 1;
		}
		return numOnes;
	}
	

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int numCases = scan.nextInt();
		int numOne, numTwo;
		for(int i = 0; i < numCases; i++)
		{
			numOne = scan.nextInt();
			numTwo = scan.nextInt();
			System.out.println(numTwosComplementOnesRange(numOne, numTwo));
		}
		scan.close();
	}

}
