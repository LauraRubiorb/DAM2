package com.example.practicajson2.model;

public class BebidaCon {
    String strDrink ;//nombreBebida
    String strDrinkThumb;//imagen
    int  idDrink; //id

    public BebidaCon() {
    }

    public BebidaCon(String strDrink, int idDrink) {
        this.strDrink = strDrink;
        this.idDrink = idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    public int getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(int idDrink) {
        this.idDrink = idDrink;
    }
}
