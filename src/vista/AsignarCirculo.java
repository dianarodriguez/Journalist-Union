/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AsignarCirculo.java
 *
 * Created on 30-jun-2012, 13:49:53
 */

package vista;

import controlador.control.CirculoEControl;
import controlador.control.Herramientas;
import controlador.control.PeriodistaCirculoControl;
import controlador.control.PeriodistaControl;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import modelo.CirculoEspecial;
import modelo.Periodista;
import modelo.PeriodistaCirculo;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author asus
 */
public class AsignarCirculo extends javax.swing.JDialog {
private int posfila=0;
EntityManager em = Trabajoem.GetEntityManager();

    /** Creates new form AsignarCirculo */
    public AsignarCirculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
          AutoCompleteDecorator.decorate(jComboBox2);
           AutoCompleteDecorator.decorate(jComboBox1);
            AutoCompleteDecorator.decorate(jComboBox3);
             AutoCompleteDecorator.decorate(jComboBox4);
           jDateChooser1.setDate(Calendar.getInstance().getTime());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        tesisUpecPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("tesisUpecPU").createEntityManager();
        circuloEspecialQuery = java.beans.Beans.isDesignTime() ? null : tesisUpecPUEntityManager.createQuery("SELECT c FROM CirculoEspecial c");
        circuloEspecialList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(circuloEspecialQuery.getResultList());
        periodistaCirculoQuery = java.beans.Beans.isDesignTime() ? null : tesisUpecPUEntityManager.createQuery("SELECT p FROM PeriodistaCirculo p");
        periodistaCirculoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(periodistaCirculoQuery.getResultList());
        periodistaQuery = java.beans.Beans.isDesignTime() ? null : tesisUpecPUEntityManager.createQuery("SELECT p FROM Periodista p");
        periodistaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : periodistaQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignar Círculo Especializado");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(30, 76, 89));

