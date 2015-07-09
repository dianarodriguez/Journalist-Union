/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GestionarCargoP.java
 *
 * Created on 29-jun-2012, 17:36:47
 */

package vista;

import controlador.control.CargoPerControl;
import controlador.control.PeriodistaCargoControl;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import modelo.CargoPeriodistico;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author asus
 */
public class GestionarCargoP extends javax.swing.JDialog {
  private int posfila;
   EntityManager em = Trabajoem.GetEntityManager();
    /** Creates new form GestionarCargoP */
    public GestionarCargoP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         AutoCompleteDecorator.decorate(jComboBox1);
    
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
        cargoPeriodisticoQuery1 = java.beans.Beans.isDesignTime() ? null : tesisUpecPUEntityManager.createQuery("SELECT c FROM CargoPeriodistico c");
        cargoPeriodisticoList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(cargoPeriodisticoQuery1.getResultList());
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestionar Cargo Periodístico");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(30, 76, 89));

        jPanel2.setBackground(new java.awt.Color(30, 76, 89));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/banergrande.jpg"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(30, 76, 89)));

        jLabel2.setText("Nombre del Cargo Periodístico:");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gestionarcargoper.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel4.setText("Descripción:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextArea1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
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
                .addGap(154, 154, 154)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(31, 31, 31)
                .addComponent(jButton5)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton5))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(30, 76, 89)));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cargoPeriodisticoList1, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombreCargop}"));
        columnBinding.setColumnName("Nombre del Cargo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcionCargop}"));
        columnBinding.setColumnName("Descripción del  Cargo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable1);

        jLabel5.setText("Cargo periodístico:");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cargoPeriodisticoList1, jComboBox1);
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
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addGap(37, 37, 37)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(49, 49, 49))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
          if (jTable1.getSelectedRow()!= -1){
             jTable1.clearSelection();
             JOptionPane.showMessageDialog(null, "Para insertar no debe tener ningún cargo periodístico seleccionado.");
        jTextField1.setText("");
        jTextArea1.setText("");
         }
        else{
             if(jTextField1.getText().isEmpty() ||jTextArea1.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "No debe dejar campos vacíos.");
             }
 else{
                CargoPerControl cpc=new CargoPerControl();
                 if(cpc.existe(jTextField1.getText())){
                      JOptionPane.showMessageDialog(null, "Este cargo periodístico ya existe.");
                 jTextField1.setText("");
                 jTextArea1.setText("");
                 }
                 else {

                        String nombre = jTextField1.getText();
                        String descripcion = jTextArea1.getText();
                        CargoPeriodistico cp = new CargoPeriodistico();
                        cp.setDescripcionCargop(descripcion);
                        cp.setNombreCargop(nombre);
                    try {
                        cpc.adicionar(cp);
                         cargoPeriodisticoList1.add(cp);
                       jTextField1.setText("");
                 jTextArea1.setText("");
                    } catch (PreexistingEntityException ex) {
                        Logger.getLogger(GestionarCargoP.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(GestionarCargoP.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       
                       // cargoPeriodisticoList.add(cp);
                    //   cp=cpc.insert(cp, cargoPeriodisticoList);
                 /*  if(cargoPeriodisticoList.add(cp)){

                   }*/


                 }
 }
        }
    }//GEN-LAST:event_jButton1MousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
 TableColumn columna3 = jTable1.getColumn("Nombre del Cargo");
        columna3.setPreferredWidth(250);
         TableColumn columna4 = jTable1.getColumn("Descripción del  Cargo");
        columna4.setPreferredWidth(300);

 

        jTable1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
               CargoPerControl g= new CargoPerControl();
                jTable1.setRowSelectionInterval(jTable1.rowAtPoint(e.getPoint()), jTable1.rowAtPoint(e.getPoint()));
                CargoPeriodistico usu1 = cargoPeriodisticoList1.get(jTable1.rowAtPoint(e.getPoint()));
             //   CargoPeriodistico usu = em.find(CargoPeriodistico.class, usu1.getIdCargop());
               CargoPeriodistico usu=g.buscarCargoP(usu1.getIdCargop());
                jTextField1.setText(usu.getNombreCargop());
                jTextArea1.setText(usu.getDescripcionCargop());


            }
        });
    }//GEN-LAST:event_formWindowOpened

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
            if (jTable1.getSelectedRow()== -1){
                 JOptionPane.showMessageDialog(null, "Para modidficar debe seleccionar el cargo periodístico.");
               }
 else{
                     Integer fila = jTable1.getSelectedRow();
                     if(jTable1.getValueAt(fila, 0)==null || jTable1.getSelectedRowCount()>1)
                  JOptionPane.showMessageDialog(null, "Debe seleccionar un cargo periodístico.");
                     else{
                     if(jTextField1.getText().isEmpty() ||jTextArea1.getText().isEmpty())
               JOptionPane.showMessageDialog(null, "No debe dejar campos vacios.");
                   else
           {
               CargoPerControl cpc=new CargoPerControl();

                   if(cpc.existe(jTextField1.getText())&& jTextField1.getText().equalsIgnoreCase(String.valueOf(jTable1.getValueAt(fila, 0)))==false){
                    JOptionPane.showMessageDialog(null, "Ya existe el cargo periodístico.");
                   }
 else{
                        try {
                            int id = cpc.buscarIdCargop(String.valueOf(jTable1.getValueAt(fila, 0)));
                            cpc.actualizarCargoP(jTextField1.getText(), jTextArea1.getText(), id);
                            jTextField1.setText("");
                            jTextArea1.setText("");
                            CargoPeriodistico cargoper=cpc.buscarCargoP(id);
                           
                           cargoPeriodisticoList1.remove(cargoper);
                           cargoPeriodisticoList1.add(cargoper);

                         /*   cargoPeriodisticoList1.clear();
            Query query = em.createQuery("SELECT c FROM CargoPeriodistico c");
            cargoPeriodisticoList1.addAll(query.getResultList());*/
                            
                        } catch (PreexistingEntityException ex) {
                            Logger.getLogger(GestionarCargoP.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(GestionarCargoP.class.getName()).log(Level.SEVERE, null, ex);
                        }

 }
                         }
             }
        }
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        // TODO add your handling code here:
          if (jTable1.getSelectedRow()== -1){
                 JOptionPane.showMessageDialog(null, "Para eliminar debe seleccionar el cargo periodístico.");
               }
 else{
              Integer fila = jTable1.getSelectedRow();
              if(jTable1.getValueAt(fila, 0)==null || jTable1.getSelectedRowCount()>1)
                  JOptionPane.showMessageDialog(null, "Debe seleccionar un Cargo periodistico .");
              else{
              if (JOptionPane.showConfirmDialog(null, "Realmente desea eliminar?") == JOptionPane.YES_OPTION) {

                   // Integer fila = jTable1.getSelectedRow();
                 CargoPerControl cpc= new CargoPerControl();
                    String nombre = String.valueOf(jTable1.getValueAt(fila, 0));

                    int id= cpc.buscarIdCargop(nombre);
                 PeriodistaCargoControl pcc= new  PeriodistaCargoControl();
                 CargoPeriodistico cp =new CargoPeriodistico();
                 cp=cpc.buscarCargoP(id);
                    if (pcc.cargoasigando(id)) {

                        JOptionPane.showMessageDialog(null, "No se podrá eliminar mientras esté asiganado a un periodista.");
                    } else {
                        try {
                            cpc.eliminar(id);
                            cargoPeriodisticoList1.remove(cp);
                            jTextField1.setText("");
                            jTextArea1.setText("");
                        } catch (NonexistentEntityException ex) {
                            Logger.getLogger(GestionarCargoP.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                  }
                  }

        }
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        // TODO add your handling code here:
         CargoPerControl pc= new CargoPerControl()   ;
       
          String nombrec=String.valueOf(jComboBox1.getSelectedItem());
               CargoPeriodistico p= pc.buscarCargop(nombrec);
                if(p==null)
       JOptionPane.showMessageDialog(null, "El cargo periodístico no existe");
        else
                {
                    int posi= cargoPeriodisticoList1.lastIndexOf(p);
          //  Integer pos = getion.BuscarMunicipios(municipiosList, jnombre1.getText());
          //  if (pos != -1) {
                jTable1.setRowSelectionInterval(posi, posi);
                CargoPeriodistico usu1 = cargoPeriodisticoList1.get(jTable1.getSelectedRow());
                CargoPeriodistico usu = em.find(CargoPeriodistico.class, usu1.getIdCargop());

               jTextField1.setText(p.getNombreCargop());
                 jTextArea1.setText(p.getDescripcionCargop());
              


        }
    }//GEN-LAST:event_jButton4MousePressed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
         if (jTextField1.getText().length() >= 80) {
            char temp = 0;
            evt.setKeyChar(temp);
        }
        char caracter = evt.getKeyChar();
        if (!( (caracter >= 'A' && caracter <= 'Z') ||  caracter == 8 || caracter ==':'|| caracter =='"'||(caracter >= 'a' && caracter <= 'z'))) {
            char temp = 0;
            evt.setKeyChar(temp);
        }     // T
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextArea1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyTyped
        // TODO add your handling code here:
          if (jTextArea1.getText().length() >= 300) {
            char temp = 0;
            evt.setKeyChar(temp);
        }
    }//GEN-LAST:event_jTextArea1KeyTyped

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
        // TODO add your handling code here:
           jTextField1.setText("");
                 jTextArea1.setText("");
                 jTable1.clearSelection();
    }//GEN-LAST:event_jButton5MousePressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GestionarCargoP dialog = new GestionarCargoP(new javax.swing.JFrame(), true);
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
    private java.util.List<modelo.CargoPeriodistico> cargoPeriodisticoList1;
    private javax.persistence.Query cargoPeriodisticoQuery1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.persistence.EntityManager tesisUpecPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
