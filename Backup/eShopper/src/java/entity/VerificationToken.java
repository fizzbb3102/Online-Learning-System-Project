/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDateTime;


/**
 *
 * @author Zake
 */
public class VerificationToken {
    private String token;
    private int uid;
    private long expiry;

    public VerificationToken() {
    }

    public VerificationToken(String token, int uid, long expiry) {
        this.token = token;
        this.uid = uid;
        this.expiry = expiry;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public long getExpiry() {
        return expiry;
    }

    public void setExpiry(long expiry) {
        this.expiry = expiry;
    }
            
    
}
