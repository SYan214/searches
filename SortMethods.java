import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;		// for testing purposes

/**
 *	SortMethods - Sorts an ArrayList of Strings in ascending order.
 *
 *	Requires FileUtils class to compile.
 *	Requires file randomWords.txt to execute a test run.
 *
 *	@author	Sophia Yan
 *	@since	January 11, 2024
 */
public class SortMethods {
	
	/**
	 *	Merge Sort algorithm - in ascending order
	 *	@param arr		List of String objects to sort
	 */
	public void mergeSort(List<String> arr) {
		if(arr.size() <= 1) {
			return;
		}
		else{ //you have 2 elements or more

			//create two arrays, one from left one from right
			int hfpt = arr.size()/2;

			List <String> leftArr = new ArrayList <>();
			List <String> rightArr = new ArrayList <>();

			//sort into the left and right arrays
			for (int i = 0 ; i < hfpt ; i++){
				leftArr.add(arr.get(i));
			}
			for (int i = hfpt ; i < arr.size() ; i++){
				rightArr.add(arr.get(i));
			}
			mergeSort(leftArr);
			mergeSort(rightArr);

			//this proceeds to this step when there is 1 element left in both left and right array
			int l = 0 , r = 0 , a = 0;
			//sort left and right arrays until entire done comparing two arrays
			while (l < leftArr.size() && r < rightArr.size()){
				if (leftArr.get(l).compareTo(rightArr.get(r)) < 0){
					arr.set(a, leftArr.get(l));
					l++;
				}
				else{
					arr.set(a, rightArr.get(r));
					r++;
				}
				a++;
			}
			//get remaining elements
			while (l < leftArr.size()){
				arr.set(a, leftArr.get(l));
				l++;
				a++;
			}
			while (r < rightArr.size()){
				arr.set(a, rightArr.get(r));
				r++;
				a++;
			}
		}
	}
	
	/**
	 *	Print an List of Strings to the screen
	 *	@param arr		the List of Strings
	 */
	public void printArray(List<String> arr) {
		if (arr.size() == 0) System.out.print("(");
		else System.out.printf("( %-15s", arr.get(0));
		for (int a = 1; a < arr.size(); a++) {
			if (a % 5 == 0) System.out.printf(",\n  %-15s", arr.get(a));
			else System.out.printf(", %-15s", arr.get(a));
		}
		System.out.println(" )");
	}
	
	/*************************************************************/
	/********************** Test program *************************/
	/*************************************************************/
	private final String FILE_NAME = "randomWords.txt";
	
	public static void main(String[] args) {
		SortMethods se = new SortMethods();
		se.run();
	}
	
	public void run() {
		List<String> arr = new ArrayList<String>();
		// Fill List with random words from file		
		fillArray(arr);
		
		System.out.println("\nMerge Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		mergeSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();
	}
	
	// Fill String array with words
	public void fillArray(List<String> arr) {
		Scanner inFile = FileUtils.openToRead(FILE_NAME);
		while (inFile.hasNext())
			arr.add(inFile.next());
		inFile.close();
	}
}
