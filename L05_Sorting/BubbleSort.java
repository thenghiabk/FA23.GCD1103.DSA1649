package fgw.L05_Sorting;

import java.util.Arrays;

public class BubbleSort {
    public void sort( int[] array ) {
        for ( int i = 0; i < array.length; i++ ) {
            for ( int j = 1; j < array.length; j++ ) {
                if ( array[ j ] < array[ j - 1 ] ) {
                    var temp = array[ j ];
                    array[ j ] = array[ j - 1 ];
                    array[ j - 1 ] = temp;
                }
            }
        }
    }

    public void sortEnhanced( int[] array ) {
        boolean isSorted;
        for ( int i = 0; i < array.length; i++ ) {
            isSorted = true;
            for ( int j = 1; j < array.length; j++ ) {
                if ( array[ j ] < array[ j - 1 ] ) {
                    var temp = array[ j ];
                    array[ j ] = array[ j - 1 ];
                    array[ j - 1 ] = temp;
                    isSorted = false;
                }
            }
            if ( isSorted ) {
                return;
            }
        }
    }

    public void sortEnhanced2( int[] array ) {
        boolean isSorted;
        for ( int i = 0; i < array.length; i++ ) {
            isSorted = true;
            for ( int j = 1; j < array.length - i; j++ ) {
                if ( array[ j ] < array[ j - 1 ] ) {
                    var temp = array[ j ];
                    array[ j ] = array[ j - 1 ];
                    array[ j - 1 ] = temp;
                    isSorted = false;
                }
            }
            if ( isSorted ) {
                return;
            }
        }
    }
}

class BubbleSortTest {
    public static void main( String[] args ) {
        int[] numbers = { 7, 3, 1, 4, 6, 2, 3 };
        // int[] numbers = { 7, 3 };
        // int[] numbers = { 7 };
        // int[] numbers = {  };
        var sorter = new BubbleSort( );
        sorter.sort( numbers );
        System.out.println( Arrays.toString( numbers ) );
    }
}