/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AsignarIdioma.java
 *
 * Created on 05-jul-2012, 7:56:11
 */

package vista;

import controlador.control.IdiomaControl;
import controlador.control.PeriodistaControl;
import controlador.control.PeriodistaIdiomaControl;
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
import modelo.Idioma;
import modelo.Periodista;
import modelo.PeriodistaIdioma;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author asus
 */
public class AsignarIdioma extends javax.swing.JDialog {
private int posfila=0;
EntityManager em = Trabajoem.GetEntityManager();
    /** Creates new form AsignarIdioma */
    public AsignarIdioma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
           AutoCompleteDecorator.decorate(jComboBox6);
             AutoCompleteDecorator.decorate(jComboBox1);
               AutoCompleteDecorator.decorate(jComboBox7);
                 AutoCompleteDecorator.decorate(jComboBox8);
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
        idiomaQuery = java.beans.Beans.isDesignTime() ? null : tesisUpecPUEntityManager.createQuery("SELECT i FROM Idioma i");
        idiomaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(idiomaQuery.getResultList());
        periodistaIdiomaQuery = java.beans.Beans.isDesignTime() ? null : tesisUpecPUEntityManager.createQuery("SELECT p FROM PeriodistaIdioma p");
        periodistaIdiomaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(periodistaIdiomaQuery.getResultList());
        periodistaQuery = java.beans.Beans.isDesignTime() ? null : tesisUpecPUEntityManager.createQuery("SELECT p FROM Periodista p");
        periodistaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : periodistaQuery.getResultList();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox();
        jComboBox8 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asigidiom.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setPreferredSize(new java.awt.Dimension(495, 50));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Asignar Idioma");
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
        jPanel4.setPreferredSize(new java.awt.Dimension(503, 324));

        jLabel2.setText("Nombre del periodista:");

