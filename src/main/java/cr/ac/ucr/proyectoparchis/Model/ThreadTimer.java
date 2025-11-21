/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.proyectoparchis.Model;

import cr.ac.ucr.proyectoparchis.View.GUIGameOver;
import cr.ac.ucr.proyectoparchis.View.GUIPlay;
import cr.ac.ucr.proyectoparchis.View.GUIWin;

/**
 *
 * @author Allan
 */
public class ThreadTimer extends Thread // clase con el hilo para manejar el tiempo  
{
    private int minutes;
    private boolean run = true;
    private GUIWin gUIWin;
    private GUIGameOver gUIGameOver;
    private GUIPlay gUIPlay;
    

    public ThreadTimer()
    {
       
    }//fin constructor 

    public ThreadTimer(GUIWin gUIWin, GUIGameOver gUIGameOver, GUIPlay gUIPlay)
    {
        this.gUIWin = gUIWin;
        this.gUIGameOver = gUIGameOver;
        this.gUIPlay = gUIPlay;
    }//fin constructor con parametros

    
    public void stopTheard()// metodo para para el proyecto
    {
        this.run =  false;
    }//fin metodo
    
    
    @Override
    public void run() 
    {
        while(run)
        {
            try 
            {
                this.sleep(1000); //esto para que el contador espere un segundo
                this.minutes++;//suma uno a una variable que es la que maneja los numeros 
                this.gUIWin.setTimer(""+ minutes);
                this.gUIGameOver.setTimer(""+minutes);
                this.gUIPlay.setIbmTiempo(""+minutes);
                System.out.println("Tiempo : "+minutes+" s");
            }
            catch(InterruptedException ex)
            {
                System.err.println("Se interrumpió el hilo");
            }
        }//fin while 
        
    
    
    }//fin metodo run
    
    
    
    
}
