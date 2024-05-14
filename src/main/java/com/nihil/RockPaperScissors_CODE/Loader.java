package com.nihil.RockPaperScissors_CODE;

import javax.swing.*;
import java.awt.*;

import com.nihil.RockPaperScissors.GameBoard;
import com.nihil.RockPaperScissors_USER_LOGON.Player;

public class Loader extends JFrame {

    private final JProgressBar bar;

    public Loader(Player player) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setUndecorated(true);
        this.setSize(550, 250);
        this.setTitle("GETTING YOUR DATA.....");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        this.setLayout(null);

        bar = new JProgressBar();
        bar.setValue(0);
        bar.setStringPainted(true);
        bar.setBackground(new Color(255, 255, 255));
        bar.setForeground(new Color(102, 0, 102));
        bar.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 23));
        bar.setBounds(0, 50, 550, 50);

        JLabel lbl = new JLabel();
        lbl.setText("RETRIVING PLAYER DATA.............");
        lbl.setBounds(160, 180, 300, 10);
        lbl.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 10));

        this.add(bar);
        this.add(lbl);
        this.setVisible(true);
        fill(player);

    }

    private void fill(Player player) {

        final class MyThread extends Thread {

            @Override
            public void run() {

                int counter = 0;
                while (counter <= 100) {
                    bar.setValue(counter);
                    try {
                        counter++;
                        Thread.sleep(100);
                    } catch (InterruptedException error) {
                        JOptionPane.showMessageDialog(null, "ACTION FAILED", "ERROR OCCURED", JOptionPane.ERROR_MESSAGE);
                        System.out.println(error.getMessage());
                    }
                }

                bar.setString("DATA READY! :)");
                //new TransactionHistory().setVisible(true);
                dispose();
                new GameBoard(player).setVisible(true);
            }
        }
        MyThread thread = new MyThread();
        thread.start();
    }
//    static public void main(String...main)
//    {
//        new Loader().setVisible(true);
////        Date now = new Date();
////        System.out.println("Milliseconds :" + now.getTime());
////        System.out.println("Time : " + now.toGMTString());
//        
//    }  
}
