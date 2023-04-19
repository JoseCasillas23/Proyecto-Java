
package Final;

import java.io.Serializable;

//Datos Habitaciones
public class Habitaciones implements Serializable {
    
     private String id;
    private String numero;
    private String estado;

    public Habitaciones (){
        
    }
        public Habitaciones (String id, String num, String est)
    {
        
    this.setId(id);
    this.setNumero(num);
    this.setEstado(est);
       
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
        
    
    
}
