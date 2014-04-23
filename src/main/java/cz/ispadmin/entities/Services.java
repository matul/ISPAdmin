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
@Table(name = "services", catalog = "ropr")
public class Services implements java.io.Serializable {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id", unique = true, nullable = false) ///presunut aj ostatne properties
  private Integer id;

  @Size(min = 2, max = 20)
  private String name;

  @Size(min = 4, max = 50)
  private String description;

  @Size(min = 3, max = 10)
  private String price;

  public Services() {}

  public Services(String name, String description, String price, String date) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public void setData(Services service) {
    this.name = service.getName();
    this.description = service.getDescription();
    this.price = service.getPrice();
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
