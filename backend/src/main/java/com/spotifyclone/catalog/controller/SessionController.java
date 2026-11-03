package com.spotifyclone.catalog.controller;
import com.spotifyclone.catalog.model.AppUser; import com.spotifyclone.catalog.repository.AppUserRepository; import jakarta.servlet.http.HttpSession; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import org.springframework.web.server.ResponseStatusException; import java.util.Map;
@RestController @RequestMapping("/api/auth") @CrossOrigin(origins={"http://localhost:5173","http://127.0.0.1:5173"},allowCredentials="true")
public class SessionController {
 private final AppUserRepository users; public SessionController(AppUserRepository users){this.users=users;}
 @PostMapping("/login") public Map<String,Object> login(@RequestBody Credentials body,HttpSession session){
  AppUser user=users.findByEmailIgnoreCase(body.username()==null?"":body.username()).orElse(null);
  if(user==null||!user.isActive()||!user.matchesPassword(body.password()==null?"":body.password()))throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Credenciales no válidas");
  session.setAttribute("userId",user.getId());return Map.of("id",user.getId(),"email",user.getEmail());
 }
 @GetMapping("/me") public Map<String,Object> me(HttpSession session){AppUser u=current(session);return Map.of("id",u.getId(),"email",u.getEmail());}
 @PostMapping("/logout") public ResponseEntity<Void> logout(HttpSession session){session.invalidate();return ResponseEntity.noContent().build();}
 AppUser current(HttpSession session){Object id=session.getAttribute("userId");if(!(id instanceof Long userId))throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Iniciá sesión");return users.findById(userId).orElseThrow(()->new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Iniciá sesión"));}
 public record Credentials(String username,String password){}
}
