/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_pack;

/**
 *
 * @author ManhTri
 */
public class Validation {
    public static <T extends Comparable<? super T>> boolean
            linearSearch(T[] data, int min, int max, T target) {
        int index = min;
        boolean found = false;
        while (!found && index <= max) {
            if (data[index].compareTo(target) == 0) {
                found = true;
            }
            index++;
        }
        return found;
    }
    
            
    int[] data;
    int size = 0;

    public boolean binarySearch(int key) {
        int low = 0;
        int high = size - 1;

        while (high >= low) {
            int middle = (low + high) / 2;
            if (data[middle] == key) {
                return true;
            }
            if (data[middle] < key) {
                low = middle + 1;
            }
            if (data[middle] > key) {
                high = middle - 1;
            }
        }
        return false;
    }
    
    
    public static int arraySum(int[] data, int n) {
        if (n == 0) {
            return 0;
        } else {
            return arraySum(data, n-1) + data[n-1];
        }
    }

}