        jLabel5.setText("Idioma:");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, idiomaList, jComboBox1);
        bindingGroup.addBinding(jComboBoxBinding);

        jLabel6.setText("Nivel de Idioma:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nivel I", "NivelI", "NivelII", "NivelIV" }));

        jLabel7.setText("Expresión:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Muy Bien", "Bien", "Regular" }));

        jLabel8.setText("Lectura:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Muy Bien", "Bien", "Regular" }));

        jLabel9.setText("Escritura:");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Muy Bien", "Bien", "Regular" }));
        jComboBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox5MousePressed(evt);
            }
        });

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, periodistaList, jComboBox6);
        bindingGroup.addBinding(jComboBoxBinding);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/asigidiom.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setPreferredSize(new java.awt.Dimension(455, 50));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jComboBox1, 0, 143, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox6, 0, 343, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(30, 76, 89)));
        jPanel5.setPreferredSize(new java.awt.Dimension(500, 51));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(38, 38, 38)
                .addComponent(jButton5)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton5)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(30, 76, 89)));
        jPanel3.setPreferredSize(new java.awt.Dimension(600, 438));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, periodistaIdiomaList, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idioma}"));
        columnBinding.setColumnName("Idioma");
        columnBinding.setColumnClass(modelo.Idioma.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${periodista}"));
        columnBinding.setColumnName("Periodista");
        columnBinding.setColumnClass(modelo.Periodista.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nivel}"));
        columnBinding.setColumnName("Nivel");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${escribe}"));
        columnBinding.setColumnName("Escribe");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${lee}"));
        columnBinding.setColumnName("Lee");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${habla}"));
        columnBinding.setColumnName("Habla");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);

        jLabel10.setText("Periodista:");

        jLabel11.setText("Idioma:");

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, periodistaList, jComboBox7);
        bindingGroup.addBinding(jComboBoxBinding);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, idiomaList, jComboBox8);
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
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.LEADING, 0, 246, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jButton4)
                .addContainerGap(86, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
          jTable2.setAutoResizeMode(jTable2.AUTO_RESIZE_OFF);
TableColumn columna3 = jTable2.getColumn("Idioma");
        columna3.setPreferredWidth(150);
         TableColumn columna4 = jTable2.getColumn("Periodista");
        columna4.setPreferredWidth(150);
TableColumn columna2 = jTable2.getColumn("Nivel");
        columna2.setPreferredWidth(150);

        jTable2.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {
             PeriodistaIdiomaControl g= new PeriodistaIdiomaControl();
                jTable2.setRowSelectionInterval(jTable2.rowAtPoint(e.getPoint()), jTable2.rowAtPoint(e.getPoint()));
               PeriodistaIdioma usu1 = periodistaIdiomaList.get(jTable2.rowAtPoint(e.getPoint()));
           //    PeriodistaIdioma usu = em.find(PeriodistaIdioma.class, usu1.getIdPerIdioma());
                PeriodistaIdioma usu=g.buscarIdiomaId(usu1.getIdPerIdioma());
                jComboBox1.setSelectedItem(usu.getIdioma());
               jComboBox6.setSelectedItem(usu.getPeriodista());
               jComboBox2.setSelectedItem(usu.getNivel());
               jComboBox3.setSelectedItem(usu.getHabla());
               jComboBox4.setSelectedItem(usu.getLee());
               jComboBox5.setSelectedItem(usu.getEscribe());
             // posfila++;
            }
        });
    }//GEN-LAST:event_formWindowOpened

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
             if (jComboBox6.getSelectedItem()==null){
           //  jTable1.clearSelection();
             JOptionPane.showMessageDialog(null, "Debe seleccionar al periodista.");


         }
        else{
              if (jTable2.getSelectedRow()!= -1){
             jTable2.clearSelection();
             JOptionPane.showMessageDialog(null, "Para asignar no debe tener otra asignació seleccionada.");
             }
 else{
          
              
                 
 
            PeriodistaIdioma pi=new PeriodistaIdioma();
            PeriodistaIdiomaControl pic=new PeriodistaIdiomaControl();
               PeriodistaControl pc=new PeriodistaControl();
              IdiomaControl ic=new IdiomaControl();
                       Periodista per=null;
               per=pc.buscarPerNombre(String.valueOf(jComboBox6.getSelectedItem()));
                        int idper= per.getIdPeriodista();
           String    nombre=String.valueOf(jComboBox1.getSelectedItem());
               int idi=ic.buscarIdIdioma(nombre);
                       if(pic.existe(idper, idi)){
                      JOptionPane.showMessageDialog(null, "Este idioma ya fue asignado a este periodista.");
             

                 }
                 else {
                            try {
                                pi.setEscribe(String.valueOf(jComboBox5.getSelectedItem()));
                                pi.setHabla(String.valueOf(jComboBox3.getSelectedItem()));
                                pi.setIdioma(ic.buscarIdioma(nombre));
                                pi.setLee(String.valueOf(jComboBox4.getSelectedItem()));
                                pi.setNivel(String.valueOf(jComboBox2.getSelectedItem()));
                                pi.setPeriodista(pc.BuscarPeriod(idper));
                                pic.adicionar(pi);
                                periodistaIdiomaList.add(pi);
                               jComboBox3.setSelectedIndex(0);
         jComboBox4.setSelectedIndex(0);
          jComboBox5.setSelectedIndex(0);
           jComboBox2.setSelectedIndex(0);
                               
                            } catch (PreexistingEntityException ex) {
                                Logger.getLogger(AsignarIdioma.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                Logger.getLogger(AsignarIdioma.class.getName()).log(Level.SEVERE, null, ex);
                            }

                                   
    
 }}
        }
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
           
           //  jTable1.clearSelection();
           
            if (jTable2.getSelectedRow()== -1){
                 JOptionPane.showMessageDialog(null, "Para modidficar debe seleccionar la asignación.");
               }
 else{
                     Integer fila = jTable2.getSelectedRow();
                     if(jTable2.getValueAt(fila, 2)==null || jTable2.getSelectedRowCount()>1)
                  JOptionPane.showMessageDialog(null, "Debe seleccionar una asignación.");
                     else{
                   
                     PeriodistaIdioma pi=new PeriodistaIdioma();
            PeriodistaIdiomaControl pic=new PeriodistaIdiomaControl();
               PeriodistaControl pc=new PeriodistaControl();
              IdiomaControl ic=new IdiomaControl();
                Periodista per=null;
               per=pc.buscarPerNombre(String.valueOf(jComboBox6.getSelectedItem()));
                        int idper= per.getIdPeriodista();
           String    nombre=String.valueOf(jComboBox1.getSelectedItem());
           PeriodistaIdioma seleccionado=periodistaIdiomaList.get(fila);
           Periodista p=pc.BuscarPeriod(idper);

      int     idselecc=seleccionado.getIdPerIdioma();
               int idi=ic.buscarIdIdioma(nombre);
                Idioma idioma=ic.buscarIdioma(nombre);
               boolean existe=false;
               for (int i = 0; i < pic.listarPeriodistaIdioma().size(); i++) {
                  PeriodistaIdioma perid = pic.listarPeriodistaIdioma().get(i);
                   if(perid.getIdioma().getIdIdioma()==idi
                   && perid.getPeriodista().getIdPeriodista()==idper &&
                   perid.getIdPerIdioma()!=idselecc){
                       existe=true;break;
                   }
               }

               if(existe){
                     JOptionPane.showMessageDialog(null, "ya existe esta asignación.");
               }
 else{
                            try {
                                pic.actualizarPerIdioma(String.valueOf(jComboBox2.getSelectedItem()), p, idioma, idselecc, String.valueOf(jComboBox3.getSelectedItem()), String.valueOf(jComboBox4.getSelectedItem()), String.valueOf(jComboBox5.getSelectedItem()));
                               PeriodistaIdioma pidio=pic.buscarIdiomaId(idselecc);
                               periodistaIdiomaList.remove(pidio);
                               periodistaIdiomaList.add(pidio);
                             jComboBox3.setSelectedIndex(0);
         jComboBox4.setSelectedIndex(0);
          jComboBox5.setSelectedIndex(0);
           jComboBox2.setSelectedIndex(0);
                               
                            } catch (PreexistingEntityException ex) {
                                Logger.getLogger(AsignarIdioma.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (Exception ex) {
                                Logger.getLogger(AsignarIdioma.class.getName()).log(Level.SEVERE, null, ex);
                            }
                          
                


        }}}
    }//GEN-LAST:event_jButton2MousePressed

    private void jComboBox5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox5MousePressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jComboBox5MousePressed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        // TODO add your handling code here:
         
              Integer fila = jTable2.getSelectedRow();
              if(jTable2.getValueAt(fila, 0)==null || jTable2.getSelectedRowCount()>1)
                  JOptionPane.showMessageDialog(null, "Debe seleccionar una asignación.");
              else{
              if (JOptionPane.showConfirmDialog(null, "Realmente desea eliminar?") == JOptionPane.YES_OPTION) {
                    try {
                        // Integer fila = jTable1.getSelectedRow();
                        PeriodistaIdiomaControl pic = new PeriodistaIdiomaControl();
                        String nombre = String.valueOf(jTable2.getValueAt(fila, 0));
                        PeriodistaIdioma pi = periodistaIdiomaList.get(fila);
                        int idperid = pi.getIdPerIdioma();
                        pic.eliminar(idperid);
                        periodistaIdiomaList.remove(pi);
                         jComboBox3.setSelectedIndex(0);
         jComboBox4.setSelectedIndex(0);
          jComboBox5.setSelectedIndex(0);
           jComboBox2.setSelectedIndex(0);
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(AsignarIdioma.class.getName()).log(Level.SEVERE, null, ex);
                    }


                    
                  }
                  }
    }//GEN-LAST:event_jButton3MousePressed

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        // TODO add your handling code here:
         PeriodistaIdiomaControl pc= new PeriodistaIdiomaControl()   ;
         String nombre=String.valueOf(jComboBox7.getSelectedItem());
          String nombrec=String.valueOf(jComboBox8.getSelectedItem());
                PeriodistaIdioma p= pc.buscarIdiomaNombre(nombre,nombrec);
                if(p==null)
       JOptionPane.showMessageDialog(null, "Al periodista"+" "+nombre+" "+"no se le ha sido asignado el idioma:"+" "+nombrec);
        else
                {
                    int posi= periodistaIdiomaList.lastIndexOf(p);
          //  Integer pos = getion.BuscarMunicipios(municipiosList, jnombre1.getText());
          //  if (pos != -1) {
                jTable2.setRowSelectionInterval(posi, posi);
                PeriodistaIdioma usu1 = periodistaIdiomaList.get(jTable2.getSelectedRow());
                PeriodistaIdioma  usu = em.find(PeriodistaIdioma.class, usu1.getIdPerIdioma());

                jComboBox6.setSelectedItem(usu.getPeriodista());
               // jComboBox1.setSelectedItem(usu.getCargoPeriodistico().getNombreCargop());
                jComboBox1.setSelectedItem(usu.getIdioma());
                jComboBox2.setSelectedItem(usu.getNivel());
                jComboBox3.setSelectedItem(usu.getHabla());
                jComboBox4.setSelectedItem(usu.getLee());
                jComboBox5.setSelectedItem(usu.getEscribe());



        }
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
        // TODO add your handling code here:
        jTable2.clearSelection();
        jComboBox3.setSelectedIndex(0);
         jComboBox4.setSelectedIndex(0);
          jComboBox5.setSelectedIndex(0);
           jComboBox2.setSelectedIndex(0);

    }//GEN-LAST:event_jButton5MousePressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AsignarIdioma dialog = new AsignarIdioma(new javax.swing.JFrame(), true);
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
    private java.util.List<modelo.Idioma> idiomaList;
    private javax.persistence.Query idiomaQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private java.util.List<modelo.PeriodistaIdioma> periodistaIdiomaList;
    private javax.persistence.Query periodistaIdiomaQuery;
    private java.util.List<modelo.Periodista> periodistaList;
    private javax.persistence.Query periodistaQuery;
    private javax.persistence.EntityManager tesisUpecPUEntityManager;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

}
