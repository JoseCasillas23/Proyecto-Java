
package Final;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
/*
Proyecto Final Hotel
Estructura de Datos 2
Integrantes:
Jose Manuel Casillas Rodriguez 
***Pongan su Nombre***
*/
//Clase Main en donde se controla toda la interfaz
public class Main_Final extends javax.swing.JFrame {

    boolean flag=false;
    boolean flag2=false;
    Habitaciones open;
    Reservaciones open2;
    Serializacion1 h;
    Serializacion2 r;
    
    public Main_Final() {
        initComponents();
        h = new Serializacion1();
        r = new Serializacion2();
        cargarDatos();
        cargarDatosr();
      
    }
    
        public void grabarh()
    {
        try{
            FileOutputStream fos = new FileOutputStream("Habitaciones.bin");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            if(out != null){
                out.writeObject(h);
                out.close();
            }
        }catch(Exception ex){
           
        }
    }
             public void cargarDatos()
    {
        try{
            FileInputStream pri = new FileInputStream("Habitaciones.bin");
            ObjectInputStream input = new ObjectInputStream(pri);
            if(input != null)
            {
                h = (Serializacion1) input.readObject();
                input.close();
            }
        }catch(Exception ex){
           // escribir(ex.getMessage());
        }   
    } 
             
               public void AgregarH(){
        Habitaciones em = new Habitaciones();
        String id = txtId2.getText();
        String num = txtNumero2.getText();
        String est = cbEstado2.getSelectedItem().toString();
      

        open = new Habitaciones(id,num,est);
        if(h.Buscar(open.getId()) != -1){
                JOptionPane.showMessageDialog(null,"Id Existente");
        }else{
            h.Agregar(open);
            grabarh();
          
        }   
    }
   
       public void ModificarH()
       {
                  int op = 1;
        if(op==0){
            consultarh();
        }else if(op==1){
            int n = h.getNumero();
            for(int p=0;p<n;p++){
                String id = txtId2.getText();
                String num = txtNumero2.getText();
                String est = cbEstado2.getSelectedItem().toString();
                       
                open = new Habitaciones(id,num,est);
                int  i = h.Buscar(id);
                if(i == -1){
                    h.Agregar(open);
                }else{
                    h.Actualizar(i, open);
                    grabarh();
                }
            }
        } 
       }

          
               
               
    public void consultarh(){
        //String co = JOptionPane.showInputDialog("Buscar por ID:");
        int p = h.Buscar(txtBuscar2.getText());
        int n = h.getNumero();
        if(p == -1){
         JOptionPane.showMessageDialog(null,"Id No Existente");
            DesHabilitarH();
            btnNuevo2.setEnabled(true);
            btnAgregar2.setEnabled(false);
          
            btnEditar2.setEnabled(false);
          
            
        }else{
            for(int i=0; i<n; i++){
                open = h.getHabitaciones(p);
                String id = open.getId();
                String num = open.getNumero();
                String est = open.getEstado();

                txtId2.setText(id);
                txtNumero2.setText(num);
                cbEstado2.setSelectedItem(est);
            }
        }
    }
         
   //*********************Final Funciones Habitaciones************************************//
               
//*********************Inicio Funciones Reservaciones************************************//
        
            public void grabarr()
    {
        try{
            FileOutputStream fos = new FileOutputStream("Reservaciones.bin");
            ObjectOutputStream out = new ObjectOutputStream(fos);
            if(out != null){
                out.writeObject(r);
                out.close();
            }
        }catch(Exception ex){
           
        }
    }
    

      public void cargarDatosr()
    {
        try{
            FileInputStream pri = new FileInputStream("Reservaciones.bin");
            ObjectInputStream input = new ObjectInputStream(pri);
            if(input != null)
            {
                r = (Serializacion2) input.readObject();
                input.close();
            }
        }catch(Exception ex){
           // escribir(ex.getMessage());
        }   
    }
    

       public void AgregarR(){
        Habitaciones em = new Habitaciones();
        String id = txtId3.getText();
        String fr = txtFechaR3.getText();
        String costo = txtCosto3.getText();
        String fs = txtFechaS3.getText();
        String hr = txtHora3.getText();
        String cid = cbIdCliente3.getSelectedItem().toString();
        String hid = cbIdHabitacion3.getSelectedItem().toString();
      

        open2 = new Reservaciones(id,cid,hid,costo,fr,fs,hr);
        if(r.Buscar(open2.getId()) != -1){
                JOptionPane.showMessageDialog(null,"Id Existente");
        }else{
            r.Agregar(open2);
            grabarr();
          
        }   
    }
       
   
       public void ModificarR()
       {
                  int op = 1;
        if(op==0){
            consultarR();
        }else if(op==1){
            int n = r.getNumero();
            for(int p=0;p<n;p++){
        String id = txtId3.getText();
        String fr = txtFechaR3.getText();
        String costo=txtCosto3.getText();
        String fs = txtFechaS3.getText();
        String hr = txtHora3.getText();
        String cid = cbIdCliente3.getSelectedItem().toString();
        String hid = cbIdHabitacion3.getSelectedItem().toString();
                       
                open2 = new Reservaciones(id,cid,hid,costo,fr,fs,hr);
                int  i = r.Buscar(id);
                if(i == -1){
                    r.Agregar(open2);
                }
                else
                {
                    r.Actualizar(i, open2);
                    grabarr();
                }
            }
        } 
       }
       
