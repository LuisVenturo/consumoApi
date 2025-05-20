package principal;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.ConsultaPelicula;
import models.GeneradorDeArchivo;
import models.TituloSwapi;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        ConsultaPelicula consultaPelicula = new ConsultaPelicula();
        List<TituloSwapi> listaPelicua = new ArrayList<>();

        System.out.println("""
                ************************************************
                *****BIENVENIDO DE CONSUMO DE APIS SWAPI********
                ***** - DIGITE 0 SI DESEA SALIR
                ***** - DIGITE DEL 1 EN ADELANTE PARA ESCOGER SU
                *****   EPISODIO DE STAR WARS
                ************************************************
                """);
        System.out.println("Escriba el nombre de coleccion de peliculas a consultar: ");
        String nombre = sc.nextLine();

        while (true) {


            System.out.println("Escriba el número de la pelicula de Star Wars que quiere consultar: ");

            try {
                var numeroPelicula = Integer.valueOf(sc.nextLine());

                if (numeroPelicula == 0) {
                    break;
                }

                TituloSwapi pelicula = consultaPelicula.buscaPelicula(numeroPelicula);
                System.out.println(pelicula);

                //Array para agregar pelicula a la lista
                listaPelicua.add(pelicula);



            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación");
            }
        }
        GeneradorDeArchivo generador = new GeneradorDeArchivo();
        generador.guardarJson(nombre, listaPelicua);
    }
}
