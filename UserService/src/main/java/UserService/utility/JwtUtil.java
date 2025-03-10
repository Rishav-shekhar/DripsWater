package UserService.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private String secretKey = "yourSecretKey"; // Replace with a secure key

    // Extract Username from JWT
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Extract All Claims from JWT
    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }
}

