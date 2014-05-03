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
 * Address generated by hbm2java
 */
@Entity
@Table(name = "incidents", catalog = "ropr"
)
public class Incidents implements java.io.Serializable {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Integer id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "userId")
  private Users user;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "stateId")
  private IncidentStates state;

  @Size(min = 2, max = 30)
  private String subject;

  @Size(min = 2, max = 1000)
  private String message;

  @Size(min = 2, max = 1000)
  private String answer;

  public Incidents() {

  }

  public Incidents(String message) {
    this.message = message;
  }

  public void setData(Incidents incident) {
    this.message = incident.getMessage();
    this.subject = incident.getSubject();
    this.state = incident.getState();
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Users getUser() {
    return user;
  }

  public void setUser(Users user) {
    this.user = user;
  }

  public IncidentStates getState() {
    return state;
  }

  public void setState(IncidentStates state) {
    this.state = state;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

}
