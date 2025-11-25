/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.proyectoparchis.Controller;

import cr.ac.ucr.proyectoparchis.Model.Board;
import cr.ac.ucr.proyectoparchis.Model.Modelo;
import cr.ac.ucr.proyectoparchis.Model.Player;
import cr.ac.ucr.proyectoparchis.Model.Questions;
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
    Questions questions;

    public PlayController()
    {
        modelo = new Modelo();
        gUIPlay = new GUIPlay(this);
        gUIPlay.setListenerPlay(this);
        player2 = new Player(); // se crea un segundo objeto jugador para la maquina
        questions = new Questions();

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
                setColorPlayer2(player.getColor());// este metodo configura el color del jugador 2
                // para el inicio, en donde todavia no se ha salido de home
                if(player.getFicha5() == false || player2.getFicha5() == false)
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
                                JOptionPane.showMessageDialog(null, "Jugador "+player.getColor()+", su dado lanzó un " + dado + ". Se pasa al siguiente jugador");
                            }//fin if anidado
                            else// este else es para sacar la ficha del home, si la ficha cae en 5
                            {
                                JOptionPane.showMessageDialog(null, "EL jugador "+player.getColor()+" sacó un 5 \n Puede empezar a mover la ficha!!");
                                player.setFicha5(true);
                                board.sacarFichas(player.getColor());
                                gUIPlay.repaint();
                            }//fin else anidado 2
                        }//fin if anidado

                        else// para que el jugador juegue aunque haya salido del home 
                        {
                            // player 1
                            player.setTurn(true); // para configurar quien tiene el turno
                            player2.setTurn(false);
                            if(player.getTurn() && player2.getTurn() == false) // verifica turnos para que el primer jugador juegue
                            {
                                int dado = modelo.dado();// velve a lanzar el dado cada vez que precione el boton
                                String respuesta = " ";
                                
                                JOptionPane.showMessageDialog(null, "Jugador "+player.getColor()+", el dado sacó un "+dado);
                                board.moverFichas(dado, 0, player.getColor());    
                                gUIPlay.repaint();// para actualizar y repintar despues de;

                                
                                //para las puntuaciones
                                respuesta = JOptionPane.showInputDialog("!!Momento de preguntas¡¡ \n Escriba sí o no según crea \n "+questions.getEasyQuestions());
                                if (respuesta.equalsIgnoreCase("si")) 
                                {
                                    player.setScore(1);
                                    gUIPlay.setIbmPuntajeP1(player.getScore()+"");
                                }//fin if anidado 2
                                else
                                {
                                    if(respuesta.equalsIgnoreCase("no"))
                                    {
                                        player.setScore(-1);
                                        gUIPlay.setIbmPuntajeP1(player.getScore()+"");
                                    }//fin if aniado 3
                                }//fin else 2
                            }//fin if anidado
                        }//fin else
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
                                JOptionPane.showMessageDialog(null, "Jugador "+player2.getColor()+", su dado lanzó un " + dado + ". Se pasa al siguiente jugador");
                            }//fin if anidado
                            else// este else es para sacar la ficha del home, si la ficha cae en 5
                            {
                                JOptionPane.showMessageDialog(null, "EL jugador "+player2.getColor()+" sacó un 5 \n Puede empezar a mover la ficha!!");
                                player2.setFicha5(true);
                                board.sacarFichas(player2.getColor());
                                gUIPlay.repaint();
                            }//fin else anidado 2
                        }//fin if anidado
                        
                        else//para que la maquina jugue, aunque haya salido del home
                        {
                            player.setTurn(false); // para configurar quien tiene el turno
                            player2.setTurn(true);
                            if(player2.getTurn() && player.getTurn() == false) // verifica turnos para que el jugador juegue
                            {     
                                int dado = modelo.dado();// velve a lanzar el dado cada vez que precione el boton
                                JOptionPane.showMessageDialog(null, "Jugador "+player2.getColor()+", el dado sacó un "+dado);
                                board.moverFichas(0, dado, player.getColor());// siempre que se muevan fichas se debe enviar el color del jugador 1     
                                gUIPlay.repaint();// para actualizar y repintar despues de;
                            }//fin if anidado
                        }// fin else
                    }//fin if 
                    
                    

                    else // aqui esta la jugabilidad despues de que alguno de los jugadores saque 5. 
                    {
                        //turno jugador
                        if (player.getFicha5() == true)
                        {
                            player.setTurn(true); // para configurar quien tiene el turno
                            player2.setTurn(false);
                            if(player.getTurn() && player2.getTurn() == false) // verifica turnos para que el primer jugador juegue
                            {
                                int dado = modelo.dado();// velve a lanzar el dado cada vez que precione el boton
                                String respuesta = " ";
                                
                                JOptionPane.showMessageDialog(null, "Jugador "+player.getColor()+", el dado sacó un "+dado);
                                board.moverFichas(dado, 0, player.getColor());    
                                gUIPlay.repaint();// para actualizar y repintar despues de;
                                
                                //para las puntuaciones
                                respuesta = JOptionPane.showInputDialog("!!Momento de preguntas¡¡ \n Escroba si o no según crea \n "+questions.getEasyQuestions());
                                if (respuesta.equalsIgnoreCase("si")) 
                                {
                                    player.setScore(1);
                                    gUIPlay.setIbmPuntajeP1(player.getScore()+"");
                                }//fin if anidado 2
                                else
                                {
                                    if(respuesta.equalsIgnoreCase("no"))
                                    {
                                        player.setScore(-1);
                                        gUIPlay.setIbmPuntajeP1(player.getScore()+"");
                                    }//fin if aniado 3
                                }//fin else 2
                            }//fin if anidado
                        }//fin if
                        
                        
                        //turno maquina
                        if (player2.getFicha5() == true)
                        {
                            player.setTurn(false); // para configurar quien tiene el turno
                            player2.setTurn(true);
                            if(player2.getTurn() && player.getTurn() == false) // verifica turnos para que el primer jugador juegue
                            {     
                                int dado = modelo.dado();// velve a lanzar el dado cada vez que presione el boton
                                JOptionPane.showMessageDialog(null, "Jugador "+player2.getColor()+", el dado sacó un "+dado);
                                board.moverFichas(0, dado, player.getColor());     
                                gUIPlay.repaint();// para actualizar y repintar despues de;
                            }//fin if anidado
                        }//fin if
                    }//fin else
                }//fin if

                
                
                
                // para jugar cuando ambos salieron de la casa
                if (player.getFicha5() == true && player2.getFicha5() == true)
                {
                    // turno jugador
                    player.setTurn(true); // para configurar quien tiene el turno
                    player2.setTurn(false);
                    if(player.getTurn() && player2.getTurn() == false) // verifica turnos para que el primer jugador juegue
                    {
                        int dado = modelo.dado();// velve a lanzar el dado cada vez que precione el boton
                        String respuesta = " ";
                        
                        JOptionPane.showMessageDialog(null, "Jugador "+player.getColor()+", el dado sacó un "+dado);
                        board.moverFichas(dado, 0, player.getColor());
                        gUIPlay.repaint();
                        
                        //para las puntuaciones
                                respuesta = JOptionPane.showInputDialog("!!Momento de preguntas¡¡ \n Escroba si o no según crea \n "+questions.getEasyQuestions());
                                if (respuesta.equalsIgnoreCase("si")) 
                                {
                                    player.setScore(1);
                                    gUIPlay.setIbmPuntajeP1(player.getScore()+"");
                                }//fin if anidado 2
                                else
                                {
                                    if(respuesta.equalsIgnoreCase("no"))
                                    {
                                        player.setScore(-1);
                                        gUIPlay.setIbmPuntajeP1(player.getScore()+"");
                                    }//fin if aniado 3
                                }//fin else 2
                    }//fin if anidado
                    
                    // turno maquina
                    player.setTurn(false); // para configurar quien tiene el turno
                    player2.setTurn(true);
                    if(player2.getTurn() && player.getTurn() == false) // verifica turnos para que el primer jugador juegue
                    {
                        int dado = modelo.dado();// velve a lanzar el dado cada vez que precione el boton
                        JOptionPane.showMessageDialog(null, "Jugador "+player2.getColor()+", el dado sacó un "+dado);
                        board.moverFichas(0, dado, player.getColor());//  al mover fichas, se usa siempre player 1
                        gUIPlay.repaint();
                    }//fin if anidado
                }//fin  if
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
    
    
    public void setColorPlayer2(String color)
    {
        if (color.equalsIgnoreCase("rojo"))
        {
            player2.setColor("verde");
        }//fin if
        else
        {
            if(color.equalsIgnoreCase("verde"))
            {
                player2.setColor("amarillo"); 
            }//fin if anidado
            else
            {
                if (color.equalsIgnoreCase("amarillo"))
                {
                    player2.setColor("azul");
                }//fin if anidado 2
                else
                {
                    if(color.equalsIgnoreCase("azul"))
                    {
                        player2.setColor("rojo");
                    }//fin if anidado 3
                }//fin else anidado 2
            }//fin else anidado
        }// fin else
    
    
    }//fin metodo


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
