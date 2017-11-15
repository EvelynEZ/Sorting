package sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Class full of static sorting methods. Used to sort Generic elements.
 *
 * @author Jiaqi Zhang
 *
 */

public class GenericSorter {
    /**
     * Sorts the given array of elements in ascending order according to the
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
     * 			thrown when the array is null or an element in the array is null.
     */
    public static <E> void  mergeSort(E[] array, Comparator<E> comparator) {
    	if (array == null){
    		throw new IllegalArgumentException();
    	}
    	for (E e:array){
    		if (e == null){
    			throw new IllegalArgumentException();
    		}
    	}
        if(array.length > 1){       	
        	E[] leftHalf = Arrays.copyOfRange(array, 0, array.length/2);
        	E[] rightHalf = Arrays.copyOfRange(array, array.length/2, array.length);
        	mergeSort(leftHalf, comparator);
        	mergeSort(rightHalf, comparator);
        	merge(array, leftHalf, rightHalf, comparator);
        }
    }
    
   /**
    * Combine two two given array into one with ascending values, using the comparator 
    * provided. 
    *
    * @param array
    *          the combined sorted array
    * @param left
    *          the left part of the array to combine
    * @param right
    *          the right part of the array to combine
    * @param comparator
    *          The comparator the will be used to compare two elements.
    */
    private static <E> void merge(E[] array, E[] left, E[] right, Comparator<E> comparator){
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
     * Sort the array of elements in ascending order according to the comparator
     * using selection sort.
     * 
     * @param array
     *            the array of elements that will be sorted.
     * @param comparator
     *            The comparator the will be used to compare two elements.
     * @exception null pointer
     * 			thrown when the array is null or an element in the array is null.
     */
    public static <E> void selectionSort(E[] array, Comparator<E> comparator) {
    	if (array == null){
    		throw new IllegalArgumentException();
    	}
    	for (E e:array){
    		if (e == null){
    			throw new IllegalArgumentException();
    		}
    	}
    	for (int currentIndex = 0; currentIndex < array.length - 1; currentIndex++){
    		int minIndex = currentIndex;
    		for (int outerIndex = currentIndex + 1; outerIndex < array.length; outerIndex++){
    			if(comparator .compare(array[outerIndex], array[minIndex]) < 0){
    				minIndex = outerIndex;
    			}
    		}
    		E min = array[minIndex];
    		array[minIndex] = array[currentIndex];
    		array[currentIndex] = min;
    	}
    }
    

    /**
     * Sort the array of elements in ascending order according to the comparator
     * using insertion sort.
     * 
     * @param array
     *            the array of elements that will be sorted.
     * @param comparator
     *            The comparator the will be used to compare two elements.
     * @exception null pointer
     * 			thrown when the array is null or an element in the array is null.
     */
    public static <E> void insertionSort(E[] array, Comparator<E> comparator) {
    	if (array == null){
    		throw new IllegalArgumentException();
    	}
    	for (E e:array){
    		if (e == null){
    			throw new IllegalArgumentException();
    		}
    	}
        for (int outerIndex = 1; outerIndex < array.length; outerIndex++) {
            E currentInt = array[outerIndex];
            int innerIndex = outerIndex - 1;
            while (innerIndex >= 0 && comparator.compare(currentInt, array[innerIndex]) < 0) {
                array[innerIndex + 1] = array[innerIndex];
                innerIndex--;
            }
            array[innerIndex + 1] = currentInt;
        }
    }
}
