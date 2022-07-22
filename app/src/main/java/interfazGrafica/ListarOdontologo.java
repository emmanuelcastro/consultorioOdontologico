package interfazGrafica;

import consultorio.consultorio.Consultorio;
import consultorio.persona.Odontologo;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.OrdenarOdontologoPorApellido;
import utils.OrdenarOdontologoPorDni;

public class ListarOdontologo extends javax.swing.JFrame {

    private Consultorio consultorio;
    private ArrayList<Odontologo> odontologos;

    int filaSeleccionada = -1;

    public ListarOdontologo(Consultorio consultorio, ArrayList<Odontologo> odontologos) {

        this.consultorio = consultorio;
        this.odontologos = odontologos;

        initComponents();
        setLocationRelativeTo(null);
        mostrarDatosOdontologos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupOrdenar = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnAtras = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOdontologos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JToggleButton();
        btnActualizar = new javax.swing.JToggleButton();
        btnGestionDeAgenda = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnOrdenarPorDni = new javax.swing.JRadioButton();
        btnOrdenarPorApellido = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 153, 255), 5, true));

        btnAtras.setBackground(new java.awt.Color(255, 51, 51));
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Listar Odontologos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaOdontologos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaOdontologos);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 102, 255), 2));

        btnModificar.setBackground(new java.awt.Color(102, 255, 0));
        btnModificar.setText("Modificar ");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar Lista");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnGestionDeAgenda.setBackground(new java.awt.Color(255, 204, 204));
        btnGestionDeAgenda.setText("Gestion De Agenda");
        btnGestionDeAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionDeAgendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGestionDeAgenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnGestionDeAgenda)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        btnOrdenarPorDni.setBackground(new java.awt.Color(204, 204, 255));
        groupOrdenar.add(btnOrdenarPorDni);
        btnOrdenarPorDni.setText("Ordenar por Dni");
        btnOrdenarPorDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarPorDniActionPerformed(evt);
            }
        });

        btnOrdenarPorApellido.setBackground(new java.awt.Color(204, 204, 255));
        groupOrdenar.add(btnOrdenarPorApellido);
        btnOrdenarPorApellido.setText("Ordenar por Apellido");
        btnOrdenarPorApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarPorApellidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnOrdenarPorDni)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOrdenarPorApellido)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOrdenarPorDni)
                    .addComponent(btnOrdenarPorApellido)))
        );

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Opciones Odontologo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(311, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(btnAtras))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        filaSeleccionada = tablaOdontologos.getSelectedRow();

        if (filaSeleccionada != -1) {

            Odontologo odontologoEncontrado = null;

            for (Odontologo odontologo : odontologos) {

                if (odontologo.getMatriculaProfesional().equals(tablaOdontologos.getValueAt(tablaOdontologos.getSelectedRow(), 3))) {

                    odontologoEncontrado = odontologo;

                }
            }
            ModificarOdontologo modificarOdontologo = new ModificarOdontologo(consultorio, odontologoEncontrado);
            modificarOdontologo.setLocationRelativeTo(this);
            modificarOdontologo.setVisible(true);

        } else {

            JOptionPane.showMessageDialog(this, "NO SE HA SELECIONADO UNA FILA  ");

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        this.mostrarDatosOdontologos();

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        filaSeleccionada = tablaOdontologos.getSelectedRow();

        if (filaSeleccionada != -1) {

            int respuesta = JOptionPane.showConfirmDialog(null, "Está Seguro De Eliminar EL Odontologo Seleccionado" + "?", "Alerta", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {

                Integer odontologoAeliminar = null;

                for (Odontologo odontologo : odontologos) {

                    if (odontologo.getMatriculaProfesional().equals(tablaOdontologos.getValueAt(tablaOdontologos.getSelectedRow(), 3))) {

                        odontologoAeliminar = odontologo.getMatriculaProfesional();
                    }
                }

                consultorio.eliminarOdontologo(odontologoAeliminar);

                JOptionPane.showMessageDialog(null, "Odontologo Eliminado Con Exito");

            } else {

                // JOptionPane.showMessageDialog(this, "NO SE HA SELECIONADO UNA FILA  ");
            }

        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGestionDeAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionDeAgendaActionPerformed

        filaSeleccionada = tablaOdontologos.getSelectedRow();

        if (filaSeleccionada != -1) {

            Odontologo odontologoEncontrado = null;

            for (Odontologo odontologo : odontologos) {

                if (odontologo.getMatriculaProfesional().equals(tablaOdontologos.getValueAt(tablaOdontologos.getSelectedRow(), 3))) {

                    odontologoEncontrado = odontologo;

                }
            }
            GestionDeAgenda gestionDeAgenda = new GestionDeAgenda(consultorio, odontologoEncontrado);
            gestionDeAgenda.setLocationRelativeTo(this);
            gestionDeAgenda.setVisible(true);

        } else {

            JOptionPane.showMessageDialog(this, "NO SE HA SELECIONADO UNA FILA  ");

        }


    }//GEN-LAST:event_btnGestionDeAgendaActionPerformed

    private void btnOrdenarPorDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarPorDniActionPerformed

        Collections.sort(consultorio.getOdontologos(), new OrdenarOdontologoPorDni());

        mostrarDatosOdontologos();

    }//GEN-LAST:event_btnOrdenarPorDniActionPerformed

    private void btnOrdenarPorApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarPorApellidoActionPerformed

        Collections.sort(consultorio.getOdontologos(), new OrdenarOdontologoPorApellido());

        mostrarDatosOdontologos();
    }//GEN-LAST:event_btnOrdenarPorApellidoActionPerformed

    DefaultTableModel modelo;

    private void mostrarDatosOdontologos() {

        String[] columnas = {"NOMBRE", "APELLIDO", "DNI", "MATRICULA", "ENTRADA", "TURNOS DIARIOS"};
        Object[][] datos = new Object[odontologos.size()][6];
        int i = 0;
        for (Odontologo dato : odontologos) {
            datos[i][0] = dato.getNombre();
            datos[i][1] = dato.getApellido();
            datos[i][2] = dato.getDni();
            datos[i][3] = dato.getMatriculaProfesional();
            datos[i][4] = dato.getHoraDeEntrada();
            datos[i][5] = dato.getCantidadDeTurnosDiarios();
            i++;
        }
        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        this.tablaOdontologos.setModel(modelo);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnActualizar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JToggleButton btnEliminar;
    private javax.swing.JButton btnGestionDeAgenda;
    private javax.swing.JButton btnModificar;
    private javax.swing.JRadioButton btnOrdenarPorApellido;
    private javax.swing.JRadioButton btnOrdenarPorDni;
    private javax.swing.ButtonGroup groupOrdenar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaOdontologos;
    // End of variables declaration//GEN-END:variables
}