       public void consultarR(){
        //String co = JOptionPane.showInputDialog("Buscar por ID:");
        int p = r.Buscar(txtBuscar3.getText());
        int n = r.getNumero();
        if(p == -1){
         JOptionPane.showMessageDialog(null,"Id No Existente");
            DesHabilitarR();
       btnNuevo3.setEnabled(true);
       btnReservar3.setEnabled(false);
       btnEditar3.setEnabled(false);
       btnCancelar3.setEnabled(false);
          
            
        }
        else{
            for(int i=0; i<n; i++){
                open2 = r.getReservaciones(p);
        String id = open2.getId();
        String fr = open2.getFr();
        String costo=open2.getCosto();
        String fs = open2.getFs();
        String hr = open2.getHr();
        String cid = open2.getCid();
        String hid = open2.getHid();;        
                
        txtId3.setText(id);
        txtCosto3.setText(costo);
        txtFechaR3.setText(fr);
        txtFechaS3.setText(fs);
        txtHora3.setText(hr);
        cbIdCliente3.setSelectedItem(cid);
        cbIdHabitacion3.setSelectedItem(hid);
            }
        }
    }
       
           public void borrarr(){
       
        int p = r.Buscar(txtBuscar3.getText());
        if(p == -1){
            JOptionPane.showMessageDialog(null,"Id No Existente");
        }else{
            int i =0;
            if(i==0){
                r.Eliminar(p);
                grabarr();
              
            }
        }
    }
    
    //*********************Final Funciones Reservaciones************************************//
           
           
   //*********************Inicio Funciones Habilitadoras************************************//    
     public void HabilitarH(){
        txtId2.setEnabled(true);
        txtNumero2.setEnabled(true);
        cbEstado2.setEnabled(true);
    }
  
    public void DesHabilitarH(){
        txtId2.setEnabled(false);
        txtNumero2.setEnabled(false);
        cbEstado2.setEnabled(false);
    }
    public void HabilitarR(){
        txtId3.setEnabled(true);
        txtCosto3.setEnabled(true);
        cbIdCliente3.setEnabled(true);
       cbIdHabitacion3.setEnabled(true);
       txtFechaR3.setEnabled(true);
        txtFechaS3.setEnabled(true);
        txtHora3.setEnabled(true);
    }
  
    public void DesHabilitarR(){
          txtId3.setEnabled(false);
        txtCosto3.setEnabled(false);
        cbIdCliente3.setEnabled(false);
       cbIdHabitacion3.setEnabled(false);
       txtFechaR3.setEnabled(false);
        txtFechaS3.setEnabled(false);
        txtHora3.setEnabled(false);
    }
    
