package com.example.laura_rubio_dam2_27_11.model;

public class PaisesJSON {
    private String name_en; //nombre pais

    public PaisesJSON() {
    }

    public PaisesJSON(String name_en) {
        this.name_en = name_en;
    }

    @Override
    public String toString() {
        return name_en;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }
}
