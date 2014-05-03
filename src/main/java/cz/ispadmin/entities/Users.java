package cz.ispadmin.entities;

import cz.ispadmin.models.validators.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", catalog = "ropr")
public class Users implements java.io.Serializable {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @Size(min = 2, max = 20)
  private String username;

  @Size(min = 4, max = 50)
  private String password;

  @Size(min = 3, max = 10)
  private String firstname;

  @Size(min = 3, max = 15)
  private String surname;

  @Size(min = 2, max = 30)
  private String description;

  @Size(min = 2, max = 15)
  private String city;

  @Size(min = 2, max = 15)
  private String street;

  @Size(min = 2, max = 6)
  private String post_code;

  @Size(min = 8, max = 30)
  @Email(message = "špatný mail")
  private String email;

  @Phone(message = "špatné číslo")
  private String phone_number;

  @Birth(message = "špatné datum narození")
  private String birthDate;

  private String forgotten_pass_hash;

  public Users() {
  }

  public Users(String username, String password, String firstname, String surname, String description, String city,
               String street, String post_code, String email, String phone_number, String birthDate, String forgottenPassHash) {
    this.username = username;
    this.password = password;
    this.firstname = firstname;
    this.surname = surname;
    this.description = description;
    this.city = city;
    this.street = street;
    this.post_code = post_code;
    this.email = email;
    this.phone_number = phone_number;
    this.birthDate = birthDate;
    this.forgotten_pass_hash = forgottenPassHash;
  }

  public void setData(Users user) {
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.firstname = user.getFirstname();
    this.surname = user.getSurname();
    this.description = user.getDescription();
    this.city = user.getCity();
    this.street = user.getStreet();
    this.post_code = user.getPost_code();
    this.email = user.getEmail();
    this.phone_number = user.getPhone_number();
    this.birthDate = user.getBirthDate();
    this.forgotten_pass_hash = user.getForgottenPassHash();
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstname() {
    return this.firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getSurname() {
    return this.surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getPost_code() {
    return post_code;
  }

  public void setPost_code(String post_code) {
    this.post_code = post_code;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone_number() {
    return phone_number;
  }

  public void setPhone_number(String phone_number) {
    this.phone_number = phone_number;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getForgottenPassHash() {
    return forgotten_pass_hash;
  }

  public void setForgottenPassHash(String forgottenPassHash) {
    this.forgotten_pass_hash = forgottenPassHash;
  }
}
