package com.seedafricaorgtech.MyRent.service.api.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "business")
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private int phone_no;
    private String momo_name;
    private int acc_num;
    private String acc_name;

    public Business(String name, int phone_no, String momo_name, int acc_num, String acc_name) {
        this.name = name;
        this.phone_no = phone_no;
        this.momo_name = momo_name;
        this.acc_num = acc_num;
        this.acc_name = acc_name;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(int phone_no) {
        this.phone_no = phone_no;
    }

    public String getMomo_name() {
        return momo_name;
    }

    public void setMomo_name(String momo_name) {
        this.momo_name = momo_name;
    }

    public int getAcc_num() {
        return acc_num;
    }

    public void setAcc_num(int acc_num) {
        this.acc_num = acc_num;
    }

    public String getAcc_name() {
        return acc_name;
    }

    public void setAcc_name(String acc_name) {
        this.acc_name = acc_name;
    }
}
