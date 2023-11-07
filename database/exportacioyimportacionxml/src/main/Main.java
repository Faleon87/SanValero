package main;

import model.Poo.Albaran;
import model.Poo.Juguete;
import model.SqlAction;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file=null;
        int resp=0;
        String table="";
        FileReader reader=null;
        BufferedReader buffer=null;
        String salidaArchivo;

        do {
            System.out.println("Salir: 0" );
            System.out.println("Quiero importar xml: 1");
            System.out.println("Quiero exportar xml: 2");
            resp=sc.nextInt();
            switch (resp){
                case 1:
                    System.out.println("Que tabla quieres: Albaran,Factura,Juguete,NotaPago");
                    table = sc.next();
                    if (table.toUpperCase().equals("ALBARAN")){
                        try {
                            System.out.println("Pasame la ruta de tu archivo mamon");
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
                                e2.printStackTrace();
                            }
                        }
                    }if(table.toUpperCase().equals("FACTURA")){

                    }
                    break;
                case 2:
                    System.out.println("Que tabla quieres: Albaran,Factura,Juguete,NotaPago");
                    table = sc.next();
                    if (table.equalsIgnoreCase("JUGUETE")){
                        SqlAction sql = new SqlAction();
                        ArrayList<Juguete> j1 = sql.findJuguete();
                        String xml = Juguete.toXml(j1);
                        System.out.println(xml);
                    }if (table.equalsIgnoreCase("ALBARAN")){
                        SqlAction sql = new SqlAction();
                        ArrayList<Albaran> a1 = sql.findAlbaran();
                        String xml = Albaran.toXml(a1);
                        System.out.println(xml);
                    }if (table.equalsIgnoreCase("FACTURA")){
                        SqlAction sql = new SqlAction();
                        ArrayList<Factura> f1 = sql.
                }

            }
        }while (resp!=0);


    }
}