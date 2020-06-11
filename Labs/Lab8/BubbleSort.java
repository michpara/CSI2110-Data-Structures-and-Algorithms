import java.util.ArrayList;

// ==========================================================================
// $Id: BubbleSort.java,v 1.1 2006/11/05 03:27:51 jlang Exp $
// CSI2110 Lab code; basic bubble sort 
// ==========================================================================
// (C)opyright:
//
//   SITE, University of Ottawa
//   800 King Edward Ave.
//   Ottawa, On., K1N 6N5
//   Canada. 
//   http://www.site.uottawa.ca
// 
// Creator: unknown (Lab source without reference), adapted by J.Lang
// Email:   jlang@site.uottawa.ca
// ==========================================================================
// $Log: BubbleSort.java,v $
// Revision 1.1  2006/11/05 03:27:51  jlang
// Added lab8 on sorting.
//
// Revision 1.2 2006/11/10  (Shantanu Das)
// Sorting Method changed to Mergesort
// ==========================================================================
/**
 * Implements merge-sort
 */
public class BubbleSort<T extends Comparable> {

  public BubbleSort(T[] _seq) {
	  mergeSort(_seq, 0, _seq.length-1);
  }
  
  public void mergeSort(T[] array, int start, int end) {
	  if(start < end) {
		  int middle = (start + end)/2;
		  mergeSort(array, start, middle);
		  mergeSort(array, middle+1, end);
		  merge(array, start, middle, end);
	  }
  }
  
  public void merge(T[] array, int start, int middle, int end) {
	  int leftSize = middle - start + 1;
	  int rightSize = end - middle;
	  
      ArrayList<T> temp1 = new ArrayList<T>(leftSize);
      ArrayList<T> temp2 = new ArrayList<T>(rightSize);
      
	  for(int i =0; i<leftSize; ++i) {
		  temp1.add(i, array[start + i]);
	  }
	  
	  for(int j = 0; j<rightSize; ++j) {
		  temp2.add(j, array[(middle + 1) + j]);
	  }
	  
	  int i = 0, j = 0;
	  
	  int k = start;
	  while(i < leftSize && j < rightSize ) {
		  if(temp1.get(i).compareTo(temp2.get(j)) <= 0) {
			  array[k] = temp1.get(i);
			  i++;
		  }else {
			  array[k] = temp2.get(j);
			  j++;
		  }
		  k++;
	  }
	  
      /* Copy remaining elements of L[] if any */
      while (i < leftSize) { 
          array[k] = temp1.get(i); 
          i++; 
          k++; 
      } 

      /* Copy remaining elements of R[] if any */
      while (j < rightSize) { 
          array[k] = temp2.get(j); 
          j++; 
          k++; 
      } 
  }
}
