package az.code.studentdbrest.config;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JWTToPrincipalConverter {
public UserPrinciple convert(DecodedJWT jwt){
    return UserPrinciple.builder()
            .userId(Long.valueOf(jwt.getSubject()))
            .email(jwt.getClaim("e").asString())
            .authorities(extractAuthoritiesFromClaim(jwt))
            .build();
}
public List<SimpleGrantedAuthority> extractAuthoritiesFromClaim(DecodedJWT jwt){
    var claim=jwt.getClaim("a");
    if(claim.isNull()|| claim.isMissing()) return List.of();
    return claim.asList(SimpleGrantedAuthority.class);
}

}
