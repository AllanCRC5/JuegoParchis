/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.proyectoparchis.Model;

/**
 *
 * @author Allan
 */
public class Square // clase para controlar el comportamiento de las casillas
{
    private Piece piece;
    private Position position;

    public Square()
    {
        
    }//fin constructor

    public Square(Position position)
    {
        this.position = position;
    }

    public Square(Piece piece, Position position)
    {
        this.piece = piece;
        this.position = position;
    }

    public Piece getPiece()
    {
        return piece;
    }

    public void setPiece(Piece piece)
    {
        this.piece = piece;
    }

    public Position getPosition()
    {
        return position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }
    
    public boolean isEmpty() //Utilizado para determinar si la celda esta vacia o llena
    {
        return(piece != null);
    }//fin metodo isEmpty

}//fin clase
