/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author informatica
 */
public class Sort {
    public static List<Integer> listaale;
    public static List<Integer> listaCre;
    public static List<Integer> listaDecre;
    public static List<Integer> listaMismo;
    public static Random rnd = new Random();
    private final int cont = 1000;
    private long startTime;
    private long endTime;
    private long duration;
    
    public Sort()
    {
        listaale = new ArrayList<Integer>();
        listaCre = new ArrayList<Integer>();
        listaDecre = new ArrayList<Integer>();
        listaMismo = new ArrayList<Integer>();
    }
    
    private void comprobarOrden(List<Integer> lista)
    {
        for (int i = 0; i < lista.size(); i++) {
             
            System.out.println(lista.get(i));
        }
    }
    private void RunTests()
    {
        
    }
    /**
     * 
     */
    private void desOrdenarAleatoria()
    {
        listaale.clear();
        for (int l = 0; l < 1000; l++) {
             
            listaale.add((int)(rnd.nextDouble() * 1000));
        }
    }
    public void ordenadaCreciente()
    {
        
         listaCre.clear();
        for (int l = 0; l < 1000; l++) {
             
            listaCre.add(l);
        }
        
    }
    public void ordenadaDecreciente()
    {
       listaDecre.clear();
        for (int l = 999; l >= 0; l--) {
             
            listaDecre.add(l);
        } 
    }
    public void listaMismoValor()
    {
        listaMismo.clear();
        for (int l = 999; l >= 0; l--) {
             
            listaMismo.add(4);
        } 
    }
    
