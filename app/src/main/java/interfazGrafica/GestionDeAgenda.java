package interfazGrafica;

import consultorio.consultorio.Consultorio;
import consultorio.cronograma.Turno;
import consultorio.persona.Odontologo;
import java.time.LocalDateTime;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionDeAgenda extends javax.swing.JFrame {

    private Consultorio consultorio;

    private Odontologo odontologo;
    int filaSeleccionada = -1;

    public GestionDeAgenda(Consultorio consultorio, Odontologo odontologo) {

        this.consultorio = consultorio;
        this.odontologo = odontologo;
        initComponents();
        setLocationRelativeTo(null);

        generarTurnosEnTabla();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAgenda = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnAgregarTurnos = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 153, 255), 5, true));

        jButton4.setBackground(new java.awt.Color(255, 51, 51));
        jButton4.setText("Atras");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion de Agenda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        tablaAgenda.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaAgenda);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 102, 255)));

        btnAgregarTurnos.setBackground(new java.awt.Color(153, 255, 153));
        btnAgregarTurnos.setText("Crear ");
        btnAgregarTurnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTurnosActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(153, 255, 204));
        btnActualizar.setText("Actualizar Lista");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(51, 51, 255));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarTurnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarTurnos)
                .addGap(18, 18, 18)
                .addComponent(btnModificar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Opciones Turno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(336, 336, 336))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(759, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jButton4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnAgregarTurnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTurnosActionPerformed

        filaSeleccionada = tablaAgenda.getSelectedRow();

        if (filaSeleccionada != -1) {
            String nombreSeleccionado = (String) tablaAgenda.getValueAt(tablaAgenda.getSelectedRow(), 1);

            if (nombreSeleccionado == null) {

                int indice = filaSeleccionada;

                LocalDateTime fechaSeleccionada = (LocalDateTime) tablaAgenda.getValueAt(tablaAgenda.getSelectedRow(), 0);

                AgregarTurno agregarTurno = new AgregarTurno(consultorio, fechaSeleccionada, indice, odontologo);
                agregarTurno.setLocationRelativeTo(this);
                agregarTurno.setVisible(true);

            } else {

                JOptionPane.showMessageDialog(this, "EL TURNO SELECCIONADO SE ENCUENTRA OCUPADO");

            }

        } else {

            JOptionPane.showMessageDialog(this, "NO SE HA SELECIONADO UNA FILA  ");

        }


    }//GEN-LAST:event_btnAgregarTurnosActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        generarTurnosEnTabla();

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        filaSeleccionada = tablaAgenda.getSelectedRow();

        int indice = filaSeleccionada;

        if (filaSeleccionada != -1) {

            String nombreSeleccionado = (String) tablaAgenda.getValueAt(tablaAgenda.getSelectedRow(), 1);

            if (nombreSeleccionado != null) {

                LocalDateTime fechaSeleccionada = (LocalDateTime) tablaAgenda.getValueAt(tablaAgenda.getSelectedRow(), 0);

                ModificarTurno modificar = new ModificarTurno(consultorio, fechaSeleccionada, indice, odontologo);
                modificar.setVisible(true);
                modificar.setLocationRelativeTo(this);

            } else {

                JOptionPane.showMessageDialog(this, "NO PUEDE MODIFICAR UN TURNO NO ASIGNADO  ");

            }

        } else {

            JOptionPane.showMessageDialog(this, "NO SE HA SELECIONADO UNA FILA  ");

        }


    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        filaSeleccionada = tablaAgenda.getSelectedRow();

        if (filaSeleccionada != -1) {

            String nombreSeleccionado = (String) tablaAgenda.getValueAt(tablaAgenda.getSelectedRow(), 1);
            if (nombreSeleccionado != null) {
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el turno Seleccionado" + "?", "Alerta", JOptionPane.YES_NO_OPTION);
                if (respuesta == 0) {

                    Integer dniAEliminar = (Integer) tablaAgenda.getValueAt(tablaAgenda.getSelectedRow(), 3);
                    Turno turnoAeliminar = null;

                    turnoAeliminar = odontologo.getAgenda().buscarPacientePorDni(dniAEliminar);

                    odontologo.getAgenda().eliminarTurno(turnoAeliminar);

                    JOptionPane.showMessageDialog(null, "El turno fue dado de baja con exito");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El Turno Se Encuentra Sin Paciente");
            }

        } else {

            JOptionPane.showMessageDialog(this, "NO SE HA SELECIONADO UNA FILA  ");

        }


    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarTurnos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaAgenda;
    // End of variables declaration//GEN-END:variables

    private void generarTurnosEnTabla() {

        String[] columnas = {"HORARIOS DISPONIBLES", "NOMBRE DEL PACIENTE", "APELLIDO DEL PACIENTE", "DNI"};
        Object[][] datos = new Object[odontologo.getAgenda().getListaTurnos().size()][4];
        int i = 0;

        //Traer los datos de los pacientes en los turnos
        for (Map.Entry<Integer, Turno> turno : odontologo.getAgenda().getListaTurnos().entrySet()) {

            datos[turno.getKey()][0] = odontologo.getAgenda().calcularHoraDelTurno(turno.getKey());
            if (turno.getValue() != null) {

                datos[turno.getKey()][1] = turno.getValue().getPaciente().getNombre();
                datos[turno.getKey()][2] = turno.getValue().getPaciente().getApellido();
                datos[turno.getKey()][3] = turno.getValue().getPaciente().getDni();
            }

        }

        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        this.tablaAgenda.setModel(modelo);

        //}
    }

}

//    
//    private void mostrarDatosDeAgenda() {
//        
//        
//            String[] columnas = {"HORARIOS DISPONIBLES", "NOMBRE DEL PACIENTE", "APELLIDO DEL PACIENTE", "DNI"};
//        Object[][] datos = new Object[odontologo.getAgenda().getListaTurnos().size()][4];
//        int i = 0;
//        
//        
//        for (Odontologo dato : consultorio.getOdontologos()) {
//            datos[i][0] = dato.getAgenda().calcularHoraDelTurno(i);
////            datos[i][1] = dato.getAgenda().getListaTurnos();
////            datos[i][2] = dato.getDni();
////            datos[i][3] = dato.getObraSocial();
//            i++;
//        }
//        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
//        this.tablaAgenda.setModel(modelo);
//
//    }

