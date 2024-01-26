/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author toapa
 */
public abstract class Figura {
     private double area;
    
    public void setArea(double area){
        this.area = area;
    }
    
    public double calcularArea(){
        return 0;
    }
    
    public abstract String guardarBDD();

    public abstract List<Document> consultarAreas();

    public abstract String eliminarAreas();


    public double getArea() {
        return area;
    }
    
    
}
