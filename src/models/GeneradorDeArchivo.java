package models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeneradorDeArchivo {

    Gson gson = new GsonBuilder().
            setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
            .setPrettyPrinting()
            .create();

    public void guardarJson(String nombre, List listaPelicula) throws IOException {

        FileWriter escritor = new FileWriter(nombre + ".json");
        escritor.write(gson.toJson(listaPelicula));
        escritor.close();

    }
}
