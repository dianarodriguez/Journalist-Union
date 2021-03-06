/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GestionarComputadora.java
 *
 * Created on 29-jun-2012, 20:26:53
 */

package vista;

import controlador.control.ComputadoraControl;
import controlador.control.DelegacionControl;
import controlador.control.PeriodistaCompControl;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import modelo.Computadoras;
import modelo.Delegacion;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author asus
 */
public class GestionarComputadora extends javax.swing.JDialog {
EntityManager em = Trabajoem.GetEntityManager();
    /** Creates new form GestionarComputadora */
    public GestionarComputadora(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
           AutoCompleteDecorator.decorate(jComboBox3);
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
        delegacionQuery = java.beans.Beans.isDesignTime() ? null : tesisUpecPUEntityManager.createQuery("SELECT d FROM Delegacion d");
        delegacionList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(delegacionQuery.getResultList());
        computadorasQuery = java.beans.Beans.isDesignTime() ? null : tesisUpecPUEntityManager.createQuery("SELECT c FROM Computadoras c");
        computadorasList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(computadorasQuery.getResultList());
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Computadoras");
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
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(30, 76, 89)));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gestionarcomput.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel2.setText("Tipo de PC:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Portátil", "De Mesa" }));

        jLabel4.setText("Año de fabricación:");

        jYearChooser1.setEndYear(2012);
        jYearChooser1.setStartYear(1950);

        jLabel5.setText("Marca:");

        jTextField1.setText("(GB)");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel6.setText("Capacidad:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jLabel7.setText("Delegación:");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, delegacionList, jComboBox2);
        bindingGroup.addBinding(jComboBoxBinding);

        jLabel8.setText("Código:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, 111, Short.MAX_VALUE))))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(41, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(33, 33, 33)
                .addComponent(jButton5)
                .addContainerGap(94, Short.MAX_VALUE))
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

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, computadorasList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoPc}"));
        columnBinding.setColumnName("Código de la PC");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${delegacion}"));
        columnBinding.setColumnName("Delegación");
        columnBinding.setColumnClass(modelo.Delegacion.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${capacidad}"));
        columnBinding.setColumnName("Capacidad");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${yearFabricacion}"));
        columnBinding.setColumnName("Año de fabricación");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${marcaPc}"));
        columnBinding.setColumnName("Marca de la PC");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipoPc}"));
        columnBinding.setColumnName("Tipo de PC");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane1.setViewportView(jTable1);

        jLabel9.setText("Código de la PC:");

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, computadorasList, jComboBox3);
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
                .addGap(23, 23, 23)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(97, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
             jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
TableColumn columna3 = jTable1.getColumn("Código de la PC");
        columna3.setPreferredWidth(250);
         TableColumn columna4 = jTable1.getColumn("Delegación");
        columna4.setPreferredWidth(250);
   TableColumn columna1 = jTable1.getColumn("Capacidad");
        columna1.setPreferredWidth(250);
   TableColumn columna2 = jTable1.getColumn("Año de fabricación");
        columna2.setPreferredWidth(250);
           TableColumn columna = jTable1.getColumn("Marca de la PC");
        columna.setPreferredWidth(250);
    TableColumn columna5 = jTable1.getColumn("Tipo de PC");
        columna5.setPreferredWidth(250);

        jTable1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                ComputadoraControl g= new ComputadoraControl();
                  jTable1.setRowSelectionInterval(jTable1.rowAtPoint(e.getPoint()), jTable1.rowAtPoint(e.getPoint()));
                Computadoras usu1 = computadorasList.get(jTable1.rowAtPoint(e.getPoint()));
             //   Computadoras usu = em.find(Computadoras.class, usu1.getIdPc());
                Computadoras usu= g.buscarCompId(usu1.getIdPc());
                jTextField1.setText(usu.getCapacidad());
                jTextField2.setText(usu.getMarcaPc());
                jTextField3.setText(usu.getCodigoPc());
                jComboBox1.setSelectedItem(usu.getTipoPc());
                jComboBox2.setSelectedItem(usu.getDelegacion());
              //   jSpinner1.setValue(Integer.valueOf(usu.getYearFabricacion()));
               jYearChooser1.setYear(Integer.valueOf(usu.getYearFabricacion()));
            }
        });
    }//GEN-LAST:event_formWindowOpened

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
          if (jTable1.getSelectedRow()!= -1){
             jTable1.clearSelection();
             JOptionPane.showMessageDialog(null, "Para insertar no debe tener ninguna computadora seleccionado.");
        jTextField1.setText("");
         jTextField3.setText("");
 jTextField2.setText("");

         }
        else{
             if(jTextField1.getText().isEmpty() ||jTextField2.getText().isEmpty()||jTextField3.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "No debe dejar campos vacíos.");
             }
 else{
              ComputadoraControl cc=new ComputadoraControl();
                 if(cc.existe(jTextField3.getText())){
                      JOptionPane.showMessageDialog(null, "ya existe.");
                 jTextField1.setText("");
                   jTextField2.setText("");
                      jTextField3.setText("");
                 }
                 else {
                    try {
                        String codigo = jTextField3.getText();
                        String nombred = String.valueOf(jComboBox2.getSelectedItem());
                        String tipo = String.valueOf(jComboBox1.getSelectedItem());
                        Computadoras c = new Computadoras();
                        Delegacion d = new Delegacion();
                        DelegacionControl dc = new DelegacionControl();
                        d = dc.buscaDeleg(nombred);
                        c.setCapacidad(jTextField1.getText());
                        c.setCodigoPc(codigo);
                        c.setDelegacion(d);
                        c.setMarcaPc(jTextField2.getText());
                        c.setTipoPc(tipo);
                        //c.setYearFabricacion(String.valueOf(jSpinner1.getValue()));
                        c.setYearFabricacion(String.valueOf(jYearChooser1.getYear()));
                        cc.adicionar(c);
                        computadorasList.add(c);
                        jTextField1.setText("");
                        jTextField3.setText("");
                        jTextField2.setText("");
                    } catch (PreexistingEntityException ex) {
                        Logger.getLogger(GestionarComputadora.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(GestionarComputadora.class.getName()).log(Level.SEVERE, null, ex);
                    }







                 }
 }
        }
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
         if (jTable1.getSelectedRow()== -1){
                 JOptionPane.showMessageDialog(null, "Para modidficar debe seleccionar la computadora.");
               }
 else{
                     Integer fila = jTable1.getSelectedRow();
                     if(jTable1.getValueAt(fila, 1)==null || jTable1.getSelectedRowCount()>1)
                  JOptionPane.showMessageDialog(null, "Debe seleccionar una Computadora.");
                     else{
                     if(jTextField1.getText().isEmpty() ||jTextField2.getText().isEmpty()||jTextField3.getText().isEmpty())
               JOptionPane.showMessageDialog(null, "No debe dejar campos vacios.");
                   else
           {
                ComputadoraControl cc=new ComputadoraControl();
                         DelegacionControl dc=new DelegacionControl();
                   if(cc.existe(jTextField3.getText())&& jTextField3.getText().equalsIgnoreCase(String.valueOf(jTable1.getValueAt(fila, 0)))==false){
                    JOptionPane.showMessageDialog(null, "Ya existe una computadora con ese código.");
                   }
 else{
                        try {
                            String nombred = String.valueOf(jComboBox2.getSelectedItem());
                            String tipo = String.valueOf(jComboBox1.getSelectedItem());
                            Delegacion d = new Delegacion();
                            d = dc.buscaDeleg(nombred);
                            int id = cc.buscarIdComp(String.valueOf(jTable1.getValueAt(fila, 0)));
                          
                           
                            cc.actualizarComp(jTextField3.getText(), tipo, id, jTextField2.getText(), String.valueOf(jYearChooser1.getYear()), jTextField1.getText(), d);
                          Computadoras comp=cc.buscarCompId(id);
                         
                       
                            computadorasList.remove(comp);
                            computadorasList.add(comp);
                             
                         
                            jTextField1.setText("");

                            jTextField3.setText("");
                            jTextField2.setText("");
                        } catch (PreexistingEntityException ex) {
                            Logger.getLogger(GestionarComputadora.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(GestionarComputadora.class.getName()).log(Level.SEVERE, null, ex);
                        }






 }
                         }
             }
        }
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        // TODO add your handling code here:
          if (jTable1.getSelectedRow()== -1){
                 JOptionPane.showMessageDialog(null, "Para eliminar debe seleccionar la computadora.");
               }
 else{
              Integer fila = jTable1.getSelectedRow();
              if(jTable1.getValueAt(fila, 0)==null || jTable1.getSelectedRowCount()>1)
                  JOptionPane.showMessageDialog(null, "Debe seleccionar una computadora.");
              else{
              if (JOptionPane.showConfirmDialog(null, "Realmente desea eliminar?") == JOptionPane.YES_OPTION) {

                   // Integer fila = jTable1.getSelectedRow();
               ComputadoraControl cc=new ComputadoraControl();
                    String codigo = String.valueOf(jTable1.getValueAt(fila, 0));

                    int id= cc.buscarIdComp(codigo);
           PeriodistaCompControl pcc=new PeriodistaCompControl();
           Computadoras c= new Computadoras();
           c= cc.buscarComp(codigo);
                    if (pcc.compAsignado(id)) {

                        JOptionPane.showMessageDialog(null, "No se puede eliminar mientras esté asignada a un periodista.");
                    } else {
                        try {
                            cc.eliminar(id);
                            computadorasList.remove(c);
                            jTextField1.setText("");
                            jTextField3.setText("");
                            jTextField2.setText("");
                        } catch (NonexistentEntityException ex) {
                            Logger.getLogger(GestionarComputadora.class.getName()).log(Level.SEVERE, null, ex);
                        }







                    }
                  }
                  }

        }
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        // TODO add your handling code here:
          ComputadoraControl pc= new   ComputadoraControl();

          String nombrec=String.valueOf(jComboBox3.getSelectedItem());
               Computadoras p= pc.buscarComp(nombrec);
                if(p==null)
       JOptionPane.showMessageDialog(null, "La computadora no existe");
        else
                {
                    int posi= computadorasList.lastIndexOf(p);
          //  Integer pos = getion.BuscarMunicipios(municipiosList, jnombre1.getText());
          //  if (pos != -1) {
                jTable1.setRowSelectionInterval(posi, posi);
                Computadoras usu1 = computadorasList.get(jTable1.getSelectedRow());
                Computadoras usu = em.find(Computadoras.class, usu1.getIdPc());
                   jComboBox1.setSelectedItem(usu.getTipoPc());
                   jComboBox2.setSelectedItem(usu.getDelegacion());
                   jTextField3.setText(usu.getCodigoPc());

               jTextField1.setText(usu.getCapacidad());

                 jTextField2.setText(usu.getMarcaPc());
                 jYearChooser1.setYear(Integer.valueOf(usu.getYearFabricacion()));
                 


        }
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
        // TODO add your handling code here:
          jTextField1.setText("");
                        jTextField3.setText("");
                        jTextField2.setText("");
                        jTable1.clearSelection();
    }//GEN-LAST:event_jButton5MousePressed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        // TODO add your handling code here:
         if (jTextField3.getText().length() >= 12) {
            char temp = 0;
            evt.setKeyChar(temp);
        }
        char caracter = evt.getKeyChar();
        if (!((caracter >= '0' && caracter <= '9') || (caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z'))) {
            char temp = 0;
            evt.setKeyChar(temp);
        }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
         if (jTextField3.getText().length() >=10) {
            char temp = 0;
            evt.setKeyChar(temp);
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
         if (jTextField3.getText().length() >= 30) {
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
                GestionarComputadora dialog = new GestionarComputadora(new javax.swing.JFrame(), true);
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
    private java.util.List<modelo.Computadoras> computadorasList;
    private javax.persistence.Query computadorasQuery;
    private java.util.List<modelo.Delegacion> delegacionList;
    private javax.persistence.Query delegacionQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.persistence.EntityManager tesisUpecPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
