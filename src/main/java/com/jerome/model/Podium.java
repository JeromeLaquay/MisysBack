package com.jerome.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Podium {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POD_SEQ")
  @SequenceGenerator(sequenceName = "podium_seq", initialValue = 1, allocationSize = 1, name = "POD_SEQ")
  private Long idpodium;

  private String name;
  
  private int numberOfVotes;
  
  @OneToMany(mappedBy="podium", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Item> items;

  public Podium() {
    super();
  }

public Podium(Long idpodium, String name, int numberOfVotes, List<Item> items) {
	super();
	this.idpodium = idpodium;
	this.name = name;
	this.numberOfVotes = numberOfVotes;
	this.items = items;
}

public Podium(String name) {
	this.name = name;
}



public Long getIdpodium() {
	return idpodium;
}

public void setIdpodium(Long idpodium) {
	this.idpodium = idpodium;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getNumberOfVotes() {
	return numberOfVotes;
}

public void setNumberOfVotes(int numberOfVotes) {
	this.numberOfVotes = numberOfVotes;
}

public List<Item> getItems() {
	return items;
}

public void setItems(List<Item> items) {
	this.items = items;
}

//@Override
//public String toString() {
//    return "Podium{" +
//            "idpodium=" + idpodium +
//            ", name='" + name + '\'' +
//            ", numberOfVotes='" + numberOfVotes + '\'' +
//            ", items=" + items+
//            '}';
//}





}