package cz.ispadmin.services.authentication;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SignedInUser extends User {
  
  private static final long serialVersionUID = -3531439484732724601L;
  
  private int id;
  
  public SignedInUser(int id, String username, String password, boolean enabled, 
                      boolean accountNonExpired, boolean credentialsNonExpired, 
                      boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
    
    super(username, password, enabled, accountNonExpired, credentialsNonExpired, 
          accountNonLocked, authorities);
    
    this.id = id;
  }

  public int getUserID() {
    return id;
  }
}
