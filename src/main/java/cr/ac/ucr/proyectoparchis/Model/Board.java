/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.proyectoparchis.Model;

import java.awt.Component;
import java.awt.Graphics;
import java.lang.management.ManagementFactory;
import javax.swing.ImageIcon;



/**
 *
 * @author Allan
 */
public class Board// clase encargada de controlar lo que se muestra en el tablero
{
    private Square square[]; //se crea un array de tipo objeto celda
    private Home homeRed;
    private Home homeYellow;
    private Home homeGreen;
    private Home homeBlue; //referencia de las 4 casas de la misma clase
    private String color;
    
    private Position position[]; // arreglo tipo objeto Position
    
    int numDadoR, numDadoY, numDadoG, numDadoB;
    
    
    public Board(String color) // constructor que recibe por parametro el color escogido por el usuario
    {
        this.color = color;// crea variable color y la incializa con variable color por parametro
        numDadoR = 38;
        numDadoG = 55;
        numDadoY = 4;
        numDadoB = 21; 
        
        square = new Square[68]; // arreglo creado con 68 espacios, coincidiendo con las celdas
        position = new Position[68]; // arreglo creado para las posiciones
        
        if (this.color.equalsIgnoreCase("rojo")) 
        {
            this.homeRed = new Home(color); // se crea la instancia del color escogido por el usuario
            this.homeGreen = new Home("verde");// ademas de otra casa aleatoria para que la computadora use
            System.out.println("Creo las instancias de las casas escogidas");
            startRed(); // se llama a los metodos para que ambos aparezcan en el menu
            startGreen();
        }//fin if 
        else
        {
            if (this.color.equalsIgnoreCase("amarillo"))
            {
                this.homeYellow = new Home("amarillo");
                this.homeBlue = new Home("azul");
                startYelllow();
                startBlue();
            }//fin if anidado
            else
            {
                if (this.color.equalsIgnoreCase("verde")) 
                {
                    this.homeGreen = new Home("verde");
                    this.homeYellow = new Home("amarillo");
                    startGreen();
                    startYelllow();
                }//fin if anidado 2
                else 
                {
                    if (this.color.equalsIgnoreCase("azul"))
                    {
                        this.homeBlue = new Home("azul");
                        this.homeRed = new Home("rojo");
                        startBlue();
                        startRed();
                    }//fin if anidado 3
                }//fin else anidado 2
            }//fin else anidado
        }//fin else
        setPositions();
    }//fin constructor
    
    
    
    public void setPositions() // metodo creado para llenar las coordenadas
    {
        // llena la columna arriba izquierda
        int coordenatesX = 220;
        int coordenatesY = 16;
        for (int i = 0; i < 8; i++)// se pone de 0 a 8, por lo que son 8 campos, el ultimo indice es 7, no 8
        {
            position[i] = new Position(coordenatesX, coordenatesY); // llena el arreglo de posiciones con las coordenadas
            square[i] = new Square(position[i]); //se llena el arreglo de la casilla, con la posicion del arreglo de arriba
            coordenatesY += 24;
        }//fin for
        
        // llenar fila izquierda arriba
        coordenatesX = 198;
        coordenatesY = 187;
        for(int i = 8; i < 16; i++)
        {
            position[i] = new Position(coordenatesX, coordenatesY);
            square[i] = new Square(position[i]);
            coordenatesX -= 24;
        }//fin for
        
        
        // para llenar la casilla solitaria
        position[16] = new Position(47, 245);
        square[16] = new Square(position[16]);
        
        
              
        //llenar fila izquierda abajo
        coordenatesX = 47;
        coordenatesY = 297;
        for (int i = 17; i < 25; i++) 
        {
            position[i] = new Position(coordenatesX, coordenatesY);
            square[i] = new Square(position[i]);
            coordenatesX += 24;
        }//fin for
        
        
        // llenar columna izquieda abajo
        coordenatesX = 230;
        coordenatesY = 327;
        for (int i = 25; i < 33; i++) 
        {
            position[i] = new Position(coordenatesX, coordenatesY);
            square[i] = new Square(position[i]);
            coordenatesY += 24;
        }//fin for 
        
        
        // para llenar casilla 34 suelta
         position[33] = new Position(275, 503);
        square[33] = new Square(position[16]);
        
        
        // llenar columna derecha abajo
        coordenatesX = 332;
        coordenatesY = 503;
        for (int i = 34; i < 42; i++) 
        {
            position[i] = new Position(coordenatesX, coordenatesY);
            square[i] = new Square(position[i]);
            coordenatesY -= 24;
        }//fin for
        
        
        //llena fila derecha abajo 
        coordenatesX = 355;
        coordenatesY = 296;
        for (int i = 42; i < 50; i++) 
        {
            position[i] = new Position(coordenatesX, coordenatesY);
            square[i] = new Square(position[i]);
            coordenatesX += 24;
        }//fin for
        
        
        // llenar casilla 52 solitaria
        position[50] = new Position(540, 245);
        square[50] = new Square(position[16]);
        
        
        //llenar fila derecha arriba
        coordenatesX = 540;
        coordenatesY = 187;
        for (int i = 51; i < 59; i++) 
        {
            position[i] = new Position(coordenatesX, coordenatesY);
            square[i] = new Square(position[i]);
            coordenatesX -= 24;
        }//fin for
        
        
        //llenar columna derecha arriba
        coordenatesX = 332;
        coordenatesY = 171;
        for (int i = 59; i < 67; i++) 
        {
            position[i] = new Position(coordenatesX, coordenatesY);
            square[i] = new Square(position[i]);
            coordenatesY -= 24;
        }//fin for
        
        //llenar casiila solitaria 68
        position[67] = new Position(275, 16);
        square[67] = new Square(position[16]);
        //square[67].setPiece(new Piece(position[67], new ImageIcon("./src/main/resources/img/Ficha roja 30px.jpg")));
    }//fin metodo setPositionas
    
    
    
