/******************************************************************
 *
 *  Adrian Mleczek / 001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {

        //create and populate the hash map
        HashMap<Integer, Integer> main = new HashMap<>();
        for(int i =0; i < list1.length;i++)
        {
           main.put(i, list1[i]);
        }
        
        //checks to see if each value in the subset(list2) is in the mainset(list1)
        for(int i=0; i<list2.length;i++)
        {
            if(main.containsValue(list2[i])==false)
            {
                return false;
            }
        }

        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     *
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {

        //creates and populates a priority queue
        PriorityQueue<Integer> sort = new PriorityQueue<>();
        for (int i: array)
        {
            sort.offer(i);
        }
        
        //removes values until only the K largest remain
        while(sort.size()>k)
        {
            sort.remove();
        }
        
        //returns the top of the queue, the smallest/kth-maximum value
        return sort.peek();
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        
        //creates array to sort results
        int[] results = new int[array1.length + array2.length];
        
        
        //creates PQ that is populated with elements from each list
        PriorityQueue<Integer> sorted = new PriorityQueue<>();
        for(int i: array1)
        {
            sorted.offer(i);
        }
         for(int x: array2)
        {
            sorted.offer(x);
        }
         
        //populates results[] by polling the PQ until its empty
        int z = 0;
        while (sorted.isEmpty()==false)
        {
            results[z]= sorted.poll();
            z++;
        }

        return results;
    }

}

