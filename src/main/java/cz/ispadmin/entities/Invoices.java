package cz.ispadmin.entities;

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
 * @author Maya
 */
@Entity
@Table(name = "invoices", catalog = "ropr"
)
public class Invoices implements java.io.Serializable {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "userId")
  private Users user;

  @Size(min = 2, max = 30)
  private String issueDate;

  @Size(min = 2, max = 30)
  private String dueDate;

  @Size(min = 2, max = 100)
  private String price;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="stateId")
  private InvoiceStates state;

  public Invoices() {

  }

  public Invoices(String issueDate) {
    this.issueDate = issueDate;
  }

  public void setData(Invoices i) {
    this.id = i.getId();
    this.issueDate = i.getIssueDate();
    this.dueDate = i.getDueDate();
    this.price = i.getPrice();
    this.state = i.getState();
    this.user = i.getUser();
  }

  public Integer getId() {
    return this.id;
  }

  public Users getUser() {
    return this.user;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }

  public void setUser(Users user) {
    this.user = user;
  }

  public String getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(String issueDate) {
    this.issueDate = issueDate;
  }

  public String getDueDate() {
    return dueDate;
  }

  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  public InvoiceStates getState() {
    return state;
  }

  public void setState(InvoiceStates state) {
    this.state = state;
  }
}
