/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyshop;

import java.util.Scanner;

/**
 *
 * @author informatica
 */
public class PropertyGeneral {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner (System.in);
        Property pro = new Property();
        System.out.println("Introduce el nombre del inmueble");
        String nombre = sc.nextLine();
        pro.setName(nombre);
        System.out.println("Introduce la dirección del inmueble");
        String direccion = sc.nextLine();
        pro.setAddress(direccion);
        System.out.println(pro.getName()+" "+pro.getAddress());
        
        
    }
    
}