        jPanel2.setBackground(new java.awt.Color(30, 76, 89));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/banergrande.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(30, 76, 89)));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asigcirculo.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel2.setText("Nombre del periodista:");

        jLabel5.setText("Responsabilidad del periodista en el Círculo:");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel6.setText("Fecha:");

        jLabel7.setText("Círculo:");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, circuloEspecialList, jComboBox1);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, periodistaList, jComboBox2);
        bindingGroup.addBinding(jComboBoxBinding);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, 266, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(30, 76, 89)));

        jButton1.setText("Insertar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jButton2.setText("Modificar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });

        jButton5.setText("Cancelar");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(19, 19, 19))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(30, 76, 89)));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, periodistaCirculoList, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${circuloEspecial}"));
        columnBinding.setColumnName("Círculo Especializado");
        columnBinding.setColumnClass(modelo.CirculoEspecial.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${periodista}"));
        columnBinding.setColumnName("Periodista");
        columnBinding.setColumnClass(modelo.Periodista.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fecha}"));
        columnBinding.setColumnName("Fecha");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cargoPeriodista}"));
        columnBinding.setColumnName("Cargo del Periodista");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        jLabel4.setText("Periodista:");

        jLabel8.setText("Círculo:");

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, periodistaList, jComboBox3);
        bindingGroup.addBinding(jComboBoxBinding);

        jButton4.setText("Buscar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, circuloEspecialList, jComboBox4);
        bindingGroup.addBinding(jComboBoxBinding);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, 222, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jButton4)
                .addContainerGap(94, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
            if (jComboBox2.getSelectedItem()==null){
             JOptionPane.showMessageDialog(null, "Debe seleccionar al periodista.");


         }
        else{
              if (jTable2.getSelectedRow()!= -1){
             jTable2.clearSelection();
             JOptionPane.showMessageDialog(null, "Para asignar no debe tener otra asignació seleccionada.");
             }
 else{
             if(jDateChooser1.getDate()==null ||jTextField2.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "No debe dejar campos vacíos.");

                  }
             

 else{
              PeriodistaCirculo pcirc=new PeriodistaCirculo();
               CirculoEControl cpc=new CirculoEControl();
               PeriodistaControl pc=new PeriodistaControl();
               PeriodistaCirculoControl pcc=new PeriodistaCirculoControl();
                Periodista per=null;
               per=pc.buscarPerNombre(String.valueOf(jComboBox2.getSelectedItem()));
                       int idper=per.getIdPeriodista();
           String    nombrec=String.valueOf(jComboBox1.getSelectedItem());
               int idcirculo=cpc.buscarIdCirculo(nombrec);
                       if(pcc.existe(idper, idcirculo)){
                      JOptionPane.showMessageDialog(null, "Este círculo ya fue asignado a este periodista.");
                
                 }
                 else {
                            try {
                                pcirc.setCargoPeriodista(jTextField2.getText());
                                pcirc.setCirculoEspecial(cpc.buscarCirculo(idcirculo));
                                pcirc.setFecha(jDateChooser1.getDate());
                                pcirc.setPeriodista(pc.BuscarPeriod(idper));
                                pcc.adicionar(pcirc);
                                periodistaCirculoList.add(pcirc);
                                jTextField2.setText("");
                                 jDateChooser1.setDate(Calendar.getInstance().getTime());
                            } catch (PreexistingEntityException ex) {
                                Logger.getLogger(AsignarCirculo.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                Logger.getLogger(AsignarCirculo.class.getName()).log(Level.SEVERE, null, ex);
                            }







        
    }
 }}
        }
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
          
            if (jTable2.getSelectedRow()== -1){
                 JOptionPane.showMessageDialog(null, "Para modidficar debe seleccionar la asignación.");
               }
 else{
                     Integer fila = jTable2.getSelectedRow();
                     if(jTable2.getValueAt(fila, 2)==null || jTable2.getSelectedRowCount()>1)
                  JOptionPane.showMessageDialog(null, "Debe seleccionar una asignación.");
                     else{
                     if(jDateChooser1.getDate()==null||jTextField2.getText().isEmpty())
               JOptionPane.showMessageDialog(null, "No debe dejar campos vacios.");
                   else
           {
                     PeriodistaCirculo pcirc=new PeriodistaCirculo();
               CirculoEControl cec=new CirculoEControl();
               PeriodistaControl pc=new PeriodistaControl();
              PeriodistaCirculoControl pcc=new PeriodistaCirculoControl();
               Periodista per=null;
               per=pc.buscarPerNombre(String.valueOf(jComboBox2.getSelectedItem()));
           int    idper=per.getIdPeriodista();
           String    nombrec=String.valueOf(jComboBox1.getSelectedItem());
           PeriodistaCirculo seleccionado=periodistaCirculoList.get(fila);
           Periodista p=pc.BuscarPeriod(idper);

      int     idselecc=seleccionado.getIdPerCirculo();
               int idc=cec.buscarIdCirculo(nombrec);
                CirculoEspecial ce=cec.buscarCirculo(idc);
               boolean existe=false;
               for (int i = 0; i < pcc.listarPerCirculo().size(); i++) {
                  PeriodistaCirculo cargoPer = pcc.listarPerCirculo().get(i);
                   if(cargoPer.getCirculoEspecial().getIdCirculoe()==idc
                   &&cargoPer.getPeriodista().getIdPeriodista()==idper &&
                   cargoPer.getIdPerCirculo()!=idselecc){
                       existe=true;break;
                   }
               }

               if(existe){
                     JOptionPane.showMessageDialog(null, "ya existe esta asignación.");
               }
 else{
                            try {
                                pcc.actualizarPC(jDateChooser1.getDate(), p, ce, idselecc, jTextField2.getText());
                           PeriodistaCirculo perc=pcc.buscarId(idselecc);
                           periodistaCirculoList.remove(perc);
                           periodistaCirculoList.add(perc);
                            jTextField2.setText("");
                             jDateChooser1.setDate(Calendar.getInstance().getTime());
                            } catch (PreexistingEntityException ex) {
                                Logger.getLogger(AsignarCirculo.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                Logger.getLogger(AsignarCirculo.class.getName()).log(Level.SEVERE, null, ex);
                            }



 }
                


        }}}
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        // TODO add your handling code here:
            if (jTable2.getSelectedRow()== -1){
                 JOptionPane.showMessageDialog(null, "Para eliminar debe seleccionar la asignación.");
               }
 else{
              Integer fila = jTable2.getSelectedRow();
              if(jTable2.getValueAt(fila, 0)==null || jTable2.getSelectedRowCount()>1)
                  JOptionPane.showMessageDialog(null, "Debe seleccionar una asignación.");
              else{
              if (JOptionPane.showConfirmDialog(null, "Realmente desea eliminar?") == JOptionPane.YES_OPTION) {
                    try {
                        // Integer fila = jTable1.getSelectedRow();
                        PeriodistaCirculoControl pcc = new PeriodistaCirculoControl();
                        String nombre = String.valueOf(jTable2.getValueAt(fila, 0));
                        PeriodistaCirculo pc = periodistaCirculoList.get(fila);
                        int idpercirc = pc.getIdPerCirculo();
                        pcc.eliminar(idpercirc);
                       periodistaCirculoList.remove(pc);
                        jTextField2.setText("");
                         jDateChooser1.setDate(Calendar.getInstance().getTime());
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(AsignarCirculo.class.getName()).log(Level.SEVERE, null, ex);
                    }


                    }
                  }
                  }
    }//GEN-LAST:event_jButton3MousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
            jTable2.setAutoResizeMode(jTable2.AUTO_RESIZE_OFF);
TableColumn columna3 = jTable2.getColumn("Círculo Especializado");
        columna3.setPreferredWidth(150);
         TableColumn columna4 = jTable2.getColumn("Periodista");
        columna4.setPreferredWidth(150);
TableColumn columna2 = jTable2.getColumn("Cargo del Periodista");
        columna2.setPreferredWidth(150);

        TableColumn columna1 = jTable2.getColumn("Fecha");
        columna1.setPreferredWidth(100);
        jTable2.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                PeriodistaCirculoControl gestion= new PeriodistaCirculoControl();
                jTable2.setRowSelectionInterval(jTable2.rowAtPoint(e.getPoint()), jTable2.rowAtPoint(e.getPoint()));
                 PeriodistaCirculo usu1 = periodistaCirculoList.get(jTable2.rowAtPoint(e.getPoint()));
            //   PeriodistaCirculo usu = em.find(PeriodistaCirculo.class, usu1.getIdPerCirculo());
               PeriodistaCirculo usu= gestion.buscarId(usu1.getIdPerCirculo());
                jComboBox2.setSelectedItem(usu.getPeriodista());
               jTextField2.setText(usu.getCargoPeriodista());
                jComboBox1.setSelectedItem(usu.getCirculoEspecial());
                jDateChooser1.setDate(usu.getFecha());

            }
        });

    }//GEN-LAST:event_formWindowOpened

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        // TODO add your handling code here:
         PeriodistaCirculoControl pc= new PeriodistaCirculoControl()   ;
         String nombre=String.valueOf(jComboBox3.getSelectedItem());
          String nombrec=String.valueOf(jComboBox4.getSelectedItem());
                PeriodistaCirculo p= pc.buscarNombre(nombre,nombrec);
                if(p==null)
       JOptionPane.showMessageDialog(null, "Al periodista"+" "+nombre+" "+"no se le ha sido asignado el círculo especializado:"+" "+nombrec);
        else
                {
                    int posi= periodistaCirculoList.lastIndexOf(p);
          //  Integer pos = getion.BuscarMunicipios(municipiosList, jnombre1.getText());
          //  if (pos != -1) {
                jTable2.setRowSelectionInterval(posi, posi);
                PeriodistaCirculo usu1 = periodistaCirculoList.get(jTable2.getSelectedRow());
                PeriodistaCirculo usu = em.find(PeriodistaCirculo.class, usu1.getIdPerCirculo());

                jComboBox2.setSelectedItem(usu.getPeriodista());
               // jComboBox1.setSelectedItem(usu.getCargoPeriodistico().getNombreCargop());
                jComboBox1.setSelectedItem(usu.getCirculoEspecial());
                jTextField2.setText(usu.getCargoPeriodista());
                jDateChooser1.setDate(usu.getFecha());




        }
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
        // TODO add your handling code here:
         jDateChooser1.setDate(Calendar.getInstance().getTime());
         jTextField2.setText("");
          jTable2.clearSelection();
    }//GEN-LAST:event_jButton5MousePressed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
          if (jTextField2.getText().length() >= 100) {
            char temp = 0;
            evt.setKeyChar(temp);
        }
        char caracter = evt.getKeyChar();
        if (!((caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z') || (caracter >= '0' && caracter <= '9') || caracter == 8 || caracter == ' ' || Herramientas.vocalTilde(caracter))) {//
            char temp = 0;
            evt.setKeyChar(temp);
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AsignarCirculo dialog = new AsignarCirculo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<modelo.CirculoEspecial> circuloEspecialList;
    private javax.persistence.Query circuloEspecialQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private java.util.List<modelo.PeriodistaCirculo> periodistaCirculoList;
    private javax.persistence.Query periodistaCirculoQuery;
    private java.util.List<modelo.Periodista> periodistaList;
    private javax.persistence.Query periodistaQuery;
    private javax.persistence.EntityManager tesisUpecPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
