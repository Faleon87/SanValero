package model.Poo;

import java.util.ArrayList;

public class NotaPago {
    private int id_nota_pago;
    private int id_particular;
    private String  dni;
    private String nombre_particular;
    private String fecha_particular;

    public NotaPago(int id_nota_pago, int id_particular, String dni, String nombre_particular, String fecha_particular) {
        this.id_nota_pago = id_nota_pago;
        this.id_particular = id_particular;
        this.dni = dni;
        this.nombre_particular = nombre_particular;
        this.fecha_particular = fecha_particular;
    }
    public NotaPago(){

    }

    public int getId_nota_pago() {
        return id_nota_pago;
    }

    public void setId_nota_pago(int id_nota_pago) {
        this.id_nota_pago = id_nota_pago;
    }

    public int getId_particular() {
        return id_particular;
    }

    public void setId_particular(int id_particular) {
        this.id_particular = id_particular;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre_particular() {
        return nombre_particular;
    }

    public void setNombre_particular(String nombre_particular) {
        this.nombre_particular = nombre_particular;
    }

    public String getFecha_particular() {
        return fecha_particular;
    }

    public void setFecha_particular(String fecha_particular) {
        this.fecha_particular = fecha_particular;
    }

    @Override
    public String toString() {
        return "NotaPago{" +
                "id_nota_pago=" + id_nota_pago +
                ", id_particular=" + id_particular +
                ", dni='" + dni + '\'' +
                ", nombre_particular='" + nombre_particular + '\'' +
                ", fecha_particular='" + fecha_particular + '\'' +
                '}';
    }

    public static String toXML(ArrayList<NotaPago> infonotapago){
        String xml= "<NotasPagos>\n";
        for (int i = 0; i < infonotapago.size(); i++) {
            xml+= "<NotaPago pk=" + '"' + infonotapago.get(i).getId_nota_pago() + '"' + ">\n";
            xml+= "<id_nota_pago>" + infonotapago.get(i).getId_nota_pago() + "</id_nota_pago>\n";
            xml+= "<id_particular>" + infonotapago.get(i).getId_particular() + "</id_particular>\n";
            xml+= "<dni>" + infonotapago.get(i).getDni() + "</dni>\n";
            xml+= "<nombre_particular>" + infonotapago.get(i).getNombre_particular() + "</nombre_particular>\n";
            xml+= "<fecha_particular>" + infonotapago.get(i).getFecha_particular() + "</fecha_particular>\n";
            xml+= "<NotasPagos>\n";
        }
        xml+="</NotasPagos>\n";
        return xml;
    }
}
