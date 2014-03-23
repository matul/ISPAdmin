package cz.ispadmin.models.dao;

import cz.ispadmin.entities.Users;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Matul
 */
@Service
public class AuthenticationDAO extends DAO implements UserDetailsService {
  
  private UserDAO userDao;
  
  // Temporary usage (TODO: remove)
  private boolean accountNonExpired = true;
  private boolean accountNonLocked = true;
  private boolean credentialsNonExpired = true;
  private boolean accountEnabled = true;
  
  public final String ROLE_USER = "user";
  public final String ROLE_ADMIN = "admin";

  //  @Autowired
  //  public AuthenticationDAO(UserDAO userDao) {
  //    this.userDao = userDao;
  //  }
  
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
    
    User userDetail = new User(
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
