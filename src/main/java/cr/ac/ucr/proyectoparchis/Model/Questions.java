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
        easyQuestion[0] = "Los caballeros con armadura existieron en los años 1200";
        easyQuestion[1] = "Durante la edad media los reyes vivian en castillos";
        easyQuestion[2] = "Las princesas eran hijas de amorios ocultos de las reinas";
        easyQuestion[3] = "Los campesinos eran personas con mucho dinero"; 
        easyQuestion[4] = "Las casas de los campesinos eran de metal y cemento";
        easyQuestion[5] = "Loa caballeros viajaban en automóviles";
        easyQuestion[6] = "La forma de communicarse en la edad media era con cartas";
        easyQuestion[7] = "Las computadoras y el internet eran muy comunes en esa época";
        easyQuestion[8] = "Los principes y princesas eran los hijos de los reyes en los reinos";
        easyQuestion[9] = " La peste negra ocurrió durante la edad media";
    }//fin metodo llenarArrayEasy
    
    public void fillArrayHard() 
    {
        hardQuestion[0] = "En la edad media existia el feudalismo";
        hardQuestion[1] = "Existía la organización social de clase media en la edad media";
        hardQuestion[2] = "La iglesia católica manipulaba a la gente por dinero";
        hardQuestion[3] = "Martin Lutero fue un personaje importante  en la edad media";
        hardQuestion[4] = "La caida de roma se dió en la edad media";
    
    }//fin metodo hard
    
    
    
}//fin clase

    
    

