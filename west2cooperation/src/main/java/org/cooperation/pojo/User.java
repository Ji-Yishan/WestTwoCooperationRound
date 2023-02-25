package org.cooperation.pojo;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private int contact;
    private String idcard;
    private int degree;
    private String newName;

    public User(String username, String password, int contact, String idcard, int degree) {
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.idcard = idcard;
        this.degree = degree;
    }
    public User(String username,String newName,int contact, String idcard){
        this.newName=newName;
        this.username = username;
        this.contact = contact;
        this.idcard = idcard;
    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", contact=" + contact +
                ", idcard='" + idcard + '\'' +
                ", degree=" + degree +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getContact() {
        return contact;
    }

    public String getIdcard() {
        return idcard;
    }

    public int getDegree() {
        return degree;
    }
}
