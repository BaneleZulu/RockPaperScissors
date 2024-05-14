/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nihil.RockPaperScissors;

/**
 *
 * @author LATITUDE 5410
 */
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.util.Date;
import java.util.Random;
import com.nihil.RockPaperScissors_CODE.RoundedPanel;
import com.nihil.RockPaperScissors_USER_LOGON.*;
import java.io.IOException;

public class GameBoard extends javax.swing.JFrame {

    /**
     * Creates new form GameBoard
     */
    private final String rockURL = "C:/Users/LATITUDE 5410/netBeans/netBeans-Programs/ROCK_PAPER_SCISSORS/src/main/java/Images/rock.jpeg";
    private final String paperURL = "C:/Users/LATITUDE 5410/netBeans/netBeans-Programs/ROCK_PAPER_SCISSORS/src/main/java/Images/paper.jpeg";
    private final String scissorURL = "C:/Users/LATITUDE 5410/netBeans/netBeans-Programs/ROCK_PAPER_SCISSORS/src/main/java/Images/scissors.jpeg";
    private Random anything = new Random();
    private int index=0, 
                playerScore=0, cpuScore=0,
                roundCount=1;

    private BufferedImage imgPlay;
    private Image sizedImgPlay;
    private ImageIcon iconPlay;
    
    public GameBoard(Player player) {
        this.setUndecorated(true);
        this.setResizable(false);
        this.setTitle("ROCK-PAPER-SCISSORS -> GAMEBOARD");
        ImageIcon icon = new ImageIcon("C:\\Users\\LATITUDE 5410\\netBeans\\netBeans-Programs\\ROCK_PAPER_SCISSORS\\src\\main\\java\\Images\\Rock-paper-scissors.svg.png");
        this.setIconImage(icon.getImage());
        initComponents();
        upTimeCounter();
    }
    
    public GameBoard() {
        this.setUndecorated(true);
        this.setResizable(false);
        this.setTitle("ROCK-PAPER-SCISSORS -> GAMEBOARD");
        ImageIcon icon = new ImageIcon("C:\\Users\\LATITUDE 5410\\netBeans\\netBeans-Programs\\ROCK_PAPER_SCISSORS\\src\\main\\java\\Images\\Rock-paper-scissors.svg.png");
        this.setIconImage(icon.getImage());
        initComponents();
        userInformationPnl.hide();
        timePnl.hide();
        
        playerIDtxt.setText("LOGON");
        usernamelbl.setText("Annonymous");
        datelbl.setText(new Date().toString());
        try{
            String unregisteredUser = "C:/Users/LATITUDE 5410/netBeans/netBeans-Programs/ROCK_PAPER_SCISSORS/src/main/java/Images/addUser.jpg";
            imgPlay = ImageIO.read(new File(unregisteredUser));
            sizedImgPlay = sizedImgPlay = imgPlay.getScaledInstance(userImg.getWidth() - 2, userImg.getHeight() - 2, Image.SCALE_SMOOTH);
            icon = new ImageIcon(sizedImgPlay);
            userImg.setIcon(icon);
        }
        catch(IOException error) {System.out.println(error.getMessage());}
    }


    private void upTimeCounter() 
    {
        final class MyThread extends Thread {
            @Override
            public void run() 
            {
                int second=0, minute=0, hour=0;
                while (true) {
                    try {
                        second++;
                        secLbl.setText(String.valueOf(second));
                        if(second == 60){
                            second = 0;
                            minute = minute + 1;
                            minLbl.setText("0" + String.valueOf(minute));
                            if(minute>9){
                                 minLbl.setText(String.valueOf(minute));
                            }
                        }
                        if(minute == 60){
                            minute = 0;
                            hour = hour + 1;
                            hrLbl.setText("0" + String.valueOf(hour));
                            if(hour>9){
                                 hrLbl.setText(String.valueOf(hour));
                            }
                        }
                        Thread.sleep(1_000);
                    } catch (InterruptedException error) {
                        System.out.println(error.getMessage());
                    }
                }
            }
        }
        MyThread thread = new MyThread();
        thread.start();
    }
    
