package model;

import model.MotorSql.MotorSql;
import model.Poo.Juguete;

import java.sql.ResultSet;
import java.util.ArrayList;

public class SqlAction {

    private final String SQL_SELECT="select *  from juguete";
    private MotorSql motorSql;

    public  SqlAction(){
        this.motorSql = new MotorSql();
    }
    public ArrayList<Juguete> findProveedor(){
        ArrayList<Juguete> infoProveedor= new ArrayList<>();
        String sql = SQL_SELECT;
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
                infoProveedor.add(juguete);
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }finally {
            this.motorSql.disconnect();
        }
        return infoProveedor;

    }

}
