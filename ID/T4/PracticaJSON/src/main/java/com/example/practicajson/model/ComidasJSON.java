package com.example.practicajson.model;

import com.google.gson.annotations.SerializedName;

public class ComidasJSON {

    @SerializedName("strMeal")
    private String strMeal;
    private String strMealThumb;
    private int idMeal;

    public ComidasJSON() {
    }

    public ComidasJSON(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public int getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(int idMeal) {
        this.idMeal = idMeal;
    }

    @Override
    public String toString() {
        return strMeal;
    }
}