    private void playerPlay(String handURL) {
        try {
            imgPlay = ImageIO.read(new File(handURL));
            sizedImgPlay = imgPlay.getScaledInstance(playerHand.getWidth() - 0, playerHand.getHeight() - 0, Image.SCALE_SMOOTH);
            iconPlay = new ImageIcon(sizedImgPlay);
            playerHand.setIcon(iconPlay);

            Thread.sleep(200);
            playerThrownHand.setText(this.setPlayerHandLbl(handURL));
            computerPlay();
        } catch (IOException | InterruptedException error) {
            System.out.println(error.getMessage());
        }
    }

    private void computerPlay() {
        try {
            /**
             * *****COMPUTER PLAY*******
             */
            String[] cpuPlays = new String[]{rockURL, paperURL, scissorURL, paperURL, rockURL, scissorURL};
                index = anything.nextInt(6);
                imgPlay = ImageIO.read(new File(cpuPlays[index]));
                sizedImgPlay = sizedImgPlay = imgPlay.getScaledInstance(cpuHand.getWidth() - 0, cpuHand.getHeight() - 0, Image.SCALE_SMOOTH);
                iconPlay = new ImageIcon(sizedImgPlay);
                cpuHand.setIcon(iconPlay);

            cpuThrownHand.setText(this.setCpuHandLbl(cpuPlays[index]));
            setResultindicator();
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }

    private String setPlayerHandLbl(String handURL) {
        switch (handURL) {
            case rockURL -> {
                return "ROCK";
            }
            case paperURL -> {
                return "PAPER";
            }
            case scissorURL -> {
                return "SCISSORS";
            }
        }
        return null;
    }

    private String setCpuHandLbl(String handURL) {
        switch (handURL) {
            case rockURL -> {
                return "ROCK";
            }
            case paperURL -> {
                return "PAPER";
            }
            case scissorURL -> {
                return "SCISSORS";
            }
        }
        return null;
    }

    private void setResultindicator() {
        String rockOutcome = "ROCK";
        String paperOutcome = "PAPER";
        String scissorOutcome = "SCISSORS";
        roundCount();
        
        switch (playerThrownHand.getText()) {
            case "ROCK" -> {
                           /****************PLAYER RESULT CONDITIONS -> ROCK ******************/
                if (playerThrownHand.getText().equals(rockOutcome) && cpuThrownHand.getText().equals(scissorOutcome)) {
                        playerScore = playerScore+1;
                        playerResultLbl.setText("WINNER");
                        playerResultLbl.setForeground(Color.GREEN);
                        playerScoreCount.setText(String.valueOf(playerScore));
                        playerScoreCount.setForeground(playerResultLbl.getForeground());
                            cpuResultLbl.setText("LOOSE");
                            cpuResultLbl.setForeground(Color.RED);
                            cpuScoreCount.setForeground(Color.RED);
                }   if (playerThrownHand.getText().equals(rockOutcome) && cpuThrownHand.getText().equals(paperOutcome)) {
                        playerResultLbl.setText("LOOSE");
                        playerResultLbl.setForeground(Color.RED);
                        playerScoreCount.setForeground(playerResultLbl.getForeground());
                            cpuScore=cpuScore+1;
                            cpuResultLbl.setText("WINNER");
                            cpuResultLbl.setForeground(Color.GREEN);
                            cpuScoreCount.setForeground(cpuResultLbl.getForeground());
                            cpuScoreCount.setText(String.valueOf(cpuScore));
                }   if (playerThrownHand.getText().equals(rockOutcome) && cpuThrownHand.getText().equals(rockOutcome)) {
                        cpuResultLbl.setText("DRAW");
                        cpuResultLbl.setForeground(Color.LIGHT_GRAY);
                        cpuScoreCount.setForeground(cpuResultLbl.getForeground());
                            playerResultLbl.setText("DRAW");
                            playerResultLbl.setForeground(cpuResultLbl.getForeground());
                            playerScoreCount.setForeground(cpuResultLbl.getForeground());
                }
            }
            case "PAPER" -> {
                            /****************PLAYER RESULT CONDITIONS -> PAPER ******************/
                if (playerThrownHand.getText().equals(paperOutcome) && cpuThrownHand.getText().equals(rockOutcome)) {
                        playerScore = playerScore+1;
                        playerResultLbl.setText("WINNER");
                        playerResultLbl.setForeground(Color.GREEN);
                        playerScoreCount.setText(String.valueOf(playerScore));
                        playerScoreCount.setForeground(playerResultLbl.getForeground());
                            cpuResultLbl.setText("LOOSE");
                            cpuResultLbl.setForeground(Color.RED);
                            cpuScoreCount.setForeground(Color.RED);
                }   if (playerThrownHand.getText().equals(paperOutcome) && cpuThrownHand.getText().equals(scissorOutcome)) {
                        playerResultLbl.setText("LOOSE");
                        playerResultLbl.setForeground(Color.RED);
                        playerScoreCount.setForeground(playerResultLbl.getForeground());
                            cpuScore=cpuScore+1;
                            cpuResultLbl.setText("WINNER");
                            cpuResultLbl.setForeground(Color.GREEN);
                            cpuScoreCount.setForeground(cpuResultLbl.getForeground());
                            cpuScoreCount.setText(String.valueOf(cpuScore));
                }   if (playerThrownHand.getText().equals(paperOutcome) && cpuThrownHand.getText().equals(paperOutcome)) {
                        cpuResultLbl.setText("DRAW");
                        cpuResultLbl.setForeground(Color.LIGHT_GRAY);
                        cpuScoreCount.setForeground(cpuResultLbl.getForeground());
                            playerResultLbl.setText("DRAW");
                            playerResultLbl.setForeground(cpuResultLbl.getForeground());
                            playerScoreCount.setForeground(cpuResultLbl.getForeground());
                } 
            }
            default -> {
                        /****************PLAYER RESULT CONDITIONS -> SCISSOR******************/
                if (playerThrownHand.getText().equals(scissorOutcome) && cpuThrownHand.getText().equals(paperOutcome)) {
                        playerScore = playerScore+1;
                        playerResultLbl.setText("WINNER");
                        playerResultLbl.setForeground(Color.GREEN);
                        playerScoreCount.setText(String.valueOf(playerScore));
                        playerScoreCount.setForeground(playerResultLbl.getForeground());
                            cpuResultLbl.setText("LOOSE");
                            cpuResultLbl.setForeground(Color.RED);
                            cpuScoreCount.setForeground(Color.RED);
                }   if (playerThrownHand.getText().equals(scissorOutcome) && cpuThrownHand.getText().equals(rockOutcome)) {
                        playerResultLbl.setText("LOOSE");
                        playerResultLbl.setForeground(Color.RED);
                        playerScoreCount.setForeground(playerResultLbl.getForeground());
                            cpuScore=cpuScore+1;
                            cpuResultLbl.setText("WINNER");
                            cpuResultLbl.setForeground(Color.GREEN);
                            cpuScoreCount.setForeground(cpuResultLbl.getForeground());
                            cpuScoreCount.setText(String.valueOf(cpuScore));
                }   if (playerThrownHand.getText().equals(scissorOutcome) && cpuThrownHand.getText().equals(scissorOutcome)) {
                        cpuResultLbl.setText("DRAW");
                        cpuResultLbl.setForeground(Color.LIGHT_GRAY);
                        cpuScoreCount.setForeground(cpuResultLbl.getForeground());
                            playerResultLbl.setText("DRAW");
                            playerResultLbl.setForeground(cpuResultLbl.getForeground());
                            playerScoreCount.setForeground(cpuResultLbl.getForeground());
                }  
            }
        }
    }
    
    private void roundCount() {
        roundCountLbl.setText("0" + String.valueOf(roundCount++));
        if(roundCount > 9){
          roundCountLbl.setText(String.valueOf(roundCount++));   
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
        headerLbl = new javax.swing.JLabel();
        navPnl = new javax.swing.JPanel();
        exitControl = new javax.swing.JLabel();
        cpuContainerPnl = new RoundedPanel(100);
        cpuHand = new javax.swing.JLabel();
        userInformationPnl = new RoundedPanel(50);
        userImgPnl = new RoundedPanel(100);
        userImg = new javax.swing.JLabel();
        usernamelbl = new javax.swing.JLabel();
        datelbl = new javax.swing.JLabel();
        welcomeLbl = new javax.swing.JLabel();
        playerIDtxt = new javax.swing.JLabel();
        platerContainerPnl1 = new RoundedPanel(100);
        playerHand = new javax.swing.JLabel();
        vsLbl = new javax.swing.JLabel();
        rockLbl = new javax.swing.JLabel();
        paperLbl = new javax.swing.JLabel();
        scissorsLbl = new javax.swing.JLabel();
        quickManual = new javax.swing.JLabel();
        playerThrownHand = new javax.swing.JLabel();
        cpuThrownHand = new javax.swing.JLabel();
        cpuResultLbl = new javax.swing.JLabel();
        cpuScorePnl = new RoundedPanel(100);
        cpuScoreCount = new javax.swing.JLabel();
        playerScorePnl = new RoundedPanel(100);
        playerScoreCount = new javax.swing.JLabel();
        timePnl = new javax.swing.JPanel();
        upTimeLbl = new javax.swing.JLabel();
        clockPnl = new javax.swing.JPanel();
        minLbl = new javax.swing.JLabel();
        hrSeparator = new javax.swing.JLabel();
        hrLbl = new javax.swing.JLabel();
        minSeparator = new javax.swing.JLabel();
        secLbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        roundLbl = new javax.swing.JLabel();
        roundCountLbl = new javax.swing.JLabel();
        playerResultLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(41, 41, 41));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        contentPane.setBackground(new java.awt.Color(41, 41, 41));

        headerLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 44)); // NOI18N
        headerLbl.setForeground(new java.awt.Color(255, 255, 255));
        headerLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLbl.setText("ROCK-PAPER-SCISSORS");
        headerLbl.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 255)));

        navPnl.setBackground(new java.awt.Color(51, 51, 51));
        navPnl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout navPnlLayout = new javax.swing.GroupLayout(navPnl);
        navPnl.setLayout(navPnlLayout);
        navPnlLayout.setHorizontalGroup(
            navPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );
        navPnlLayout.setVerticalGroup(
            navPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        exitControl.setBackground(new java.awt.Color(41, 41, 41));
        exitControl.setFont(new java.awt.Font("Showcard Gothic", 0, 22)); // NOI18N
        exitControl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitControl.setText("X");
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

        cpuContainerPnl.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout cpuContainerPnlLayout = new javax.swing.GroupLayout(cpuContainerPnl);
        cpuContainerPnl.setLayout(cpuContainerPnlLayout);
        cpuContainerPnlLayout.setHorizontalGroup(
            cpuContainerPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cpuContainerPnlLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(cpuHand, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        cpuContainerPnlLayout.setVerticalGroup(
            cpuContainerPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cpuContainerPnlLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(cpuHand, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        userInformationPnl.setBackground(new java.awt.Color(51, 51, 51));

        userImgPnl.setBackground(new java.awt.Color(250, 250, 250));

        userImg.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout userImgPnlLayout = new javax.swing.GroupLayout(userImgPnl);
        userImgPnl.setLayout(userImgPnlLayout);
        userImgPnlLayout.setHorizontalGroup(
            userImgPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userImgPnlLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(userImg, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        userImgPnlLayout.setVerticalGroup(
            userImgPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userImgPnlLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(userImg, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        usernamelbl.setForeground(new java.awt.Color(153, 0, 153));
        usernamelbl.setText("USERNAME :");

        datelbl.setForeground(new java.awt.Color(255, 51, 255));
        datelbl.setText("DATE");

        welcomeLbl.setForeground(new java.awt.Color(255, 255, 255));
        welcomeLbl.setText("WELCOME");

        playerIDtxt.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        playerIDtxt.setForeground(new java.awt.Color(255, 204, 255));
        playerIDtxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        playerIDtxt.setText("Anonymous");

        javax.swing.GroupLayout userInformationPnlLayout = new javax.swing.GroupLayout(userInformationPnl);
        userInformationPnl.setLayout(userInformationPnlLayout);
        userInformationPnlLayout.setHorizontalGroup(
            userInformationPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInformationPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userImgPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userInformationPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userInformationPnlLayout.createSequentialGroup()
                        .addGroup(userInformationPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernamelbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(userInformationPnlLayout.createSequentialGroup()
                                .addComponent(welcomeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playerIDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addComponent(datelbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        userInformationPnlLayout.setVerticalGroup(
            userInformationPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userInformationPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(userInformationPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userInformationPnlLayout.createSequentialGroup()
                        .addGroup(userInformationPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(welcomeLbl)
                            .addComponent(playerIDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usernamelbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(datelbl))
                    .addComponent(userImgPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        platerContainerPnl1.setBackground(new java.awt.Color(255, 255, 255));

        playerHand.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                playerHandKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout platerContainerPnl1Layout = new javax.swing.GroupLayout(platerContainerPnl1);
        platerContainerPnl1.setLayout(platerContainerPnl1Layout);
        platerContainerPnl1Layout.setHorizontalGroup(
            platerContainerPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(platerContainerPnl1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(playerHand, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        platerContainerPnl1Layout.setVerticalGroup(
            platerContainerPnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(platerContainerPnl1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(playerHand, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        vsLbl.setFont(new java.awt.Font("Showcard Gothic", 1, 40)); // NOI18N
        vsLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vsLbl.setText("VS");

        rockLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        rockLbl.setForeground(new java.awt.Color(104, 104, 104));
        rockLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rockLbl.setText("ROCK");
        rockLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rockLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rockLblMouseClicked(evt);
            }
        });

        paperLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        paperLbl.setForeground(new java.awt.Color(104, 104, 104));
        paperLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        paperLbl.setText("PAPER");
        paperLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        paperLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paperLblMouseClicked(evt);
            }
        });

        scissorsLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        scissorsLbl.setForeground(new java.awt.Color(104, 104, 104));
        scissorsLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scissorsLbl.setText("SCISSORS");
        scissorsLbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scissorsLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scissorsLblMouseClicked(evt);
            }
        });

        quickManual.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        quickManual.setForeground(new java.awt.Color(104, 104, 104));
        quickManual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        quickManual.setText("PLAY REMINDER");
        quickManual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quickManual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quickManualMouseClicked(evt);
            }
        });

        playerThrownHand.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        playerThrownHand.setForeground(new java.awt.Color(224, 224, 224));

        cpuThrownHand.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        cpuThrownHand.setForeground(new java.awt.Color(224, 224, 224));
        cpuThrownHand.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        cpuResultLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        cpuResultLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cpuResultLbl.setText("RESULT APPEAR HERE");

        cpuScorePnl.setBackground(new java.awt.Color(41, 41, 41));

        cpuScoreCount.setFont(new java.awt.Font("Showcard Gothic", 0, 20)); // NOI18N
        cpuScoreCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cpuScoreCount.setText("0");

        javax.swing.GroupLayout cpuScorePnlLayout = new javax.swing.GroupLayout(cpuScorePnl);
        cpuScorePnl.setLayout(cpuScorePnlLayout);
        cpuScorePnlLayout.setHorizontalGroup(
            cpuScorePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cpuScorePnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cpuScoreCount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        cpuScorePnlLayout.setVerticalGroup(
            cpuScorePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cpuScorePnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cpuScoreCount, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        playerScorePnl.setBackground(new java.awt.Color(41, 41, 41));

        playerScoreCount.setFont(new java.awt.Font("Showcard Gothic", 0, 20)); // NOI18N
        playerScoreCount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerScoreCount.setText("0");

        javax.swing.GroupLayout playerScorePnlLayout = new javax.swing.GroupLayout(playerScorePnl);
        playerScorePnl.setLayout(playerScorePnlLayout);
        playerScorePnlLayout.setHorizontalGroup(
            playerScorePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerScorePnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerScoreCount, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );
        playerScorePnlLayout.setVerticalGroup(
            playerScorePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerScorePnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerScoreCount, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        timePnl.setBackground(new java.awt.Color(41, 41, 41));

        upTimeLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 16)); // NOI18N
        upTimeLbl.setForeground(new java.awt.Color(241, 241, 241));
        upTimeLbl.setText("UP TIME : ");

        clockPnl.setBackground(new java.awt.Color(41, 41, 41));

        minLbl.setBackground(new java.awt.Color(41, 41, 41));
        minLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 22)); // NOI18N
        minLbl.setForeground(new java.awt.Color(255, 255, 255));
        minLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minLbl.setText("00");

        hrSeparator.setBackground(new java.awt.Color(41, 41, 41));
        hrSeparator.setFont(new java.awt.Font("Showcard Gothic", 0, 23)); // NOI18N
        hrSeparator.setForeground(new java.awt.Color(255, 255, 255));
        hrSeparator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hrSeparator.setText(":");

        hrLbl.setBackground(new java.awt.Color(41, 41, 41));
        hrLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 22)); // NOI18N
        hrLbl.setForeground(new java.awt.Color(255, 255, 255));
        hrLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hrLbl.setText("00");

        minSeparator.setBackground(new java.awt.Color(41, 41, 41));
        minSeparator.setFont(new java.awt.Font("Showcard Gothic", 0, 23)); // NOI18N
        minSeparator.setForeground(new java.awt.Color(255, 255, 255));
        minSeparator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minSeparator.setText(":");

        secLbl.setBackground(new java.awt.Color(41, 41, 41));
        secLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 22)); // NOI18N
        secLbl.setForeground(new java.awt.Color(255, 255, 255));
        secLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        secLbl.setText("00");

        javax.swing.GroupLayout clockPnlLayout = new javax.swing.GroupLayout(clockPnl);
        clockPnl.setLayout(clockPnlLayout);
        clockPnlLayout.setHorizontalGroup(
            clockPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clockPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hrLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hrSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(minSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        clockPnlLayout.setVerticalGroup(
            clockPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clockPnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clockPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hrLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(secLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, clockPnlLayout.createSequentialGroup()
                        .addGroup(clockPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hrSeparator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minSeparator, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout timePnlLayout = new javax.swing.GroupLayout(timePnl);
        timePnl.setLayout(timePnlLayout);
        timePnlLayout.setHorizontalGroup(
            timePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timePnlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upTimeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clockPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        timePnlLayout.setVerticalGroup(
            timePnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timePnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(upTimeLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clockPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBackground(new java.awt.Color(41, 41, 41));

        roundLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 22)); // NOI18N
        roundLbl.setForeground(new java.awt.Color(204, 204, 204));
        roundLbl.setText(" ROUND :");

        roundCountLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 25)); // NOI18N
        roundCountLbl.setForeground(new java.awt.Color(204, 204, 204));
        roundCountLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roundCountLbl.setText("00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(roundLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roundCountLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roundLbl)
                    .addComponent(roundCountLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addContainerGap())
        );

        playerResultLbl.setFont(new java.awt.Font("Showcard Gothic", 0, 14)); // NOI18N
        playerResultLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerResultLbl.setText("RESULT APPEAR HERE");

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(navPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(rockLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(paperLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scissorsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(platerContainerPnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cpuScorePnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cpuThrownHand, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(playerScorePnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(playerThrownHand, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(cpuResultLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                                    .addComponent(playerResultLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(23, 23, 23))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(vsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)))
                        .addComponent(cpuContainerPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                        .addComponent(quickManual, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219)
                        .addComponent(exitControl, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addComponent(userInformationPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timePnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPaneLayout.createSequentialGroup()
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exitControl, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(headerLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quickManual))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(playerThrownHand, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playerScorePnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(playerResultLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vsLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpuResultLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cpuScorePnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cpuThrownHand, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(platerContainerPnl1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cpuContainerPnl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rockLbl)
                            .addComponent(paperLbl)
                            .addComponent(scissorsLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userInformationPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timePnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(navPnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    private void exitControlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitControlMouseClicked
//        this.dispose();
//        new MenuBoard().setVisible(true);
        int responce = JOptionPane.showConfirmDialog(null, "Are you show you want to exit the game?", "UNSAFE TERMINATION", JOptionPane.WARNING_MESSAGE);
        if(responce == JOptionPane.OK_OPTION){
            this.dispose();
        }
    }//GEN-LAST:event_exitControlMouseClicked

    private void playerHandKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_playerHandKeyTyped
    }//GEN-LAST:event_playerHandKeyTyped

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        switch (evt.getKeyChar()) {
            case 'R', 'r' -> playerPlay(rockURL);
            case 'P', 'p' -> playerPlay(paperURL);
            case 'S', 's' -> playerPlay(scissorURL);
            default -> JOptionPane.showMessageDialog(null, "SHORTCUT ARE : \nR/r -> ROCK \nP/p -> PAPER \nS/s ->SCISSOR\n PLAY [" + evt.getKeyChar() + "] IS INVALID", "INVALID HAND THROWN", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formKeyTyped

    private void exitControlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitControlMouseEntered
        exitControl.setForeground(Color.RED);
        exitControl.setFont(new Font("Showcard Gothic", Font.BOLD, 25));
    }//GEN-LAST:event_exitControlMouseEntered

    private void exitControlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitControlMouseExited
        exitControl.setForeground(new Color(204, 204, 204));
        exitControl.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
    }//GEN-LAST:event_exitControlMouseExited

    private void rockLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rockLblMouseClicked
        playerPlay(rockURL);
    }//GEN-LAST:event_rockLblMouseClicked

    private void paperLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paperLblMouseClicked
        playerPlay(paperURL);
    }//GEN-LAST:event_paperLblMouseClicked

    private void scissorsLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scissorsLblMouseClicked
        playerPlay(scissorURL);
    }//GEN-LAST:event_scissorsLblMouseClicked

    private void quickManualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quickManualMouseClicked
        new QuakManuals().setVisible(true);
    }//GEN-LAST:event_quickManualMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel clockPnl;
    private javax.swing.JPanel contentPane;
    private javax.swing.JPanel cpuContainerPnl;
    private javax.swing.JLabel cpuHand;
    private javax.swing.JLabel cpuResultLbl;
    private javax.swing.JLabel cpuScoreCount;
    private javax.swing.JPanel cpuScorePnl;
    private javax.swing.JLabel cpuThrownHand;
    private javax.swing.JLabel datelbl;
    private javax.swing.JLabel exitControl;
    private javax.swing.JLabel headerLbl;
    private javax.swing.JLabel hrLbl;
    private javax.swing.JLabel hrSeparator;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel minLbl;
    private javax.swing.JLabel minSeparator;
    private javax.swing.JPanel navPnl;
    private javax.swing.JLabel paperLbl;
    private javax.swing.JPanel platerContainerPnl1;
    private javax.swing.JLabel playerHand;
    private javax.swing.JLabel playerIDtxt;
    private javax.swing.JLabel playerResultLbl;
    private javax.swing.JLabel playerScoreCount;
    private javax.swing.JPanel playerScorePnl;
    private javax.swing.JLabel playerThrownHand;
    private javax.swing.JLabel quickManual;
    private javax.swing.JLabel rockLbl;
    private javax.swing.JLabel roundCountLbl;
    private javax.swing.JLabel roundLbl;
    private javax.swing.JLabel scissorsLbl;
    private javax.swing.JLabel secLbl;
    private javax.swing.JPanel timePnl;
    private javax.swing.JLabel upTimeLbl;
    private javax.swing.JLabel userImg;
    private javax.swing.JPanel userImgPnl;
    private javax.swing.JPanel userInformationPnl;
    private javax.swing.JLabel usernamelbl;
    private javax.swing.JLabel vsLbl;
    private javax.swing.JLabel welcomeLbl;
    // End of variables declaration//GEN-END:variables

}
