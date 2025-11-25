/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.proyectoparchis.Model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Allan
 */
public class Piece // esta clase representa los objetos piezas 
{
    private Position position; //referencia a la clase position
    private ImageIcon image; // metodo clase java para las imagenes
    private Color color;

    public Piece()
    {
        
    }//fin constructor

    public Piece(Position position, ImageIcon image)// en este constructor el color no se pide por que se va a definir con un set
    {
        this.position = position;
        this.image = image;
    }//fin constructor con parametros

    public Position getPosition()
    {
        return position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }

    public ImageIcon getImage()
    {
        return image;
    }

    public void setImage(ImageIcon image)
    {
        this.image = image;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }
    
    public void draw(Component c, Graphics g) // metodo utilizado para pintar la pieza y que se vea en los paneles 
    {
        image.paintIcon(c, g, position.getX(), position.getY());
    }//fin metodo draw
}//fin clase
