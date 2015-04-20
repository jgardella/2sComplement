import java.util.Scanner;

public class TwosComplement 
{
	
	
	/**
	 * Calculates the total number of 1's needed to write all numbers in the range (start -> stop) using 2's complement notation.
	 * @param start Start of range (inclusive)
	 * @param end End of range (inclusive)
	 * @return Returns the  number of 1's needed to write all numbers in the given range.
	 */
	public static long numTwosComplementOnesRange(int start, int end)
	{
		long totalOnes = 0L;
		long numOnes;
		for(int i = start; i <= end; i++)
		{
			numOnes = numTwosComplementOnes(i);
			totalOnes += numOnes;
		}
		return totalOnes;
	}
	
	/**
	 * Calculates the number of 1's needed to write the given number using 2's complement notation.
	 * @param num Number to calculate number of 1's for
	 * @return Returns the number of 1's required to write the given number
	 */
	private static long numTwosComplementOnes(int num)
	{
		if (num >= 0) {
            return countPositive(num);
        } else if (num == -1) {
            return 32;
        }
        //if ((num & 1) == 1)//odd
            return 32 - countPositive((num * -1) - 1);
        //return 32 - countPositive((num * -1));
	}
    
    private static long countPositive(int num) {
        long sum = 0L;
        while (num != 0) {
            if ((num & 1) == 1)
                sum++;
            num = num >>> 1;
        }
        return sum;
        
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
