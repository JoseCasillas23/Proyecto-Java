
package Final;

import java.io.Serializable;
//Datos Reservaciones

public class Reservaciones implements Serializable{
    
    private String id;
    private String cid;
    private String hid;
    private String costo;
    private String fr;
    private String fs;
    private String hr;
    
     public Reservaciones (){
        
    }
        public Reservaciones(String id, String cid, String hid, String costo, String fr, String fs, String hr)
    {
        
    this.setId(id);
    this.setCid(cid);
    this.setHid(hid);
    this.setCosto(costo);
    this.setFr(fr);
    this.setFs(fs);
    this.setHr(hr);
       
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }
}
