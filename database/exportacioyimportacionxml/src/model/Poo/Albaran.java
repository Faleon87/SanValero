package model.Poo;

import java.util.ArrayList;

public class Albaran {
    private int id_albaran;
    private  int id_pedido;
    private  int id_factura;

    private  String nombreEmpresaProveedora;
    private  String nombreResponsable;
    private  String nombreEmpresa;
    private  String fechaPedido;
    private  String fechaEnvio;

    public Albaran(int id_albaran, int id_pedido, int id_factura, String nombreEmpresaProveedora, String nombreResponsable, String nombreEmpresa, String fechaPedido, String fechaEnvio) {
        this.id_albaran = id_albaran;
        this.id_pedido = id_pedido;
        this.id_factura = id_factura;
        this.nombreEmpresaProveedora = nombreEmpresaProveedora;
        this.nombreResponsable = nombreResponsable;
        this.nombreEmpresa = nombreEmpresa;
        this.fechaPedido = fechaPedido;
        this.fechaEnvio = fechaEnvio;
    }

    public Albaran() {
    }

    public int getId_albaran() {
        return id_albaran;
    }

    public void setId_albaran(int id_albaran) {
        this.id_albaran = id_albaran;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_factura() {
        return id_factura;
    }

    public void setId_factura(int id_factura) {
        this.id_factura = id_factura;
    }

    public String getNombreEmpresaProveedora() {
        return nombreEmpresaProveedora;
    }

    public void setNombreEmpresaProveedora(String nombreEmpresaProveedora) {
        this.nombreEmpresaProveedora = nombreEmpresaProveedora;
    }

    public String getNombreResponsable() {
        return nombreResponsable;
    }

    public void setNombreResponsable(String nombreResponsable) {
        this.nombreResponsable = nombreResponsable;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public static String toXml(ArrayList<Albaran> info){
        String xml = "<Albarans>\n";
        for (int i = 0; i <info.size() ; i++) {
            xml+= "<Albaran pk=" + '"' + info.get(i).getId_albaran() + '"' + ">\n";
            xml+= "<id_albaran>" + info.get(i).getId_albaran() + "</id_albaran>\n";
            xml+= "<id_pedido>" + info.get(i).getId_pedido() +  "</id_pedido>\n";
            xml+= "<id_factura>" + info.get(i).getId_factura() + "</id_factura>\n";
            xml+= "<nombreEmpresaProveedora>" + info.get(i).getNombreEmpresaProveedora() + "</nombreEmpresaProveedora>\n";
            xml+= "<nombreResponsable>" + info.get(i).getNombreResponsable() + "</nombreResponsable>\n";
            xml+= "<nombreEmpresa>" + info.get(i).getNombreEmpresa() + "</nombreEmpresa\n";
            xml+= "<fechaPedido>" + info.get(i).getFechaPedido() + "</fechaPedido>\n";
            xml+= "<fechaEnvio>" + info.get(i).getFechaEnvio() + "</fechaPedido>\n";
            xml+= "</Albaran>\n";
        }
        xml+= "</Albarans>\n";
    return xml;
    }
}
