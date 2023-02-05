package az.code.studentdbrest.conf;

import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal( @Nonnull HttpServletRequest request,
                                     @Nonnull HttpServletResponse response,
                                     @Nonnull FilterChain filterChain) throws ServletException, IOException {
final String authHeader=request.getHeader("Authorazition");
final String jwt;
final String userName;
if(authHeader==null || !authHeader.startsWith("Bearer")){
    filterChain.doFilter(request,response);
}
jwt=authHeader.substring(7);
//userName=
    }
}
