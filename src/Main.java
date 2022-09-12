import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        //Ruta del archivo
        Path filePath = Paths.get("C:\\Users\\ana.carton\\IdeaProjects\\Itinerario_Backend\\ej1.1-primer-ejercicio\\fichero.txt");
        List<Persona> listaPersonas = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {//while there is content on the current line

                String[] info = currentLine.split(":");

                Persona persona;

                //Switch de casos según la longitud de currentLine
                if (info.length == 2) {
                    persona = new Persona(info[0], info[1], null);
                } else {//Si falta la info de la poblacion o la edad, que sea null
                    if (info[1] == "") {
                        info[1] = null;
                    }
                    if (info[2] == "") {
                        info[2] = null;
                    }
                    persona = new Persona(info[0], info[1], info[2]);
                }

                listaPersonas.add(persona);

            }
        } catch (IOException ex) {
            ex.printStackTrace(); //handle an exception here
        }

        //Mostrar las personas de la lista menores de 25
        listaPersonas.stream()
                .filter(x -> !x.getEdad().equals("Desconocida") && Integer.parseInt(x.getEdad()) < 25)
                .forEach(System.out::println);


    }
}
