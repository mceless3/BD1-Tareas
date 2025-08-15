
package trabajos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class csv1 {
    public static void main(String[] args) {
        //Primero definimos la ruta del archivo csv 
        String archivo = "c://codigos_postales_hmo.csv"; 
        //Creamos un separador para cada linea del archivo, separando por columnas
        String separador = ",";
        //Creamos hashmap para almacenar los codigos postales y asentamientos
        HashMap<String, Integer> mapa = new HashMap<>();
        //leemos y almacenamos las lineas del archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine(); // Saltar encabezado si existe
            String linea;

            while ((linea = br.readLine()) != null) {
                //separamos las lineas
                String[] partes = linea.split(separador);
                //Tomamos el codigo postal que esta en la posicion 0
                String codigo = partes[0];
                //Tomamos el asentamiento en la posicion 1
                String asentamiento = partes[1];

                //verificamos si ya existe, si no lo agregamos
                if (!mapa.containsKey(codigo)) {
                    mapa.put(codigo, 1);
                } else {
                    //incrementamos el contador de los que existan
                    mapa.put(codigo, mapa.get(codigo) + 1);
                }
            }

            //Iteramos todos los elementos del archivo
            for (String codigo : mapa.keySet()) {
                //Imprimimos el resultado
                System.out.println("Codigo postal: " + codigo +
                                   ", Numero de asentamientos: " + mapa.get(codigo));
            }
        //Catch por si ocurre una excepcion en entradas/salidas
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
