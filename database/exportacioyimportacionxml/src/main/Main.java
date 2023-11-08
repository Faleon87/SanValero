package main;

import model.Poo.Albaran;
import model.Poo.Factura;
import model.Poo.Juguete;
import model.Poo.NotaPago;
import model.SqlAction;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
        Document doc;
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
                            doc= dBuilder.parse(file);
                            doc.getDocumentElement().normalize();
                            NodeList nodeList = doc.getElementsByTagName("Albarans");
                            for (int i = 0; i <nodeList.getLength() ; i++) {
                                Node nodo = nodeList.item(i);
                                if (nodo.getNodeType() == Node.ELEMENT_NODE){
                                    Element elemento = (Element) nodo;
                                    Albaran albaran = Albaran.fromXml(elemento);
//                                    boolean exist = sql.checkduplicateregister()
                                   // if (exist) {
                                     //   System.out.println("Ya existe este registro");
                                    //}else{
                                        int result = sql.InsertAlbaran(albaran);
                                        System.out.println(result);
                                    //}
                                }
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
                        try (FileWriter writer = new FileWriter("C:\\Users\\jaime\\OneDrive\\Escritorio\\SanValero\\database\\exportacioyimportacionxml\\src\\xml\\juguetes.xml")) {
                           writer.write(xml);
                            System.out.println("ArrayList exportado a XML correctamente.");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }if (table.equalsIgnoreCase("ALBARAN")){
                        ArrayList<Albaran> a1 = sql.findAlbaran();
                         xml = Albaran.toXml(a1);
                        System.out.println(xml);
                    }if (table.equalsIgnoreCase("FACTURA")){
                        ArrayList<Factura> f1 = sql.findFactura();
                        xml = Factura.toXML(f1);
                    }if(table.equalsIgnoreCase("NOTAPAGO")){
                        ArrayList<NotaPago> n1 = sql.findNotaPago();
                        xml = NotaPago.toXML(n1);
                        System.out.println(xml);
                    }
            }
        }while (resp!=0);




    }
}