package main;

import model.Poo.Juguete;
import model.SqlAction;

import java.io.*;
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
               SqlAction sql = new SqlAction();
               sql.findProveedor();
                    break;
            }
        }while (resp!=0);


    }
}