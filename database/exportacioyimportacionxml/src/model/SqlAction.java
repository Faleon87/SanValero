package model;

import model.MotorSql.MotorSql;
import model.Poo.Albaran;
import model.Poo.Factura;
import model.Poo.Juguete;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SqlAction {

    private final String SQL_SELECT_JUGUETE="select *  from juguete";
    private final String SQL_SELECT_ALBARAN="select * from albaran";
    private final String SQL_SELECT_FACTURA="select * from factura";
    private MotorSql motorSql;

    public  SqlAction(){
        this.motorSql = new MotorSql();
    }
    public ArrayList<Juguete> findJuguete(){
        ArrayList<Juguete> infoJuguete= new ArrayList<>();
        String sql = SQL_SELECT_JUGUETE;
        try {
            this.motorSql.connect();
            ResultSet rs = this.motorSql.executeQuery(sql);
            while (rs.next()){
                Juguete juguete = new Juguete();
                juguete.setId_juguete(rs.getInt(1));
                juguete.setId_nota_pago(rs.getInt(2));
                juguete.setNombre(rs.getString(3));
                juguete.setCantidad(rs.getInt(4));
                juguete.setPrecio(rs.getInt(5));
                infoJuguete.add(juguete);
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }finally {
            this.motorSql.disconnect();
        }
        return infoJuguete;

    }
    public ArrayList<Albaran> findAlbaran(){
        ArrayList<Albaran> infoAlbaran= new ArrayList<>();
        String sql = SQL_SELECT_ALBARAN;
        try {
            this.motorSql.connect();
            ResultSet rs = this.motorSql.executeQuery(sql);
            while (rs.next()){
               Albaran albaran = new Albaran();
               albaran.setId_albaran(rs.getInt(1));
               albaran.setId_pedido(rs.getInt(2));
               albaran.setId_factura(rs.getInt(3));
               albaran.setNombreEmpresaProveedora(rs.getString(4));
               albaran.setNombreResponsable(rs.getString(5));
               albaran.setNombreEmpresa(rs.getString(6));
               albaran.setFechaPedido(rs.getString(7));
               albaran.setFechaEnvio(rs.getString(8));
               infoAlbaran.add(albaran);
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }finally {
            this.motorSql.disconnect();
        }
        return infoAlbaran;

    }

    public ArrayList<Factura>  findFactura(){
        ArrayList<Factura> infoFactura= new ArrayList<>();
        String sql = SQL_SELECT_FACTURA;
        try {
            this.motorSql.connect();
            ResultSet rs = this.motorSql.executeQuery(sql);
            while (rs.next()){
                Factura factura = new Factura();
                factura.setId_factura(rs.getInt(1));
                factura.setMedio_pago(rs.getString(2));
                factura.setDireccion_envio(rs.getString(3));
                factura.setCodigo_envio(rs.getInt(4));
                factura.setCompaniaTransporte(rs.getString(5));
                factura.setFecha(rs.getString(6));
                infoFactura.add(factura);
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }finally {
            this.motorSql.disconnect();
        }
        return infoFactura;
    }

}
