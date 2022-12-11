package my.spring.jdbc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "board.jdbc")
public class JDBCConnectionManagerProperties {
  private String driverClass;
  private String url;
  private String username;
  private String password;
}
