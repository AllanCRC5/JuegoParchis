/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.proyectoparchis.Model;

/**
 *
 * @author Allan
 */
public class Position // clase para cotrollar las posiciones de las piezas
{
    private int x;
    private int y;

    public Position()
    {
        
    }//fin constructor sin parametros

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }// fin constructor con parametros

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }
    
    
    
    
    
    
    
    
}//fin clase position
