package sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Class full of static sorting methods. Used to sort packets received from a
 * server containing image metadata.
 * 
 * @author pattersp, Jiaqi Zhang
 *
 */

public class PacketSorter {
    /**
     * Sorts the given array of packets in ascending order according to the
     * comparator using mergesort. 
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the packets to sort
     * @param comparator
     *            The comparator the will be used to compare two packets.
     * @exception null pointer
     * 			If null array passed or an element in the array is null.
     */
    public static void mergeSort(Packet[] array, Comparator<Packet> comparator) {
    	if(array == null){
    		throw new IllegalArgumentException();
    	}
    	for (Packet p: array){
    		if (p == null){
    			throw new IllegalArgumentException();
    		}
    	}
        if(array.length > 1){       	
        	Packet[] leftHalf = Arrays.copyOfRange(array, 0, array.length/2);
        	Packet[] rightHalf = Arrays.copyOfRange(array, array.length/2, array.length);
        	mergeSort(leftHalf, comparator);
        	mergeSort(rightHalf, comparator);
        	merge(array, leftHalf, rightHalf, comparator);
        }
    }
    
   /**
    * Combine two two given array into one with ascending values, using the packet comparator 
    * provided. 
    * @param array
    *          the combined sorted array
    * @param left
    *          the left part of the array to combine
    * @param right
    *          the right part of the array to combine
    * @param comparator
    *          The comparator the will be used to compare two packets.
    */
    private static void merge(Packet[] array, Packet[] left, Packet[] right, Comparator<Packet> comparator){
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
     * Sort the array of packets in ascending order using selection sort.
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the array of packets that will be sorted.
     * @param comparator
     *            The comparator the will be used to compare two packets.
     * @exception null pointer
     * 			If null array passed or an element in the array is null.
     */
    public static void selectionSort(Packet[] array, Comparator<Packet> comparator) {
    	if(array == null){
    		throw new IllegalArgumentException();
    	}
    	for (Packet p: array){
    		if (p == null){
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
    		Packet min = array[minIndex];
    		array[minIndex] = array[currentIndex];
    		array[currentIndex] = min;
    	}
    }

    /**
     * Sort the array of packets in ascending order using insertion sort.
     * 
     * A note about ascending order:
     * 
     * When the method is finished, it should be true that:
     * comparator.compare(array[i - 1], array[i]) <= 0 for all i from 1 through
     * array.length.
     * 
     * @param array
     *            the array of packets that will be sorted.
     * @param comparator
     *            The comparator the will be used to compare two packets.
     * @exception null pointer
     * 			If null array passed or an element in the array is null.
     */
    public static void insertionSort(Packet[] array,  Comparator<Packet> comparator) {
    	if(array == null){
    		throw new IllegalArgumentException();
    	}
    	for (Packet p: array){
    		if (p == null){
    			throw new IllegalArgumentException();
    		}
    	}
        for (int outerIndex = 1; outerIndex < array.length; outerIndex++) {
            Packet currentPacket = array[outerIndex];
            int innerIndex = outerIndex - 1;
            while (innerIndex >= 0
                    && comparator.compare(currentPacket, array[innerIndex]) < 0) {
                array[innerIndex + 1] = array[innerIndex];
                innerIndex--;
            }
            array[innerIndex + 1] = currentPacket;
        }
    }
}
