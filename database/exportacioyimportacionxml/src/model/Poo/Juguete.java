package model.Poo;

public class Juguete {

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

    public String toXml(){
        return "<Juguetes>" +
                "<id_juguete>" +
                id_juguete +
                "</id_juguete>" +
                "<id_nota_pago>" +
                id_nota_pago +
                "</id_nota_pago>" +
                "<nombre>"+
                nombre+
                "</nombre>"+
                "<cantidad>"+
                cantidad +
                "</cantidad>"+
                "<precio>" +
                precio +
                "</precio>"+
                "</Juguetes>";
    }

}
