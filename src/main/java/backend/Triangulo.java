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
public class Triangulo extends Figura {
     private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }
    
    @Override
     public double calcularArea(){
        double area = (this.base*this.altura)/2;
        super.setArea(area);
        return area;
    }
     
      @Override
    public String guardarBDD() {
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("Figuras");
            MongoCollection<Document> areasCollection = database.getCollection("areas");

            Document circuloDocument = new Document("tipo", "Triangulo")
                    .append("base", this.base)
                    .append("altura", this.altura)
                    .append("area", this.getArea());

            areasCollection.insertOne(circuloDocument);

            mongoClient.close();

            return "Área de círculo guardada en la base de datos.";
        } catch (Exception e) {
            return "Error al guardar el área de círculo en la base de datos: " + e.getMessage();
        }
    }

    @Override
    public List<Document> consultarAreas() {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("Figuras");
            MongoCollection<Document> areasCollection = database.getCollection("areas");

            List<Document> areasFiltradas = new ArrayList<>();

            try (MongoCursor<Document> cursor = areasCollection.find(Filters.eq("tipo", "Triangulo")).iterator()) {
                while (cursor.hasNext()) {
                    areasFiltradas.add(cursor.next());
                }
            }

            return areasFiltradas;
        } catch (Exception e) {
            System.err.println("Error al obtener áreas de triángulo: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public String eliminarAreas() {
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = mongoClient.getDatabase("Figuras");
            MongoCollection<Document> areasCollection = database.getCollection("areas");

            areasCollection.deleteMany(Filters.eq("tipo", "Triangulo"));

            mongoClient.close();

            return "Áreas de triángulo eliminadas de la base de datos.";
        } catch (Exception e) {
            return "Error al eliminar las áreas de triángulo de la base de datos: " + e.getMessage();
        }
    }
}
