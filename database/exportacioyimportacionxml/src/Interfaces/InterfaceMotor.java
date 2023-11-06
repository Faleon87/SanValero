package Interfaces;

import java.sql.ResultSet;

public interface InterfaceMotor {
    public void connect();
    public  int execute(String sql);
    public ResultSet executeQuery(String sql);
    public  void disconnect();
}
