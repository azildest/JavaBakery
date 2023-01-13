/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itenas.javabakery.view.swing;

import com.itenas.javabakery.pojo.Produk;
import com.itenas.javabakery.service.ProdukService;
import com.itenas.javabakery.serviceimpl.ProdukServiceImpl;
import com.itenas.javabakery.utility.ConnectionManager;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.coobird.thumbnailator.Thumbnails;

/**
 *
 * @author ASUS
 */
public class ProdukManagement extends javax.swing.JFrame {

    /**
     * Creates new form ViewProduk
     */
    ProdukService produkService;
    ProdukServiceImpl proSer;
    
    public ProdukManagement() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadData();
    }
    
    public void close() {
        WindowEvent we = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
    }
    
    private void emptyField() {
        txtIDProduk.setText("");
        txtNamaProduk.setText("");
        txtHarga.setText("");
        bgroupStatus.clearSelection();
        txtImagePath.setText("");
        lblImage.setIcon(null);
    }
    
    private void loadData() {
        produkService = new ProdukServiceImpl();
        List<Produk> listProduk;
        sort = comboStatus.getSelectedItem().toString();
        
        if (sort.equals("Tersedia")){
            listProduk = produkService.sortByCondition1();
        } else if (sort.equals("Tidak Tersedia")){
            listProduk = produkService.sortByCondition2();
        } else {
            listProduk = produkService.findAll();
        }
        Object[][] objectProduk = new Object[listProduk.size()][6];
        
        int counter = 0;
        
        for (Produk produk : listProduk) {
            objectProduk[counter][0] = produk.getId();
            objectProduk[counter][1] = produk.getNama();
            objectProduk[counter][2] = produk.getHarga();
            objectProduk[counter][3] = produk.getStatus();
            objectProduk[counter][4] = produk.getImage();
            counter++;
        }
        
        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            objectProduk,
            new String [] {
                "ID Produk", "Nama Produk", "Harga", "Status", "Image"
            }
        ));
    }
    
    private void loadData(Produk produk) {
        Object[][] objectProduk = new Object[1][6];
        
        objectProduk[0][0] = produk.getId();
        objectProduk[0][1] = produk.getNama();
        objectProduk[0][2] = produk.getHarga();
        objectProduk[0][3] = produk.getStatus();
        objectProduk[0][4] = produk.getImage();
            
        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            objectProduk,
            new String [] {
                "ID Produk", "Nama Produk", "Harga", "Status", "Image"
            }
        ));
    }
    
    private Produk findProduk(String name) {
        Produk produk = new Produk();
        produkService = new ProdukServiceImpl();
        produk = produkService.findByName(name);
    
        return produk;
    }
    
    private void sortTersedia(){
        produkService = new ProdukServiceImpl();
        List<Produk> listProduk;
        listProduk = produkService.sortByCondition1();
        Object[][] objectProduk = new Object[listProduk.size()][6];
        
        int counter = 0;
        
        for (Produk produk : listProduk) {
            objectProduk[counter][0] = produk.getId();
            objectProduk[counter][1] = produk.getNama();
            objectProduk[counter][2] = produk.getHarga();
            objectProduk[counter][3] = produk.getStatus();
            objectProduk[counter][4] = produk.getImage();
            counter++;
        }
        
        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            objectProduk,
            new String [] {
                "ID Produk", "Nama Produk", "Harga", "Status", "Image"
            }
        ));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgroupStatus = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduk = new javax.swing.JTable();
        txtCariNama = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNamaProduk = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        radioTersedia = new javax.swing.JRadioButton();
        radioTdkTersedia = new javax.swing.JRadioButton();
        comboStatus = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        lblImage = new javax.swing.JLabel();
        txtImagePath = new javax.swing.JTextField();
        btnUpload = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtIDProduk = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 50, 73));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PRODUK MANAGEMENT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(188, 188, 188))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        tblProduk.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        tblProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Produk", "Nama", "Harga", "Status", "Image"
            }
        ));
        tblProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduk);

        txtCariNama.setBackground(new java.awt.Color(244, 237, 252));
        txtCariNama.setText("Cari melalui nama...");
        txtCariNama.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        txtCariNama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariNamaMouseClicked(evt);
            }
        });
        txtCariNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariNamaActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel3.setText("Nama Produk");

        txtNamaProduk.setBackground(new java.awt.Color(244, 237, 252));
        txtNamaProduk.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        txtNamaProduk.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel4.setText("Harga");

        txtHarga.setBackground(new java.awt.Color(244, 237, 252));
        txtHarga.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        txtHarga.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel5.setText("Status");

        bgroupStatus.add(radioTersedia);
        radioTersedia.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        radioTersedia.setText("Tersedia");
        radioTersedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTersediaActionPerformed(evt);
            }
        });

        bgroupStatus.add(radioTdkTersedia);
        radioTdkTersedia.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        radioTdkTersedia.setText("Tidak Tersedia");
        radioTdkTersedia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTdkTersediaActionPerformed(evt);
            }
        });

        comboStatus.setBackground(new java.awt.Color(204, 204, 204));
        comboStatus.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Status", "Tersedia", "Tidak Tersedia" }));
        comboStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboStatusItemStateChanged(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Downloads\\refresh-page-option.png")); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnCari.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCari.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Documents\\Bahan\\Zoom-icon.png")); // NOI18N
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jDesktopPane1.setBorder(new javax.swing.border.MatteBorder(null));

        jDesktopPane1.setLayer(lblImage, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
        );

        txtImagePath.setBackground(new java.awt.Color(244, 237, 252));
        txtImagePath.setBorder(null);

        btnUpload.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpload.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Documents\\Bahan\\upload-icon.png")); // NOI18N
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Documents\\Bahan\\edit-validated-icon.png")); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Documents\\Bahan\\Actions-edit-clear-icon.png")); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 153, 153));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Documents\\Bahan\\Trash-empty-icon.png")); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Documents\\Bahan\\add-icon.png")); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnPrint.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPrint.setText("PRINT");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel6.setText("Gambar");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jLabel2.setText("ID Produk");

        txtIDProduk.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        txtIDProduk.setBorder(null);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIDProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCariNama, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)))
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNamaProduk, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtHarga, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(radioTersedia)
                            .addGap(10, 10, 10)
                            .addComponent(radioTdkTersedia)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtImagePath, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCariNama, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 38, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIDProduk)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtImagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(txtNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(1, 1, 1)
                        .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioTersedia)
                            .addComponent(radioTdkTersedia)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jMenu1.setText("Menu");

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jMenu1.add(btnExit);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.setVisible(true);
        close();
    }//GEN-LAST:event_btnExitActionPerformed

    private void txtCariNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariNamaActionPerformed
        // TODO add your handling code here:
        txtCariNama.setText("");
    }//GEN-LAST:event_txtCariNamaActionPerformed

    private void tblProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdukMouseClicked
        // TODO add your handling code here:
        
        String namaProduk, stat, image;
        int idProduk;
        double harga;
        
        int row = tblProduk.getSelectedRow();
        idProduk = Integer.parseInt(tblProduk.getValueAt(row, 0).toString());
        namaProduk = tblProduk.getValueAt(row, 1).toString();
        harga = Double.parseDouble(tblProduk.getValueAt(row, 2).toString());
        stat = tblProduk.getValueAt(row, 3).toString();
        image = tblProduk.getValueAt(row, 4).toString();
        
        txtIDProduk.setText(idProduk+"");
        txtNamaProduk.setText(namaProduk);
        txtHarga.setText(harga+"");
        if (stat.equals("Tersedia")) {
            radioTersedia.setSelected(true);
        }
        if (stat.equals("Tidak Tersedia")) {
            radioTdkTersedia.setSelected(true);
        }
        lblImage.setIcon(produkIcon);
    }//GEN-LAST:event_tblProdukMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        
        String namaProduk, stat, image;
        double harga;
        produkService = new ProdukServiceImpl();
        
        namaProduk = txtNamaProduk.getText();
        harga = Double.parseDouble(txtHarga.getText());
        stat = status;
        
        Produk produk = new Produk();
        produk.setNama(namaProduk);
        produk.setHarga(harga);
        produk.setStatus(stat);
        produk.setImage(produkImage);
        
        produkService.create(produk);
        JOptionPane.showMessageDialog(null, "Data produk berhasil dibuat!");
        loadData();
        emptyField();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        String namaProduk, stat;
        double harga;
        int idProduk;
        produkService = new ProdukServiceImpl();
        
        idProduk = Integer.parseInt(txtIDProduk.getText());
        namaProduk = txtNamaProduk.getText();
        harga = Double.parseDouble(txtHarga.getText());
        stat = status;
        
        Produk produk = new Produk();
        produk.setId(idProduk);
        produk.setNama(namaProduk);
        produk.setHarga(harga);
        produk.setStatus(status);
        produk.setImage(produkImage);
        
        produkService.update(produk);
        
        JOptionPane.showMessageDialog(null, "Data Produk berhasil diperbarui!");
        loadData();
        emptyField();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        
        int id;
        produkService = new ProdukServiceImpl();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        
        id = Integer.parseInt(txtIDProduk.getText());
        
        int dialogResult = JOptionPane.showConfirmDialog (null, "Anda yakin ingin menghapus item?", "Warning", dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            produkService.delete(id);
            loadData();
            emptyField();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        emptyField();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:
        
        String name;
        Produk searchedProduk = new Produk();
        name = txtCariNama.getText();
        
        searchedProduk = findProduk(name);
        if (searchedProduk != null) {
            loadData(searchedProduk);
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan!");
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        loadData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void radioTersediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTersediaActionPerformed
        // TODO add your handling code here:
        status = "Tersedia";
    }//GEN-LAST:event_radioTersediaActionPerformed

    private void radioTdkTersediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTdkTersediaActionPerformed
        // TODO add your handling code here:
        status = "Tidak Tersedia";
    }//GEN-LAST:event_radioTdkTersediaActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        
        MessageFormat header = new MessageFormat("List Produk Reporting");
        MessageFormat footer = new MessageFormat("Page {0, number, integer}");
        try {
            tblProduk.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException e) {
            System.out.println("Error: " + e);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void txtCariNamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariNamaMouseClicked
        // TODO add your handling code here:
        
        txtCariNama.setText("");
    }//GEN-LAST:event_txtCariNamaMouseClicked

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        namaFileProduk = file.getAbsolutePath();
        txtImagePath.setText(namaFileProduk);
        
        try {
            File image = new File(namaFileProduk);
            
            BufferedImage thumbnail = Thumbnails.of(image).size(180, 220).asBufferedImage();
            
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            
            ImageIO.write(thumbnail, "jpeg", os);
            
            InputStream is = new  ByteArrayInputStream(os.toByteArray());
            
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            
            byte[] buf = new byte[1024];
            
            for (int readNum; (readNum = is.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            
            produkIcon = new ImageIcon(thumbnail);
            lblImage.setIcon(produkIcon);
            
            produkImage = bos.toByteArray();
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void comboStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboStatusItemStateChanged
        // TODO add your handling code here:
        
        sort = comboStatus.getSelectedItem().toString();
        
        if (sort.equals("Tersedia")){
            produkService.sortByCondition1();
        } else if (sort.equals("Tidak Tersedia")){
            produkService.sortByCondition2();
        }
    }//GEN-LAST:event_comboStatusItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProdukManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdukManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdukManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdukManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdukManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgroupStatus;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JMenuItem btnExit;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpload;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JRadioButton radioTdkTersedia;
    private javax.swing.JRadioButton radioTersedia;
    private javax.swing.JTable tblProduk;
    private javax.swing.JTextField txtCariNama;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtIDProduk;
    private javax.swing.JTextField txtImagePath;
    private javax.swing.JTextField txtNamaProduk;
    // End of variables declaration//GEN-END:variables
    private String status;
    private String sort;
    String namaFileProduk = null;
    private ImageIcon produkIcon = null;
    byte[] produkImage = null;
}
