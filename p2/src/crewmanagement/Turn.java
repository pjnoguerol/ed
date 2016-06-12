/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crewmanagement;

/**
 * Esta es una clase de turnos
 * @author Pablo Javier Noguerol Santalices Ciclo Dam GRUPO B
 */
public class Turn {
    
    private String day;
    private int hour;
    private int initHour;
    private int finishHour;
    
    public Turn()
    {
        
    }
    public Turn(String aDay)
    {
        this.setDay(aDay);
    }
    public Turn(String aDay, int aInitHour, int aFinishHour)
    {
        this.setFinishHour(aFinishHour);
        this.setInitHour(aInitHour);
        this.setDay(aDay);
    }
    /**
     * retornamos el dia
     * @return 
     */
    public String getDay() {
        return day;
    }
    /**
     * ponemos el dia pasado como string en mayusculas
     * @param day 
     */
    public void setDay(String day) {
        if(day!=null)
        {
            this.day = day.toUpperCase();
        }
    }
    /**
     * retornamos la hora
     * @return 
     */
    public int getHour() {
        return hour;
    }
    /**
     * asignamos la hora
     * @param hour 
     */
    public void setHour(int hour) {
        this.hour = hour;
    }
    /**
     * retornamos la hora de inicio
     * @return 
     */
    public int getInitHour() {
        return initHour;
    }
    /**
     * asignamos la hora de inicio entre 0 y 23
     * @param initHour 
     */
    public void setInitHour(int initHour) {
        if (initHour>0 && initHour<24)
        {
            this.initHour = initHour;
        }
    }
    /**
     * retornamos la variable FinishHpur
     * @return 
     */
    public int getFinishHour() {
        return finishHour;
    }
    /**
     * asignamos el fin de turno
     * @param finishHour 
     */
    public void setFinishHour(int finishHour) {
        if (finishHour>0 && finishHour<23)
        {
            this.finishHour = finishHour;
        }
    }
    
    
    
    
}
