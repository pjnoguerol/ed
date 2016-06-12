/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertyshop;

/**
 * Esta clase es para una inmobilariaria para recoger datos de inmuebles
 * @author Pablo Javier Noguerol Santalices Ciclo Dam GRUPO B
 */
public class Property {
    
    private String name;
    private String address;
    private double constructedSurface;
    private double availableSurface;
    private String owner;
    private String ownerAddress;
    private int price;
    
    /**
     * 
     * Aquí retornamos la propiedad name
     * @return 
     */
    public String getName() {
        return name;
    }
   
    /**
     * Aquí asignamos la propiedad name poniendola en minúscula
     * @param name
     */
    public void setName(String name) {
        if (name!=null)
        {
            this.name = name.toLowerCase();
        }
    }
    /**
     * Aquí retornamos la propiedad Address
     * @return 
     */
    public String getAddress() {
        return address;
    }
    /**
     * Aquí asignamos la propiedad Address del usuario poniendola en mayúscula
     * @param address 
     */
    public void setAddress(String address) {
        if(address!=null)
        {  
            this.address = address.toUpperCase();
        }
    }
    /**
     * Aquí retornamos la propiedad constructedSurface
     * @return 
     */
    public double getConstructedSurface() {
        return constructedSurface;
    }
    /**
     * Aquí asignamos la variable constructedSurface si es mayor de 0
     * @param constructedSurface 
     */
    public void setConstructedSurface(double constructedSurface) {
        if (constructedSurface>0)
        {
            this.constructedSurface = constructedSurface;
        }
    }
    /**
     * Aquí devolvemos la propiedad availableSurface
     * @return 
     */
    public double getAvailableSurface() {
        return availableSurface;
    }
    /**
     * Aquí asignamos la variable availableSurface si es mayor de 0
     * @param availableSurface 
     */
    public void setAvailableSurface(double availableSurface) {
        if (availableSurface>0)
        {
            this.availableSurface = availableSurface;
        }
    }
    /**
     * Aquí devolvemos la propiedad owner
     * @return 
     */
    public String getOwner() {
        return owner;
    }
    /**
     * Aquí asignamos la variable owner a la propiedad
     * @param owner 
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
    /**
     * Aquí recogemos la propiedad ownerAddrees
     * @return 
     */
    public String getOwnerAddress() {
        return ownerAddress;
    }
    /**
     * Aquí asignamos con la variable ownerAddress 
     * @param ownerAddress 
     */
    public void setOwnerAddres(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }
    /**
     * Aquí recogemos la propiedad price
     * @return 
     */
    public int getPrice() {
        return price;
    }
    /**
     * Asignamos la variable price a la propiedad si es positivo
     * @param price 
     */
    public void setPrice(int price) {
        if (price>0)
        {
            this.price = price;
        }
    }
    
   
    
    
    
    
}
