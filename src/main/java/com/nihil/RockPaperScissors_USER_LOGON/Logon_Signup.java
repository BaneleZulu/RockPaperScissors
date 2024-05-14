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
import com.nihil.RockPaperScissors_CODE.*;
import java.sql.*;
import java.util.Date;

public class Logon_Signup extends javax.swing.JFrame {

    /**
     * Creates new form Logon
     */
    private Connection connect;
    private Statement state;
    private PreparedStatement prep;
    private ResultSet result;
    private String query;
    private String password = null;
    private int count = 0;

    public Logon_Signup() {
        this.setUndecorated(true);
        this.setResizable(false);
        this.setTitle("ROCK-PAPER-SCISSORS -> LOGON -> SIGN UP");
        initComponents();
        establishConnection();
        //dbReader();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPanel = new javax.swing.JPanel();
        headerLbl = new javax.swing.JLabel();
        subHeaderLbl = new javax.swing.JLabel();
        motherPnl = new javax.swing.JPanel();
        nametxt = new javax.swing.JTextField();
        lastnametxt = new javax.swing.JTextField();
        emailtxt = new javax.swing.JTextField();
        passwordtxt = new javax.swing.JPasswordField();
        passwordStatusPnl = new javax.swing.JPanel();
        passwordStatusLbl = new javax.swing.JLabel();
        strongPnl = new RoundedPanel(100);
        mediumPnl = new RoundedPanel(100);
        weakPnl = new RoundedPanel(100);
        confirmPasswordtxt = new javax.swing.JPasswordField();
        signUpControl = new javax.swing.JLabel();
        cancelControl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        signinControl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPanel.setBackground(new java.awt.Color(41, 41, 41));
        contentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headerLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 44)); // NOI18N
        headerLbl.setForeground(new java.awt.Color(255, 255, 255));
        headerLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLbl.setText("ROCK-PAPER-SCISSORS");
        headerLbl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 255)));
        contentPanel.add(headerLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 505, 65));

        subHeaderLbl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        subHeaderLbl.setForeground(new java.awt.Color(255, 255, 255));
        subHeaderLbl.setText("Hello and Welcome!, Create an account to keep track of your game data.");
        contentPanel.add(subHeaderLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 77, 400, 20));

        motherPnl.setBackground(new java.awt.Color(41, 41, 41));
        motherPnl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nametxt.setBackground(new java.awt.Color(41, 41, 41));
        nametxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nametxt.setForeground(new java.awt.Color(255, 255, 255));
        nametxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nametxt.setText("FIRSTNAME");
        nametxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 0, 204)));
        nametxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nametxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nametxtMouseExited(evt);
            }
        });

        lastnametxt.setBackground(new java.awt.Color(41, 41, 41));
        lastnametxt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lastnametxt.setForeground(new java.awt.Color(255, 255, 255));
        lastnametxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lastnametxt.setText("LASTNAME");
        lastnametxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 0, 204)));
        lastnametxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lastnametxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lastnametxtMouseExited(evt);
            }
        });

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
        passwordtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordtxtActionPerformed(evt);
            }
        });
        passwordtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordtxtKeyPressed(evt);
            }
        });

        passwordStatusPnl.setBackground(new java.awt.Color(41, 41, 41));
        passwordStatusPnl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        passwordStatusLbl.setBackground(new java.awt.Color(41, 41, 41));
        passwordStatusLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 16)); // NOI18N
        passwordStatusLbl.setForeground(new java.awt.Color(255, 255, 255));
        passwordStatusLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordStatusLbl.setText("PASSWORD STATUS");

        strongPnl.setBackground(new java.awt.Color(41, 41, 41));

        javax.swing.GroupLayout strongPnlLayout = new javax.swing.GroupLayout(strongPnl);
        strongPnl.setLayout(strongPnlLayout);
        strongPnlLayout.setHorizontalGroup(
            strongPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );
        strongPnlLayout.setVerticalGroup(
            strongPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        mediumPnl.setBackground(new java.awt.Color(41, 41, 41));

        javax.swing.GroupLayout mediumPnlLayout = new javax.swing.GroupLayout(mediumPnl);
        mediumPnl.setLayout(mediumPnlLayout);
        mediumPnlLayout.setHorizontalGroup(
            mediumPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        mediumPnlLayout.setVerticalGroup(
            mediumPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        weakPnl.setBackground(new java.awt.Color(41, 41, 41));

        javax.swing.GroupLayout weakPnlLayout = new javax.swing.GroupLayout(weakPnl);
        weakPnl.setLayout(weakPnlLayout);
        weakPnlLayout.setHorizontalGroup(
            weakPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        weakPnlLayout.setVerticalGroup(
            weakPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout passwordStatusPnlLayout = new javax.swing.GroupLayout(passwordStatusPnl);
        passwordStatusPnl.setLayout(passwordStatusPnlLayout);
        passwordStatusPnlLayout.setHorizontalGroup(
            passwordStatusPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, passwordStatusPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(weakPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mediumPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(strongPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(passwordStatusLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        passwordStatusPnlLayout.setVerticalGroup(
            passwordStatusPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordStatusPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(passwordStatusPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordStatusLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addGroup(passwordStatusPnlLayout.createSequentialGroup()
                        .addGroup(passwordStatusPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(weakPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mediumPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(strongPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        confirmPasswordtxt.setBackground(new java.awt.Color(41, 41, 41));
        confirmPasswordtxt.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        confirmPasswordtxt.setForeground(new java.awt.Color(255, 255, 255));
        confirmPasswordtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        confirmPasswordtxt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 0, 204)));
        confirmPasswordtxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmPasswordtxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmPasswordtxtMouseExited(evt);
            }
        });

        signUpControl.setBackground(new java.awt.Color(41, 41, 41));
        signUpControl.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        signUpControl.setForeground(new java.awt.Color(255, 255, 255));
        signUpControl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signUpControl.setText("SIGN UP");
        signUpControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signUpControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpControlMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout motherPnlLayout = new javax.swing.GroupLayout(motherPnl);
        motherPnl.setLayout(motherPnlLayout);
        motherPnlLayout.setHorizontalGroup(
            motherPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(motherPnlLayout.createSequentialGroup()
                .addGroup(motherPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(motherPnlLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(motherPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordStatusPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordtxt)
                            .addComponent(confirmPasswordtxt)
                            .addComponent(signUpControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(motherPnlLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(motherPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lastnametxt)
                            .addComponent(emailtxt)
                            .addComponent(nametxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        motherPnlLayout.setVerticalGroup(
            motherPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(motherPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lastnametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(emailtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(passwordStatusPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(confirmPasswordtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(signUpControl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        contentPanel.add(motherPnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 470, 450));

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
        contentPanel.add(cancelControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, 413, 20));

        jLabel1.setBackground(new java.awt.Color(41, 41, 41));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Already have an account?");
        contentPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 140, -1));

        signinControl.setBackground(new java.awt.Color(41, 41, 41));
        signinControl.setForeground(new java.awt.Color(255, 255, 255));
        signinControl.setText(" Sign In.");
        signinControl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(255, 153, 255)));
        signinControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signinControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signinControlMouseClicked(evt);
            }
        });
        contentPanel.add(signinControl, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 600, 70, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nametxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nametxtMouseEntered
        if (nametxt.getText().length() == 0 || nametxt.getText().equals("FIRSTNAME")) {
            nametxt.setText(null);
            nametxt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255, 255, 255)));
        }
    }//GEN-LAST:event_nametxtMouseEntered

    private void nametxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nametxtMouseExited
        if (nametxt.getText().length() == 0) {
            nametxt.setText("FIRSTNAME");
            nametxt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 0, 204)));
        }
    }//GEN-LAST:event_nametxtMouseExited

    private void lastnametxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastnametxtMouseEntered
        if (lastnametxt.getText().length() == 0 || lastnametxt.getText().equals("LASTNAME")) {
            lastnametxt.setText(null);
            lastnametxt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255, 255, 255)));
        }
    }//GEN-LAST:event_lastnametxtMouseEntered

    private void lastnametxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lastnametxtMouseExited
        if (lastnametxt.getText().length() == 0) {
            lastnametxt.setText("LASTNAME");
            lastnametxt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 0, 204)));
        }
    }//GEN-LAST:event_lastnametxtMouseExited

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

    private void signUpControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpControlMouseClicked
        Player player = new Player();
        try {

            if (!nametxt.getText().equals(null) || !nametxt.getText().equals("FIRSTNAME")
                    || !lastnametxt.getText().equals(null) || !lastnametxt.getText().equals("LASTNAME")
                    || !emailtxt.getText().equals(null) || !emailtxt.getText().equals("EMAIL")
                    || !passwordtxt.getText().equals(null) || !passwordtxt.getText().equals("PASSWORD")
                    || !confirmPasswordtxt.getText().equals(null) || !confirmPasswordtxt.getText().equals("CONFIRM PASSWORD")) {
                player.setName(nametxt.getText());
                player.setLastname(lastnametxt.getText());
                player.setEmail(emailtxt.getText());
                player.setPassword(passwordtxt.getText());

                if (!passwordtxt.getText().equals(confirmPasswordtxt.getText())) {
                    JOptionPane.showMessageDialog(null, "You entered an un-identical confirmation password!", "ERROR PASSWORD ENTERED", JOptionPane.ERROR_MESSAGE);
                    passwordtxt.setText(null);
                    confirmPasswordtxt.setText(null);
                } else {
                    playerCreator(player);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Incomplete information entered. Please ensure you filled all fields!", "ERROR PASSWORD ENTERED", JOptionPane.WARNING_MESSAGE);
            }
        } catch (HeadlessException error) {
            System.out.println(error.getMessage());
        }
    }//GEN-LAST:event_signUpControlMouseClicked

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

    private void playerCreator(Player player) {
        try {
            Date now = new Date();

            query = "INSERT INTO PLAYER(PLAYER_NAME, PLAYER_LASTNAME, PLAYER_EMAIL, PLAYER_PASSWORD, PLAYER_LASTLOGON, PLAYER_JOINDATE)" +
                    "VALUES(?,?,?,ENCRYPTBYPASSPHRASE('password', ?),?,?)";
            prep = connect.prepareStatement(query);

            prep.setString(1, player.getName());
            prep.setString(2, player.getLastname());
            prep.setString(3, player.getEmail());
            byte[] passwordVarbinary = player.getPassword().getBytes();
            prep.setBytes(4, passwordVarbinary);
            prep.setString(5, now.toLocaleString());
            prep.setString(6, now.toString());

            System.out.println(player.toString());
            prep.executeUpdate();
            JOptionPane.showMessageDialog(null, "Woooooo!!!\nGreat " + player.getName().toUpperCase() + " you just created your account.\n You can now track you user data and modifiy it how you see fit.\n Also more fetures are now unlocked.", "USER ACCOUNT CREATED SUCCESSFULLY", JOptionPane.INFORMATION_MESSAGE);
            connect.close();
            prep.close();
            JOptionPane.showMessageDialog(null, "Login to access your account.", "SIGN IN TO ACCESS YOUR ACCOUNT", JOptionPane.PLAIN_MESSAGE);
            dispose();
            new Logon_Signin().setVisible(true);
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    private void dbReader() {
        try {
            //query = "SELECT CONVERT (VARCHAR(200), DECRYPTBYPASSPHRASE('password', PLAYER_PASSWORD)), *  FROM PLAYER;";
            query = "SELECT * FROM PLAYER;";
            prep = connect.prepareCall(query);
            result = prep.executeQuery();
            while (result.next()) {
                byte[] ps = result.getBytes("PLAYER_PASSWORD");
                String pswrd = ps.toString();
                System.out.println(ps + " <|||>\n");
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    static public void main(String... m) {
        new Logon_Signup().setVisible(true);
    }

    private void cancelControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelControlMouseClicked
        dispose();
    }//GEN-LAST:event_cancelControlMouseClicked

    private void passwordtxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordtxtMouseEntered
        passwordtxt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255, 255, 255)));
    }//GEN-LAST:event_passwordtxtMouseEntered

    private void passwordtxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordtxtMouseExited
        passwordtxt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 0, 204)));
    }//GEN-LAST:event_passwordtxtMouseExited

    private void passwordtxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordtxtKeyPressed
        password = passwordtxt.getText();
        for (int r = 0; r < password.length(); r++) {
            count = r;
        }
        passwordStrength(password, count);
    }//GEN-LAST:event_passwordtxtKeyPressed

    private void confirmPasswordtxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmPasswordtxtMouseEntered
        confirmPasswordtxt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(255, 255, 255)));
    }//GEN-LAST:event_confirmPasswordtxtMouseEntered

    private void confirmPasswordtxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmPasswordtxtMouseExited
        confirmPasswordtxt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 0, 204)));
    }//GEN-LAST:event_confirmPasswordtxtMouseExited

    private void passwordtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordtxtActionPerformed
    }//GEN-LAST:event_passwordtxtActionPerformed

    private void signinControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signinControlMouseClicked
        new Logon_Signin().setVisible(true);
        dispose();
    }//GEN-LAST:event_signinControlMouseClicked

    private void passwordStrength(String password, int count) {
        class CheckPassword extends Thread {

            int track = count;

            @Override
            public void run() {
                if (track > 0 || track < 4) {
                    weakPnl.setBackground(new Color(220, 20, 60));
                    weakPnl.show();
                    mediumPnl.hide();
                    passwordStatusLbl.setText("Weak");
                    passwordStatusLbl.setForeground(weakPnl.getBackground());
                }
                if (track > 7) {
                    mediumPnl.show();
                    strongPnl.hide();
                    mediumPnl.setBackground(new Color(225, 127, 0));
                    passwordStatusLbl.setText("Medium");
                    passwordStatusLbl.setForeground(mediumPnl.getBackground());
                }
                if (password.length() > 10) {
                    char[] passwordLetters = new char[passwordtxt.getText().length()];
                    boolean isSecured = false;
                    for (int run = 0; run < passwordLetters.length; run++) {
                        passwordLetters[run] = passwordtxt.getText().charAt(run);
                    }
                    for (int run = 0; run < passwordLetters.length; run++) {
                        if (Character.isUpperCase(passwordLetters[run]) || Character.isDigit(passwordLetters[run]) && Character.isLetter(passwordLetters[run])) {
                            isSecured = true;
                        }
                    }
                    if (isSecured == true) {
                        strongPnl.show();
                        strongPnl.setBackground(new Color(50, 205, 50));
                        passwordStatusLbl.setText("Strong");
                        passwordStatusLbl.setForeground(strongPnl.getBackground());
                    }
                }
                if (track == 0) {
                    passwordStatusLbl.setText(null);
                    weakPnl.hide();
                    mediumPnl.hide();
                    strongPnl.hide();
                }
            }
        }
        CheckPassword inn = new CheckPassword();
        inn.start();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cancelControl;
    private javax.swing.JPasswordField confirmPasswordtxt;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JTextField emailtxt;
    private javax.swing.JLabel headerLbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField lastnametxt;
    private javax.swing.JPanel mediumPnl;
    private javax.swing.JPanel motherPnl;
    private javax.swing.JTextField nametxt;
    private javax.swing.JLabel passwordStatusLbl;
    private javax.swing.JPanel passwordStatusPnl;
    private javax.swing.JPasswordField passwordtxt;
    private javax.swing.JLabel signUpControl;
    private javax.swing.JLabel signinControl;
    private javax.swing.JPanel strongPnl;
    private javax.swing.JLabel subHeaderLbl;
    private javax.swing.JPanel weakPnl;
    // End of variables declaration//GEN-END:variables
}
