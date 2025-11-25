/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.proyectoparchis.Controller;

import cr.ac.ucr.proyectoparchis.Model.Board;
import cr.ac.ucr.proyectoparchis.Model.Player;
import cr.ac.ucr.proyectoparchis.Model.ThreadTimer;
import cr.ac.ucr.proyectoparchis.View.GUIChooseColor;
import cr.ac.ucr.proyectoparchis.View.GUICredits;
import cr.ac.ucr.proyectoparchis.View.GUIGameOver;
import cr.ac.ucr.proyectoparchis.View.GUIHistory;
import cr.ac.ucr.proyectoparchis.View.GUIInstructions;
import cr.ac.ucr.proyectoparchis.View.GUIPlay;
import cr.ac.ucr.proyectoparchis.View.GUIStartGame;
import cr.ac.ucr.proyectoparchis.View.GUIWin;
import cr.ac.ucr.proyectoparchis.View.PanelButtons;
import cr.ac.ucr.proyectoparchis.View.PanelData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Allan
 */
public class GameController implements ActionListener 
{

    GUIStartGame gUIStartGame;
    PanelButtons panelButtons;
    PanelData panelData; // las referencias de los JPanel dentro del GUIStart Game, se instancian abajo llamando al metodo instanciador
    GUIInstructions gUIInstructions;
    GUIChooseColor gUIChooseColor;
    GUIHistory gUIHistory;
    GUICredits gUICredits;
    
    PlayController playController;// se crea una referencia del otro controlador, en donde esta creado el objeto Play Menu, para que se pueda abrir desde aqui
    Player player;
    GUIWin guiWin;
    Board board;
    GUIGameOver gUIGameOver;
    ThreadTimer threadTimer;

    //constructor sin parametros, donde se crearan las instancias de todos los GUI con botones
    public GameController()
    {
        gUIStartGame = new GUIStartGame();
        gUIInstructions = new GUIInstructions();
        gUIChooseColor = new GUIChooseColor();
        gUIHistory = new GUIHistory();
        gUICredits = new GUICredits();
        playController = new PlayController();
        player = new Player();
        guiWin = new GUIWin();
        gUIGameOver = new GUIGameOver();
        this.panelButtons = gUIStartGame.getPanelButtons();
        this.panelData = gUIStartGame.getPanelData();
        this.threadTimer = new ThreadTimer(guiWin, gUIGameOver, playController.gUIPlay);
        
        
        this.panelButtons.setListenerMenu(this);// se llama al metodo escrito en el JPanel de los botones, y se dice por parametros que este es la clase que tiene el ActionListener que va a escuchar que dicen los botones
        this.gUIChooseColor.setListenerColor(this);
        this.gUICredits.setListenerCred(this);
        this.gUIHistory.setListenerHist(this);
        this.gUIInstructions.setListenerInstr(this);
        this.gUIStartGame.setVisible(true);
    }// fin constructor

    //este metodo le asigna la funcion a los botones
    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Un for para que cada vez que salga de una ventana, vuelva al menu inicial

        switch (e.getActionCommand()) 
        {
            case "color":
                gUIStartGame.setVisible(false);
                gUIChooseColor.setVisible(true);
                break;
            case "Historia":
                gUIStartGame.setVisible(false);
                gUIHistory.setVisible(true);
                break;
            case "Instrucciones":
                gUIStartGame.setVisible(false);
                gUIInstructions.setVisible(true);
                break;
            case "Creditos":
                gUIStartGame.setVisible(false);
                gUICredits.setVisible(true);
                break;
                
            case "Jugar":
                if (player.getColor() != null)// revisa que hay un color seleccionado
                {
                     playController.gUIPlay.setVisible(true);// usando el objeto de la clase controlador, se llama al objeto creado del gUIPlay para que abra la ventana
                     board = new Board(player.getColor());// crea instancia de la clase board
                     
                     playController.setBoard(board, player); // se usa este metodo para llamar esas instancias en el otro controllador
                     playController.setTimer(threadTimer);

                }//fin if
                else
                {
                    JOptionPane.showMessageDialog(null, "!!Atención¡¡\n Antes de jugar debe seleccionar un color");
                }// fin else
                break;
                
            case "Back":
                gUIChooseColor.setVisible(false);
                gUICredits.setVisible(false);
                gUIHistory.setVisible(false);
                gUIInstructions.setVisible(false);
                guiWin.setVisible(false);
                gUIGameOver.setVisible(false);
                gUIStartGame.setVisible(true);
                break;
            case "Rojo":
                player.setColor("rojo");
                JOptionPane.showMessageDialog(null, "Su color fue seleccionado con éxito");
                break;
            case "Azul":
                player.setColor("azul");
                JOptionPane.showMessageDialog(null, "Su color fue seleccionado con éxito");
                break;
            case "Amarillo":
                player.setColor("Amarillo");
                JOptionPane.showMessageDialog(null, "Su color fue seleccionado con éxito");
                break;
            case "Verde":
                player.setColor("verde");
                JOptionPane.showMessageDialog(null, "Su color fue seleccionado con éxito");
                break;
        }//fin switch
    }//fin metodo actionPerformed

   
    
    
    
}//fin clase GameController
