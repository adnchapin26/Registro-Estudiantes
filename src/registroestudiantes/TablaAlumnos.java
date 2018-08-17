package registroestudiantes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class TablaAlumnos extends javax.swing.JFrame implements ActionListener {
    ArrayList<Alumno> lista = new ArrayList<>();
    int contadorFilas=0;
    
    public TablaAlumnos() {
        initComponents();
        
        botonBuscar.addActionListener(this);
        botonEliminar.addActionListener(this);
        botonsalir.addActionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        JtbAlumnos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMostarAlumnoBuscado = new javax.swing.JTextArea();
        txtBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JtbAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(JtbAlumnos);

        txtMostarAlumnoBuscado.setColumns(20);
        txtMostarAlumnoBuscado.setRows(5);
        jScrollPane2.setViewportView(txtMostarAlumnoBuscado);

        botonBuscar.setText("Buscar");

        botonEliminar.setText("Eliminar");

        botonsalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(522, 522, 522)
                        .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBuscar)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(289, 289, 289))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JtbAlumnos;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonsalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtMostarAlumnoBuscado;
    // End of variables declaration//GEN-END:variables

    public void llenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel(); // modelo del JTable
        
        // en la tabla solo mostrare los datos siguientes, no todos
        modelo.addColumn("CARNET"); 
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("CORREO");
        
        // Recorrer la lista para acceder a sus campos 
        for ( Alumno x : lista ){
            String[] datosTabla = {
                        x.getCarnet(), x.getNombre(), x.getDireccion(), x.getTelefono(), x.getCorreo()
            };
            
            modelo.addRow(datosTabla); // pasar el objeto a un nueva fila
        }
        
        JtbAlumnos.setModel(modelo);
        
    }
    
    // metodo para pasar el arraylist de otro JFrame a este JFrame
    public void setArrayListAlumno(ArrayList<Alumno> lista  ){
        // clonar el arrayList
        this.lista = (ArrayList<Alumno>) lista.clone();        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if ( ae.getSource() == botonBuscar ){
            buscar();
        }
        
        if ( ae.getSource() == botonEliminar ){
            eliminar();
        }
        
        if ( ae.getSource() == botonsalir ){
            this.dispose();
            form1.setArregloGeneral(lista);
        }
    }

    private void buscar() {
        contadorFilas=0;
        
        if ( txtBuscar.getText().length() == 0 ){
            System.out.println("No se ha ingresado el carne a buscar");
        }else{
            // Buscar el elemento en el arreglo
            for ( Alumno x : lista ){
                if ( x.getCarnet() == null ? txtBuscar.getText() == null : x.getCarnet().equals(txtBuscar.getText()) ){
                    txtMostarAlumnoBuscado.setText("CARNET: " + x.getCarnet() + 
                                                "\nNOMBRE: " + x.getNombre() + 
                                                "\nDIRRECCION: " + x.getDireccion() +
                                                "\nTELEFONO: " + x.getTelefono() +
                                                "\nCORREO: " + x.getCorreo()
                            );
                    
                                                // filas, columnas
                    JtbAlumnos.changeSelection(contadorFilas, 1, false, false);
                    break; // terminar la busqueda
                }
                
                contadorFilas++; // Incrementar el contador de filas para controlar
            }
        }
    }
    
    private void eliminar() {
        
        if ( JtbAlumnos.getRowCount() == 0 ){
            System.out.println("La tabla esta vacia.");
        }else{
            lista.remove(contadorFilas);
            llenarTabla();
        }
        
        
    }
    
}