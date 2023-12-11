package com.example.practicajson2.model;

public class BebidasJSON {

    String strDrink ;//nombreBebida
    String strDrinkThumb;//imagen
    int  idDrink; //id

    public BebidasJSON() {
    }

    public BebidasJSON(String strDrink, int idDrink) {
        this.strDrink = strDrink;
        this.idDrink = idDrink;
    }

    @Override
    public String toString() {
        return strDrink;
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
