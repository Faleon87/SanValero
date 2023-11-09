package model.Poo;

import org.w3c.dom.Element;

import java.util.ArrayList;

public class Juguete extends ArrayList<Juguete> {

    private int id_juguete;
    private int id_nota_pago;
    private String nombre;
    private int cantidad;

    private int precio;

    public Juguete(int id_juguete, int id_nota_pago, String nombre, int cantidad, int precio) {
        this.id_juguete = id_juguete;
        this.id_nota_pago = id_nota_pago;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public Juguete(){

    }

    public int getId_juguete() {
        return id_juguete;
    }

    public void setId_juguete(int id_juguete) {
        this.id_juguete = id_juguete;
    }

    public int getId_nota_pago() {
        return id_nota_pago;
    }

    public void setId_nota_pago(int id_nota_pago) {
        this.id_nota_pago = id_nota_pago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public static Juguete fromXml(Element elemento){
        Juguete juguete = new Juguete();
        String id_nota_pago = elemento.getElementsByTagName("id_nota_pago").item(0).getTextContent();
        juguete.setId_nota_pago(Integer.parseInt(id_nota_pago));
        juguete.setNombre(elemento.getElementsByTagName("nombre").item(0).getTextContent());
        String cantidad = elemento.getElementsByTagName("cantidad").item(0).getTextContent();
        juguete.setCantidad(Integer.parseInt(cantidad));
        String precio = elemento.getElementsByTagName("precio").item(0).getTextContent();
        juguete.setPrecio(Integer.parseInt(precio));
        return juguete;
    }
    @Override
    public String toString() {
        return "Juguete{" +
                "id_juguete=" + id_juguete +
                ", id_nota_pago=" + id_nota_pago +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                '}';
    }

    public static String toXml(ArrayList<Juguete> info){
        String xml="<Juguetes>\n";
        for (int i = 0; i <info.size() ; i++) {
            xml += "<Juguete pk=" + '"' + info.get(i).getId_juguete() + '"' + ">\n";
            xml += "<id_juguete>" + info.get(i).getId_juguete() + "</id_juguete>\n";
            xml += "<id_nota_pago>" + info.get(i).getId_nota_pago() + "</id_nota_pago>\n";
            xml += "<nombre>" + info.get(i).getNombre() + "</nombre>\n";
            xml += "<cantidad>" + info.get(i).getCantidad() + "</cantidad>\n";
            xml += "<precio>" + info.get(i).getPrecio() + "</precio>\n";
            xml += "</Juguete>\n";
        }
        xml+= "</Jugetes>\n";
        return xml;
    }

}
