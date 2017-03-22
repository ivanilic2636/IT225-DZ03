/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it225.dz01;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class Main {

    public Main() {
        try{
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if(conn.getResponseCode() != 200){
                throw new RuntimeException ("Pokusaj nije uspeo : HTTP error : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String json = "";
            String output;
            while ((output = br.readLine()) != null){
                json += output;
            }
            conn.disconnect();
            Gson gson = new Gson();
            RootObject lista = gson.fromJson(json, RootObject.class);
               
                System.out.println("User ID je: " + lista.getUserId());
                System.out.println("ID je: " + lista.getId());
                System.out.println("Naslov je: " + lista.getTitle());
                
                System.out.println("Body je: " + lista.getBody());
          
        }catch(MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
                  e.printStackTrace();
        }
    
    }
    
    
    
    public static void main(String[] args) {
        new Main();
    }
    
}
