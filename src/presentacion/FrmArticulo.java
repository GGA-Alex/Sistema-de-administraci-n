
package presentacion;

import entidades.Categoria;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;
import negocio.ArticuloControl;

public class FrmArticulo extends javax.swing.JInternalFrame {

    private final ArticuloControl CONTROL;
    private String accion;
    private String nombreAnt;
    
    private String rutaOrigen;
    private String rutaDestino;
    private final String DIRECTORIO = "src/files/articulos/";
    private String imagen = "";
    private String imagenAnterior;
    
    public FrmArticulo() {
        initComponents();
        this.CONTROL = new ArticuloControl();
        this.listar("");
        tabGeneral.setEnabledAt(1, false);
        this.accion = "guardar";
        txtId.setVisible(false);
        lblId.setVisible(false);
        this.cargarCategorias();
    }
    
    private void ocultarColumnas(){
        tablaListado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(1).setMinWidth(0);
        
        tablaListado.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
    }
    
    private void listar(String texto){
        tablaListado.setModel(this.CONTROL.listar(texto, 10, 1));
        TableRowSorter orden = new  TableRowSorter(tablaListado.getModel());
        tablaListado.setRowSorter(orden);
        this.ocultarColumnas();
        lblTotalRegistros.setText("Mostrando " + this.CONTROL.totalMostrados() + " de un total de " + this.CONTROL.total() + " registros.");
    }
    
    private void cargarCategorias(){
        DefaultComboBoxModel items = this.CONTROL.seleccionar();
        cboCategoria.setModel(items);
    }
    
    private void subirImagenes(){
        File origen = new File(this.rutaOrigen);
        File destino = new File(this.rutaDestino);
        
        try {
            InputStream in = new FileInputStream(origen);
            OutputStream ou = new FileOutputStream(destino);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0){
                ou.write(buf,0,len);
            }
            in.close();
            ou.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void limpiar(){
        txtId.setText("");
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecioVenta.setText("");
        txtStock.setText("");
        txtDescripcion.setText("");
        lblImagen.setIcon(null);
        this.rutaDestino = "";
        this.rutaOrigen = "";
        this.accion = "guardar";
        this.imagenAnterior = "";
    }
    
    private void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Sistema", JOptionPane.ERROR_MESSAGE);
    }
    
    private void mensajeOk(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tabGeneral = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        lblTotalRegistros = new javax.swing.JLabel();
        btnAgregarCategoria = new javax.swing.JButton();
        btnEditar = new javax.swing.JToggleButton();
        btnActivar = new javax.swing.JButton();
        btnDesactivar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        btnAgregarImagen = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        txtStock = new javax.swing.JFormattedTextField();
        txtPrecioVenta = new javax.swing.JFormattedTextField();

        jLabel2.setText("jLabel2");

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Artículos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Nombre");

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaListado);

        lblTotalRegistros.setText("Registros");

        btnAgregarCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarCategoria.setText("Agregar Artículo");
        btnAgregarCategoria.setMaximumSize(new java.awt.Dimension(69, 25));
        btnAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCategoriaActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setText("Editar Artículo");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnActivar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActivar.setText("Activar Artículo");
        btnActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarActionPerformed(evt);
            }
        });

        btnDesactivar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDesactivar.setText("Desactivar Artículo");
        btnDesactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDesactivar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 378, Short.MAX_VALUE)
                        .addComponent(lblTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnAgregarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalRegistros)
                    .addComponent(btnActivar)
                    .addComponent(btnDesactivar))
                .addGap(12, 12, 12))
        );

        tabGeneral.addTab("Listado", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre (*)");
        jLabel3.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Descripción");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Formulario");

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel6.setText("(*) Indica que es un campo obligatorio.");

        lblId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblId.setText("ID");

        txtId.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Categoría (*)");
        jLabel7.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Código");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Precio de Venta (*)");
        jLabel9.setToolTipText("");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Stock (*)");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Imagen");

        lblImagen.setBackground(new java.awt.Color(204, 204, 204));
        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnAgregarImagen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarImagen.setText("Agregar imagen");
        btnAgregarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImagenActionPerformed(evt);
            }
        });

        txtStock.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        txtPrecioVenta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboCategoria, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigo)
                            .addComponent(txtId)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStock, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarImagen)
                                .addGap(0, 452, Short.MAX_VALUE))
                            .addComponent(txtPrecioVenta)
                            .addComponent(txtNombre)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarImagen))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap())
        );

        tabGeneral.addTab("Mantenimiento", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        this.listar(txtBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCategoriaActionPerformed
        tabGeneral.setEnabledAt(1, true);
        tabGeneral.setEnabledAt(0, false);
        tabGeneral.setSelectedIndex(1);
        this.accion = "guardar";
        btnGuardar.setText("Guardar");
    }//GEN-LAST:event_btnAgregarCategoriaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        tabGeneral.setEnabledAt(0, true);
        tabGeneral.setEnabledAt(1, false);
        lblId.setVisible(false);
        txtId.setVisible(false);
        tabGeneral.setSelectedIndex(0);
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().length() == 0 || txtNombre.getText().length() > 100){
            JOptionPane.showMessageDialog(this, "El campo nombre es obligatorio y no debe de ser mayor a 100 caracteres.", "Sistema", JOptionPane.WARNING_MESSAGE);
            txtNombre.requestFocus();
            return;
        }
        
        if (txtPrecioVenta.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "El campo precio de venta es obligatorio.", "Sistema", JOptionPane.WARNING_MESSAGE);
            txtPrecioVenta.requestFocus();
            return;
        }
        
        if (txtStock.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "El campo stock es obligatorio.", "Sistema", JOptionPane.WARNING_MESSAGE);
            txtStock.requestFocus();
            return;
        }
        
        if (txtDescripcion.getText().length() > 255){
            JOptionPane.showMessageDialog(this, "Debes de ingresar una descripción no mayor a 255 caracteres.", "Sistema", JOptionPane.WARNING_MESSAGE);
            txtDescripcion.requestFocus();
            return;
        }
        String resp;
        
        if (this.accion.equals("editar")){
            String imagenActual = "";
            if (this.imagen.equals("")) {
                imagenActual = this.imagenAnterior;
            } else {
                imagenActual = this.imagen;
            }
            Categoria seleccionado = (Categoria) cboCategoria.getSelectedItem();
            resp = this.CONTROL.actualizar(Integer.parseInt(txtId.getText()),seleccionado.getId(), txtCodigo.getText(), txtNombre.getText(), this.nombreAnt ,Double.parseDouble(txtPrecioVenta.getText()), Integer.parseInt(txtStock.getText()), txtDescripcion.getText(), imagenActual );
            if (resp.equals("OK")) {
                if (!this.imagen.equals("")) {
                    this.subirImagenes();
                }
                this.mensajeOk("Se ha actualizado el artículo de manera exitosa.");
                this.limpiar();
                this.listar("");
                lblId.setVisible(false);
                txtId.setVisible(false);
                tabGeneral.setSelectedIndex(0);
                tabGeneral.setEnabledAt(1, false);
                tabGeneral.setEnabledAt(0, true);
            } else {
                this.mensajeError(resp);
                this.limpiar();
            }
        } else {
            Categoria seleccionado = (Categoria) cboCategoria.getSelectedItem();
            resp = this.CONTROL.insertar(seleccionado.getId(), txtCodigo.getText(), txtNombre.getText(), Double.parseDouble(txtPrecioVenta.getText()), Integer.parseInt(txtStock.getText()), txtDescripcion.getText(), this.imagen );
            if (resp.equals("OK")) {
                if (!this.imagen.equals("")) {
                    this.subirImagenes();
                }
                this.mensajeOk("Se ha registrado el artículo de manera exitosa.");
                this.limpiar();
                this.listar("");
            } else {
                this.mensajeError(resp);
                this.limpiar();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (tablaListado.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            int categoriaId = Integer.parseInt(String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1)));
            String categoriaNombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));
            String codigo = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 3));
            String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 4));
            this.nombreAnt = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 4));
            String precioVenta = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 5));
            String stock = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 6));
            String descripcion = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 7));
            this.imagenAnterior = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 8));
            
            lblId.setVisible(true);
            txtId.setVisible(true);
            
            txtId.setText(id);
            Categoria seleccionado = new Categoria(categoriaId, categoriaNombre);
            cboCategoria.setSelectedItem(seleccionado);
            txtCodigo.setText(codigo);
            txtNombre.setText(nombre);
            txtPrecioVenta.setText(precioVenta);
            txtStock.setText(stock);
            txtDescripcion.setText(descripcion);
            
            ImageIcon im = new ImageIcon(this.DIRECTORIO + this.imagenAnterior);
            Icon icono = new ImageIcon(im.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
            lblImagen.setIcon(icono);
            lblImagen.repaint();
            
            tabGeneral.setEnabledAt(0, false);
            tabGeneral.setEnabledAt(1, true);
            tabGeneral.setSelectedIndex(1);
            this.accion = "editar";
            btnGuardar.setText("Editar");
        } else {
            this.mensajeError("Seleccione una categoría a editar.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDesactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarActionPerformed
        if (tablaListado.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
            
            if (JOptionPane.showConfirmDialog(this, "¿Desea desactivar la categoría " + nombre + "?", "Desactivar" , JOptionPane.YES_NO_OPTION) == 0) {
                String resp = this.CONTROL.desactivar(Integer.valueOf(id));
                if (resp.equals("OK")) {
                    this.mensajeOk("Categoría descativada con exito.");
                    this.listar("");
                } else {
                    this.mensajeError(resp);
                }
            }
        } else {
            this.mensajeError("Seleccione una categoría a desactivar.");
        }
    }//GEN-LAST:event_btnDesactivarActionPerformed

    private void btnActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarActionPerformed
        if (tablaListado.getSelectedRowCount() == 1) {
            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
            String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
            
            if (JOptionPane.showConfirmDialog(this, "¿Desea activar la categoría " + nombre + "?", "Desactivar" , JOptionPane.YES_NO_OPTION) == 0) {
                String resp = this.CONTROL.activar(Integer.valueOf(id));
                if (resp.equals("OK")) {
                    this.mensajeOk("Categoría activada con exito.");
                    this.listar("");
                } else {
                    this.mensajeError(resp);
                }
            }
        } else {
            this.mensajeError("Seleccione una categoría a activar.");
        }
    }//GEN-LAST:event_btnActivarActionPerformed

    private void btnAgregarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImagenActionPerformed
        JFileChooser file = new JFileChooser();
        int estado = file.showOpenDialog(this);
        
        if (estado == JFileChooser.APPROVE_OPTION) {
            this.imagen = file.getSelectedFile().getName();
            this.rutaOrigen = file.getSelectedFile().getAbsolutePath();
            this.rutaDestino = this.DIRECTORIO + this.imagen;
            
            ImageIcon im = new ImageIcon(this.rutaOrigen);
            Icon icono = new ImageIcon(im.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
            lblImagen.setIcon(icono);
            lblImagen.repaint();
        }
    }//GEN-LAST:event_btnAgregarImagenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivar;
    private javax.swing.JButton btnAgregarCategoria;
    private javax.swing.JButton btnAgregarImagen;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDesactivar;
    private javax.swing.JToggleButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboCategoria;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblTotalRegistros;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtPrecioVenta;
    private javax.swing.JFormattedTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
