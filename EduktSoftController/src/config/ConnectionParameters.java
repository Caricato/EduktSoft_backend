/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author alulab14
 */
public class ConnectionParameters {

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public ConnectionParameters(){
        this.url = "jdbc:mysql://basepersonallp2.cz0yqyqkgmmt.us-east-1.rds.amazonaws.com:3306/lp2";
        this.user = "caricato";
        this.password = "mahal_1999";
    }
    
    private String url;
    private String user;
    private String password;
    
}
