
package Final;

import java.io.Serializable;
import java.util.ArrayList;
//Metodos de Serializacion para Habitaciones

public class Serializacion1 implements Serializable{
     private ArrayList <Habitaciones> h;
    
    public Serializacion1 (){
        h = new ArrayList();
    }
    
    public  void Agregar (Habitaciones ha){
        h.add(ha);
    }
    
    public Habitaciones getHabitaciones (int i){
        return h.get(i);
    }
    
    public void Actualizar (int p,Habitaciones nuevo){
        h.set(p, nuevo);
    }
    
    public void Eliminar (int p){
        h.remove(p);
    }
    
    public int getNumero(){
        return h.size();
    }
    
    public int Buscar (String codigo){
        
        int n = this.getNumero();
        for(int p=0; p<n; p++)
        {
            if(codigo.equalsIgnoreCase(this.getHabitaciones(p).getId()))
            {
                return p;
            }
        }
        return -1;
    }
   
}
