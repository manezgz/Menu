package com.cro.menu.model;

import android.graphics.Bitmap;

/**
 * Created by mane on 30/9/15.
 */
public class Dish {

    private String name;
    private String urlImage;
    private Bitmap image;
    private String[] alergenos;
    private String[] ingredientes;
    private String[] opciones;

    public Dish(String name,String urlImage,String[] alergenos,String[] ingredientes,String[] opciones){
        this.setName(name);
        this.setUrlImage(urlImage);
        this.setAlergenos(alergenos);
        this.setIngredientes(ingredientes);
        this.setOpciones(opciones);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String[] getAlergenos() {
        return alergenos;
    }

    public void setAlergenos(String[] alergenos) {
        this.alergenos = alergenos;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }
}