    public void showHomeRed() 
    {
        // esta combinacion llama  al metodo de home para asignar un valor al campo del array pieza, ahi crea un nuevo objeto pieza, al mismo tiempo llama a la clase posicion, y un nuevo ImageIcon para la imagen
        homeRed.setPiece(0, new Piece(new Position(397, 385), new ImageIcon("./src/main/resources/img/caballero pro rojo.png")));//
        homeRed.setPiece(1, new Piece(new Position(397, 473), new ImageIcon("./src/main/resources/img/caballero pro rojo.png")));
        homeRed.setPiece(2, new Piece(new Position(489, 385), new ImageIcon("./src/main/resources/img/caballero pro rojo.png")));
        homeRed.setPiece(3, new Piece(new Position(489, 473), new ImageIcon("./src/main/resources/img/caballero pro rojo.png")));
        System.out.println("Entro al metodo que crea las fichas");
    }//fin metodo
     
    public void showHomeYellow() 
    {
        System.out.println("Entro al showHomeYellow amarillo");
        homeYellow.setPiece(0, new Piece(new Position(73, 48), new ImageIcon("./src/main/resources/img/caballero pro.png")));
        homeYellow.setPiece(1, new Piece(new Position(155, 48), new ImageIcon("./src/main/resources/img/caballero pro.png")));
        homeYellow.setPiece(2, new Piece(new Position(73, 149), new ImageIcon("./src/main/resources/img/caballero pro.png")));
        homeYellow.setPiece(3, new Piece(new Position(155, 149), new ImageIcon("./src/main/resources/img/caballero pro.png")));
    }//fin metodo
                                       
    public void showHomeGreen() 
    {
        homeGreen.setPiece(0, new Piece(new Position(399, 54), new ImageIcon("./src/main/resources/img/caballero pro verde.png")));
        homeGreen.setPiece(1, new Piece(new Position(399, 142), new ImageIcon("./src/main/resources/img/caballero pro verde.png")));
        homeGreen.setPiece(2, new Piece(new Position(502, 54), new ImageIcon("./src/main/resources/img/caballero pro verde.png")));
        homeGreen.setPiece(3, new Piece(new Position(502, 142), new ImageIcon("./src/main/resources/img/caballero pro verde.png")));
    }//fin metodo 
    
    public void showHomeBlue() 
    {
        homeBlue.setPiece(0, new Piece(new Position(79, 387), new ImageIcon("./src/main/resources/img/caballero pro azul.png")));
        homeBlue.setPiece(1, new Piece(new Position(157, 387), new ImageIcon("./src/main/resources/img/caballero pro azul.png")));
        homeBlue.setPiece(2, new Piece(new Position(79, 468), new ImageIcon("./src/main/resources/img/caballero pro azul.png")));
        homeBlue.setPiece(3, new Piece(new Position(157, 468), new ImageIcon("./src/main/resources/img/caballero pro azul.png")));
    }//fin metodo
    
    
    public void startRed() 
    {
        showHomeRed();
    }//fin metodo
    
