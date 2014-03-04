package cz.ispadmin.entities;
// Generated Nov 10, 2013 2:28:45 PM by Hibernate Tools 3.6.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", catalog = "ropr"
)
public class Users implements java.io.Serializable {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id", unique = true, nullable = false) ///presunut aj ostatne properties
  private Integer id;

  @Size(min = 2, max = 30)
  private String username;

  @Size(min = 2, max = 30)
  private String firstname;

  @Size(min = 2, max = 30)
  private String surname;

  @Size(min = 2, max = 30)
  private String description;

  public Users() {

  }

  public Users(String username) {
    this.username = username;
  }

  public Users(String username, String firstname, String surname, String description) {
    this.username = username;
    this.firstname = firstname;
    this.surname = surname;
    this.description = description;
  }
  
  public void setData(Users user) {
    this.username = user.getUsername();
    this.firstname = user.getFirstname();
    this.surname = user.getSurname();
    this.description = user.getDescription();
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  //@Column(name = "username", nullable = false, length = 30)
  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  //@Column(name = "firstname", length = 30)
  public String getFirstname() {
    return this.firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  //@Column(name = "surname", length = 30)
  public String getSurname() {
    return this.surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  //@Column(name = "description")
  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
