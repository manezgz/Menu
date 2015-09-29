package com.cro.menu.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mane on 30/9/15.
 */
public class Menu {

    private static Menu instance;
    private static final String URL_JSON="http://www.mocky.io/v2/560b0a61b78b0f9302b22e54";
    private static final Object lock = new Object();

    private List<Dish> tapas;
    private List<Dish> ensaladas;
    private List<Dish> arroces;
    private List<Dish> entrantes;
    private List<Dish> pescados;
    private List<Dish> carnes;

    public static Menu getInstance(){
        if(instance==null){
            synchronized (lock) {
                instance = new Menu();

            }
        }
        return instance;
    }

    public Menu(){
        tapas=new ArrayList<Dish>();
        ensaladas=new ArrayList<Dish>();
        arroces=new ArrayList<Dish>();
        entrantes=new ArrayList<Dish>();
        pescados=new ArrayList<Dish>();
        carnes=new ArrayList<Dish>();
    }



    private void downloadJson(){
        // Download JSON data into an StringBuilder
        try {
            URLConnection conn = new URL(URL_JSON).openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

            JSONArray jsonRoot = (new JSONObject(sb.toString())).getJSONArray("tipos");
            //TAPAS
            JSONObject tapas=jsonRoot.getJSONObject(0);
            JSONArray platosTapas=tapas.getJSONArray("platos");
            for (int i = 0; i < platosTapas.length(); i++) {
                JSONObject jsonDish = platosTapas.getJSONObject(i);

                String name = jsonDish.getString("name");
                String imageURL = jsonDish.getString("urlImage");
                JSONArray ingredientes=jsonDish.getJSONArray("ingredientes");
                String[] ingredientesArray=new String[ingredientes.length()];
                for (int j = 0; j < ingredientes.length(); j++) {
                    ingredientesArray[j]=ingredientes.getString(j);
                }

                JSONArray alergenos=jsonDish.getJSONArray("ingredientes");
                String[] alergenosArray=new String[alergenos.length()];
                for (int j = 0; j < alergenos.length(); j++) {
                    alergenosArray[j]=alergenos.getString(j);
                }

                JSONArray opciones=jsonDish.getJSONArray("opciones");
                String[] opcionesArray=new String[opciones.length()];
                for (int j = 0; j < opciones.length(); j++) {
                    opcionesArray[j]=opciones.getString(j);
                }
                Dish dish=new Dish(name,imageURL,ingredientesArray,alergenosArray,opcionesArray);
                this.tapas.add(dish);

            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public List<Dish> getTapas() {
        return tapas;
    }

    public void setTapas(List<Dish> tapas) {
        this.tapas = tapas;
    }

    public List<Dish> getEnsaladas() {
        return ensaladas;
    }

    public void setEnsaladas(List<Dish> ensaladas) {
        this.ensaladas = ensaladas;
    }

    public List<Dish> getArroces() {
        return arroces;
    }

    public void setArroces(List<Dish> arroces) {
        this.arroces = arroces;
    }

    public List<Dish> getEntrantes() {
        return entrantes;
    }

    public void setEntrantes(List<Dish> entrantes) {
        this.entrantes = entrantes;
    }

    public List<Dish> getPescados() {
        return pescados;
    }

    public void setPescados(List<Dish> pescados) {
        this.pescados = pescados;
    }

    public List<Dish> getCarnes() {
        return carnes;
    }

    public void setCarnes(List<Dish> carnes) {
        this.carnes = carnes;
    }
}
