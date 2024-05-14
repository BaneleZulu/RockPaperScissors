/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nihil.RockPaperScissors;

/**
 *
 * @author LATITUDE 5410
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.*;

import com.nihil.RockPaperScissors_USER_LOGON.*;
import com.nihil.RockPaperScissors_CODE.*;

public class MenuBoard extends javax.swing.JFrame {

    private Connection connect;
    private Statement state;
    private PreparedStatement prep;
    private ResultSet result;
    private String query;
    private Player player;

    /**
     * Creates new form MenuBoard
     */
    public MenuBoard() {
        this.setUndecorated(true);
        this.setResizable(false);
        this.setTitle("MENUBOARD");
        initComponents();
        //establishConnection();
        editingLabelIcons();
    }

    private void editingLabelIcons() {
        try {

            JLabel[] pictureLbl = new JLabel[]{playImg, continueImg, settingsImg, exitImg};
            String[] iconURLs = new String[] {"src\\main\\java\\Images\\play-button.png", 
                                              "src\\main\\java\\Images\\synergy.png", 
                                              "src\\main\\java\\Images\\setting.png", 
                                              "src\\main\\java\\Images\\cross.png"};
            for (int run = 0; run < pictureLbl.length; run++) {
                BufferedImage imgPlay = ImageIO.read(new File(iconURLs[run]));
                Image sizedImgPlay = imgPlay.getScaledInstance(pictureLbl[run].getWidth() - 0, pictureLbl[run].getHeight() - 0, Image.SCALE_SMOOTH);
                ImageIcon iconPlay = new ImageIcon(sizedImgPlay);
                pictureLbl[run].setIcon(iconPlay);
            }

        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    private void establishConnection() {
        final String url = "jdbc:sqlserver://DESKTOP-LUKU6V1; Database=RockPaperScissorsDATABASE; IntegratedSecurity=false; Encrypt=True; TrustServerCertificate=True";
        String username = "sa";
        String password = "securityTrue";
        try {
            connect = DriverManager.getConnection(url, username, password);
            System.out.println("CONNECTION ESTABLISHED SUCCESSFULY");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
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

        contentPane = new javax.swing.JPanel();
        copyrightsLbl = new javax.swing.JLabel();
        devLbl = new javax.swing.JLabel();
        headerLbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        continueControl = new javax.swing.JLabel();
        settingsControl = new javax.swing.JLabel();
        playControl = new javax.swing.JLabel();
        exitControl = new javax.swing.JLabel();
        usermanualsControl = new javax.swing.JLabel();
        settingsImg = new javax.swing.JLabel();
        playImg = new javax.swing.JLabel();
        exitImg = new javax.swing.JLabel();
        continueImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        contentPane.setBackground(new java.awt.Color(51, 51, 51));

        copyrightsLbl.setBackground(new java.awt.Color(204, 204, 204));
        copyrightsLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        copyrightsLbl.setForeground(new java.awt.Color(204, 204, 204));
        copyrightsLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        copyrightsLbl.setText("CopyRight 2023");

        devLbl.setBackground(new java.awt.Color(204, 204, 204));
        devLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        devLbl.setForeground(new java.awt.Color(204, 204, 204));
        devLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        devLbl.setText("Developer: NIHIL (‎Wednesday, ‎20 ‎December ‎2023, ‏‎23:29:44)");

        headerLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 44)); // NOI18N
        headerLbl.setForeground(new java.awt.Color(255, 255, 255));
        headerLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLbl.setText("ROCK-PAPER-SCISSORS");
        headerLbl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 204)));

        jPanel1.setBackground(new java.awt.Color(41, 41, 41));

        continueControl.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
        continueControl.setForeground(new java.awt.Color(224, 224, 224));
        continueControl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        continueControl.setText("CONTINUE");
        continueControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        continueControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                continueControlMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                continueControlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                continueControlMouseExited(evt);
            }
        });

        settingsControl.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
        settingsControl.setForeground(new java.awt.Color(224, 224, 224));
        settingsControl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settingsControl.setText("SETTINGS");
        settingsControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        settingsControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsControlMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingsControlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingsControlMouseExited(evt);
            }
        });

        playControl.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
        playControl.setForeground(new java.awt.Color(224, 224, 224));
        playControl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playControl.setText("PLAY");
        playControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playControlMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                playControlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                playControlMouseExited(evt);
            }
        });

        exitControl.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
        exitControl.setForeground(new java.awt.Color(224, 224, 224));
        exitControl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitControl.setText("EXIT");
        exitControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitControlMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitControlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitControlMouseExited(evt);
            }
        });

        usermanualsControl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usermanualsControl.setForeground(new java.awt.Color(255, 102, 255));
        usermanualsControl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usermanualsControl.setText("USER MANUALS");
        usermanualsControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usermanualsControl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usermanualsControlMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(continueImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playImg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(continueControl, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playControl, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(settingsImg, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(settingsControl, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(exitImg, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(usermanualsControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(350, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playImg, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(playControl, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(continueControl, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(continueImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(settingsImg, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settingsControl, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exitControl, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addComponent(usermanualsControl)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(copyrightsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(devLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(copyrightsLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(devLbl)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //LOGON ANNONYMOUS
    private void playControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playControlMouseClicked
        dispose();
        new GameBoard().setVisible(true);
    }//GEN-LAST:event_playControlMouseClicked

    private void playControlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playControlMouseEntered
        playControl.setForeground(Color.BLUE);
        playControl.setFont(new java.awt.Font("Showcard Gothic", 0, 38)); // NOI18N
    }//GEN-LAST:event_playControlMouseEntered

    private void playControlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playControlMouseExited
        playControl.setForeground(new Color(221,221,221));
        playControl.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
    }//GEN-LAST:event_playControlMouseExited

    //LOGON WITH AUTHENTIATION
    private void continueControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueControlMouseClicked
        dispose();
        new Logon_Signin().setVisible(true);
    }//GEN-LAST:event_continueControlMouseClicked

    private void continueControlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueControlMouseEntered
        continueControl.setForeground(Color.GREEN);
        continueControl.setFont(new java.awt.Font("Showcard Gothic", 0, 38)); // NOI18N
    }//GEN-LAST:event_continueControlMouseEntered

    private void continueControlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueControlMouseExited
        continueControl.setForeground(new Color(221,221,221));
        continueControl.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
    }//GEN-LAST:event_continueControlMouseExited

    private void settingsControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsControlMouseClicked
       // new SettingsBoard(true).setVisible(true);
       new Logon_Signin(true).setVisible(true);
       
    }//GEN-LAST:event_settingsControlMouseClicked

    private void settingsControlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsControlMouseEntered
        settingsControl.setForeground(Color.GRAY);
        settingsControl.setFont(new java.awt.Font("Showcard Gothic", 0, 38)); // NOI18N
    }//GEN-LAST:event_settingsControlMouseEntered

    private void settingsControlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsControlMouseExited
        settingsControl.setForeground(new Color(221,221,221));
        settingsControl.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
    }//GEN-LAST:event_settingsControlMouseExited

    private void exitControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitControlMouseClicked
        try{
//            connect.close();
//            state.close();
//            prep.close();
//            result.close();
            this.dispose();
        }
        catch(Exception error){}
    }//GEN-LAST:event_exitControlMouseClicked

    private void exitControlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitControlMouseEntered
        exitControl.setForeground(Color.RED);
        exitControl.setFont(new java.awt.Font("Showcard Gothic", 0, 38)); // NOI18N
    }//GEN-LAST:event_exitControlMouseEntered

    private void exitControlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitControlMouseExited
        exitControl.setForeground(new Color(221,221,221));
        exitControl.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
    }//GEN-LAST:event_exitControlMouseExited

    private void usermanualsControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usermanualsControlMouseClicked
       new UsermanualsPln().setVisible(true);
    }//GEN-LAST:event_usermanualsControlMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel continueControl;
    private javax.swing.JLabel continueImg;
    private javax.swing.JLabel copyrightsLbl;
    private javax.swing.JLabel devLbl;
    private javax.swing.JLabel exitControl;
    private javax.swing.JLabel exitImg;
    private javax.swing.JLabel headerLbl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel playControl;
    private javax.swing.JLabel playImg;
    private javax.swing.JLabel settingsControl;
    private javax.swing.JLabel settingsImg;
    private javax.swing.JLabel usermanualsControl;
    // End of variables declaration//GEN-END:variables
}
