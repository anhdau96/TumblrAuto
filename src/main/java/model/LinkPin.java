/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SaiBack
 */
public class LinkPin {
    private int id;
    private String link;
    private String img;
    private String title;
    private String des;
    private byte checkPin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte getCheckPin() {
        return checkPin;
    }

    public void setCheckPin(byte checkPin) {
        this.checkPin = checkPin;
    }


    public LinkPin(String link, String img) {
        this.link = link;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public LinkPin(int id, String link, String img, String title, String des, byte checkPin) {
        this.id = id;
        this.link = link;
        this.img = img;
        this.title = title;
        this.des = des;
        this.checkPin = checkPin;
    }


    
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "LinkPin{" + "id=" + id + ", link=" + link + ", img=" + img + ", title=" + title + ", des=" + des + ", checkPin=" + checkPin + '}';
    }
    
}