    public void startBlue() 
    {
        showHomeBlue();
    }//fin metodo
    
    public void startGreen() 
    {
        showHomeGreen();
    }//fin metodo
    
    public void startYelllow() 
    {
        showHomeYellow();
    }//fin metodo
    
    
    
    
    public void draw(Component c, Graphics g) // encargado de pintar figuras
    {
        for (int i = 0; i < 4; i++)// hay un arreglo en la clase Home que guardar las 5 piezas creadas aca las estamos llamando, pues se crearon el el metodo showHome
        {
            if (color.equalsIgnoreCase("rojo"))// siguiendo el patron del constructor, depende del color elegido esos colores va a pintar
            {
                if(homeRed != null) 
                {
                    homeRed.getPiece(i).draw(c, g);
                    homeGreen.getPiece(i).draw(c, g);  
                }//fin if
                
            }//fin if
            else
            {
                if(color.equalsIgnoreCase("amarillo"))
                {
                    homeYellow.getPiece(i).draw(c, g);
                    homeBlue.getPiece(i).draw(c, g);
                }//fin if anidado 
                else 
                {
                    if(color.equalsIgnoreCase("verde"))
                    {
                        homeGreen.getPiece(i).draw(c, g);
                        homeYellow.getPiece(i).draw(c, g);
                    }//fin if anidado 2 
                    else 
                    {
                        if(color.equalsIgnoreCase("azul")) 
                        {
                            homeBlue.getPiece(i).draw(c, g);
                            homeRed.getPiece(i).draw(c, g);
                        }//fin if anidado 3   
                    }//fin else anidado 2
                }//fin else anidado
            }//fin else
        }//fin for
        
        
        for (int i = 0; i < square.length; i++)// utilizado para pintar las fichas en el tablero 
        {
            if(square[i] != null) // medida de proteccion, no entra si el null esta vacio 
            {
                if (square[i].getPiece() != null) // segunda medida de seguridad, revisa que la pieza este llena
                {
                    square[i].getPiece().draw(c, g); //pinta las piezas
                }//fin if anidado
            }//fin if
        }//fin for
    }//fin metodo draw 
    
    
    public void moverFichas(int i, int o, String color)// 
    {
        if(color.equalsIgnoreCase("rojo"))
        {
            numDadoR += i;
            numDadoG += o;
            homeRed.getPiece(0).setPosition(position[numDadoR]);// se llama a la clase que tiene el arreglo de la pieza, se obtiene esa pieza y se le cambia la posicion, con el arreglo de posiciones
            homeGreen.getPiece(0).setPosition(position[numDadoG]);
        }//fin if
        else
        {
            if(color.equalsIgnoreCase("amarillo"))
            {
                numDadoY += i;
                numDadoB += o;
                homeYellow.getPiece(0).setPosition(position[numDadoY]);
                homeBlue.getPiece(0).setPosition(position[numDadoB]);
            }//fin if anidado
            else
            {
                if(color.equalsIgnoreCase("verde")) 
                {
                    numDadoG += i;
                    numDadoY += o;
                    homeGreen.getPiece(0).setPosition(position[numDadoG]);
                    homeYellow.getPiece(0).setPosition(position[numDadoY]);
                }//fin if anidado 2
                else
                {
                    if(color.equalsIgnoreCase("azul"))
                    {
                        numDadoB += i;
                        numDadoR += o;
                        homeBlue.getPiece(0).setPosition(position[numDadoB]);
                        homeRed.getPiece(0).setPosition(position[numDadoR]);
                    }//fin if anidado 3
                }//fin else anidado 2
            }//fin else anidado
        }//fin else
    }//fin metodo
    
    
    
    
    public void sacarFichas(String color) 
    {
        if(color.equalsIgnoreCase("rojo"))
        {
            homeRed.getPiece(0).setPosition(position[38]);
        }//fin if
        else
        {
            if(color.equalsIgnoreCase("amarillo"))
            {
                homeYellow.getPiece(0).setPosition(position[4]);
            }//fin if anidado
            else
            {
                if(color.equalsIgnoreCase("verde")) 
                {
                    homeGreen.getPiece(0).setPosition(position[55]);
                }//fin if anidado 2
                else
                {
                    if(color.equalsIgnoreCase("azul"))
                    {
                        homeBlue.getPiece(0).setPosition(position[21]);
                    }//fin if anidado 3
                }//fin else anidado 2
            }//fin else anidado
        }//fin else
    }//fin metodo
}//fin clase
