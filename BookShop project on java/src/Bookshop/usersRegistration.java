package Bookshop;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.Connection;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Admin
 */
public final class usersRegistration extends javax.swing.JFrame {

    /**
     * Creates new form books
     */
    public usersRegistration() {
        initComponents();
        Connect();
        table_update();
       
    }
    
    Connection con;
    PreparedStatement pst;
    PreparedStatement pst1;
    ResultSet rs;
    DefaultTableModel df;
    PreparedStatement extract;
    ResultSet res;
    Statement st;
    public void reset()
    {
        Uid.setText("");
        Uname.setText("");
        Uphone.setText("");
        Uaddress.setText("");
        Upassword.setText("");
    }
    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/bookshop","root","");
            
            
        } 
        
        
        
        
        
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void table_update() {
        int CC;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bookshop","root","");
            extract = con.prepareStatement("SELECT * FROM user");
            res = extract.executeQuery();
            
            ResultSetMetaData RSMD = res.getMetaData();
            CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel) showusers.getModel();
            DFT.setRowCount(0);

            while (res.next()) {
                Vector v2 = new Vector();
           
                for (int ii = 1; ii <= CC; ii++) {
                    v2.add(res.getString("id"));
                    v2.add(res.getString("name"));
                    v2.add(res.getString("phone"));
                    v2.add(res.getString("address"));
                    
                }
                DFT.addRow(v2);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Uname = new javax.swing.JTextField();
        Uphone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        showusers = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        close = new javax.swing.JButton();
        Uid = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Uaddress = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Upassword = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        save = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        remove = new javax.swing.JButton();
        Logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(695, 419));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Unique ID");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Phone");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Address");

        Uphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UphoneActionPerformed(evt);
            }
        });
        Uphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UphoneKeyPressed(evt);
            }
        });

        showusers.setBackground(new java.awt.Color(255, 102, 102));
        showusers.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        showusers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAME", "PHONE", "ADDRESS"
            }
        ));
        showusers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showusersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(showusers);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 0));
        jLabel7.setText("User Registration Form");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/285655_user_icon.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 0));
        jLabel14.setText("Book Store Management Application");

        close.setBackground(new java.awt.Color(204, 255, 204));
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-close-20.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(237, 237, 237)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel7)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(close))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(close)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Uid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UidKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Password");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-details-20.png"))); // NOI18N
        jLabel10.setText("List of enrolled users");

        jLabel4.setText("[Enter a unique id which you want to use as a login id]");

        jLabel9.setText("[Enter your name]");

        jLabel11.setText("[Enter your contact number]");

        jLabel12.setText("[Enter your shipping address]");

        jLabel13.setText("[Enter login password]");

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        save.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-add-30.png"))); // NOI18N
        save.setText("Add");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });

        reset.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-reset-30.png"))); // NOI18N
        reset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetMouseClicked(evt);
            }
        });

        edit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-edit-30.png"))); // NOI18N
        edit.setText("Edit");
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        remove.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-delete-30.png"))); // NOI18N
        remove.setText("Remove");
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMouseClicked(evt);
            }
        });

        Logout.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Logout.setForeground(new java.awt.Color(0, 51, 255));
        Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Bookshop/icons8-exit-30.png"))); // NOI18N
        Logout.setText("Back to Login");
        Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Logout)
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(reset)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(remove)
                        .addComponent(Logout)
                        .addComponent(edit))
                    .addComponent(save))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(117, 117, 117))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Uid, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Uname, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Uphone, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Uaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(Upassword, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Uid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Uphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Uaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Upassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(jLabel13)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutMouseClicked
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogoutMouseClicked

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
        if(Upassword.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Enter password to remove");
        }
        else
        {
            String query="select * from bookshop.user where id='"+Uid.getText()+"'and password='"+Upassword.getText()+"'";
            try {
                con=DriverManager.getConnection("jdbc:mysql://localhost/bookshop","root","");
            } catch (SQLException ex) {
                Logger.getLogger(usersRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                st=con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(usersRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs=st.executeQuery(query);
            } catch (SQLException ex) {
                Logger.getLogger(usersRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                if(rs.next())
                {

                    String uid=Uid.getText();
                    String Query="delete from bookshop.user where id= "+uid;

                    try {
                        st = con.createStatement();
                    } catch (SQLException ex) {
                        Logger.getLogger(usersRegistration.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        st.executeUpdate(Query);
                    } catch (SQLException ex) {
                        Logger.getLogger(usersRegistration.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(this, "User deleted");
                    table_update();

                    reset();

                }
                else{
                    JOptionPane.showMessageDialog(this, "Password invalid");
                }

            } catch (SQLException ex) {
                Logger.getLogger(usersRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_removeMouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed

    }//GEN-LAST:event_editActionPerformed

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
        if(Upassword.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Enter password to edit details");
        }
        else
        {
            String query="select * from bookshop.user where id='"+Uid.getText()+"'and password='"+Upassword.getText()+"'";
            try {
                con=DriverManager.getConnection("jdbc:mysql://localhost/bookshop","root","");
            } catch (SQLException ex) {
                Logger.getLogger(usersRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                st=con.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(usersRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs=st.executeQuery(query);
            } catch (SQLException ex) {
                Logger.getLogger(usersRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if(rs.next())
                {

                    DefaultTableModel model = (DefaultTableModel) showusers.getModel();
                    int selectedIndex = showusers.getSelectedRow();
                    try {

                        int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

                        String uname =Uname.getText();
                        String phn =Uphone.getText();
                        String add =Uaddress.getText();

                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/bookshop","root","");
                        extract = con.prepareStatement("update user set name= ?,phone= ?,address= ? where id= ?");

                        extract.setString(1,uname);
                        extract.setString(2,phn);
                        extract.setString(3,add);
                        extract.setInt(4,id);
                        extract.executeUpdate();
                        JOptionPane.showMessageDialog(this, "User Updated");
                        Uname.setText("");
                        Uphone.setText("");
                        Uaddress.setText("");
                        Uid.setText("");
                        Upassword.setText("");
                        table_update();

                    } catch (ClassNotFoundException | SQLException ex) {}

                }
                else{
                    JOptionPane.showMessageDialog(this,"Password not matching");
                }
            } catch (SQLException ex) {
                Logger.getLogger(usersRegistration.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_editMouseClicked

    private void resetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetMouseClicked
        Uid.setText("");
        Uname.setText("");
        Uphone.setText("");
        Uaddress.setText("");
        Upassword.setText("");
    }//GEN-LAST:event_resetMouseClicked

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        if(Uid.getText().isEmpty()|| Uname.getText().isEmpty()||Uphone.getText().isEmpty()||Uaddress.getText().isEmpty()||Upassword.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Input Error, enter valid details");
        }
        else{
            df = (DefaultTableModel)showusers.getModel();

            df.addRow(new Object[]
                {
                    Uid.getText(),
                    Uname.getText(),
                    Uphone.getText(),
                    Uaddress.getText(),
                    Upassword.getText(),

                });

                try{

                    String query1 = "insert into user(id,name,phone,address,password)values(?,?,?,?,?)";
                    pst1 = con.prepareStatement(query1);

                    pst1.setInt(1, Integer.valueOf(Uid.getText()));

                    pst1.setString(2, Uname.getText());
                    pst1.setString(3, Uphone.getText());
                    pst1.setString(4, Uaddress.getText());
                    pst1.setString(5, Upassword.getText());
                    pst1.executeUpdate();
                    JOptionPane.showMessageDialog(this, "User Added");
                    Uname.setText("");
                    Uphone.setText("");
                    Uaddress.setText("");
                    Uid.setText("");
                    Upassword.setText("");

                }catch (HeadlessException | NumberFormatException | SQLException e){
                }
            }

    }//GEN-LAST:event_saveMouseClicked

    private void UidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UidKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            try {
                String uid= Uid.getText();
                pst = con.prepareStatement("select * from user where id = ?");
                pst.setString(1, uid);
                rs = pst.executeQuery();
                if(rs.next() == false)
                {
                    JOptionPane.showMessageDialog(this, "id not Found");
                }
                else{
                    String uname=rs.getString("name");
                    Uname.setText(uname);
                    String uphone=rs.getString("phone");
                    Uphone.setText(uphone);
                    String uaddress=rs.getString("address");
                    Uaddress.setText(uaddress);

                }

            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_UidKeyPressed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        int result=JOptionPane.showConfirmDialog(null, "Do you want to exit");
        if(result==JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_closeMouseClicked

    private void showusersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showusersMouseClicked
        DefaultTableModel model = (DefaultTableModel) showusers.getModel();
        int selectedIndex = showusers.getSelectedRow();

        Uid.setText(model.getValueAt(selectedIndex, 0).toString());
        Uname.setText(model.getValueAt(selectedIndex, 1).toString());
        Uphone.setText(model.getValueAt(selectedIndex, 2).toString());
        Uaddress.setText(model.getValueAt(selectedIndex, 3).toString());

    }//GEN-LAST:event_showusersMouseClicked

    private void UphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UphoneActionPerformed

    }//GEN-LAST:event_UphoneActionPerformed

    private void UphoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UphoneKeyPressed
         
    }//GEN-LAST:event_UphoneKeyPressed
   
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new usersRegistration().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JTextField Uaddress;
    private javax.swing.JTextField Uid;
    private javax.swing.JTextField Uname;
    private javax.swing.JPasswordField Upassword;
    private javax.swing.JTextField Uphone;
    private javax.swing.JButton close;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton remove;
    private javax.swing.JButton reset;
    private javax.swing.JButton save;
    private javax.swing.JTable showusers;
    // End of variables declaration//GEN-END:variables
}
