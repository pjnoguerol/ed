/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crewmanagement;

import java.util.Arrays;

/**
 * Esta es una clase que recoge los empleados y sus turnos 
 * @author Pablo Javier Noguerol Santalices Ciclo Dam GRUPO B
 */
public class Employee {
    
    private String name;
    private String surname;
    private String DNI;
    private Turn [] turno;
    private int contador;
    /**
     * Contructor por defecto sin parametros
     */
    public Employee()
    {
        this.contador =0;
        this.turno = new Turn [7];
    }
     /**
     * Contructor sobrecargado
     */
    public Employee(String aName, String aSurname)
    {
        this.contador =0;
        this.turno = new Turn [7];
        this.setName(aName);
        this.setSurname(aSurname);
    }
    /**
     * Contructor sobrecargado con 3 parametros
     * @param aDNI
     * @param aName
     * @param aSurname
     */
    public Employee(String aDNI, String aName, String aSurname)
    {
        this.contador =0;
        this.turno = new Turn [7];
        this.setName(aName);
        this.setSurname(aSurname);
        this.setDNI(aDNI);
        
    }
    /**
     * 
     * Aquí retornamos la propiedad name
     * @return 
     */
    public String getName() {
        return name;
    }
     /**
     * Aquí asignamos la propiedad name 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Aquí retornamos la propiedad Surname
     * @return 
     */
    public String getSurname() {
        return surname;
    }
    /**
     * Aquí asignamos la propiedad Surname
     * @param surname 
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     * Aquí retornamos la propiedad DNI
     * @return 
     */
    public String getDNI() {
        return DNI;
    }
    /**
     * Aqui comprobamos que el DNI es correcto antes de asignarlo
     * @param DNI 
     */
    public void setDNI(String DNI) {
        if (this.ComDni(DNI))
            this.DNI = DNI;
    }
    /**
     * Aqui retornamos los datos modificados del empleado 
     * @param nameInUppercase
     * @param surnameInUpperCase
     * @return 
     */
    public String getFullName(boolean nameInUppercase, boolean surnameInUpperCase)
    {
        
        if (nameInUppercase==true)
        {
           if (this.name!=null)
           {
            this.name = this.name.toUpperCase();
           }
           
             
        }
        else
        {
            if (this.name!=null)
           {
            this.name = this.name.toLowerCase();
            this.name = Character.toUpperCase(this.name.charAt(0)) + this.name.substring(1);
           }
        }
        if (surnameInUpperCase==true)
        {
           if (this.surname!=null)
           {
            this.surname = this.surname.toUpperCase();
           }
        }
        else
        {
            if (this.surname!=null)
           {
            this.surname = this.surname.toLowerCase();
            this.surname = Character.toUpperCase(this.surname.charAt(0)) + this.surname.substring(1);
           }
        }
        if (this.name ==null && this.surname==null)
        {
            return "";
        }
        if (this.name ==null)
        {
            return this.surname;
            
        }
        if (this.surname==null)
        {
            return this.name;
        }
        
        
        return this.name+", "+this.surname;
    }
    /**
     * Clase privada que controlamos que el DNI sea correcto
     * @param dni
     * @return 
     */
    private boolean ComDni(String dni)
    {
        boolean correct = true;
        //comprobamos que sea distinto de null
        if (dni==null)
        {
          correct = false;
          return correct; 
        }
        //comprobamos que su tamaño el correcto
        if (dni.length()!=9)
        {
          correct = false;
          return correct;
          
        }
        int numero;
        int calculo;
        String caracter;
        char[] letra =  {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B','N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
        try
        {
           numero =  Integer.parseInt(dni.substring(0, 8));
           calculo=numero%23;
           caracter=""+letra[calculo];
           
           if (dni.substring(8, 9).toUpperCase().compareTo(caracter)==0)
           {
              return correct; 
           }
           
           
        }
        catch (Exception e)
        {
            correct = false;
            return correct;
            
        }
        
        correct = false;
        return correct;
        
    }
    public void prueba(String dni)
    {
         int numero;
        int calculo;
        String caracter;
        char[] letra =  {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B','N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
        try
        {
           
           numero =  Integer.parseInt(dni.substring(0, 8));
           calculo=numero%23;
           caracter=""+letra[calculo];
           System.out.println(dni.substring(7, 8));
           
           if (dni.substring(8, 9).toUpperCase().compareTo(caracter)==0)
           {
               System.out.println("correcto");
             
           }
           
           
        }
        catch (Exception e)
        {
            System.out.println("error");
            
        }
        
    }
    
    /**
     * Asignamos turno si el turno menos de 7 y no es null y avanzamos el contador
     * @param turno 
     */
    public void addTurn(Turn turno)
    {
         
        if (turno!=null)
        {
            if (this.contador<7)
            {      
                this.turno [this.contador] = turno;
                this.contador++;
            }
        }
     
    }
    /**
     * Borramos el turno si lo encuentra controlando un array aux temporal
     * @param aDay 
     */
    public void removeTurn(String aDay)
    {
        if (aDay!=null)
        {
             Turn [] aux = new Turn [7];     
    

             for (int i=0;i<this.contador;i++)
            {
                if (this.turno[i].getDay().compareTo(aDay)!=0)
                {
                    aux[i]= this.turno[i];
                    this.contador--;
                }
            }
            this.turno = aux;
        }
    }
    /**
     * devolvemos el numero de turnos que hay
     * @return 
     */
    public  int getTurnCount()
    {
        return this.contador;
        
    }
    /**
     * devolvemos el turno con un indice pasado por parametro
     * @param anIndex
     * @return 
     */
    public Turn getTurnAt(int anIndex)
    {
        
        
        return this.turno[anIndex];
        
    }
    //devolvemos el array entero de turnos
    public Turn[] getTurns()
    {
        
        Turn [] aux = new Turn [contador];
        
         for (int i =0; i< contador; i++)
        {
            if (this.turno[i]!= null)
            {
              
              aux [i] = this.turno[i];
            }
        }
        if (contador ==0)
        {
            return null;
        }
        else
            return aux;
         
        
    }
    
    
}
