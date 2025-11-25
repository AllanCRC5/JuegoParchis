/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.ucr.proyectoparchis.Model;

/**
 *
 * @author Allan
 */
public class Questions 
{
    private String easyQuestion[];
    private String hardQuestion[];

    public Questions()
    {
        easyQuestion = new String[10];
        hardQuestion = new String[5];
        fillArrayEasy();// se llama al metodo para que al llamar la clase llene el array
    }//fin constructor
    
    public void fillArrayEasy() 
    {
        easyQuestion[0] = "Los caballeros con armadura existieron en la edad media";
        easyQuestion[1] = "Durante la edad media los reyes vivian en castillos";
        easyQuestion[2] = "Las princesas eran hijas de loa reyes y reinas";
        easyQuestion[3] = "Los campesinos eran personas con poco dinero"; 
        easyQuestion[4] = "Las casas de los campesinos eran de paja";
        easyQuestion[5] = "Loa caballeros viajaban en caballos";
        easyQuestion[6] = "La forma de communicarse en la edad media era con cartas";
        easyQuestion[7] = "Las computadoras y el internet eran no existian en esa época";
        easyQuestion[8] = "Los principes eran los hijos de los reyes en los reinos";
        easyQuestion[9] = " La peste negra ocurrió durante la edad media";
    }//fin metodo llenarArrayEasy
    
    public void fillArrayHard() 
    {
        hardQuestion[0] = "En la edad media existia el capitalismo";
        hardQuestion[1] = "Existía la organización social de clase media en la edad media";
        hardQuestion[2] = "La iglesia católica no manipulaba a la gente por dinero";
        hardQuestion[3] = "Vladimir Putin fue un personaje importante  en la edad media";
        hardQuestion[4] = "La caida de roma se dió en la edad media";
    }//fin metodo hard
    
    public String getEasyQuestions() 
    {
        return easyQuestion[(int)(Math.random()*9+0)];
    }//fin metodod
    
    public String getHardQuestions() 
    {
        return hardQuestion[(int)(Math.random()*9+0)];
    }//fin metodod
    
    
    
}//fin clase

    
    

