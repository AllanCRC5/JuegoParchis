/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.proyectoparchis.Model;

/**
 *
 * @author Allan
 */
public class Modelo //clase donde se programa toda la jugabilidad y funciones del juego, ademas de contener los arrays
{
    private int numRan;

    public Modelo()
    {
        numRan = 0;
        
    }//fin metodo constructor
    
    
    public int dado() 
    {
        numRan = (int)(Math.random()*6+1);
        return numRan;
    }//fin metodo dado
    
    
}//fin clase modelo
