/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AsignarBaja.java
 *
 * Created on 02-abr-2012, 14:45:01
 */

package vista;

//import controlador.control.BajaControl;
import controlador.control.BajControl;
import controlador.control.Herramientas;
import controlador.control.PeriodistaControl;
import controlador.jpa.exceptions.NonexistentEntityException;
import controlador.jpa.exceptions.PreexistingEntityException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import modelo.Baja;
import modelo.Periodista;
import javax.persistence.EntityManager;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author asus
 */
public class AsignarBaja extends javax.swing.JDialog {
EntityManager em = Trabajoem.GetEntityManager();
    /** Creates new form AsignarBaja */
    public AsignarBaja(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         AutoCompleteDecorator.decorate(jComboBox2);
          AutoCompleteDecorator.decorate(jComboBox1);
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
        bajaQuery = java.beans.Beans.isDesignTime() ? null : tesisUpecPUEntityManager.createQuery("SELECT b FROM Baja b");
        bajaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(bajaQuery.getResultList());
        periodistaQuery = java.beans.Beans.isDesignTime() ? null : tesisUpecPUEntityManager.createQuery("SELECT p FROM Periodista p");
        periodistaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : periodistaQuery.getResultList();
        periodistaQuery1 = java.beans.Beans.isDesignTime() ? null : tesisUpecPUEntityManager.createQuery("SELECT p FROM Periodista p");
        periodistaList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : periodistaQuery1.getResultList();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignar Baja");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(30, 76, 89));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(30, 76, 89)));

        jPanel2.setBackground(new java.awt.Color(30, 76, 89));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/banergrande.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(30, 76, 89)));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asignarbaja.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");

        jLabel2.setText("Nombre del periodista:");

        jLabel6.setText("Fecha:");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, periodistaList, jComboBox2);
        bindingGroup.addBinding(jComboBoxBinding);

        jLabel4.setText("Causa: ");

        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField1MousePressed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel5.setText("Observaciones:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 448, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(jTextField1)
                                    .addComponent(jComboBox2, 0, 303, Short.MAX_VALUE))))))
                .addGap(62, 62, 62))
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
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(30, 76, 89)));

        jButton1.setText("Insertar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jButton4.setText("Modificar");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
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
                .addGap(137, 137, 137)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(30, 76, 89)));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, bajaList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${periodista}"));
        columnBinding.setColumnName("Periodista");
        columnBinding.setColumnClass(modelo.Periodista.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fecha}"));
        columnBinding.setColumnName("Fecha");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${observacionPeriod}"));
        columnBinding.setColumnName("Observaciones");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${causaBaja}"));
        columnBinding.setColumnName("Causa de la Baja");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable1);

        jLabel7.setText("Nombre del Periodista:");

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, periodistaList1, jComboBox1);
        bindingGroup.addBinding(jComboBoxBinding);

        jButton2.setText("Buscar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, 0, 271, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(17, 17, 17))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 522, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if (jComboBox2.getSelectedIndex()==-1){
 
            JOptionPane.showMessageDialog(null, "Debe seleccionar al periodista.");


        } else{
            if (jTable1.getSelectedRow()!= -1){
                jTable1.clearSelection();
                JOptionPane.showMessageDialog(null, "Para asignar no debe tener otra asignació seleccionada.");
            } else{
                if(jDateChooser1.getDate()==null || jTextField1.getText().isEmpty() || jTextArea1.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "No debe dejar campos vacíos.");

                } else{

                   Baja b=new Baja();
                    PeriodistaControl pc=new PeriodistaControl();
                     BajControl bc= new BajControl();
                    Periodista per=null;
                    per=pc.buscarPerNombre(String.valueOf(jComboBox2.getSelectedItem()));
                    int idper= per.getIdPeriodista();

                 /*   if(bc.existe(idper)){
                        JOptionPane.showMessageDialog(null, "A este periodista ya se le dio baja.");


                    } else {*/
                    boolean exis=false;
                    for (int i = 0; i < bajaList.size(); i++) {
                        Baja baja = bajaList.get(i);
                        if(baja.getPeriodista().getNombrePeriodista().equalsIgnoreCase(String.valueOf(jComboBox2.getSelectedItem()))){
                            exis=true;
                             JOptionPane.showMessageDialog(null, "A este periodista ya se le dio baja.");
break;
                        }
                    }
                    if(exis==false){
                        try {
                            b.setCausaBaja(jTextField1.getText());
                            b.setFecha(jDateChooser1.getDate());
                            b.setObservacionPeriod(jTextArea1.getText());
                            b.setPeriodista(pc.BuscarPeriod(idper));
                            bc.adicionar(b);
                            bajaList.add(b);
                            jTextArea1.setText("");
                            jTextField1.setText("");
                               jDateChooser1.setDate(Calendar.getInstance().getTime());
                        } catch (PreexistingEntityException ex) {
                            Logger.getLogger(AsignarBaja.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(AsignarBaja.class.getName()).log(Level.SEVERE, null, ex);
                        }

              
                 //   }
                }
 else{
                        jTextArea1.setText("");
                        jTextField1.setText("");
                          jDateChooser1.setDate(Calendar.getInstance().getTime());
 }
                }
            }}
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow()== -1){
            JOptionPane.showMessageDialog(null, "Para eliminar debe seleccionar la asignación.");
        } else{
            Integer fila = jTable1.getSelectedRow();
            if(jTable1.getValueAt(fila, 0)==null || jTable1.getSelectedRowCount()>1)
                JOptionPane.showMessageDialog(null, "Debe seleccionar una asignación.");
            else{
                if (JOptionPane.showConfirmDialog(null, "Realmente desea eliminar?") == JOptionPane.YES_OPTION) {
                    try {
                        BajControl bc = new BajControl();
                        Baja b = bajaList.get(fila);
                        int idbaja = b.getIdBaja();
                        bc.eliminar(idbaja);
                        bajaList.remove(b);
                         jTextArea1.setText("");
                            jTextField1.setText("");
                               jDateChooser1.setDate(Calendar.getInstance().getTime());
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(AsignarBaja.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 
                   

                }
            }
        }
}//GEN-LAST:event_jButton3MousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_OFF);
TableColumn columna3 = jTable1.getColumn("Periodista");
        columna3.setPreferredWidth(150);
         TableColumn columna4 = jTable1.getColumn("Fecha");
        columna4.setPreferredWidth(150);
TableColumn columna2 = jTable1.getColumn("Observaciones");
        columna2.setPreferredWidth(150);
        TableColumn columna = jTable1.getColumn("Causa de la Baja");
        columna.setPreferredWidth(150);

        jTable1.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
                jTable1.setRowSelectionInterval(jTable1.rowAtPoint(e.getPoint()), jTable1.rowAtPoint(e.getPoint()));
              Baja usu1 = bajaList.get(jTable1.rowAtPoint(e.getPoint()));
               Baja usu = em.find(Baja.class, usu1.getIdBaja());
                jComboBox2.setSelectedItem(usu.getPeriodista().getNombrePeriodista());

                jTextArea1.setText(usu.getObservacionPeriod());
                jTextField1.setText(usu.getCausaBaja());
                jDateChooser1.setDate(usu.getFecha());

            }
        });
    }//GEN-LAST:event_formWindowOpened

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        // TODO add your handling code here:
             if (jTable1.getSelectedRow()== -1){
            JOptionPane.showMessageDialog(null, "Para modidficar debe seleccionar la asignación.");
        } else{
            Integer fila = jTable1.getSelectedRow();
            if(jTable1.getValueAt(fila, 1)==null || jTable1.getSelectedRowCount()>1)
                JOptionPane.showMessageDialog(null, "Debe seleccionar una asignación.");
            else{
                if(jDateChooser1.getDate()==null)
                    JOptionPane.showMessageDialog(null, "No debe dejar campos vacios.");
                else {
                    Baja b=new Baja();
                    PeriodistaControl pc=new PeriodistaControl();
                    BajControl bc=new BajControl();

                    Periodista per=null;
                    per=pc.buscarPerNombre(String.valueOf(jComboBox2.getSelectedItem()));
                    int idper= per.getIdPeriodista();

                    Baja seleccionado=bajaList.get(fila);
                    Periodista p=pc.BuscarPeriod(idper);

                    int     idselecc=seleccionado.getIdBaja();

                         /*   bc.actualizar(jTextField1.getText(),jTextArea1.getText(),jDateChooser1.getDate(), p, idselecc);
                            bajaList.clear();
                            Query query = em.createQuery("SELECT b FROM Baja b");
                            bajaList.addAll(query.getResultList());*/

                    // }


                        b.setCausaBaja(jTextField1.getText());
                        b.setFecha(jDateChooser1.getDate());
                        b.setObservacionPeriod(jTextArea1.getText());
                        b.setPeriodista(pc.BuscarPeriod(idper));
                    try {
                        bc.eliminar(idselecc);
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(AsignarBaja.class.getName()).log(Level.SEVERE, null, ex);
                    }

                        bajaList.remove(seleccionado);
                    try {
                        bc.adicionar(b);
                        bajaList.add(b);
                         jTextArea1.setText("");
                            jTextField1.setText("");
                               jDateChooser1.setDate(Calendar.getInstance().getTime());
                    } catch (PreexistingEntityException ex) {
                        Logger.getLogger(AsignarBaja.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(AsignarBaja.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }}}
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
        //  if (jnombre1.getText().isEmpty() == true) {
          //  JOptionPane.showMessageDialog(null, "Debe introducir el nombre para buscar el municipio.");


      //  } else {
        BajControl bc= new BajControl()   ;
                Baja b= bc.buscar(String.valueOf(jComboBox1.getSelectedItem()));
                if(b==null)
       JOptionPane.showMessageDialog(null, "Este periodista no constituye baja de la UPEC");
        else
                {
                    int posi= bajaList.lastIndexOf(b);
          //  Integer pos = getion.BuscarMunicipios(municipiosList, jnombre1.getText());
          //  if (pos != -1) {
                jTable1.setRowSelectionInterval(posi, posi);
                Baja usu1 = bajaList.get(jTable1.getSelectedRow());
                Baja usu = em.find(Baja.class, usu1.getIdBaja());

                jComboBox2.setSelectedItem(usu.getPeriodista().getNombrePeriodista());
                jTextField1.setText(usu.getCausaBaja());
                jTextArea1.setText(usu.getObservacionPeriod());
                jDateChooser1.setDate(usu.getFecha());


            
        }

       // }
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
        // TODO add your handling code here:
         jTextArea1.setText("");
                            jTextField1.setText("");
                               jDateChooser1.setDate(Calendar.getInstance().getTime());
                                jTable1.clearSelection();
    }//GEN-LAST:event_jButton5MousePressed

    private void jTextField1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextField1MousePressed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        // TODO add your handling code here:
         if (jTextField1.getText().length() >= 200) {
            char temp = 0;
            evt.setKeyChar(temp);
            }
              char caracter = evt.getKeyChar();
        if (!((caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z') || caracter == 8 || caracter == ' ' || Herramientas.vocalTilde(caracter))) {//
            char temp = 0;
            evt.setKeyChar(temp);
        }
        
    }//GEN-LAST:event_jTextField1KeyTyped

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AsignarBaja dialog = new AsignarBaja(new javax.swing.JFrame(), true);
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
    private java.util.List<modelo.Baja> bajaList;
    private javax.persistence.Query bajaQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private java.util.List<modelo.Periodista> periodistaList;
    private java.util.List<modelo.Periodista> periodistaList1;
    private javax.persistence.Query periodistaQuery;
    private javax.persistence.Query periodistaQuery1;
    private javax.persistence.EntityManager tesisUpecPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
