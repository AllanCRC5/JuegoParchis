/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.proyectoparchis.Model;

/**
 *
 * @author Allan
 */
public class SpecialSquare extends Square// una clase para las casillas especiales, hereda la clase de casillas normales
{
    private String type;    

    public SpecialSquare()
    {
        
    }//fin constructor

    public SpecialSquare(String type)
    {
        this.type = type;
    }//fin constructor con parametros

    public SpecialSquare(String type, Position position)
    {
        super(position);
        this.type = type;
    }

    public SpecialSquare(String type, Piece piece, Position position)
    {
        super(piece, position);
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
    
}//fin clase square
