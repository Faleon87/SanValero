package model.Poo;

import java.util.ArrayList;

public class Factura {
private int id_factura;
private String medio_pago;
private String direccion_envio;
private int codigo_envio;
private  String companiaTransporte;
private  String fecha;

    public Factura(int id_factura, String medio_pago, String direccion_envio, int codigo_envio, String companiaTransporte, String fecha) {
        this.id_factura = id_factura;
        this.medio_pago = medio_pago;
        this.direccion_envio = direccion_envio;
        this.codigo_envio = codigo_envio;
        this.companiaTransporte = companiaTransporte;
        this.fecha = fecha;
    }
    public Factura(){

    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public String getDireccion_envio() {
        return direccion_envio;
    }

    public void setDireccion_envio(String direccion_envio) {
        this.direccion_envio = direccion_envio;
    }

    public int getCodigo_envio() {
        return codigo_envio;
    }

    public void setCodigo_envio(int codigo_envio) {
        this.codigo_envio = codigo_envio;
    }

    public String getCompaniaTransporte() {
        return companiaTransporte;
    }

    public void setCompaniaTransporte(String companiaTransporte) {
        this.companiaTransporte = companiaTransporte;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id_factura=" + id_factura +
                ", medio_pago='" + medio_pago + '\'' +
                ", direccion_envio='" + direccion_envio + '\'' +
                ", codigo_envio=" + codigo_envio +
                ", companiaTransporte='" + companiaTransporte + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }

    public static String toXML(ArrayList<Factura> infofactura){
        String xml="<Facturas>\n";
        for (int i = 0; i <infofactura.size() ; i++) {
            xml+= "<Factura pk=" + '"' + infofactura.get(i).getId_factura() + '"' + ">\n";
            xml+= "<id_factura>" + infofactura.get(i).getId_factura() + "</id_factura>\n";
            xml+= "<medio_pago>" + infofactura.get(i).getMedio_pago() + "</medio_pago>\n";
            xml+= "<direccion_envio>" + infofactura.get(i).getDireccion_envio() + "</direccion_envio>\n";
            xml+= "<codigo_envio>" + infofactura.get(i).getCodigo_envio() + "</codigo_envio>\n";
            xml+= "<compania_transporte>" + infofactura.get(i).getCompaniaTransporte() + "</compania_transporte>\n";
            xml+= "<fecha>" + infofactura.get(i).getFecha()+ "</fecha>\n";
            xml+="</Factura>\n";
        }
        xml+= "<Facturas>\n";
        return xml;
    }
}
