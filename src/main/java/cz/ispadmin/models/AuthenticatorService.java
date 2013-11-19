package cz.ispadmin.models;

import cz.ispadmin.entities.Users;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Roman
 */
@Service
public class AuthenticatorService implements UserDetailsService {

  UserDAO userDAO;

  @Autowired
  public void setUserDAO(UserDAO userDAO) {
    this.userDAO = userDAO;
  }
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
    try {
      Users item = userDAO.getUser(username);
      return new User(item.getUsername(), "1234", getAuthorities());
    } catch (Exception e) {
      throw new UsernameNotFoundException("Error in retrieving user");
    }
  }

  public Collection<GrantedAuthority> getAuthorities() {
    // Create a list of grants for this user
    List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(1);
    authList.add(new GrantedAuthorityImpl("ROLE_USER"));
    return authList;
  }

}
