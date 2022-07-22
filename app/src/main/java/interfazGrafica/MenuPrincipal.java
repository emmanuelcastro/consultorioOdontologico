package interfazGrafica;

import consultorio.DatosAnexos.ObraSocial;
import consultorio.consultorio.Consultorio;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MenuPrincipal extends javax.swing.JFrame {

    Consultorio consultorio;

    FondoPanel fondo = new FondoPanel();

    public MenuPrincipal(Consultorio consultorio) {

        this.consultorio = consultorio;
        ObraSocial sinObraSocial = new ObraSocial("Particular", 0);
        consultorio.agregarObraSocial(sinObraSocial);
        initComponents();
        this.setContentPane(fondo);
        setLocationRelativeTo(null);

        this.setExtendedState(MenuPrincipal.MAXIMIZED_BOTH);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuOdontologos = new javax.swing.JMenu();
        agregarOdontologo = new javax.swing.JMenuItem();
        listarOdontologos = new javax.swing.JMenuItem();
        menuPacientes = new javax.swing.JMenu();
        menuAgregarPaciente = new javax.swing.JMenuItem();
        JlistarPaciente = new javax.swing.JMenuItem();
        menuObraSocial = new javax.swing.JMenu();
        agregarObraSocial = new javax.swing.JMenuItem();
        listarObrasSociales = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal");

        menuOdontologos.setText("Odontologos");

        agregarOdontologo.setText("Agregar Odontologo");
        agregarOdontologo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarOdontologoActionPerformed(evt);
            }
        });
        menuOdontologos.add(agregarOdontologo);

        listarOdontologos.setText("Listar Odontologos");
        listarOdontologos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarOdontologosActionPerformed(evt);
            }
        });
        menuOdontologos.add(listarOdontologos);

        jMenuBar1.add(menuOdontologos);

        menuPacientes.setText("Pacientes");
        menuPacientes.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                menuPacientesAncestorRemoved(evt);
            }
        });

        menuAgregarPaciente.setText("Agregar Paciente");
        menuAgregarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAgregarPacienteActionPerformed(evt);
            }
        });
        menuPacientes.add(menuAgregarPaciente);

        JlistarPaciente.setText("Listar Pacientes");
        JlistarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JlistarPacienteActionPerformed(evt);
            }
        });
        menuPacientes.add(JlistarPaciente);

        jMenuBar1.add(menuPacientes);

        menuObraSocial.setText("Obra Social");
        menuObraSocial.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                menuObraSocialAncestorRemoved(evt);
            }
        });

        agregarObraSocial.setText("Agregar Obra Social");
        agregarObraSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarObraSocialActionPerformed(evt);
            }
        });
        menuObraSocial.add(agregarObraSocial);

        listarObrasSociales.setText("Listar Obras Sociales");
        listarObrasSociales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarObrasSocialesActionPerformed(evt);
            }
        });
        menuObraSocial.add(listarObrasSociales);

        jMenuBar1.add(menuObraSocial);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuPacientesAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_menuPacientesAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_menuPacientesAncestorRemoved

    private void menuAgregarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAgregarPacienteActionPerformed

        AgregarPaciente pacientes = new AgregarPaciente(consultorio);
        pacientes.setVisible(true);

    }//GEN-LAST:event_menuAgregarPacienteActionPerformed

    private void JlistarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JlistarPacienteActionPerformed

        ListarPaciente listarPaciente = new ListarPaciente(consultorio, consultorio.getPacientes());
        listarPaciente.setVisible(true);

    }//GEN-LAST:event_JlistarPacienteActionPerformed

    private void agregarObraSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarObraSocialActionPerformed

        AgregarObraSocial obraSocial = new AgregarObraSocial(consultorio);
        obraSocial.setVisible(true);


    }//GEN-LAST:event_agregarObraSocialActionPerformed

    private void listarObrasSocialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarObrasSocialesActionPerformed

        ListarObraSocial listar = new ListarObraSocial(consultorio, consultorio.getObrasSociales());
        listar.setVisible(true);

    }//GEN-LAST:event_listarObrasSocialesActionPerformed

    private void menuObraSocialAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_menuObraSocialAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_menuObraSocialAncestorRemoved

    private void listarOdontologosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarOdontologosActionPerformed

        ListarOdontologo listarOdontologo = new ListarOdontologo(consultorio, consultorio.getOdontologos());
        listarOdontologo.setVisible(true);
    }//GEN-LAST:event_listarOdontologosActionPerformed

    private void agregarOdontologoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarOdontologoActionPerformed

        AgregarOdontologo agregarOdontologo = new AgregarOdontologo(consultorio);
        agregarOdontologo.setVisible(true);
    }//GEN-LAST:event_agregarOdontologoActionPerformed

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/ImagenMenu.jpg")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);
            super.paint(g);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JlistarPaciente;
    private javax.swing.JMenuItem agregarObraSocial;
    private javax.swing.JMenuItem agregarOdontologo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem listarObrasSociales;
    private javax.swing.JMenuItem listarOdontologos;
    private javax.swing.JMenuItem menuAgregarPaciente;
    private javax.swing.JMenu menuObraSocial;
    private javax.swing.JMenu menuOdontologos;
    private javax.swing.JMenu menuPacientes;
    // End of variables declaration//GEN-END:variables

}
