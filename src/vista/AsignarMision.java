/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AsignarMision.java
 *
 * Created on 05-jul-2012, 12:39:50
 */

package vista;

import controlador.control.MisionControl;
import controlador.control.PeriodistaControl;
import controlador.control.PeriodistaMisionControl;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import modelo.Mision;
import modelo.Periodista;
import modelo.PeriodistaCargop;
import modelo.PeriodistaMision;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author asus
 */
public class AsignarMision extends javax.swing.JDialog {
private int posfila=0;
EntityManager em = Trabajoem.GetEntityManager();
    /** Creates new form AsignarMision */
    public AsignarMision(java.awt.Frame parent, boolean modal) {
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
        periodistaMisionQuery = java.beans.Beans.isDesignTime() ? null : tesisUpecPUEntityManager.createQuery("SELECT p FROM PeriodistaMision p");
        periodistaMisionList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(periodistaMisionQuery.getResultList());
        misionQuery = java.beans.Beans.isDesignTime() ? null : tesisUpecPUEntityManager.createQuery("SELECT m FROM Mision m");
        misionList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(misionQuery.getResultList());
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
        jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
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
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignar Misión");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(30, 76, 89));

        jPanel2.setBackground(new java.awt.Color(30, 76, 89));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/banergrande.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(30, 76, 89)));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asigmision.jpg"))); // NOI18N

        jLabel2.setText("Nombre del periodista:");

        jLabel5.setText("Cantidad de meses:");

        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField2MousePressed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel6.setText("Fecha:");

        jLabel7.setText("Observaciones:");

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jLabel8.setText("Código:");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, misionList, jComboBox1);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, periodistaList, jComboBox2);
        bindingGroup.addBinding(jComboBoxBinding);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addContainerGap())
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 325, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, 0, 325, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addContainerGap(54, Short.MAX_VALUE)))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
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
                .addGap(155, 155, 155)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(26, 26, 26)
                .addComponent(jButton5)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton5))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(30, 76, 89)));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, periodistaMisionList, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${mision}"));
        columnBinding.setColumnName("Misión");
        columnBinding.setColumnClass(modelo.Mision.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${periodista}"));
        columnBinding.setColumnName("Periodista");
        columnBinding.setColumnClass(modelo.Periodista.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fecha}"));
        columnBinding.setColumnName("Fecha");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${observaciones}"));
        columnBinding.setColumnName("Observaciones");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${cantidadMeses}"));
        columnBinding.setColumnName("Cantidad de Meses");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        jLabel4.setText("Periodista:");

        jLabel9.setText("Misión:");

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, periodistaList, jComboBox3);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, misionList, jComboBox4);
        bindingGroup.addBinding(jComboBoxBinding);

        jButton4.setText("Buscar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(75, 75, 75)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, 227, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jButton4)
                .addContainerGap(68, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
             if(jTextField2.getText().isEmpty() ||jDateChooser1.getDate()==null
                     || jTextField3.getText().isEmpty() ){
              JOptionPane.showMessageDialog(null, "No debe dejar campos vacíos.");

                  }
             
 else{
              PeriodistaMision pm=new PeriodistaMision();
              PeriodistaMisionControl pmc=new PeriodistaMisionControl();
               PeriodistaControl pc=new PeriodistaControl();
              MisionControl mc=new MisionControl();
                        Periodista per=null;
               per=pc.buscarPerNombre(String.valueOf(jComboBox2.getSelectedItem()));
                        int idper= per.getIdPeriodista();
           String    codigo=String.valueOf(jComboBox1.getSelectedItem());
               int idm=mc.buscarId(codigo);
                       if(pmc.existe(idper, idm,jDateChooser1.getDate())){
                      JOptionPane.showMessageDialog(null, "Esta misión ya fue asignado a este periodista.");
                jTextField3.setText("");
                 jTextField2.setText("");
                                }
                 else {
                            try {
                                pm.setCantidadMeses(Integer.valueOf(jTextField2.getText()));
                                pm.setMision(mc.buscarMision(codigo));
                                pm.setObservaciones(jTextField3.getText());
                                pm.setFecha(jDateChooser1.getDate());
                                pm.setPeriodista(pc.BuscarPeriod(idper));
                                pmc.adicionar(pm);
                         
                               periodistaMisionList.add(pm);


                                jTextField3.setText("");
                                jTextField2.setText("");
                            jDateChooser1.setDate(Calendar.getInstance().getTime());
                            } catch (PreexistingEntityException ex) {
                                Logger.getLogger(AsignarMision.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                Logger.getLogger(AsignarMision.class.getName()).log(Level.SEVERE, null, ex);
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
                     if(jTextField2.getText().isEmpty() ||jDateChooser1.getDate()==null
                     || jTextField3.getText().isEmpty())
               JOptionPane.showMessageDialog(null, "No debe dejar campos vacios.");
                   else
           {
                   PeriodistaMision pm=new PeriodistaMision();
              PeriodistaMisionControl pmc=new PeriodistaMisionControl();
               PeriodistaControl pc=new PeriodistaControl();
              MisionControl mc=new MisionControl();
                Periodista per=null;
               per=pc.buscarPerNombre(String.valueOf(jComboBox2.getSelectedItem()));
                        int idper= per.getIdPeriodista();
           String   codigo=String.valueOf(jComboBox1.getSelectedItem());
           PeriodistaMision seleccionado=periodistaMisionList.get(fila);
           Periodista p=pc.BuscarPeriod(idper);

      int     idselecc=seleccionado.getIdPerMision();
               int idm=mc.buscarId(codigo);
               Mision m= mc.buscarMision(codigo);
               boolean existe=false;
               for (int i = 0; i < pmc.listarPerMision().size(); i++) {
                  PeriodistaMision permis = pmc.listarPerMision().get(i);
                   if(permis.getMision().getIdMision()==idm
                   && permis.getPeriodista().getIdPeriodista()==idper &&
                   permis.getIdPerMision()!=idselecc && permis.getFecha().equals(jDateChooser1.getDate())){
                       existe=true;break;
                   }
               }

               if(existe){
                     JOptionPane.showMessageDialog(null, "ya existe esta asignación.");
               }
 else{
                            try {
                                pmc.actualizarMision(jDateChooser1.getDate(), p, m, idselecc, Integer.valueOf(jTextField2.getText()), jTextField3.getText());
                               PeriodistaMision pmm=pmc.buscarMisionId(idselecc);
                               periodistaMisionList.remove(pmm);
                               periodistaMisionList.add(pmm);
                                jTextField3.setText("");
                 jTextField2.setText("");
                 jDateChooser1.setDate(Calendar.getInstance().getTime());
                                /* periodistaMisionList.clear();
                                Query query = em.createQuery("SELECT p FROM PeriodistaMision p");
                                periodistaMisionList.addAll(query.getResultLi*/
                            } catch (PreexistingEntityException ex) {
                                Logger.getLogger(AsignarMision.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                Logger.getLogger(AsignarMision.class.getName()).log(Level.SEVERE, null, ex);
                            }
                 }


        }}}

    }//GEN-LAST:event_jButton2MousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
             jTable2.setAutoResizeMode(jTable2.AUTO_RESIZE_OFF);
TableColumn columna3 = jTable2.getColumn("Misión");
        columna3.setPreferredWidth(150);
         TableColumn columna4 = jTable2.getColumn("Periodista");
        columna4.setPreferredWidth(150);
TableColumn columna2 = jTable2.getColumn("Fecha");
        columna2.setPreferredWidth(150);
        TableColumn columna = jTable2.getColumn("Observaciones");
        columna.setPreferredWidth(150);
        TableColumn columna5 = jTable2.getColumn("Cantidad de Meses");
        columna5.setPreferredWidth(150);

        jTable2.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
             PeriodistaMisionControl g= new PeriodistaMisionControl();
                jTable2.setRowSelectionInterval(jTable2.rowAtPoint(e.getPoint()), jTable2.rowAtPoint(e.getPoint()));
               PeriodistaMision usu1 = periodistaMisionList.get(jTable2.rowAtPoint(e.getPoint()));
              // PeriodistaMision usu = em.find(PeriodistaMision.class, usu1.getIdPerMision());
               PeriodistaMision usu=g.buscarMisionId(usu1.getIdPerMision());
               jComboBox2.setSelectedItem(usu.getPeriodista().getNombrePeriodista());

                jComboBox1.setSelectedItem(usu.getMision());
                jDateChooser1.setDate(usu.getFecha());
               jTextField2.setText(String.valueOf(usu.getCantidadMeses()));
               jTextField3.setText(usu.getObservaciones());
                       }
        });
    }//GEN-LAST:event_formWindowOpened

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
                        PeriodistaMisionControl pmc = new PeriodistaMisionControl();
                        String nombre = String.valueOf(jTable2.getValueAt(fila, 0));
                        PeriodistaMision pm = periodistaMisionList.get(fila);
                        int idpermi = pm.getIdPerMision();
                        pmc.eliminar(idpermi);
                        periodistaMisionList.remove(pm);
                         jTextField3.setText("");
                 jTextField2.setText("");
                 jDateChooser1.setDate(Calendar.getInstance().getTime());
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(AsignarMision.class.getName()).log(Level.SEVERE, null, ex);
                    }


                    }
                  }
                  }
    }//GEN-LAST:event_jButton3MousePressed

    private void jTextField2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField2MousePressed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
       if (jTextField2.getText().length() >= 49) {
            char temp = 0;
            evt.setKeyChar(temp);
        }

        char caracter = evt.getKeyChar();
        if (!((caracter >= '0' && caracter <= '9') || caracter == 8) || jTextField2.getText().length() == 11) {
            char temp = 0;
            evt.setKeyChar(temp);
        }   
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        // TODO add your handling code here:
         PeriodistaMisionControl pc= new PeriodistaMisionControl()  ;
         String nombre=String.valueOf(jComboBox3.getSelectedItem());
          String nombrec=String.valueOf(jComboBox4.getSelectedItem());
                PeriodistaMision p= pc.buscarMisionNombre(nombre,nombrec);
                if(p==null)
       JOptionPane.showMessageDialog(null, "Al periodista"+" "+nombre+" "+"no se le ha sido asignado la misión:"+" "+nombrec);
        else
                {
                    int posi= periodistaMisionList.lastIndexOf(p);
          //  Integer pos = getion.BuscarMunicipios(municipiosList, jnombre1.getText());
          //  if (pos != -1) {
                jTable2.setRowSelectionInterval(posi, posi);
                PeriodistaMision usu1 = periodistaMisionList.get(jTable2.getSelectedRow());
                PeriodistaMision  usu = em.find(PeriodistaMision.class, usu1.getIdPerMision());

                jComboBox2.setSelectedItem(usu.getPeriodista());
               // jComboBox1.setSelectedItem(usu.getCargoPeriodistico().getNombreCargop());
                jComboBox1.setSelectedItem(usu.getMision());
                jTextField2.setText(String.valueOf(usu.getCantidadMeses()));
                jTextField3.setText(usu.getObservaciones());
                jDateChooser1.setDate(usu.getFecha());


        }
    }//GEN-LAST:event_jButton4MousePressed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
         if (jTextField3.getText().length() >=200) {
            char temp = 0;
            evt.setKeyChar(temp);
        }

    }//GEN-LAST:event_jTextField3KeyTyped

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
        // TODO add your handling code here:
           jTextField3.setText("");
                 jTextField2.setText("");
                 jDateChooser1.setDate(Calendar.getInstance().getTime());
                 jTable2.clearSelection();
    }//GEN-LAST:event_jButton5MousePressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AsignarMision dialog = new AsignarMision(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private java.util.List<modelo.Mision> misionList;
    private javax.persistence.Query misionQuery;
    private java.util.List<modelo.Periodista> periodistaList;
    private java.util.List<modelo.PeriodistaMision> periodistaMisionList;
    private javax.persistence.Query periodistaMisionQuery;
    private javax.persistence.Query periodistaQuery;
    private javax.persistence.EntityManager tesisUpecPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
