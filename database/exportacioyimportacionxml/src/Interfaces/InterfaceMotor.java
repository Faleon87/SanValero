package Interfaces;

import java.sql.ResultSet;

public interface InterfaceMotor {
    void connect();
    int execute(String sql);
    ResultSet executeQuery(String sql);
    void disconnect();
}
