/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nihil.RockPaperScissors_USER_LOGON;

/**
 *
 * @author LATITUDE 5410
 */
import javax.swing.*;
import java.awt.*;
import java.sql.*;

import com.nihil.RockPaperScissors.*;
import com.nihil.RockPaperScissors_CODE.Loader;
import java.nio.charset.StandardCharsets;

public class Logon_Signin extends javax.swing.JFrame {

    private Connection connect;
    private Statement state;
    private PreparedStatement prep;
    private ResultSet result;
    private String query;
    private boolean flag = false;
    /**
     * Creates new form Logon_Signin
     */
    public Logon_Signin() {
        this.setUndecorated(true);
        this.setResizable(false);
        this.setTitle("ROCK-PAPER-SCISSORS -> LOGON -> SIGN IN");
        initComponents();
        establishConnection();
        //checkModule();
    }

    public Logon_Signin(Boolean indicator) {
        this.setUndecorated(true);
        this.setResizable(false);
        this.setTitle("ROCK-PAPER-SCISSORS -> LOGON -> SIGN IN");
        initComponents();
        establishConnection();
        flag = indicator;
    }
    private void checkModule() {
        try {
            PreparedStatement stmt = connect.prepareStatement("SELECT CONVERT(VARCHAR(200), DECRYPTBYPASSPHRASE(?, ?)) AS PASSWORD2 FROM PLAYER WHERE PLAYER_ID = ?");
            long playerId = 10011011;
            byte[] playerPassword = "23may1995".getBytes();
            stmt.setString(1, "password"); // Set the passphrase
            stmt.setBytes(2, playerPassword); // Set the ciphertext
            stmt.setLong(3, playerId); // Set the player ID

            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                System.out.println("Decrypted password: " + result.getString("PASSWORD2"));
                System.out.println("Decrypted password: " + result.getBytes("PASSWORD2"));
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        contentPane = new javax.swing.JPanel();
        headerLbl = new javax.swing.JLabel();
        motherPnl = new javax.swing.JPanel();
        emailtxt = new javax.swing.JTextField();
        passwordtxt = new javax.swing.JPasswordField();
        signInControl = new javax.swing.JLabel();
        signupControl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cancelControl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPane.setBackground(new java.awt.Color(41, 41, 41));

        headerLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 44)); // NOI18N
        headerLbl.setForeground(new java.awt.Color(255, 255, 255));
        headerLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLbl.setText("ROCK-PAPER-SCISSORS");
        headerLbl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 255)));

        motherPnl.setBackground(new java.awt.Color(41, 41, 41));
        motherPnl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        emailtxt.setBackground(new java.awt.Color(41, 41, 41));
        emailtxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        emailtxt.setForeground(new java.awt.Color(255, 255, 255));
        emailtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailtxt.setText("EMAIL");
        emailtxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 0, 204)));
        emailtxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                emailtxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                emailtxtMouseExited(evt);
            }
        });

        passwordtxt.setBackground(new java.awt.Color(41, 41, 41));
        passwordtxt.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        passwordtxt.setForeground(new java.awt.Color(255, 255, 255));
        passwordtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordtxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 0, 204)));
        passwordtxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                passwordtxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                passwordtxtMouseExited(evt);
            }
        });
        passwordtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordtxtKeyPressed(evt);
            }
        });

        signInControl.setBackground(new java.awt.Color(41, 41, 41));
        signInControl.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        signInControl.setForeground(new java.awt.Color(255, 255, 255));
        signInControl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signInControl.setText("SIGN IN");
        signInControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signInControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signInControlMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout motherPnlLayout = new javax.swing.GroupLayout(motherPnl);
        motherPnl.setLayout(motherPnlLayout);
        motherPnlLayout.setHorizontalGroup(
            motherPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(motherPnlLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(motherPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(signInControl, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        motherPnlLayout.setVerticalGroup(
            motherPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(motherPnlLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(signInControl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        signupControl.setBackground(new java.awt.Color(41, 41, 41));
        signupControl.setForeground(new java.awt.Color(255, 255, 255));
        signupControl.setText(" Sign Up.");
        signupControl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(255, 153, 255)));
        signupControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signupControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupControlMouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(41, 41, 41));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dont have an account? No warries CLICK HERE ->");

        cancelControl.setBackground(new java.awt.Color(41, 41, 41));
        cancelControl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelControl.setForeground(new java.awt.Color(255, 255, 255));
        cancelControl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelControl.setText("CANCEL");
        cancelControl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 102, 255)));
        cancelControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelControlMouseClicked(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(41, 41, 41));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Please enter you login details to access you account.");

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(motherPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(signupControl, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cancelControl, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(48, 48, 48)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(motherPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelControl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signupControl)
                    .addComponent(jLabel1))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailtxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailtxtMouseEntered
        if (emailtxt.getText().length() == 0 || emailtxt.getText().equals("EMAIL")) {
            emailtxt.setText(null);
            emailtxt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255, 255, 255)));
        }
    }//GEN-LAST:event_emailtxtMouseEntered

    private void emailtxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_emailtxtMouseExited
        if (emailtxt.getText().length() == 0) {
            emailtxt.setText("EMAIL");
            emailtxt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 0, 204)));
        }
    }//GEN-LAST:event_emailtxtMouseExited

    private void passwordtxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordtxtMouseEntered
        passwordtxt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255, 255, 255)));
    }//GEN-LAST:event_passwordtxtMouseEntered

    private void passwordtxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordtxtMouseExited
        passwordtxt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 0, 204)));
    }//GEN-LAST:event_passwordtxtMouseExited

    private void passwordtxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordtxtKeyPressed

    }//GEN-LAST:event_passwordtxtKeyPressed
    private void establishConnection() {
        final String url = "jdbc:sqlserver://DESKTOP-LUKU6V1; Database=RockPaperScissorsDATABASE; IntegratedSecurity=false; Encrypt=True; TrustServerCertificate=True";
        String dbUsername = "sa";
        String dbPassword = "securityTrue";
        try {
            connect = DriverManager.getConnection(url, dbUsername, dbPassword);
            System.out.println("CONNECTION ESTABLISHED SUCCESSFULY");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }

    private void signInControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signInControlMouseClicked
        Player player = new Player();
        if (flag == true) {
            //READ USER DETAILS
               new SettingsBoard(player).setVisible(true);
               dispose();
        } else {
            try {
                if (emailtxt.getText().equals(null) || emailtxt.getText().equals("EMAIL")
                        || passwordtxt.getText().equals(null)) {
                    JOptionPane.showMessageDialog(null, "Please ensure that all fields are filled with data", "FIELD INCOMPLETE ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    //query = "SELECT * FROM PLAYER WHERE PLAYER_EMAIL = '" + emailtxt.getText() + "'";
                    query = "SELECT * FROM ANOTHER_PLAYER "
                            + "WHERE CONVERT( VARCHAR(200), DECRYPTBYPASSPHRASE('password', PLAYER_PASSWORD)) LIKE  '%" + 2003002 + "%'";

                    prep = connect.prepareStatement(query);
                    result = prep.executeQuery();
                    while (result.next()) {
                        player.setPlayerID(result.getLong("PLAYER_ID"));
                        player.setName(result.getString("PLAYER_NAME"));
                        player.setLastname(result.getString("PLAYER_LASTNAME"));
                        player.setEmail(result.getString("PLAYER_EMAIL"));
                        byte[] passwordVarbinary = result.getBytes("PLAYER_PASSWORD");
                        String pswrd = new String(passwordVarbinary, StandardCharsets.UTF_8);
                        System.out.println(pswrd);
                        player.setPassword(result.getString("PLAYER_PASSWORD"));
                        player.setLastLogon(result.getString("PLAYER_LASTLOGON"));
                        player.setJoinedDate(result.getString("PLAYER_JOINDATE"));
                        player.setPlays(result.getInt("PLAYER_PLAYS"));
                    }
                    new Loader(player).setVisible(true);
                    dispose();
                }
                if (player.getEmail().equalsIgnoreCase(emailtxt.getText())) {// && player.getPassword().equals(passwordtxt.getText())){
                    System.out.println(player.toString());
                } else {
                    System.out.println("User not found");
                }

                System.out.println(player.toString());
            } catch (SQLException error) {
                System.out.println(error.getMessage());
            }
        }
    }//GEN-LAST:event_signInControlMouseClicked

//    static public void main(String... m) {
//        new Logon_Signin().setVisible(true);
//    }

    private void cancelControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelControlMouseClicked
        dispose();
        new MenuBoard().setVisible(true);
    }//GEN-LAST:event_cancelControlMouseClicked

    private void signupControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupControlMouseClicked
        new Logon_Signup().setVisible(true);
        dispose();
    }//GEN-LAST:event_signupControlMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cancelControl;
    private javax.swing.JPanel contentPane;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JLabel headerLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel motherPnl;
    private javax.swing.JPasswordField passwordtxt;
    private javax.swing.JLabel signInControl;
    private javax.swing.JLabel signupControl;
    // End of variables declaration//GEN-END:variables
}