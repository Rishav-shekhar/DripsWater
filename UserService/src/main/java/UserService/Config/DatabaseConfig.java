package UserService.Config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Profile("dev")
    @Configuration
    static class DevDatabaseConfig {
        public DevDatabaseConfig() {
            System.out.println("Using DEV database configuration");
        }
    }

    @Profile("prod")
    @Configuration
    static class ProdDatabaseConfig {
        public ProdDatabaseConfig() {
            System.out.println("Using PROD database configuration");
        }
    }
}

