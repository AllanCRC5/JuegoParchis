/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.proyectoparchis.Model;

/**
 *
 * @author Allan
 */
public class Player // clase que controla al jugador 
{
    String color;
    boolean winCondition, turn, ficha5;
    int score;
    

    public Player()
    {
        this.color = null;
        this.winCondition = false; // para saber si alguien gana o no;
        this.turn = true; // misma funcion de arriba
        this.ficha5 = false;
        this.score = 5;
        
    }//fin constructor

    
    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public boolean getWinCondition()
    {
        return winCondition;
    }

    public void setWinCondition(boolean winCondition)
    {
        this.winCondition = winCondition;
    }

    public boolean getTurn()
    {
        return turn;
    }

    public void setTurn(boolean turn)
    {
        this.turn = turn;
    }

    public boolean getFicha5()
    {
        return ficha5;
    }

    public void setFicha5(boolean ficha5)
    {
        this.ficha5 = ficha5;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score += score;
    }
    
    
    public void sumarScore() 
    {
        this.score++;
    }//fin metodo
    
    public void restarScore() 
    {
        this.score--;
    }//fiin metodo
    
    public void sumarEspecial() 
    {
        this.score += 2;
    }//fin metodo
    
    public void restarEspecial() 
    {
        this.score -= 3;
    }//fin metodo
    
    public int getTotal() 
    {
        return this.score;
    }//fin metodo
    
}//fin clase color
