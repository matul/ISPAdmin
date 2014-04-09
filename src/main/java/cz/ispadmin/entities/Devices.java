package cz.ispadmin.entities;

import cz.ispadmin.models.validators.IPAdress;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author Honza
 */
@Entity
@Table(name = "devices", catalog = "ropr"
)
public class Devices implements java.io.Serializable {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "userId")
  private Users user;

  @Size(min = 2, max = 30)
  @IPAdress(message = "Špatná ip adresa!")
  private String ipAdress;

  @Size(min = 2, max = 100)
  private String localization;

  @Size(min = 2, max = 17)
  private String macAdress;

  @Size(min = 2, max = 50)
  private String manufacturer;

  @Size(min = 2, max = 50)
  private String model;

  @Size(min = 2, max = 50)
  private String name;

  public Devices() {

  }

  public Devices(String ipAdress) {
    this.ipAdress = ipAdress;
  }

  public Integer getId() {
    return this.id;
  }

  public String getLocalization() {
    return this.localization;
  }

  public String getIpAdress() {
    return this.ipAdress;
  }

  public String getMacAdress() {
    return this.macAdress;
  }

  public Users getUser() {
    return this.user;
  }

  public void setData(Devices u) {
    this.id = u.getId();
    this.ipAdress = u.getIpAdress();
    this.localization = u.getLocalization();
    this.macAdress = u.getMacAdress();
    this.manufacturer = u.getManufacturer();
    this.model = u.getModel();
    this.name = u.getName();
    this.user = u.getUser();
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setUser(Users user) {
    this.user = user;
  }

  public void setIpAdress(String ipAdress) {
    this.ipAdress = ipAdress;
  }

  public void setLocalization(String localization) {
    this.localization = localization;
  }

  public void setMacAdress(String macAdress) {
    this.macAdress = macAdress;
  }

}
