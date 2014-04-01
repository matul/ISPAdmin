package cz.ispadmin.services.authentication;

import cz.ispadmin.entities.Users;
import cz.ispadmin.models.dao.DAO;
import cz.ispadmin.models.dao.UserDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Matul
 */
@Service
public class Authenticator extends DAO implements UserDetailsService {
  
  private UserDAO userDao;
  
  // Temporary usage (TODO: remove)
  private boolean accountNonExpired = true;
  private boolean accountNonLocked = true;
  private boolean credentialsNonExpired = true;
  private boolean accountEnabled = true;
  
  public final String ROLE_USER = "user";
  public final String ROLE_ADMIN = "admin";
  
  @Autowired
  public void setUserDao(UserDAO userDao) {
    this.userDao = userDao;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Users user = this.userDao.getUserByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException(username);
    }

    List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
    authorities.add(new SimpleGrantedAuthority(ROLE_USER));
    
    SignedInUser userDetail = new SignedInUser (
      user.getId(),      
      user.getUsername(),
      user.getPassword(),
      this.accountEnabled,
      this.accountNonExpired,
      this.credentialsNonExpired,
      this.accountNonLocked,
      authorities
    );
    
  return userDetail;
  }
}
