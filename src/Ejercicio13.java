import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Scanner;

public class Ejercicio13 {
    static Properties properties = new Properties();
    static FileReader fr;

    static {
        try {
            fr = new FileReader("app.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    static String nombreUsuario;
    static String emailUsuario;

    public static void nombresProperties() throws FileNotFoundException {
        try {
            properties.load(fr);
            Enumeration<Object> key = properties.keys();

            while (key.hasMoreElements()) {
                Object keys = key.nextElement();
                System.out.println(keys);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void nombreUsuario() throws FileNotFoundException {
        //String nombreUsuario;
        try {
            properties.load(fr);
            nombreUsuario = properties.getProperty("userName", "Default");
            System.out.println(nombreUsuario);
            /*BufferedWriter bw=new BufferedWriter(new FileWriter("nombre.properties"));
            bw.write("Nombre usuario: " + nombre);
            bw.close();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void emailUsuario() throws FileNotFoundException {
        //String emailUsuario;
        try {
            properties.load(fr);
            emailUsuario = properties.getProperty("userEmail", "Default");
            System.out.println(emailUsuario);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cambioIdioma() throws FileNotFoundException {
        System.out.println("El idioma actual es: " + properties.getProperty("language", "default"));
        System.out.print("Añada un idioma nuevo: ");
        Scanner sc = new Scanner(System.in);
        String cambio = sc.nextLine();
        try {
            properties.load(fr);
            properties.setProperty("language", cambio);
            properties.store(new FileWriter("app.properties"), "cambio de idioma");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void nuevaPropiedad() throws FileNotFoundException {
        Date date = new Date();
        try {
            properties.load(fr);
            properties.setProperty("appStarted", String.valueOf(date));
            properties.store(new FileWriter("app.properties"), "añandiendo propiedad con fecha");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
