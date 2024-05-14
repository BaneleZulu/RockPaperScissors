/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nihil.RockPaperScissors_USER_LOGON;
/**
 *
 * @author LATITUDE 5410
 */
public class Player
{
    public void setPlayerID(long id){ this.playerID = id;}
    public void setName(String name){ this.name = name; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
    public void setLastLogon(String logonDate) {this.lastLogonDate = logonDate;}
    public void setJoinedDate(String joinDate) {this.joinDate = joinDate;}
    public void setPlays(int plays) {this.plays = plays;}
            
    public long getPlayerID() {return this.playerID;}
    public String getName() {return this.name; }
    public String getLastname() {return this.lastname;}
    public String getEmail() {return this.email;}
    public String getPassword() {return this.password;}
    public String getLastLogon() {return this.lastLogonDate;}
    public String getJoinedDate() {return this.joinDate;}
    public int getPlays() {return this.plays;}
    
    private long playerID;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String lastLogonDate;
    private String joinDate;
    private int plays;
    
    
    @Override
    public String toString(){
        return (
                "PlayerID ---- : " + this.getPlayerID() + "\n" +
                "Name -------- : " + this.getName() + "\n" + 
                "Lastname ---- : " + this.getLastname() + "\n" + 
                "Email ------- : " + this.getEmail() + "\n" + 
                "Password ---- : " + this.getPassword() + "\n" + 
                "Last Logon -- : " + this.getLastLogon() + "\n" +
                "Joined Date - : " + this.getJoinedDate() + "\n" +
                "Plays ------- : " + this.getPlays()
               );
    }
    
}