     //*********************Final Funciones Habilitadoras************************************//    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnNuevo1 = new javax.swing.JButton();
        btnAgregar1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();
        btnRemover1 = new javax.swing.JButton();
        btnBuscar1 = new javax.swing.JButton();
        txtId1 = new javax.swing.JTextField();
        txtNombre1 = new javax.swing.JTextField();
        txtDireccion1 = new javax.swing.JTextField();
        txtTelefono1 = new javax.swing.JTextField();
        txtEmail1 = new javax.swing.JTextField();
        txtBuscar1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtId2 = new javax.swing.JTextField();
        txtNumero2 = new javax.swing.JTextField();
        btnNuevo2 = new javax.swing.JButton();
        btnEditar2 = new javax.swing.JButton();
        btnBuscar2 = new javax.swing.JButton();
        txtBuscar2 = new javax.swing.JTextField();
        cbEstado2 = new javax.swing.JComboBox<>();
        btnAgregar2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnNuevo3 = new javax.swing.JButton();
        btnReservar3 = new javax.swing.JButton();
        btnCancelar3 = new javax.swing.JButton();
        btnEditar3 = new javax.swing.JButton();
        btnBuscar3 = new javax.swing.JButton();
        txtId3 = new javax.swing.JTextField();
        txtCosto3 = new javax.swing.JTextField();
        txtFechaR3 = new javax.swing.JTextField();
        txtBuscar3 = new javax.swing.JTextField();
        txtFechaS3 = new javax.swing.JTextField();
        txtHora3 = new javax.swing.JTextField();
        cbIdCliente3 = new javax.swing.JComboBox<>();
        cbIdHabitacion3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setText("ID a Buscar:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(300, 20, 59, 14);

        jLabel2.setText("ID:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 50, 15, 14);

        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(50, 80, 41, 14);

        jLabel4.setText("Direccion:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 110, 47, 14);

        jLabel5.setText("Telefono:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 140, 46, 14);

        jLabel6.setText("Email:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(50, 170, 28, 14);

        btnNuevo1.setText("Nuevo");
        jPanel1.add(btnNuevo1);
        btnNuevo1.setBounds(20, 230, 80, 40);

        btnAgregar1.setText("Agregar");
        jPanel1.add(btnAgregar1);
        btnAgregar1.setBounds(110, 230, 80, 40);

        btnCancelar1.setText("Cancelar");
        jPanel1.add(btnCancelar1);
        btnCancelar1.setBounds(200, 230, 80, 40);

        btnEditar1.setText("Editar");
        jPanel1.add(btnEditar1);
        btnEditar1.setBounds(290, 230, 80, 40);

        btnRemover1.setText("Remover");
        jPanel1.add(btnRemover1);
        btnRemover1.setBounds(380, 230, 80, 40);

        btnBuscar1.setText("Buscar");
        jPanel1.add(btnBuscar1);
        btnBuscar1.setBounds(500, 10, 80, 40);
        jPanel1.add(txtId1);
        txtId1.setBounds(110, 50, 50, 20);
        jPanel1.add(txtNombre1);
        txtNombre1.setBounds(110, 80, 140, 20);
        jPanel1.add(txtDireccion1);
        txtDireccion1.setBounds(110, 110, 140, 20);
        jPanel1.add(txtTelefono1);
        txtTelefono1.setBounds(110, 140, 140, 20);
        jPanel1.add(txtEmail1);
        txtEmail1.setBounds(110, 170, 140, 20);
        jPanel1.add(txtBuscar1);
        txtBuscar1.setBounds(370, 20, 110, 20);

        jTabbedPane1.addTab("Clientes", jPanel1);

        jLabel7.setText(" Numero de Habitacion a Buscar:");

        jLabel8.setText("Numero: ");

        jLabel9.setText("Habitacion ID:");

        jLabel10.setText("Estado de Habitacion:");

        txtId2.setEnabled(false);

        txtNumero2.setEnabled(false);

        btnNuevo2.setText("Nueva Habitacion");
        btnNuevo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo2ActionPerformed(evt);
            }
        });

        btnEditar2.setText("Editar");
        btnEditar2.setEnabled(false);
        btnEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar2ActionPerformed(evt);
            }
        });

        btnBuscar2.setText("Buscar");
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });

        cbEstado2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Libre", "Ocupado" }));
        cbEstado2.setEnabled(false);

        btnAgregar2.setText("Agregar");
        btnAgregar2.setEnabled(false);
        btnAgregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txtBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtId2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(jLabel10))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(cbEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnNuevo2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnAgregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtId2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addComponent(cbEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Habitaciones", jPanel2);

        jLabel11.setText("Reservacion a Buscar: ");

        jLabel12.setText("ID de Reservacion: ");

        jLabel13.setText("Costo: ");

        jLabel14.setText("Fecha de Salida: ");

        jLabel15.setText("Fecha de Reservacion: ");

        jLabel16.setText("Hora de Reservacion: ");

        jLabel17.setText("Habitacion ID:");

        jLabel18.setText("Cliente ID:");

        btnNuevo3.setText("Nueva Reservacion");
        btnNuevo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevo3ActionPerformed(evt);
            }
        });

        btnReservar3.setText("Reservar");
        btnReservar3.setEnabled(false);
        btnReservar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservar3ActionPerformed(evt);
            }
        });

        btnCancelar3.setText("Cancelar Reservacion");
        btnCancelar3.setEnabled(false);
        btnCancelar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar3ActionPerformed(evt);
            }
        });

        btnEditar3.setText("Editar");
        btnEditar3.setEnabled(false);
        btnEditar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar3ActionPerformed(evt);
            }
        });

        btnBuscar3.setText("Buscar");
        btnBuscar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar3ActionPerformed(evt);
            }
        });

        txtId3.setEnabled(false);

        txtCosto3.setEnabled(false);

        txtFechaR3.setEnabled(false);

        txtFechaS3.setEnabled(false);

        txtHora3.setEnabled(false);

        cbIdCliente3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cbIdCliente3.setEnabled(false);

        cbIdHabitacion3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cbIdHabitacion3.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel11)
                .addGap(10, 10, 10)
                .addComponent(txtBuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnBuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(txtId3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(130, 130, 130)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtFechaR3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(cbIdCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txtFechaS3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(cbIdHabitacion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtHora3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel13)
                .addGap(75, 75, 75)
                .addComponent(txtCosto3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnNuevo3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnReservar3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnCancelar3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnEditar3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtBuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(txtFechaR3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(cbIdCliente3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtFechaS3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(cbIdHabitacion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(txtHora3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtCosto3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReservar3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Reservaciones", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo2ActionPerformed
    HabilitarH();
    btnNuevo2.setEnabled(false);
    btnAgregar2.setEnabled(true);
    btnEditar2.setEnabled(false);
  
    }//GEN-LAST:event_btnNuevo2ActionPerformed

    private void btnEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar2ActionPerformed
    HabilitarH();
    flag=true;
    btnNuevo2.setEnabled(false);
    btnAgregar2.setEnabled(true);
    btnEditar2.setEnabled(false);
    }//GEN-LAST:event_btnEditar2ActionPerformed

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
     this.consultarh();
     DesHabilitarH(); 
    btnNuevo2.setEnabled(false);
    btnAgregar2.setEnabled(false);
    btnEditar2.setEnabled(true);   
        
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    private void btnAgregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar2ActionPerformed
    DesHabilitarH();   
       if(flag==true)
        {
            this.ModificarH();
        }
        else
        {
              this.AgregarH();
        } 
       
    btnNuevo2.setEnabled(true);
    btnAgregar2.setEnabled(false);
    btnEditar2.setEnabled(false);   
    txtId2.setText("");
    txtNumero2.setText("");  
    flag=false;
    }//GEN-LAST:event_btnAgregar2ActionPerformed

    private void btnNuevo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevo3ActionPerformed
        HabilitarR();
       btnNuevo3.setEnabled(false);
       btnReservar3.setEnabled(true);
       btnEditar3.setEnabled(false);
       btnCancelar3.setEnabled(false);
    }//GEN-LAST:event_btnNuevo3ActionPerformed

    private void btnReservar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservar3ActionPerformed
       DesHabilitarR();
        if(flag2==true)
        {
            this.ModificarR();
        }
        else
        {
              this.AgregarR();
        }
       btnNuevo3.setEnabled(true);
       btnReservar3.setEnabled(false);
       btnEditar3.setEnabled(false);
       btnCancelar3.setEnabled(false);
       txtId3.setText("");
        txtCosto3.setText("");
        txtFechaR3.setText("");
        txtFechaS3.setText("");
        txtHora3.setText("");
       flag2=false;
    }//GEN-LAST:event_btnReservar3ActionPerformed

    private void btnCancelar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar3ActionPerformed
       DesHabilitarR();
        this.borrarr();
       btnNuevo3.setEnabled(true);
       btnReservar3.setEnabled(false);
       btnEditar3.setEnabled(false);
       btnCancelar3.setEnabled(false);
        txtId3.setText("");
        txtCosto3.setText("");
        txtFechaR3.setText("");
        txtFechaS3.setText("");
        txtHora3.setText(""); 
    }//GEN-LAST:event_btnCancelar3ActionPerformed

    private void btnEditar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar3ActionPerformed
       HabilitarR();
       flag2=true;
       btnNuevo3.setEnabled(false);
       btnReservar3.setEnabled(true);
       btnEditar3.setEnabled(false);
       btnCancelar3.setEnabled(false);
    }//GEN-LAST:event_btnEditar3ActionPerformed

    private void btnBuscar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar3ActionPerformed
       DesHabilitarR();
       
       btnNuevo3.setEnabled(false);
       btnReservar3.setEnabled(false);
       btnEditar3.setEnabled(true);
       btnCancelar3.setEnabled(true);
       this.consultarR();
    }//GEN-LAST:event_btnBuscar3ActionPerformed

    
  
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Final().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnAgregar2;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnBuscar3;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnCancelar3;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnEditar3;
    private javax.swing.JButton btnNuevo1;
    private javax.swing.JButton btnNuevo2;
    private javax.swing.JButton btnNuevo3;
    private javax.swing.JButton btnRemover1;
    private javax.swing.JButton btnReservar3;
    private javax.swing.JComboBox<String> cbEstado2;
    private javax.swing.JComboBox<String> cbIdCliente3;
    private javax.swing.JComboBox<String> cbIdHabitacion3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField txtBuscar1;
    private javax.swing.JTextField txtBuscar2;
    private javax.swing.JTextField txtBuscar3;
    private javax.swing.JTextField txtCosto3;
    private javax.swing.JTextField txtDireccion1;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtFechaR3;
    private javax.swing.JTextField txtFechaS3;
    private javax.swing.JTextField txtHora3;
    private javax.swing.JTextField txtId1;
    private javax.swing.JTextField txtId2;
    private javax.swing.JTextField txtId3;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNumero2;
    private javax.swing.JTextField txtTelefono1;
    // End of variables declaration//GEN-END:variables
}
