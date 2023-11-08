package main;

import model.Poo.Albaran;
import model.Poo.Factura;
import model.Poo.Juguete;
import model.Poo.NotaPago;
import model.SqlAction;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file;
        int resp;
        String table;
        FileReader reader=null;
        BufferedReader buffer=null;
        String salidaArchivo;
        String xml;
        SqlAction sql = new SqlAction();

        do {
            System.out.println("Salir: 0" );
            System.out.println("Quiero importar xml: 1");
            System.out.println("Quiero exportar xml: 2");
            resp=sc.nextInt();
            switch (resp){
                case 1:
                    System.out.println("Que tabla quieres: Albaran,Factura,Juguete,NotaPago");
                    table = sc.next();
                    if (table.equalsIgnoreCase("ALBARAN")){
                        try {
                            System.out.println("Pasame la ruta de tu archivo ");
                            table = sc.next();
                            file = new File(table);
                            reader=new FileReader(file);
                            buffer = new BufferedReader(reader);
                            while((salidaArchivo=buffer.readLine())!=null){

                            }
                        } catch (Exception e) {
                            System.out.println("Error: " + e);
                        }finally {
                            try {
                                if (null != reader){
                                    reader.close();
                                }if (null != buffer){
                                    buffer.close();

                                }
                            }catch (Exception e2){
                                System.out.println("Error: " + e2);

                            }
                        }
                    }if(table.equalsIgnoreCase("FACTURA")){

                    }
                    break;
                case 2:
                    System.out.println("Que tabla quieres: Albaran,Factura,Juguete,NotaPago");
                    table = sc.next();
                    if (table.equalsIgnoreCase("JUGUETE")){
                        ArrayList<Juguete> j1 = sql.findJuguete();
                        xml = Juguete.toXml(j1);
                        System.out.println(xml);
                    }if (table.equalsIgnoreCase("ALBARAN")){
                        ArrayList<Albaran> a1 = sql.findAlbaran();
                         xml = Albaran.toXml(a1);
                        System.out.println(xml);
                    }if (table.equalsIgnoreCase("FACTURA")){
                        ArrayList<Factura> f1 = sql.findFactura();
                        xml = Factura.toXML(f1);
                    }if(table.equalsIgnoreCase("NOTAPAGO")){
                        ArrayList<NotaPago> n1 = sql.

                    }

            }
        }while (resp!=0);


    }
}