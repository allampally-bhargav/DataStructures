
import java.util.*;

public class HeapSort {
	
	public static void main(String[] args)
	{
		HeapSort hs = new HeapSort();
		Random r = new Random();
		
		int[] intArray = new int[25];
		intArray[0] = intArray.length - 1;
		
		for(int i=1; i< intArray.length; i++)
		{
			intArray[i] = r.nextInt(50);
		}
	
	
		System.out.println("Random list of elements in an array where index zero is equal to the number of nodes");
		hs.PrintArray(intArray);
		
		hs.sort(intArray);
		System.out.println("Array after converting into a heap, where index zero is equal to the number of nodes");
		hs.PrintArray(intArray);
		
		hs.heapSort(intArray);
		System.out.println("Heap after sorting, where index zero decreases by 1 through each pass");
		hs.PrintArray(intArray);
		
		
		
	}
	
	public void sort(int [] intArray)
	{
		int n  = intArray[0];
		
		for(int i = n/2; i>0;i--)
		{
			heapify(intArray,n,i);
		}
		
		
	}
	
	
	public void swapMaximum(int[] intArray)
	{
		int c = intArray[0];
		
		int temp = intArray[c];
		intArray[c] = intArray[1];
		intArray[1] = temp;
		
		intArray[0] = intArray[0] - 1;
		
	}
	
	public void heapSort(int [] intArray)
	{

		while (intArray[0] >1)
			{
			
				sort(intArray);
				swapMaximum(intArray);			
			}
		
	}
	
	public void heapify(int[] intArray, int n, int i)
	{
		int maximum= i;
		int leftnode = 2*i;
		int rightnode = (2*i)+1;
		
		
		if(leftnode <= n && intArray[leftnode] > intArray[maximum])
			maximum = leftnode;
		
		if(rightnode <= n && intArray[rightnode] > intArray[maximum])
			maximum = rightnode;
		
		if(maximum != i)
		{
			int temp = intArray[i];
			intArray[i] = intArray[maximum];
			intArray[maximum]= temp;
			
			heapify(intArray,n, maximum);
		}
		
	}
	
	public void PrintArray(int[] intArray)
	{
		for(int i=0; i< intArray.length; i++)
			System.out.print(intArray[i]+ " ");
		
		System.out.println("\n");
	}
	
	
}

