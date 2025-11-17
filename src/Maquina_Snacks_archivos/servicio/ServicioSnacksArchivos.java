package Maquina_Snacks_archivos.servicio;

import Maquina_Snacks_archivos.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ServicioSnacksArchivos implements ISevicioSnacks{

    private final String NOMBRE_ARCHIVO = "snacks.txt";
    //crear lista snacks
    private List<Snack> snacks =new ArrayList<Snack>();

    public ServicioSnacksArchivos(){
        //creamos el archivo si no existe
        var archivo = new File(NOMBRE_ARCHIVO);
        var existe = false;
        try{
            existe = archivo.exists();
            if ((existe)){
                this.snacks = obtenerSnacks();
            }else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        }catch(Exception e){
            System.out.println("Error al crear el archivo "+e.getMessage());
        }
        //si no existe el archivo, cargamos algunos snack iniciales
        if(!existe){
            cargarSnacksIniciales();
        }
    }

    private List<Snack> obtenerSnacks() {
        var snacks = new ArrayList<Snack>();
        try{
            List<String> lineas = Files.readAllLines(Paths.get(NOMBRE_ARCHIVO));
            for(String linea: lineas){
                String[] lineaSnack = linea.split(",");
                var idSnack = lineaSnack[0]; //no se usa
                var nombreSnack = lineaSnack[1];
                var precioSnack = Double.parseDouble(lineaSnack[2]);
                var snack = new Snack(nombreSnack, precioSnack);
                snacks.add(snack); //agregamos el snack leido a la lista
            }
        }catch(Exception e){
            System.out.println("Error al leer el archivo "+e.getMessage());
            e.printStackTrace();
        }
        return snacks;
    }

    private void cargarSnacksIniciales(){
        this.agregarSnack(new Snack("Patatas", 1.10));
        this.agregarSnack(new Snack("Refresco", 1.50));
        this.agregarSnack(new Snack("Bocadillo", 2.10));
    }

    @Override
    public void agregarSnack(Snack snack) {
        //1 agregamos el nuevo snack, 1 a la lista en memoria
        this.snacks.add(snack);
        //2 guardamos el nuevo snack en el archivo
        this.agregarSnackArchivo(snack);
    }

    private void agregarSnackArchivo(Snack snack) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(snack.escribirSnack());
            salida.close();
        }catch (Exception e){
            System.out.println("Error al agregar el snack "+e.getMessage());
        }
    }

    @Override
    public void mostrarSnack() {
        System.out.println("--- Snacks en el inventario ---");
        var inventarioSnacks = "";
        for(var snack: this.snacks){
            inventarioSnacks += snack.toString() + "\n";
        }
        System.out.println(inventarioSnacks);
    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
