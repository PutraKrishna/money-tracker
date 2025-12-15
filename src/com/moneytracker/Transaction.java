package com.moneytracker;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Transaction extends javax.swing.JPanel {
    
    private String idBarisTerpilih = "";
    private Dashboard dashboardPanel;
    DefaultTableModel modelLocal;
    
    public Transaction() {
        initComponents();
//        ImageIcon icon = new ImageIcon(getClass().getResource("/com/moneytracker/image/logo2.png"));
//        Image gambarAsli = icon.getImage();
//        Image gambarDiubah = gambarAsli.getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon iconJadi = new ImageIcon(gambarDiubah);
//        logo.setIcon(iconJadi);

        modelLocal = new DefaultTableModel();
        tabelInput.setModel(modelLocal);
        
        modelLocal.addColumn("ID");
        modelLocal.addColumn("Date");
        modelLocal.addColumn("Type");
        modelLocal.addColumn("Amount");
        modelLocal.addColumn("Category");
        modelLocal.addColumn("Description");
        
        // Sembunyikan ID
        tabelInput.getColumnModel().getColumn(0).setMinWidth(0);
        tabelInput.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelInput.getColumnModel().getColumn(0).setWidth(0);

        loadKategori();
        loadLocalData();
    }
    
    // Menghubungkan ke database
    public void setDashboardPanel(Dashboard dashPanel) {
        this.dashboardPanel = dashPanel;
    }
    
    private void loadLocalData() {
        modelLocal.getDataVector().removeAllElements();
        modelLocal.fireTableDataChanged();

        try {
            Connection c = Koneksi.getKoneksi();
            ResultSet r = c.createStatement().executeQuery("SELECT * FROM transaksi ORDER BY tanggal DESC");

            while (r.next()) {
                double jml = r.getDouble("jumlah");
                @SuppressWarnings("deprecation")
                String jmlFormatted = String.format(new Locale("id", "ID"), "%,.0f", jml);

                modelLocal.addRow(new Object[]{
                    r.getString("id"),
                    r.getString("tanggal"),
                    r.getString("jenis"),
                    "Rp " + jmlFormatted,
                    r.getString("kategori"),
                    r.getString("deskripsi")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadKategori() {
        cbKategori.removeAllItems();
        try {
            Connection c = Koneksi.getKoneksi();
            ResultSet r = c.createStatement().executeQuery("SELECT * FROM kategori_list ORDER BY nama_kategori ASC");
            while (r.next()) {
                cbKategori.addItem(r.getString("nama_kategori"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
    
    private void kosongkanForm() {
        idBarisTerpilih = "";
        txtJumlah.setText("");
        txtDeskripsi.setText("");
        txtTanggal.setText("");
        btnSimpan.setEnabled(true);
        btnEdit.setEnabled(false);
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelInput = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtJumlah = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        rbIncome = new javax.swing.JRadioButton();
        rbExpense = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        cbKategori = new javax.swing.JComboBox<>();
        btnTambahKategori = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDeskripsi = new javax.swing.JTextArea();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        txtTanggal = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(245, 245, 245));
        jScrollPane1.setBorder(null);

        tabelInput.setBackground(new java.awt.Color(245, 245, 245));
        tabelInput.setFont(new java.awt.Font("Google Sans", 0, 12)); // NOI18N
        tabelInput.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelInputMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelInput);

        jLabel2.setFont(new java.awt.Font("Google Sans", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Date");

        txtJumlah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtJumlah.setFont(new java.awt.Font("Google Sans", 0, 12)); // NOI18N
        txtJumlah.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(txtJumlah);

        jLabel3.setFont(new java.awt.Font("Google Sans", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Amount");

        buttonGroup1.add(rbIncome);
        rbIncome.setForeground(new java.awt.Color(0, 0, 0));
        rbIncome.setText("Income");

        buttonGroup1.add(rbExpense);
        rbExpense.setForeground(new java.awt.Color(0, 0, 0));
        rbExpense.setText("Expense");

        jLabel4.setFont(new java.awt.Font("Google Sans", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Category");

        cbKategori.setFont(new java.awt.Font("Google Sans", 0, 12)); // NOI18N
        cbKategori.setForeground(new java.awt.Color(0, 0, 0));
        cbKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnTambahKategori.setFont(new java.awt.Font("Google Sans", 1, 24)); // NOI18N
        btnTambahKategori.setText("+");
        btnTambahKategori.setBorder(null);
        btnTambahKategori.setMargin(new java.awt.Insets(2, 14, 2, 14));
        btnTambahKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahKategoriActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Google Sans", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Description");

        txtDeskripsi.setFont(new java.awt.Font("Google Sans", 0, 12)); // NOI18N
        jScrollPane4.setViewportView(txtDeskripsi);

        btnSimpan.setFont(new java.awt.Font("Google Sans", 1, 14)); // NOI18N
        btnSimpan.setText("Save");
        btnSimpan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Google Sans", 1, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnEdit.setBorderPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Google Sans", 1, 14)); // NOI18N
        btnHapus.setText("Delete");
        btnHapus.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnHapus.setBorderPainted(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        txtTanggal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTanggal.setForeground(new java.awt.Color(0, 0, 0));
        txtTanggal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/MM/yyyy"))));
        txtTanggal.setFont(new java.awt.Font("Google Sans", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTanggal, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rbIncome)
                                .addGap(18, 18, 18)
                                .addComponent(rbExpense))
                            .addComponent(jLabel4)
                            .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(106, 106, 106)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnTambahKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbIncome)
                            .addComponent(rbExpense))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTambahKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(700, 100));

        jLabel5.setFont(new java.awt.Font("Google Sans", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Transaction");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel7, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahKategoriActionPerformed
        String baru = JOptionPane.showInputDialog(this, "New Category Name:");
        if(baru != null && !baru.isEmpty()){
            try {
                Connection c = Koneksi.getKoneksi();
                c.createStatement().executeUpdate("INSERT IGNORE INTO kategori_list (nama_kategori) VALUES ('"+baru+"')");
                loadKategori();
                cbKategori.setSelectedItem(baru);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnTambahKategoriActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        try {
            if(txtJumlah.getText().isEmpty()) throw new Exception("Amount is required!");

            String tampilanTanggal = txtTanggal.getText();
            SimpleDateFormat formatUI = new SimpleDateFormat("d/M/yyyy");
            SimpleDateFormat formatMySQL = new SimpleDateFormat("yyyy-MM-dd");
            String tanggalSiapSimpan = formatMySQL.format(formatUI.parse(tampilanTanggal));

            com.moneytracker.Transaksi tr = buatObjectTransaksi();

            Connection c = Koneksi.getKoneksi();
            String sql = "INSERT INTO transaksi (tanggal, jenis, jumlah, kategori, deskripsi) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);

            p.setString(1, tanggalSiapSimpan);
            p.setString(2, tr.getJenis());
            p.setDouble(3, tr.getJumlah());
            p.setString(4, tr.getKategori());
            p.setString(5, tr.getDeskripsi());

            p.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully!");
            
            kosongkanForm();
            
            // --- SINKRONISASI ---
            loadLocalData(); // 1. Refresh Tabel di sini (Transaction)
            
            if(dashboardPanel != null) {
                dashboardPanel.refreshData(); // 2. Refresh Tabel di sana (Dashboard)
            }
            // --------------------

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try {
            if(idBarisTerpilih.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Select row first!");
                return;
            }

            String tampilanTanggal = txtTanggal.getText();
            SimpleDateFormat formatUI = new SimpleDateFormat("d/M/yyyy");
            SimpleDateFormat formatMySQL = new SimpleDateFormat("yyyy-MM-dd");
            String tanggalSiapSimpan = formatMySQL.format(formatUI.parse(tampilanTanggal));

            com.moneytracker.Transaksi tr = buatObjectTransaksi();

            Connection c = Koneksi.getKoneksi();
            String sql = "UPDATE transaksi SET tanggal=?, jenis=?, jumlah=?, kategori=?, deskripsi=? WHERE id=?";
            PreparedStatement p = c.prepareStatement(sql);

            p.setString(1, tanggalSiapSimpan);
            p.setString(2, tr.getJenis());
            p.setDouble(3, tr.getJumlah());
            p.setString(4, tr.getKategori());
            p.setString(5, tr.getDeskripsi());
            p.setString(6, idBarisTerpilih);

            p.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data updated!");
            
            kosongkanForm();
            
            // --- SINKRONISASI ---
            loadLocalData(); // 1. Refresh Tabel Sini
            if(dashboardPanel != null) {
                dashboardPanel.refreshData(); // 2. Refresh Tabel Sana
            }
            // --------------------

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Update Failed: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if(idBarisTerpilih.isEmpty()) return;

        int confirm = JOptionPane.showConfirmDialog(this, "Delete this data?");
        if(confirm == JOptionPane.YES_OPTION) {
            try {
                Connection c = Koneksi.getKoneksi();
                c.createStatement().executeUpdate("DELETE FROM transaksi WHERE id=" + idBarisTerpilih);
                
                kosongkanForm();
                
                // --- SINKRONISASI ---
                loadLocalData(); // 1. Refresh Tabel Sini
                if(dashboardPanel != null) {
                    dashboardPanel.refreshData(); // 2. Refresh Tabel Sana
                }
                // --------------------
                
                JOptionPane.showMessageDialog(this, "Deleted!");
            } catch (SQLException e) { e.printStackTrace(); }
        }  
    }//GEN-LAST:event_btnHapusActionPerformed

    private void tabelInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelInputMouseClicked
        int row = tabelInput.getSelectedRow();
        if(row != -1) {
            idBarisTerpilih = modelLocal.getValueAt(row, 0).toString();
            try {
                String tglDB = modelLocal.getValueAt(row, 1).toString();
                SimpleDateFormat fDB = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat fUI = new SimpleDateFormat("d/M/yyyy");
                txtTanggal.setText(fUI.format(fDB.parse(tglDB)));
            } catch (Exception e) {
                txtTanggal.setText(modelLocal.getValueAt(row, 1).toString());
            }

            String jenis = modelLocal.getValueAt(row, 2).toString();
            if(jenis.equalsIgnoreCase("Income")) rbIncome.setSelected(true);
            else rbExpense.setSelected(true);

            // Bersihkan "Rp " dan "."
            String jmlRaw = modelLocal.getValueAt(row, 3).toString();
            String jmlClean = jmlRaw.replace("Rp ", "").replace(".", "");
            txtJumlah.setText(jmlClean);

            cbKategori.setSelectedItem(modelLocal.getValueAt(row, 4).toString());
            txtDeskripsi.setText(modelLocal.getValueAt(row, 5).toString());

            btnSimpan.setEnabled(false);
            btnEdit.setEnabled(true);
        }
    }//GEN-LAST:event_tabelInputMouseClicked

    private com.moneytracker.Transaksi buatObjectTransaksi() throws Exception {
        String tgl = txtTanggal.getText();
        double jml = Double.parseDouble(txtJumlah.getText());
        String kat = cbKategori.getSelectedItem().toString();
        String desc = txtDeskripsi.getText();

        if (rbIncome.isSelected()) return new Pemasukan(tgl, jml, kat, desc);
        else return new Pengeluaran(tgl, jml, kat, desc);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahKategori;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JRadioButton rbExpense;
    private javax.swing.JRadioButton rbIncome;
    private javax.swing.JTable tabelInput;
    private javax.swing.JTextArea txtDeskripsi;
    private javax.swing.JTextPane txtJumlah;
    private javax.swing.JFormattedTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
