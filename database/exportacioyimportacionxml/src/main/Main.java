package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File file;
        int resp;
        String table;
        FileReader reader;

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
                        System.out.println("Pasame la ruta de tu archivo mamon");
                        table = sc.next();
                        file = new File(table);
                        try {
                            reader=new FileReader(file);
                        } catch (FileNotFoundException e) {
                            System.out.println("tonto: " + e);
                        }
                    }if(table.toUpperCase().equals("FACTURA")){

                    }
                    break;
                case 2:

            }
        }while (resp!=0);


    }
}