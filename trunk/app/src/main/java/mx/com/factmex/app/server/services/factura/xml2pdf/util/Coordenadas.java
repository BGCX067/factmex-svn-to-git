/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.factmex.app.server.services.factura.xml2pdf.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import mx.com.factmex.app.server.services.factura.xml2pdf.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Coordenadas
        implements Serializable {

    private static final long serialVersionUID = 1L;
    public String x;
    public String y;
    private DecimalFormat df;
    private Coordenadas arr[] = new Coordenadas[30];

    public Coordenadas() {
        this.df = new DecimalFormat("000");
    }

    public Coordenadas(int x, int y) {
        this.df = new DecimalFormat("000");
        this.x = this.df.format(x);
        this.y = this.df.format(y);
    }

    public void setDatos(int pos, String x, String y) {
        arr[pos] = new Coordenadas();
        arr[pos].x = x;
        arr[pos].y = y;
    }

    public static Coordenadas[] leerDesdeArchivo(String file)
            throws IOException, ClassNotFoundException {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea = null;
        Coordenadas data = new Coordenadas();
        try {
            archivo = new File(file);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            int i = 0;
            while ((linea = br.readLine()) != null) {
                Scanner sc = new Scanner(linea);
                sc.useDelimiter(",");

                String[] tokens = new String[2];
                while (sc.hasNext()) {
                    data.setDatos(i, tokens[0] = sc.next(), tokens[1] = sc.next());
                    i++;
                }
            }
        } catch (Exception e) {
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        /*
        File doc = new File(file);


        
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        //Coordenadas arr[] = (Coordenadas[])ois.readObject();
        Coordenadas algo = new Coordenadas();
        algo.setDatos(0,"460","650");
        algo.setDatos(1,"460","620");
        algo.setDatos(2,"455","675");
        
        ois.close();
        fis.close();*/
        return data.arr;
    }

    public static void escribirEnArchivo(Coordenadas[] coord, String file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(coord);

        oos.close();
        fos.close();
    }

    public int intX() {
        return Integer.parseInt(this.x);
    }

    public int intY() {
        return Integer.parseInt(this.y);
    }
}
