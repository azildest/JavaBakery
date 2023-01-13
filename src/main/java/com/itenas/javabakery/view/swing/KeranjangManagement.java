/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itenas.javabakery.view.swing;

import com.itenas.javabakery.pojo.Akun;
import com.itenas.javabakery.pojo.Keranjang;
import com.itenas.javabakery.pojo.Member;
import com.itenas.javabakery.pojo.Keranjang;
import com.itenas.javabakery.service.KeranjangService;
import com.itenas.javabakery.service.KeranjangService;
import com.itenas.javabakery.serviceimpl.KeranjangServiceImpl;
import com.itenas.javabakery.serviceimpl.KeranjangServiceImpl;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class KeranjangManagement extends javax.swing.JFrame {
    
    /**
     * Creates new form Homepage
     */
    Akun akun;
    KeranjangService produkService;
    KeranjangService keranjangService;
    String usrname;
    
    public KeranjangManagement() {
        initComponents();
        this.setLocationRelativeTo(null);
        //testUsername.setText(akun.getUsername());
//        getAkunInfo(akun);
        //loadData();
        
    }
    
    public String getAkunInfo(Akun akn) {
        lblUsername.setText("");
        akun = akn;
        
        //lblNamaUser.setText(akun.getAkun().getNama());
        lblUsername.setText(akun.getAkun().getUsername());
 //       testUsername.setName(lblUsername.getText());
        //usrname = lblUsername.getText();
        
//        return testUsername.getName();
        return lblUsername.getText();
    }
    
    /*public String getAkunInfo(String username) {
        lblUsername.setText("");
        lblUsername.setText(username);
        //testUsername.setText(username);
        
        usrname = lblUsername.getText();
        
        return usrname;
    }*/
    
    /*public void setAkunInfo(){
        this.
    }*/
    
        private void emptyField() {
            lblIDProduk.setText("");
            txtNamaProduk.setText("");
            txtTotal.setText("");
            //lblImage.setIcon(null);
    }
    
    public void loadData(Akun akn) {
        keranjangService = new KeranjangServiceImpl();
        List<Keranjang> listKeranjang;
        sort = comboSortir.getSelectedItem().toString();
        
        if (sort.equals("Nama")){
            listKeranjang = keranjangService.sortByCondition1(akun.getUsername().toString());
        } else if (sort.equals("Harga")){
            listKeranjang = keranjangService.sortByCondition2(akun.getUsername().toString());
        } else if (sort.equals("Jumlah")){
            listKeranjang = keranjangService.sortByCondition3(akun.getUsername().toString());
        } else if (sort.equals("Total")){
            listKeranjang = keranjangService.sortByCondition4(akun.getUsername().toString());
        } else {
            listKeranjang = keranjangService.findAll(akun.getUsername().toString());
        }
        Object[][] objectKeranjang = new Object[listKeranjang.size()][6];
        
        int counter = 0;
        
        for (Keranjang produk : listKeranjang) {
            objectKeranjang[counter][0] = produk.getIdProduk();
            objectKeranjang[counter][1] = produk.getNamaProduk();
            objectKeranjang[counter][2] = produk.getJumlah();
            objectKeranjang[counter][3] = produk.getHarga();
            objectKeranjang[counter][4] = produk.getTotal();
            objectKeranjang[counter][5] = produk.getImage();
            counter++;
        }
        
        tblKeranjang.setModel(new javax.swing.table.DefaultTableModel(
            objectKeranjang,
            new String [] {
                "ID Produk", "Nama Produk", "Jumlah", "Harga", "Total", "Image"
            }
        ));
    }
    
    private void loadData(Keranjang produk) {
        Object[][] objectKeranjang = new Object[1][6];
        
            objectKeranjang[0][0] = produk.getIdproduk();
            objectKeranjang[0][1] = produk.getNamaProduk();
            objectKeranjang[0][2] = produk.getHarga();
            objectKeranjang[0][3] = produk.getTotal();
            objectKeranjang[0][4] = produk.getImage();
            
        tblKeranjang.setModel(new javax.swing.table.DefaultTableModel(
            objectKeranjang,
            new String [] {
                "ID Produk", "Nama Keranjang", "Jumlah", "Harga", "Total", "Image"
            }
        ));
    }
    
    private Keranjang findKeranjang(String name) {
        Keranjang produk = new Keranjang();
        produkService = new KeranjangServiceImpl();
//        produk = produkService.findByNama(name);
    
        return produk;
    }
    
    public void Refresh(Akun akn){
        loadData(akun);
    }
    
    public void IncreaseQuantity(String id){
        int jumlah;
        
        keranjangService.increaseQuantity(akun.getUsername(), id);
        loadData(akun);
        
        //int row = tblKeranjang.get
        //jumlah = Integer.parseInt(tblKeranjang.getValueAt(row, 2).toString());
        lblJumlah.setText(id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnCart = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        btnProfil = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKeranjang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnAddToCart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblIDProduk = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNamaProduk = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jDesktopPane4 = new javax.swing.JDesktopPane();
        lblImage2 = new javax.swing.JLabel();
        txtCariNama = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        comboSortir = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblJumlah = new javax.swing.JTextField();
        btnMin = new javax.swing.JButton();
        btnPlus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 50, 73));

        btnHome.setBackground(new java.awt.Color(0, 50, 73));
        btnHome.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Downloads\\home-icon-silhouette.png")); // NOI18N
        btnHome.setBorder(null);
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnCart.setBackground(new java.awt.Color(255, 255, 255));
        btnCart.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Downloads\\shopping-cart (1).png")); // NOI18N
        btnCart.setBorder(null);
        btnCart.setBorderPainted(false);
        btnCart.setContentAreaFilled(false);

        btnLogOut.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Downloads\\logout.png")); // NOI18N
        btnLogOut.setBorder(null);
        btnLogOut.setBorderPainted(false);
        btnLogOut.setContentAreaFilled(false);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnProfil.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Downloads\\user.png")); // NOI18N
        btnProfil.setBorder(null);
        btnProfil.setBorderPainted(false);
        btnProfil.setContentAreaFilled(false);

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 8)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("KERANJANG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnProfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(48, 48, 48)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnCart, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProfil, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel3.setText("username :");

        lblUsername.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblUsername.setText("ax");

        tblKeranjang.setAutoCreateRowSorter(true);
        tblKeranjang.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        tblKeranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Produk", "Nama", "Jumlah", "Harga", "Total", "Image"
            }
        ));
        tblKeranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKeranjangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKeranjang);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnAddToCart.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        btnAddToCart.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Downloads\\remove-from-cart.png")); // NOI18N
        btnAddToCart.setText("Hapus dari Keranjang");
        btnAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddToCartActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft New Tai Lue", 1, 20)); // NOI18N
        jLabel1.setText("DETAIL PRODUK");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        jLabel6.setText("ID Produk");

        lblIDProduk.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        lblIDProduk.setText("x");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel2.setText("Nama Produk");

        txtNamaProduk.setEditable(false);
        txtNamaProduk.setBackground(new java.awt.Color(255, 255, 255));
        txtNamaProduk.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        txtNamaProduk.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 50, 73)));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel4.setText("Total");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtTotal.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        txtTotal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 50, 73)));

        jDesktopPane4.setBorder(new javax.swing.border.MatteBorder(null));

        jDesktopPane4.setLayer(lblImage2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
        );

        txtCariNama.setBackground(new java.awt.Color(244, 237, 252));
        txtCariNama.setText("Cari melalui nama..");
        txtCariNama.setBorder(null);
        txtCariNama.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCariNamaMouseClicked(evt);
            }
        });

        btnCari.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCari.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Documents\\Bahan\\Zoom-icon.png")); // NOI18N
        btnCari.setBorder(null);
        btnCari.setBorderPainted(false);
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        comboSortir.setBackground(new java.awt.Color(204, 204, 204));
        comboSortir.setFont(new java.awt.Font("Segoe UI Semibold", 0, 11)); // NOI18N
        comboSortir.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Urutkan", "Nama", "Harga", "Jumlah", "Total" }));
        comboSortir.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboSortirItemStateChanged(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Downloads\\refresh-page-option.png")); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        jLabel7.setText("Jumlah");

        lblJumlah.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        lblJumlah.setText("0");
        lblJumlah.setBorder(null);

        btnMin.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Downloads\\minus.png")); // NOI18N

        btnPlus.setIcon(new javax.swing.ImageIcon("C:\\Users\\acer\\Downloads\\plus.png")); // NOI18N
        btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCariNama, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSortir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUsername)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDesktopPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblIDProduk))
                            .addComponent(jLabel2)
                            .addComponent(txtNamaProduk)
                            .addComponent(btnAddToCart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotal)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(27, 27, 27)
                                .addComponent(btnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblIDProduk))
                        .addGap(7, 7, 7)
                        .addComponent(jDesktopPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnMin)
                                            .addComponent(lblJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(btnPlus))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblUsername)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtCariNama, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboSortir, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        
        LoginForm lf = new LoginForm();
        dispose();
        lf.setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void txtCariNamaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCariNamaMouseClicked
        // TODO add your handling code here:
        
        txtCariNama.setText("");
    }//GEN-LAST:event_txtCariNamaMouseClicked

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        // TODO add your handling code here:

        String nama;
        Keranjang searchedKeranjang = new Keranjang();

        nama = txtCariNama.getText().toString();
        searchedKeranjang = findKeranjang(nama);
        if (searchedKeranjang != null) {
            loadData(searchedKeranjang);
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan!");
        }
    }//GEN-LAST:event_btnCariActionPerformed

    private void comboSortirItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboSortirItemStateChanged
        // TODO add your handling code here:

        sort = comboSortir.getSelectedItem().toString();

        if (sort.equals("Tersedia")){
//            produkService.sortByCondition1();
        } else if (sort.equals("Tidak Tersedia")){
 //           produkService.sortByCondition2();
        }
    }//GEN-LAST:event_comboSortirItemStateChanged

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        Refresh(akun);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddToCartActionPerformed
        // TODO add your handling code here:
        
        String namaKeranjang, image;
        int idKeranjang;
        double harga;
        //keranjangService = new KeranjangServiceImpl();
        produkService = new KeranjangServiceImpl();
        
