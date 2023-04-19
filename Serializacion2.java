
package Final;

import java.io.Serializable;
import java.util.ArrayList;
//Metodos de Serializacion para Reservaciones

public class Serializacion2 implements Serializable{
    
       private ArrayList <Reservaciones> r;
    
    public Serializacion2 (){
        r = new ArrayList();
    }  
    
        public  void Agregar (Reservaciones ra){
        r.add(ra);
    }
    
    public Reservaciones getReservaciones (int i){
        return r.get(i);
    }
    
    public void Actualizar (int p,Reservaciones nuevo){
        r.set(p, nuevo);
    }
    
    public void Eliminar (int p){
        r.remove(p);
    }
    
        public int getNumero(){
        return r.size();
    }
    
    public int Buscar (String codigo){
        
        int n = this.getNumero();
        for(int p=0; p<n; p++)
        {
            if(codigo.equalsIgnoreCase(this.getReservaciones(p).getId()))
            {
                return p;
            }
        }
        return -1;
    }
    
}
