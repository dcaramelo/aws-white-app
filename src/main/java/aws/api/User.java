package aws.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  @Column(name="name", nullable=false)
  private String name;

  @Column(name="active", nullable=false, columnDefinition = "boolean default 1")
  private boolean active;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public boolean isActive() {
    return active;
  }

  public User setActive(boolean active) {
    this.active = active;
    return this;
  }
}
