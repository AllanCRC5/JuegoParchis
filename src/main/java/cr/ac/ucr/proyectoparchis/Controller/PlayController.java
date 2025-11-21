/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.proyectoparchis.Controller;

import cr.ac.ucr.proyectoparchis.Model.Board;
import cr.ac.ucr.proyectoparchis.Model.Modelo;
import cr.ac.ucr.proyectoparchis.Model.Player;
import cr.ac.ucr.proyectoparchis.Model.ThreadTimer;
import cr.ac.ucr.proyectoparchis.View.GUIPlay;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Allan
 */
//Este metodo será el controlador del tablero, la funcion de los botones estará aqui
public class PlayController implements ActionListener, MouseListener
{

    Modelo modelo;
    GUIPlay gUIPlay;
    Board board;
    Player player, player2;
    ThreadTimer timer;

    public PlayController()
    {
        modelo = new Modelo();
        gUIPlay = new GUIPlay(this);
        gUIPlay.setListenerPlay(this);
        player2 = new Player(); // se crea un segundo objeto jugador para la maquina

    }//fin constructor

    public void setBoard(Board board, Player player)// para usar la clase board, creada en el otro controlador
    {
        this.board = board;// para crear el draw de este metodo
        this.player = player;

        // puse esto aqui para que se vea apenas se presiona jugar
        JOptionPane.showMessageDialog(null, "**** BIENVENIDOS AL JUEGO DE PARCHIS  ****\n Para poder iniciar, algún jugador deberá sacar un 5 en el dado\n >>>> Muchisima Suerte <<<<<<");

        gUIPlay.setControllerGUI(this); // para el draw de GUIPlay, dice que la instancia de playController es la misma de esta clase
    }//fin metodo setBoard
    
    public void setTimer(ThreadTimer timer) 
    {
        this.timer = timer;
        this.timer.start();
    }//fin metodo


    @Override
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand()) 
        {
            case "Lanzar dado":
                if(player.getFicha5() == false || player2.getFicha5() == false)// para el inicio, en donde todavia no se ha salido de home
                {
                    //turno 1
                    player.setTurn(true); // para configurar quien tiene el turno
                    player2.setTurn(false);
                    
                    if(player.getTurn() && player2.getTurn() == false) // verifica turnos para que el primer jugador juegue
                    {
                        if(player.getFicha5() == false)  // para revisar si este jugador ya salio de home 
                        {
                            int dado = modelo.dado();// esto da el numero aleatorio del dado
                            if (dado != 5)// revisa si el dado es 5, para poder empezar a jugar 
                            {
                                JOptionPane.showMessageDialog(null, "Jugador 1, su dado lanzó un " + dado + ". Se pasa al siguiente jugador");
                            }//fin if anidado
                            else// este else es para sacar la ficha del home, si la ficha cae en 5
                            {
                                JOptionPane.showMessageDialog(null, "EL jugador 1 sacó un 5 \n Puede empezar a mover la ficha!!");
                                player.setFicha5(true);
                            }//fin else anidado 2
                        }//fin if anidado
                    }//fin if

                    //turno de la maquina 
                    player2.setTurn(true);
                    player.setTurn(false);
                    if (player2.getTurn() && player.getTurn() == false) // verifica turnos para que el primer jugador juegue
                    {
                        if(player2.getFicha5() == false)  // para revisar si este jugador ya salio de home 
                            {
                                int dado = modelo.dado();// esto da el numero aleatorio del dado
                                if (dado != 5)// revisa si el dado es 5, para poder empezar a jugar 
                                {
                                    JOptionPane.showMessageDialog(null, "Jugador 2, su dado lanzó un " + dado + ". Se pasa al siguiente jugador");
                                }//fin if anidado
                                else// este else es para sacar la ficha del home, si la ficha cae en 5
                                {
                                    JOptionPane.showMessageDialog(null, "EL jugador 2 sacó un 5 \n Puede empezar a mover la ficha!!");
                                    player2.setFicha5(true);
                                }//fin else anidado 2
                            }//fin if anidado
                    }//fin if anidao    
                    
                    
                    else // aqui esta la jugabilidad despues de sacar un 5
                    {
                        
                        player.setTurn(true); // para configurar quien tiene el turno
                        player2.setTurn(false);
                        if(player.getTurn() && player2.getTurn() == false) // verifica turnos para que el primer jugador juegue
                        {
                            int dado = modelo.dado();
                            board.moverFichas(dado, player.getColor());
                            gUIPlay.repaint();
                        }
                        
                
                    }//fin else
                }//fin if 
            break;
            case "Back":
                gUIPlay.setVisible(false);
            break;
        }//fin switch
        
    }// fin metodo actionPerformed

    
    public void draw(Component c, Graphics g)
    {
        board.draw(c, g);
    }//fin metodo draw

    
    

    @Override
    public void mouseClicked(MouseEvent e)
    {
        System.out.println("X= " + e.getX() + " Y= " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}//fin clase PlayController
