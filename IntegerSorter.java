package sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Class full of static sorting methods. Used to sort Integers.
 *
 * @author pattersp, Jiaqi Zhang
 *
 */

public class IntegerSorter {
    /**
     * Sorts the given array of integers in ascending order according to the
     * comparator using mergesort. 
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the integers to sort
     * @param comparator
     *            The comparator the will be used to compare two integers.
     * @exception null pointer
     * 		If null array passed.
     */
    public static void  mergeSort(Integer[] array, Comparator<Integer> comparator) {
    	if(array == null){
    		throw new IllegalArgumentException();
    	}
        if(array.length > 1){       	
        	Integer[] leftHalf = Arrays.copyOfRange(array, 0, array.length/2);
        	Integer[] rightHalf = Arrays.copyOfRange(array, array.length/2, array.length);
        	mergeSort(leftHalf, comparator);
        	mergeSort(rightHalf, comparator);
        	merge(array, leftHalf, rightHalf, comparator);
        }
    }
    
   /**
    * Combine two two given array into one with ascending values, using the integer comparator 
    * provided. 
    *
    * @param array
    *          the combined sorted array
    * @param left
    *          the left part of the array to combine
    * @param right
    *          the right part of the array to combine
    * @param comparator
    *          The comparator the will be used to compare two integers.
    */
    private static void merge(Integer[] array, Integer[] left, Integer[] right, Comparator<Integer> comparator){
    	int leftIndex = 0;
    	int rightIndex = 0;
    	for(int currentIndex = 0; currentIndex < array.length; currentIndex++){
    		if(rightIndex >= right.length || (leftIndex<left.length && comparator.compare(left[leftIndex], right[rightIndex]) < 0)){
    			array[currentIndex] = left[leftIndex];
    			leftIndex++;
    		} else {
    			array[currentIndex] = right[rightIndex];
    			rightIndex++;
    		}
    	}
    }
    
    /**
     * Sort the array of integers in ascending order according to the comparator
     * using selection sort.
     * 
     * @param array
     *            the array of integer that will be sorted.
     * @param comparator
     *            The comparator the will be used to compare two integers.
     * @exception null pointer
     * 		If null array passed.
     */
    public static void selectionSort(Integer[] array, Comparator<Integer> comparator) {
    	if(array == null){
    		throw new IllegalArgumentException();
    	}
    	for (int currentIndex = 0; currentIndex < array.length - 1; currentIndex++){
    		int minIndex = currentIndex;
    		for (int outerIndex = currentIndex + 1; outerIndex < array.length; outerIndex++){
    			if(comparator .compare(array[outerIndex], array[minIndex]) < 0){
    				minIndex = outerIndex;
    			}
    		}
    		Integer min = array[minIndex];
    		array[minIndex] = array[currentIndex];
    		array[currentIndex] = min;
    	}
    }
    

    /**
     * Sort the array of integers in ascending order according to the comparator
     * using insertion sort.
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the array of integers that will be sorted.
     * @param comparator
     *            The comparator the will be used to compare two integer.
     * @exception null pointer
     * 		If null array passed.
     */
    public static void insertionSort(Integer[] array, Comparator<Integer> comparator) {
    	if(array == null){
    		throw new IllegalArgumentException();
    	}
    	for (int outerIndex = 1; outerIndex < array.length; outerIndex++) {
            Integer currentInt = array[outerIndex];
            int innerIndex = outerIndex - 1;
            while (innerIndex >= 0 && comparator.compare(currentInt, array[innerIndex]) < 0) {
                array[innerIndex + 1] = array[innerIndex];
                innerIndex--;
            }
            array[innerIndex + 1] = currentInt;
        }
    }
}
