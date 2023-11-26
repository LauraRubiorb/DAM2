package com.example.practicajson.model;
import com.google.gson.annotations.SerializedName;

public class CategoriasJSON {
    @SerializedName("idCategory")
    private int idCategory;
    @SerializedName("strCategory")
    private String strCategory; //nombreCatg
    private String strCategoryThumb; //imagen
    private String strCategoryDescription; //descripcion

    public CategoriasJSON() {
    }

    public CategoriasJSON(int idCategory, String strCategory) {
        this.idCategory = idCategory;
        this.strCategory = strCategory;
    }

    public CategoriasJSON(int idCategory, String strCategory, String strCategoryThumb, String strCategoryDescription) {
        this.idCategory = idCategory;
        this.strCategory = strCategory;
        this.strCategoryThumb = strCategoryThumb;
        this.strCategoryDescription = strCategoryDescription;
    }

    @Override
    public String toString() {
        return idCategory + strCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrCategoryThumb() {
        return strCategoryThumb;
    }

    public void setStrCategoryThumb(String strCategoryThumb) {
        this.strCategoryThumb = strCategoryThumb;
    }

    public String getStrCategoryDescription() {
        return strCategoryDescription;
    }

    public void setStrCategoryDescription(String strCategoryDescription) {
        this.strCategoryDescription = strCategoryDescription;
    }


}