/*        idKeranjang = Integer.parseInt(lblIDKeranjang.getText());
        namaKeranjang = txtNamaKeranjang.getText();
        harga = Double.parseDouble(txtHarga.getText());
        
        Keranjang produk = new Keranjang();
        produk.setId(idKeranjang);
        produk.setNama(namaKeranjang);
        produk.setHarga(harga);
        produk.setImage(produkImage);
        
        //Keranjang keranjang = new Keranjang();
        //keranjang.setIdproduk(idKeranjang);
        
        produkService.addProduct(lblUsername.getText(), produk);
        
        //keranjangService.addProduct(lblUsername.getText(), keranjang);
        JOptionPane.showMessageDialog(null, "Keranjang telah ditambahkan ke Keranjang!");
        loadData();
        emptyField();*/
    }//GEN-LAST:event_btnAddToCartActionPerformed

    private void tblKeranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKeranjangMouseClicked
        // TODO add your handling code here:
        
        String namaProduk, image;
        int idProduk, jumlah;
        double harga, total;
        
        int row = tblKeranjang.getSelectedRow();
        idProduk = Integer.parseInt(tblKeranjang.getValueAt(row, 0).toString());
        namaProduk = tblKeranjang.getValueAt(row, 1).toString();
        jumlah = Integer.parseInt(tblKeranjang.getValueAt(row, 2).toString());
        harga = Double.parseDouble(tblKeranjang.getValueAt(row, 3).toString());
        total = Double.parseDouble(tblKeranjang.getValueAt(row, 4).toString());
        image = tblKeranjang.getValueAt(row, 5).toString();
        
        lblIDProduk.setText(idProduk+"");
        txtNamaProduk.setText(namaProduk);
        lblJumlah.setText(jumlah+"");
        txtTotal.setText(total+"");
        //lblImage.setIcon(produkIcon);
    }//GEN-LAST:event_tblKeranjangMouseClicked

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        
        Homepage hm = new Homepage();
        hm.getAkunInfo(akun);
        dispose();
        hm.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusActionPerformed
        // TODO add your handling code here:
        
        IncreaseQuantity(lblIDProduk.getText());
    }//GEN-LAST:event_btnPlusActionPerformed

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
            java.util.logging.Logger.getLogger(KeranjangManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KeranjangManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KeranjangManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KeranjangManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KeranjangManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddToCart;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCart;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMin;
    private javax.swing.JButton btnPlus;
    private javax.swing.JButton btnProfil;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> comboSortir;
    private javax.swing.JDesktopPane jDesktopPane4;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIDProduk;
    private javax.swing.JLabel lblImage2;
    private javax.swing.JTextField lblJumlah;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblKeranjang;
    private javax.swing.JTextField txtCariNama;
    private javax.swing.JTextField txtNamaProduk;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    private String sort;
    String namaFileKeranjang = null;
    private ImageIcon produkIcon = null;
    byte[] produkImage = null;
}
