package com.highline.login.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_info")
public class User {

    @Column(name = "user_id")
    @SequenceGenerator(name = "user_info_seq_id", sequenceName = "user_info_seq_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_seq_id")
    @Id
    private Integer id;

    private String username;

    private String password;

    @Column(name = "created_on")
    private Date createdOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