    private double metodoBurbuja(List<Integer> lista)
    {
        double media = 0;
        List<Integer> listaaux;
        int tmp, j;
        boolean swapped;
        
        for (int y = 0; y<cont;y++)
        {
            listaaux = lista;
            startTime = System.nanoTime();
            swapped = true;
            j = 0;
            
            while (swapped) 
            {
                swapped = false;
                j++;
                for (int i = 0; i < lista.size() - j; i++) 
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
            media += duration;
            lista = listaaux;
        }
        return media/cont;
        
    }//FIN METODO BURBUJA
    
    public double metodoSeleccion(List<Integer> lista)
    {
        double media = 0;
        List<Integer> listaaux;
        int i, j, minIndex, tmp, n;
        for (int y=0; y< cont; y++)
        {
            listaaux = lista;
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
            media+=duration;
            lista = listaaux;
        }
        return media/cont;
        
    }//FIN METODO SELECCION
    
    public double metodoInsercion(List<Integer> lista)
    {
        double media = 0;
        List<Integer> listaaux;
        for (int y=0; y< cont; y++)
        {
            listaaux = lista;
            int i, j, newValue;
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
            media += duration;
            lista = listaaux;
        }
        return media/cont;
        
    }
    
    /**
     * 
     * @param left
     * @param right
     * @return 
     */
    public  int metodoQuick(List<Integer> lista, int left, int right)
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
   public  void quickSort(List<Integer> lista, int left, int right) {
      int index = metodoQuick(lista, left, right);
      if (left < index - 1)
            quickSort(lista,  left, index - 1);
      if (index < right)
            quickSort(lista,  index, right);
    }
   
   
      public  void divide(List<Integer> lista, int startIndex,int endIndex){
         
        //Divide till you breakdown your list to single element
        if(startIndex<endIndex && (endIndex-startIndex)>=1){
            int mid = (endIndex + startIndex)/2;
            divide(lista, startIndex, mid);
            divide(lista, mid+1, endIndex);        
             
            //merging Sorted array produce above into one sorted array
            merger(lista, startIndex,mid,endIndex);            
        }       
    }   
     
    public  void merger(List<Integer> lista, int startIndex,int midIndex,int endIndex){
         
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
    
    private double binariBusqueda(List<Integer> lista, int valor)
     {
         double media = 0;
         int centro;
         //Ordenamos el array por si acaso no estuviera ordenado
         Collections.sort(lista);
         //Recorremos N veces el array
         for (int i=0; i<cont; i++)
         {
             int n = lista.size(); 
            int inf=0,sup=n-1; 
            startTime = System.nanoTime();
            
            //Mientras la variable Inf sea menor o igual a sup que es final del array
            while(inf<=sup){ 
                //centro es igual la mitad del array actual
                centro=(int)(sup+inf)/2; 
                //Si en el centro esta nuestro valor
                if(lista.get(centro)==valor) 
                {    
                    //Se termina
                    break;
                }
                //Si no es el valor del centro y el valor es menor que el valor del centro
                else if(valor < lista.get(centro) )
                { 
                    //Tomamos el centro como parte de arriba
                    sup=centro-1; 
                } 
                else 
                {
                    //Sino ponemos el centro como la parte de abajo
                    inf=centro+1; 
                } 
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
         }
         //Devolvemos la media de los tiempos
         return media/cont;
     }
     private double secuBusqueda(List<Integer> lista,int valor)
     {
        double media = 0;
        
        //Recorremos N veces el bucle
        for (int i=0; i<cont; i++)
        {
            startTime = System.nanoTime();
            //Recorremos el LInkedList
            for (int y=0; y<lista.size();y++)
            {
                //Si encontramos el valor salimos del bucle
                if (lista.get(i)==valor)
                {
                    break; 
                }
            
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            
        } 
        //Devolvemos la media de tiempos
        return media/cont;
     }
   
    public  void RunTimes()
    {
        
      
        
         
        
        
       //Metodo Burbuja
       desOrdenarAleatoria();
       ordenadaCreciente();
       ordenadaDecreciente();
       listaMismoValor();
       System.out.println("Tiempo de metodo burbuja para lista aleatoria "+ metodoBurbuja(listaale) );
       System.out.println("Tiempo de metodo burbuja para lista creciente "+ metodoBurbuja(listaCre) );
       System.out.println("Tiempo de metodo burbuja para lista Decreciente "+ metodoBurbuja(listaDecre) );
       System.out.println("Tiempo de metodo burbuja para Lista con mismo valor "+ metodoBurbuja(listaMismo) );
       desOrdenarAleatoria();
       ordenadaCreciente();
       ordenadaDecreciente();
       listaMismoValor();
       
       System.out.println("Tiempo de metodo Seleccion para lista aleatoria "+ metodoSeleccion(listaale) );
       System.out.println("Tiempo de metodo Seleccion para lista creciente "+ metodoSeleccion(listaCre) );
       System.out.println("Tiempo de metodo Seleccion para lista Decreciente "+ metodoSeleccion(listaDecre) );
       System.out.println("Tiempo de metodo Seleccion para Lista con mismo valor "+ metodoSeleccion(listaMismo) );
       desOrdenarAleatoria();
       ordenadaCreciente();
       ordenadaDecreciente();
       listaMismoValor();
       System.out.println("Tiempo de metodo Insercion para lista aleatoria "+ metodoInsercion(listaale) );
       System.out.println("Tiempo de metodo Insercion para lista creciente "+ metodoInsercion(listaCre) );
       System.out.println("Tiempo de metodo Insercion para lista Decreciente "+ metodoInsercion(listaDecre) );
       System.out.println("Tiempo de metodo Insercion para Lista con mismo valor "+ metodoInsercion(listaMismo) );
       desOrdenarAleatoria();
       ordenadaCreciente();
       ordenadaDecreciente();
       listaMismoValor();
        
       
        
        
        
       
        
        
        
        double media = 0;
        for(int i=0; i<cont; i++)
        {
            startTime = System.nanoTime();
            quickSort(listaale, 0, listaale.size()-1);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media+=duration;
        }
       
        System.out.println("Tiempo de metodo quickSort para lista aleatoria : " + media/cont);
         media = 0;
        for(int i=0; i<cont; i++)
        {
            startTime = System.nanoTime();
            quickSort(listaCre, 0, listaCre.size()-1);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media+=duration;
        }
        System.out.println("Tiempo de metodo quickSort para lista creciente: " + media/cont);
          media = 0;
          for(int i=0; i<cont; i++)
        {
            startTime = System.nanoTime();
            quickSort(listaDecre, 0, listaDecre.size()-1);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media+=duration;
        }
        System.out.println("Tiempo de metodo quickSort para lista decreciente: " + media/cont);
        media = 0;
          for(int i=0; i<cont; i++)
        {
            startTime = System.nanoTime();
            quickSort(listaMismo, 0, listaMismo.size()-1);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media+=duration;
        }
        System.out.println("Tiempo de metodo quickSort para lista con Mismo valor: " + media/cont);
        
        desOrdenarAleatoria();
        ordenadaCreciente();
        ordenadaDecreciente();
        listaMismoValor();
        
        
        media = 0;
        for(int i=0; i<cont; i++)
        {
            startTime = System.nanoTime();
            divide(listaale, 0, listaale.size()-1);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media+=duration;
        }
        System.out.println("Tiempo de metodo Merge Sort para lista aleatoria : " + media/cont);
        media = 0;
        for(int i=0; i<cont; i++)
        {
            startTime = System.nanoTime();
            divide(listaCre, 0, listaCre.size()-1);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media+=duration;
        }
        System.out.println("Tiempo de metodo Merge Sort para lista creciente : " + media/cont);
        media = 0;
        for(int i=0; i<cont; i++)
        {
            startTime = System.nanoTime();
            divide(listaDecre, 0, listaDecre.size()-1);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media+=duration;
        }
        System.out.println("Tiempo de metodo Merge Sort para lista decreciente : " + media/cont);
        media = 0;
        for(int i=0; i<cont; i++)
        {
            startTime = System.nanoTime();
            divide(listaMismo, 0, listaMismo.size()-1);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media+=duration;
        }
        System.out.println("Tiempo de metodo Merge Sort para el mismo numero : " + media/cont);
        desOrdenarAleatoria();
        ordenadaCreciente();
        ordenadaDecreciente();
        listaMismoValor();
        System.out.println("Busqueda Binaria para lista aleatoria "+ binariBusqueda(listaale, 67) );
       System.out.println("Busqueda Binaria burbuja para lista creciente "+ binariBusqueda(listaCre, 67) );
       System.out.println("Busqueda Binaria burbuja para lista Decreciente "+ binariBusqueda(listaDecre, 67) );
       System.out.println("Busqueda Binaria burbuja para Lista con mismo valor "+ binariBusqueda(listaMismo, 67) );
       
       System.out.println("Busqueda Secuencial para lista aleatoria "+ secuBusqueda(listaale, 67) );
       System.out.println("Busqueda Secuencial burbuja para lista creciente "+ secuBusqueda(listaCre, 67) );
       System.out.println("Busqueda Secuencial burbuja para lista Decreciente "+ secuBusqueda(listaDecre, 67) );
       System.out.println("Busqueda Secuencial burbuja para Lista con mismo valor "+ secuBusqueda(listaMismo, 67) );
        
        
        
         
    }
    
}
