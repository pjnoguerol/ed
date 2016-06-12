/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author informatica
 */
public class Sort {
    public static List<Integer> lista;
    public static Random rnd = new Random();
    
    public static void comprobarOrden()
    {
        for (int i = 0; i < 1000; i++) {
             
            System.out.println(lista.get(i));
        }
    }
    /**
     * 
     */
    public static void desOrdenar()
    {
        lista = new ArrayList<Integer>();
        for (int l = 0; l < 1000; l++) {
             
            lista.add((int)(rnd.nextDouble() * 1000));
        }
    }
    /**
     * 
     * @param left
     * @param right
     * @return 
     */
    public static int metodoQuick(int left, int right)
    {
      int i = left, j = right;
      int tmp;
      int pivot = lista.get((int)((left+right)/2));
     
      while (i <= j) {
            while (lista.get(i) < pivot)
                  i++;
            while (lista.get(j) > pivot)
                  j--;
            if (i <= j) {
                  tmp = lista.get(i);
                  lista.set(i, lista.get(j));
                  lista.set(j, tmp);
                  i++;
                  j--;
            }
      };
     
      return i;
    }
    /**
     * 
     * @param left
     * @param right 
     */
   public static void quickSort(int left, int right) {
      int index = metodoQuick(left, right);
      if (left < index - 1)
            quickSort( left, index - 1);
      if (index < right)
            quickSort( index, right);
    }
   
   
      public static void divide(int startIndex,int endIndex){
         
        //Divide till you breakdown your list to single element
        if(startIndex<endIndex && (endIndex-startIndex)>=1){
            int mid = (endIndex + startIndex)/2;
            divide(startIndex, mid);
            divide(mid+1, endIndex);        
             
            //merging Sorted array produce above into one sorted array
            merger(startIndex,mid,endIndex);            
        }       
    }   
     
    public static void merger(int startIndex,int midIndex,int endIndex){
         
        //Below is the mergedarray that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
        ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();
         
        int leftIndex = startIndex;
        int rightIndex = midIndex+1;
         
        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(lista.get(leftIndex)<=lista.get(rightIndex)){
                mergedSortedArray.add(lista.get(leftIndex));
                leftIndex++;
            }else{
                mergedSortedArray.add(lista.get(rightIndex));
                rightIndex++;
            }
        }       
         
        //Either of below while loop will execute
        while(leftIndex<=midIndex){
            mergedSortedArray.add(lista.get(leftIndex));
            leftIndex++;
        }
         
        while(rightIndex<=endIndex){
            mergedSortedArray.add(lista.get(rightIndex));
            rightIndex++;
        }
         
        int i = 0;
        int j = startIndex;
        //Setting sorted array to original one
        while(i<mergedSortedArray.size()){
            lista.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }
   
   
    public static void RunTimes()
    {
        
        long startTime;
        long endTime;
        long duration;
        int i, j, minIndex, tmp, n, newValue;
         
        
        //METODO BURBUJA
        desOrdenar();
        startTime = System.nanoTime();
        boolean swapped = true;
        j = 0;
        
        while (swapped) 
        {
            swapped = false;
            j++;
            for (i = 0; i < lista.size() - j; i++) 
            {                                       
                  if (lista.get(i) > lista.get(i+1)) 
                  {                          
                        tmp = lista.get(i);
                        lista.set(i,lista.get(i+1) );
                        lista.set(i+1, tmp);
                        swapped = true;
                  }
            }                
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Metodo Burbuja: " + duration);
        
        //Metodo Selection SOrt
        
        desOrdenar();
        startTime = System.nanoTime();
        n = lista.size();
        for (i = 0; i < n - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < n; j++)
                  if (lista.get(i) < lista.get(minIndex))
                        minIndex = j;
            if (minIndex != i) {
                  tmp = lista.get(i);
                  lista.set(i, lista.get(minIndex));
                  lista.set(minIndex, tmp);
                  
            }
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Metodo por seleccion: " + duration);
        
        //Metodo Insertion Sort
        desOrdenar();
        
        startTime = System.nanoTime();
        for (i = 1; i < lista.size(); i++) {
            newValue = lista.get(i);
            j = i;
            while (j > 0 && lista.get(i-1) > newValue) {
                  lista.set(j,lista.get(j-1) );
                  j--;
            }
            lista.set(j,newValue );
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Metodo por insercion: " + duration);
        
        //Metodo QuickSort
        desOrdenar();
        startTime = System.nanoTime();
        quickSort(0, lista.size()-1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Metodo por quicksort: " + duration);
        
        
        //Merge Sort
        desOrdenar();
        startTime = System.nanoTime();
        divide(0, lista.size()-1);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Metodo por Merge Sort: " + duration);
        
         
    }
    
}
