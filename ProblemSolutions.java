/******************************************************************
 *
 *   Arthur Heredia / COMP 272 002 F25
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /*
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     * Input: [1,50,55,80,90], [55,90]
     * Output: true
     * Input: [1,50,55,80,90], [55,90, 99]
     * Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return - returns boolean value B is a subset of A.
     *
     * -----------------------------------------------------------------------------------------------------------------
     *
     * Pseudocode:
     *
     * 1. Create an empty HashSet called setA
     *
     * 2. Loop through every element in list1 (the larger array A):
     * a. Add each element into setA
     *
     * 3. Loop through every element in list2 (the smaller array B):
     * a. For each element, check if it exists in setA
     * b. If any element is NOT found in setA, return false immediately
     *
     * 4. If the loop completes without finding a missing element, return true
     *
     */

    public boolean isSubset(int list1[], int list2[]) {
        // 1. Create a HashSet to store all elements from list1
        HashSet<Integer> setA = new HashSet<>();

        // 2. Add all elements from list1 into the set
        for (int num : list1) {
            setA.add(num);  // O(1) average insertion time
        }

        // 3. Check if every element in list2 exists in setA
        for (int num : list2) {
            if (!setA.contains(num)) {   // if missing, not a subset
                return false;            // early exit
            }
        }

        // 4. All elements in list2 were found in list1
        return true;
    }


    /*
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     * Input: [1,7,3,10,34,5,8], 4
     * Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return - the value in the array which is the kth maximum value
     *
     * -----------------------------------------------------------------------------------------------------------------
     *
     * Pseudocode:
     *
     * 1. Create a min-heap of integers
     *
     * 2. Loop through every element in the array:
     * a. Add each element to the min-heap
     * b. If the heap size becomes greater than k,
     * remove the smallest element
     *
     *3. After processing all elements, the peek will contain
     * the k-th largest element
     *
     * 4. Return the value at the top of the heap
     *
     */

    public int findKthLargest(int[] array, int k) {
        // 1. Create a min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 2. Loop through all elements in the array
        for (int num : array) {
            minHeap.add(num);   // 2a. Add each element to the heap

            // 2b. If heap grows beyond size k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();  // remove smallest to maintain only k largest elements
            }
        }

        // 3. The smallest element in the heap is now the k-th largest
        return minHeap.peek();
    }


    /*
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     * Input: [4,1,5], [3,2]
     * Output: 1 2 3 4 5
     *
     * @param array1 - Input array 1
     * @param array2 - Input array 2
     * @return - Sorted array with all elements in A and B.
     * -----------------------------------------------------------------------------------------------------------------
     *
     * Pseudocode:
     *
     * 1. Create a new array called combined with a size equal to the total
     * number of elements in both arrays (array1.length + array2.length)
     *
     * 2. Copy all elements from array1 into the combined array
     *
     * 3. Copy all elements from array2 into the combined array after the last
     * index of array1
     *
     * 4. Sort the combined array using Arrays.sort()
     *
     * 5. Return the sorted combined array
     *
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        // 1. Create a new array large enough to hold both arrays
        int[] combined = new int[array1.length + array2.length];

        // 2. Copy elements from array1 into combined
        for (int i = 0; i < array1.length; i++) {
            combined[i] = array1[i];
        }

        // 3. Copy elements from array2 into combined after array1’s elements
        for (int j = 0; j < array2.length; j++) {
            combined[array1.length + j] = array2[j];
        }

        // 4. Sort the combined array
        Arrays.sort(combined);

        // 5. Return the sorted result
        return combined;
    }

}