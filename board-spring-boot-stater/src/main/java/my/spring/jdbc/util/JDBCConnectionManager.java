package my.spring.jdbc.util;

import lombok.Setter;
import lombok.ToString;

import java.sql.Connection;
import java.sql.DriverManager;

@ToString
@Setter
public class JDBCConnectionManager {
  private String driverClass;
  private String url;
  private String username;
  private String password;
  
  public Connection getConnection() {
    try {
      Class.forName(driverClass);
      return DriverManager.getConnection(url, username, password);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
