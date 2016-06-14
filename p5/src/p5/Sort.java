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
 * Practica que mide una serie de metodos de ordenacion sobre un LIST , burbuja, seleccion, insercion, etc
 * Es importante para la practica repetir la operacion muchas veces , un gran numero de veces para tener resultados correctos sino seria no válido
 * Los resultados nunca van a dar los mismo exactamente porque depende de muchisimos factores, no hay una situacion normalizada
 * Depende del ordenador, de los procesos que este realizando la la cpu y los distintos componenentes, del sistema operativo, hay una gran cantidad de variables a tener en cuenta
 * Lo que si que podemos tener en consideracion es que con la gran cantidad de resultados, podemos tener una idea mas o menos clara de que operaciones son mas eficientes
 * y dependiendo del caso usar unas u otras.
 * @author Pablo Javier Noguerol Santalices
 */
public class Sort {
    
    private List<Integer> listaale;
    private  List<Integer> listaCre;
    private  List<Integer> listaDecre;
    private  List<Integer> listaMismo;
    private static Random rnd = new Random();
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
    private boolean RunTests(List<Integer> lista1, List<Integer> lista2)
    {
        boolean igual = true;
        //Ordenamos el array 1
        Collections.sort(lista1);
        //Comparamos que tengan el mismo tamaño
        if (lista1.size() == lista2.size())
        {
        for (int temp : lista1)
              if(!lista2.contains(temp))
              {
                 igual = false;
                 break;
              }
        }
        else
            igual = false;
         return igual;
         
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
    private void ordenadaCreciente()
    {
        
         listaCre.clear();
        for (int l = 0; l < 1000; l++) {
             
            listaCre.add(l);
        }
        
    }
    private void ordenadaDecreciente()
    {
       listaDecre.clear();
        for (int l = 999; l >= 0; l--) {
             
            listaDecre.add(l);
        } 
    }
    private void listaMismoValor()
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
            listaaux = new ArrayList<>(lista);
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
            lista = new ArrayList<>(listaaux);
        }
        return media/cont;
        
    }//FIN METODO BURBUJA
    
    private double metodoSeleccion(List<Integer> lista)
    {
        double media = 0;
        List<Integer> listaaux;
        int i, j, minIndex, tmp, n;
        for (int y=0; y< cont; y++)
        {
            listaaux = new ArrayList<>(lista);
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
            lista = new ArrayList<>(listaaux);
        }
        return media/cont;
        
    }//FIN METODO SELECCION
    
    private double metodoInsercion(List<Integer> lista)
    {
        double media = 0;
        List<Integer> listaaux;
        for (int y=0; y< cont; y++)
        {
            listaaux = new ArrayList<>(lista);
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
            lista = new ArrayList<>(listaaux);
        }
        return media/cont;
        
    }
    
    /**
     * 
     * @param left
     * @param right
     * @return 
     */
    private int metodoQuick(List<Integer> lista, int left, int right)
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
   private  void quickSort(List<Integer> lista, int left, int right) {
      int index = metodoQuick(lista, left, right);
      if (left < index - 1)
            quickSort(lista,  left, index - 1);
      if (index < right)
            quickSort(lista,  index, right);
    }
   
   
      private  void divide(List<Integer> lista, int startIndex,int endIndex){
         
        //Divide till you breakdown your list to single element
        if(startIndex<endIndex && (endIndex-startIndex)>=1){
            int mid = (endIndex + startIndex)/2;
            divide(lista, startIndex, mid);
            divide(lista, mid+1, endIndex);        
             
            //merging Sorted array produce above into one sorted array
            merger(lista, startIndex,mid,endIndex);            
        }       
    }   
     
    private void merger(List<Integer> lista, int startIndex,int midIndex,int endIndex){
         
        
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
      //Creamos unos LIst aux que nos serviran para guardar el array inicial sin ordenar
      List<Integer> listaaleaux;
      List<Integer> listaCreaux;
      List<Integer> listaDecreaux;
      List<Integer> listaMismoaux;
        
         
        
        
       //Metodo Burbuja
       desOrdenarAleatoria();
       listaaleaux = new ArrayList<>(listaale);
       ordenadaCreciente();
       listaCreaux = new ArrayList<>(listaCre);
       ordenadaDecreciente();
       listaDecreaux = new ArrayList<>(listaDecre);
       listaMismoValor();
       listaMismoaux = new ArrayList<>(listaMismo);
       
       System.out.println("Tiempo de metodo burbuja para lista aleatoria "+ metodoBurbuja(listaale) );
       System.out.println("Tiempo de metodo burbuja para lista creciente "+ metodoBurbuja(listaCre) );
       System.out.println("Tiempo de metodo burbuja para lista Decreciente "+ metodoBurbuja(listaDecre) );
       System.out.println("Tiempo de metodo burbuja para Lista con mismo valor "+ metodoBurbuja(listaMismo) );
       
       System.out.println("TEST UNITARIO burbuja LISTA aleatoria :"+ RunTests(listaaleaux, listaale));
       System.out.println("TEST UNITARIO burbuja LISTA creciente :"+RunTests(listaCreaux, listaCre));
       System.out.println("TEST UNITARIO burbuja LISTA decreciente :"+RunTests(listaDecreaux, listaDecre));
       System.out.println("TEST UNITARIO burbuja Misma lista :"+RunTests(listaMismoaux, listaMismo));
       
       
       desOrdenarAleatoria();
       listaaleaux = new ArrayList<>(listaale);
       ordenadaCreciente();
       listaCreaux = new ArrayList<>(listaCre);
       ordenadaDecreciente();
       listaDecreaux = new ArrayList<>(listaDecre);
       listaMismoValor();
       listaMismoaux = new ArrayList<>(listaMismo);
       
       System.out.println("Tiempo de metodo Seleccion para lista aleatoria "+ metodoSeleccion(listaale) );
       System.out.println("Tiempo de metodo Seleccion para lista creciente "+ metodoSeleccion(listaCre) );
       System.out.println("Tiempo de metodo Seleccion para lista Decreciente "+ metodoSeleccion(listaDecre) );
       System.out.println("Tiempo de metodo Seleccion para Lista con mismo valor "+ metodoSeleccion(listaMismo) );
       
       
       System.out.println("TEST UNITARIO Seleccion  LISTA aleatoria :"+ RunTests(listaaleaux, listaale));
       System.out.println("TEST UNITARIO Seleccion  LISTA creciente :"+RunTests(listaCreaux, listaCre));
       System.out.println("TEST UNITARIO Seleccion  LISTA decreciente :"+RunTests(listaDecreaux, listaDecre));
       System.out.println("TEST UNITARIO Seleccion  Misma lista :"+RunTests(listaMismoaux, listaMismo));
       
       
       desOrdenarAleatoria();
       listaaleaux = new ArrayList<>(listaale);
       ordenadaCreciente();
       listaCreaux = new ArrayList<>(listaCre);
       ordenadaDecreciente();
       listaDecreaux = new ArrayList<>(listaDecre);
       listaMismoValor();
       listaMismoaux = new ArrayList<>(listaMismo);
       
       System.out.println("Tiempo de metodo Insercion para lista aleatoria "+ metodoInsercion(listaale) );
       System.out.println("Tiempo de metodo Insercion para lista creciente "+ metodoInsercion(listaCre) );
       System.out.println("Tiempo de metodo Insercion para lista Decreciente "+ metodoInsercion(listaDecre) );
       System.out.println("Tiempo de metodo Insercion para Lista con mismo valor "+ metodoInsercion(listaMismo) );
       
       System.out.println("TEST UNITARIO Insercion LISTA aleatoria :"+ RunTests(listaaleaux, listaale));
       System.out.println("TEST UNITARIO Insercion LISTA creciente :"+RunTests(listaCreaux, listaCre));
       System.out.println("TEST UNITARIO Insercion LISTA decreciente :"+RunTests(listaDecreaux, listaDecre));
       System.out.println("TEST UNITARIO Insercion Misma lista :"+RunTests(listaMismoaux, listaMismo));
       
       
       
       desOrdenarAleatoria();
       listaaleaux = new ArrayList<>(listaale);
       ordenadaCreciente();
       listaCreaux = new ArrayList<>(listaCre);
       ordenadaDecreciente();
       listaDecreaux = new ArrayList<>(listaDecre);
       listaMismoValor();
       listaMismoaux = new ArrayList<>(listaMismo);
        
        
       
        
        
        
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
        
        
        System.out.println("TEST UNITARIO quickSort LISTA aleatoria :"+ RunTests(listaaleaux, listaale));
       System.out.println("TEST UNITARIO quickSort LISTA creciente :"+RunTests(listaCreaux, listaCre));
       System.out.println("TEST UNITARIO quickSort LISTA decreciente :"+RunTests(listaDecreaux, listaDecre));
       System.out.println("TEST UNITARIO quickSort Misma lista :"+RunTests(listaMismoaux, listaMismo));
       
        
        
         desOrdenarAleatoria();
       listaaleaux = new ArrayList<>(listaale);
       ordenadaCreciente();
       listaCreaux = new ArrayList<>(listaCre);
       ordenadaDecreciente();
       listaDecreaux = new ArrayList<>(listaDecre);
       listaMismoValor();
       listaMismoaux = new ArrayList<>(listaMismo);
        
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
        
        System.out.println("TEST UNITARIO Merge Sort LISTA aleatoria :"+ RunTests(listaaleaux, listaale));
       System.out.println("TEST UNITARIO Merge Sort LISTA creciente :"+RunTests(listaCreaux, listaCre));
       System.out.println("TEST UNITARIO Merge Sort LISTA decreciente :"+RunTests(listaDecreaux, listaDecre));
       System.out.println("TEST UNITARIO Merge Sort Misma lista :"+RunTests(listaMismoaux, listaMismo));
       
        
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
