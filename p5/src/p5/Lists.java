/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Practica que mide una serie de instrucciones de insercion, borrado, etc sobre unas LISTAS para comprobar los tiempos que tardan en hacer las operaciones
 * Es importante para la practica repetir la operacion muchas veces , un gran numero de veces para tener resultados correctos sino seria no válido
 * Los resultados nunca van a dar los mismo exactamente porque depende de muchisimos factores, no hay una situacion normalizada
 * Depende del ordenador, de los procesos que este realizando la la cpu y los distintos componenentes, del sistema operativo, hay una gran cantidad de variables a tener en cuenta
 * Lo que si que podemos tener en consideracion es que con la gran cantidad de resultados, podemos tener una idea mas o menos clara de que operaciones son mas eficientes
 * y dependiendo del caso usar unas u otras.
 * @author Pablo Javier Noguerol Santalices
 */
public class Lists {
    /**
     * Declaramos los atributos generales que vamos a usar
     */
    private ArrayList<Integer> listArray;
    private LinkedList<Integer> listLink;
    //ArrayList<Integer>media;
    private long startTime;
    private long endTime;
    private long duration;
    private final int repet=1000;
    
    
    
    public Lists()
    {
        /**
         * Inicializamos las listas que vamos a usar
         */
       listArray = new ArrayList<Integer>();
       listLink = new LinkedList<Integer>();
       
    }
    /**
     * Metodo por el cual vaciamos la lista del ArrayList
     * @return 
     */
    private double vaciarListasArray()
    {
        double media = 0;
        //Repetimos N veces
        for (int i=0; i<repet; i++)
        {
            //Comenzamos el tiempo
            startTime = System.nanoTime();
            //Borramos la lista
            for (int y = listArray.size()-1; y >=0; y--) {
                listArray.remove(i);
            }
            //Termimanos el tiempo
            endTime = System.nanoTime();
            //restamos el tiempo del final menos el de inicio
            duration = endTime - startTime;
            //Vamos añadiendo los valores tomamos y los vamos sumando
            media += duration;
        }
        //Devolvemos la media que calculamos diviendiendo las tomas entre la variable repet
        return media/repet;
        
        
        
        
    }
    /**
     * metodo por el cual vaciamos la lista del LinkedList
     * @return 
     */
    private double vaciarListasLink()
    {
        double media = 0;
        //Repetimos N veces
        for (int i=0; i<repet; i++)
        {
            startTime = System.nanoTime();
            //recorremos la lista de Linked y la borramos
            for (int y = listLink.size()-1; y >=0; y--) {
                listLink.remove(i);
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
        }
        return media/repet;
        
    }
    /**
     * Metodo por el cual borramos el ArrayList si no esta vacio y cargamos los valores
     */
    private void cargarListasArrayList()
    {
        //Borramos limpiar la lista
        listArray.clear();
        //Cargamos los datos en el ArrayList
        for (int i = 0; i < 1000; i++) {
            listArray.add(i);
        }
        
    }
    /**
     * Metodo por el cual borramos el LinkedList si no esta vacio y cargamos los valores
     */
    private void cargarListasLinkList(){
        
        //Borramos la linkedList
        listLink.clear();
        //Cargamos los datos en el LinkedList
        for (int i = 0; i < 1000; i++) {
            listLink.add(i);
        }
    }
    /**
     * Insertamos un elemento al final del arrayList
     * @return 
     */
    private double inserFinalArray()
    {
        double media = 0;
        //Repetimos N veces
        for (int i=0; i<repet; i++)
        {
            //Iniciamos el tiempo
            startTime = System.nanoTime();
            //Añadimos el valor 1000 al finak
            listArray.add(listArray.size(), 100);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            //Limpiamos al array
            cargarListasArrayList();
            
        }
        //Devolvemos la media
        return media/repet;
    }
    /**
     * metodo que insertamos un valor al final del Linked List
     * @return 
     */
    private double inserFinalLink()
    {
        double media = 0;
        for (int i=0; i<repet; i++)
        {
            
            startTime = System.nanoTime();
            //Añadimos el valor 1000 al finak
            listLink.add(listLink.size(), 1000);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
             //Limpiamos al array
            cargarListasLinkList();
            
        }
        return media/repet;
    }
    /**
     * Metodo que insertamos un valor al principio del array List
     * @return 
     */
    private double inserPrinArray()
    {
        double media = 0;
        //Repetimos N veces
        for (int i=0; i<repet; i++)
        {
            //comenzamos
            startTime = System.nanoTime();
            //Añadiomos el valor 0 al principio
            listArray.add(0, 0);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            //limpiamos al array para que la prueba sea correcta
            cargarListasArrayList();
            
        }
        //Devolvemos la media
        return media/repet;
    }
    /**
     * Metodo que insertamos un elemento al princio de un Linked List
     * @return 
     */
     private double inserPrinLink()
    {
        double media = 0;
        //Recorremos N veces
        for (int i=0; i<repet; i++)
        {
           //Comenzamos
            startTime = System.nanoTime();
            //Añadimos un elemento al principio
            listArray.add(0, 0);
            //Paramos el tiempo
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            //Limpiamos el array para que lso test sean siempre sobre lo mismo
            cargarListasLinkList();
            
        }
        //Devolvemos la media
        return media/repet;
    }
     /**
      * Metodo que inserta un elemento en medio de un array List
      * @return 
      */
    private double inseMediArray()
    {
        double media = 0;
        //recorremos N veces
        for (int i=0; i<repet; i++)
        {
            //Comenzamos
            startTime = System.nanoTime();
            //Insertamos por la mitad, el valor 500
            listArray.add((int)listArray.size()/2, 500);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            //Limpiamos el array para que la lista sea siempre la misma
            cargarListasArrayList();
            
        }
        //Devolvemos la media
        return media/repet; 
    }
    /**
     * Insertamos en el medio en un Linked List
     * @return 
     */
    private double inseMediLink()
    {
        double media = 0;
        //Repetimos N veces
        for (int i=0; i<repet; i++)
        {
            //Comenzamos el tiempo
            startTime = System.nanoTime();
            //Insertamos 500 por la mitad
            listLink.add((int)listLink.size()/2, 500);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            //Limpiamos la lista para basarnos siempre en la misma
            cargarListasLinkList();
            
        }
        //devolvemos la media
        return media/repet; 
    }
     /**
      * Borramos un elemento por posicion al final del ArrayList
      * @return 
      */
     private double elimFinArray()
     {
        double media = 0;
        //Recorremos N veces
        for (int i=0; i<repet; i++)
        {
            //Comenzamos
            startTime = System.nanoTime();
            //Borramos al final del array
            listArray.remove(listArray.size()-1);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            //Limpiamos la lista y la cargamos para que siempre sea la misma
            cargarListasArrayList();
            
        }
        //Devolvemos la media de tiempos
        return media/repet; 
         
     }
     /**
      * Eliminamos por posicion al final de un LinkedList
      * @return 
      */
     private double elimFinLink()
     {
        double media = 0;
        //Repetimos N veces
        for (int i=0; i<repet; i++)
        {
            //Comenzamos 
            startTime = System.nanoTime();
            //eliminamos por la mitad
            listLink.remove(listLink.size()-1);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            //Limpiamos el array y lo volvemos a cargar
            cargarListasLinkList();
            
        }
        //Devolvemos la media
        return media/repet; 
     }
     /**
      * Eliminamos por posicion al principio del ArrayList
      * @return 
      */
     private double elimPrinArray()
     {
        double media = 0;
        //Recorremos N veces
        for (int i=0; i<repet; i++)
        {
            //Comenzamos
            startTime = System.nanoTime();
            //Borramos al princoio
            listArray.remove(0);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            //Renovamos el array list
            cargarListasArrayList();
            
        }
        //devolvemos la media
        return media/repet; 
         
     }
      /**
       * Eliminamos por posicion al principio de un Linked Link
       * @return 
       */
     private double elimPrinLink()
     {
        double media = 0;
        //recorremos N veces
        for (int i=0; i<repet; i++)
        {
            //Comenzamos
            startTime = System.nanoTime();
            //Borramos al principio
            listLink.remove(0);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            //Limpiamos el array para usar siempre la misma lista
            cargarListasLinkList();
            
        }
        //Devolvemos la media
        return media/repet; 
     }
     /**
      * Eliminamos por en medio por posicion de un ArrayList
      * @return 
      */
     private double elimMediArray()
     {
        double media = 0;
        for (int i=0; i<repet; i++)
        {
            
            startTime = System.nanoTime();
            listArray.remove((int)listArray.size()/2);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            cargarListasArrayList();
            
        }
        return media/repet; 
     }
     /**
      * Eliminamos por en medio por posicon en un LinkedList
      * @return 
      */
      private double elimMediLink()
     {
        double media = 0;
        for (int i=0; i<repet; i++)
        {
            
            startTime = System.nanoTime();
            listLink.remove((int)listLink.size()/2);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            cargarListasLinkList();
            
        }
        return media/repet; 
     }
      /**
       * Eliminamos por valor en un Array List
       * @param valor
       * @return 
       */
      private double elimValorArray(int valor)
      {
        double media = 0;
         //repetimos N veces         
        for (int i=0; i<repet; i++)
        {
            //Comenzamos 
            startTime = System.nanoTime();
            //Borramos un elemento y dependiendo de la posicion sera antes o despues
            listArray.remove(new Integer(valor));
            
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            //Limpiamos el array para tener el resultado mas correcto
            cargarListasArrayList();
            
        }
        //Devolvemos la media de resultados
        return media/repet;  
      }
      /**
       * Eliminamos por valor los elementos en un Linked List
       * @param valor
       * @return 
       */
        private double elimValorLink(int valor)
      {
        double media = 0;
        //recorremos N veces        
        for (int i=0; i<repet; i++)
        {
            //Comenzamos
            startTime = System.nanoTime();
            //Eliminamos por valor dependiendo del valor pasado esta por el principio, medio o final
            listLink.remove(new Integer(valor));
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            //Limpiamos el array para tener siempre la misma lista
            cargarListasLinkList();
            
            
        }
        //Devolvemos el resultado
        return media/repet;  
      }
        /**
         * Busqueda por el metodo del propio ArrayList
         * @param valor
         * @return 
         */
     private double busqValorArray(int valor)
     {
        double media = 0;
                  
        for (int i=0; i<repet; i++)
        {
            
            startTime = System.nanoTime();
            //Metodo del propio array list
            listArray.indexOf(valor);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            
            
        }
        return media/repet;    
     }
     /**
      * Metodo que busca por el metodo del propio LInkedList
      * @param valor
      * @return 
      */
       private double busqValorLink(int valor)
      {
        double media = 0;
                  
        for (int i=0; i<repet; i++)
        {
            
            startTime = System.nanoTime();
            listLink.indexOf(valor);
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            
            
            
        }
        return media/repet;  
      }
     /**
      * Metodo que busca en un arrayList de forma secuencial
      * @param valor
      * @return 
      */  
     private double busqArrayArray(int valor)
     {
        double media = 0;
                  
        for (int i=0; i<repet; i++)
        {
            startTime = System.nanoTime();
            //Recorremos el array
            for (int y=0; y<listArray.size();y++)
            {
                //Si encontramos el valor salimos del bucle
                if (listArray.get(i)==valor)
                {
                    break; 
                }
            
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            
        } 
        //Devolvemos la media de los tiempos de las operaciones
        return media/repet;
     }
     /**
      * Metodo de busqueda secuencial de un valor en un LinkedList
      * @param valor
      * @return 
      */
     private double busqArrayLink(int valor)
     {
        double media = 0;
        
        //Recorremos N veces el bucle
        for (int i=0; i<repet; i++)
        {
            startTime = System.nanoTime();
            //Recorremos el LInkedList
            for (int y=0; y<listLink.size();y++)
            {
                //Si encontramos el valor salimos del bucle
                if (listLink.get(i)==valor)
                {
                    break; 
                }
            
            }
            endTime = System.nanoTime();
            duration = endTime - startTime;
            media += duration;
            
        } 
        //Devolvemos la media de tiempos
        return media/repet;
     }
     
     /**
      * Metodo de busqueda Binaria en un arrayList
      * @param valor
      * @return 
      */
     private double binariArray(int valor)
     {
         double media = 0;
         int centro;
         //Ordenamos el array por si acaso no estuviera ordenado
         Collections.sort(listArray);
         //Recorremos N veces el array
         for (int i=0; i<repet; i++)
         {
            int n = listArray.size(); 
            int inf=0,sup=n-1; 
            startTime = System.nanoTime();
            
            //Mientras la variable Inf sea menor o igual a sup que es final del array
            while(inf<=sup){ 
                //centro es igual la mitad del array actual
                centro=(int)(sup+inf)/2; 
                //Si en el centro esta nuestro valor
                if(listArray.get(centro)==valor) 
                {    
                    //Se termina
                    break;
                }
                //Si no es el valor del centro y el valor es menor que el valor del centro
                else if(valor < listArray.get(centro) )
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
         //Devolvemos la media de tiempos
         return media/repet;
     }
     /**
      * Metodo de Busqueda Binaria de un LinkedList
      * @param valor
      * @return 
      */
     private double binariLink(int valor)
     {
         double media = 0;
         int centro;
         //Ordenamos el array por si acaso no estuviera ordenado
         Collections.sort(listLink);
         //Recorremos N veces el array
         for (int i=0; i<repet; i++)
         {
             int n = listLink.size(); 
            int inf=0,sup=n-1; 
            startTime = System.nanoTime();
            
            //Mientras la variable Inf sea menor o igual a sup que es final del array
            while(inf<=sup){ 
                //centro es igual la mitad del array actual
                centro=(int)(sup+inf)/2; 
                //Si en el centro esta nuestro valor
                if(listLink.get(centro)==valor) 
                {    
                    //Se termina
                    break;
                }
                //Si no es el valor del centro y el valor es menor que el valor del centro
                else if(valor < listLink.get(centro) )
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
         return media/repet;
     }
     
    public void RunTimes()
    {   
        
       cargarListasArrayList();
       cargarListasLinkList();
       System.out.println("Insertar un elemento al final de un Array: "+inserFinalArray());
       System.out.println("Insertar un elemento al final de un Link: "+inserFinalLink());
       System.out.println("Insertar un elemento en el medio de un Array: "+inseMediArray());
       System.out.println("Insertar un elemento en el medio de un Link: "+inseMediLink());
       System.out.println("Insertar un elemento al final de un Array: "+inserFinalArray());
       System.out.println("Insertar un elemento al final de un Link: "+inserFinalLink());
       System.out.println("Borrar un elemento al final de un Array: "+elimFinArray());
       System.out.println("Borrar un elemento al final de un LINK: "+elimFinLink());
       System.out.println("Borrar un elemento en el medio de un Array: "+elimMediArray());
       System.out.println("Borrar un elemento en el medio de un Link: "+elimMediLink());
       System.out.println("Borrar un elemento en el principio de un Array: "+elimPrinArray());
       System.out.println("Borrar un elemento en el principio de un LInk: "+elimPrinLink());
       System.out.println("Borramos un elemento por valor al principio de un Array: "+elimValorArray(0));
       System.out.println("Borramos un elemento por valor al principio de una Link: "+elimValorLink(0));
       System.out.println("Borramos un elemento por valor en el medio de un Array: "+elimValorArray(500));
       System.out.println("Borramos un elemento por valor en el medio de una Link: "+elimValorLink(500));
       System.out.println("Borramos un elemento por valor al final de una Link: "+elimValorLink(999));
       System.out.println("Borramos un elemento por valor al final de una Link: "+elimValorLink(999));
       System.out.println("Buscamos un elemento con funciones del Array: "+ busqValorArray(500));
       System.out.println("Buscamos un elemento con funciones del Link: "+ busqValorLink(500));
       System.out.println("Buscamos un elemento secuencial al principio Array: "+ busqArrayArray(0) );
       System.out.println("Buscamos un elemento secuencial al princpio LInk: "+ busqArrayLink(0) );
       System.out.println("Buscamos un elemento secuencial en  medio Array: "+ busqArrayArray(500) );
       System.out.println("Buscamos un elemento secuencial en medio LInk: "+ busqArrayLink(500) );
       System.out.println("Buscamos un elemento secuencial al final Array: "+ busqArrayArray(999) );
       System.out.println("Buscamos un elemento secuencial al final LInk: "+ busqArrayLink(999) );
       System.out.println("Buscamos un elemento secuencial inexistente Array: "+ busqArrayArray(1500) );
       System.out.println("Buscamos un elemento secuencial inexistente LInk: "+ busqArrayLink(1500) );
       System.out.println("Buscamos un elemento por busquedad binaria al principio Array: "+ binariArray(0) );
       System.out.println("Buscamos un elemento por busquedad binaria al principio Link: "+ binariLink(0));
       System.out.println("Buscamos un elemento por busquedad binaria en medio Array: "+ binariArray(500) );
       System.out.println("Buscamos un elemento por busquedad binaria en medio Link: "+ binariLink(500));
       System.out.println("Buscamos un elemento por busquedad binaria al final Array: "+ binariArray(999) );
       System.out.println("Buscamos un elemento por busquedad binaria al final Link: "+ binariLink(999));
       System.out.println("Buscamos un elemento por busquedad binaria inexistente Array: "+ binariArray(1500) );
       System.out.println("Buscamos un elemento por busquedad binaria inexistente Link: "+ binariLink(1500));
       System.out.println("El tiempo de vaciado de un Array: "+vaciarListasArray());
       System.out.println("El tiempo de vaciado de un Array: "+vaciarListasLink());
        
        
    }
    
}
