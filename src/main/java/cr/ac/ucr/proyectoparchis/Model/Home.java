/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.proyectoparchis.Model;

/**
 *
 * @author Allan
 */
//Esta clase representa el espacio donde estan las fichas antes de salir al tablero
public class Home 
{
    private String color; 
    private Piece pieces[]; //arreglo  que contiene a las  piezas

    public Home(String color)
    {
        this.color = color;
        this.pieces = new Piece[4]; // objeto arreglo creado con 4 campos, para 4 colores 
    }//fin constructor
    
    public void setPiece(int index, Piece piece)
    {
        this.pieces[index]=piece; // le entra por parametro un objeto tipo pieza y un espacio
    }//fin metodo set Piece
    
    public Piece getPiece(int index)
    {
        return this.pieces[index]; // retorna una pieza en un campo especificado    
    }//fin metodo get
    
    public int getLength() 
    {
        return this.pieces.length;
    }//fin metodo
}//fin clase Home
