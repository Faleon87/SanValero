package model.MotorSql;

import Interfaces.InterfaceMotor;

import java.sql.*;

public class MotorSql implements InterfaceMotor {

    String RDS_INSTANCE_HOSTNAME = "localhost";

    String RDS_INSTANCE_PORT = "3306";
    String JDBC_URL = "jdbc:mysql://" + RDS_INSTANCE_HOSTNAME + ":" + RDS_INSTANCE_PORT + "/pruebainicial";


    private Connection conn;
    private Statement st;
    private ResultSet rs;


    @Override
    public void connect() {
        try {
            conn= DriverManager.getConnection(JDBC_URL , "root", "");
            st= conn.createStatement();
        }catch (SQLException e) {
            System.out.println("Error:" + e);
        }
    }

    @Override
    public int execute(String sql) {
        int rs = 0;
        try {
            rs= st.executeUpdate(sql);
        }catch (SQLException e){
            System.out.println("Error:" + e);
        }
        return  rs;
    }

    @Override
    public ResultSet executeQuery(String sql) {
        try {
            rs=st.executeQuery(sql);
        }catch (SQLException e){
            System.out.println("Error: " + e);
        }
        return  rs;
    }

    @Override
    public void disconnect() {
        try {
            if (conn!= null) {
                conn.close();
            }if (st!= null){
                st.close();
            } if (rs!= null) {
                rs.close();
            }
        }catch (SQLException e){
            System.out.println("Error: " + e);
        }

    }
}
