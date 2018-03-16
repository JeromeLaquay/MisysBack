package com.jerome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ITEM_SEQ")
  @SequenceGenerator(sequenceName = "item_seq", initialValue = 1, allocationSize = 1, name = "ITEM_SEQ")
  private Long id;

  private String name;
  
  private int points;
  
  private String imageUrl;
  
  @ManyToOne
  private Podium podium;


  public Item() {
    super();
  }

public Item(Long id, String name, int points, String imageUrl, Podium podium) {
	super();
	this.id = id;
	this.name = name;
	this.points = points;
	this.imageUrl = imageUrl;
	this.podium = podium;
}



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getPoints() {
	return points;
}

public void setPoints(int points) {
	this.points = points;
}

public String getImageUrl() {
	return imageUrl;
}

public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}

public Podium getPodium() {
	return podium;
}

public void setPodium(Podium podium) {
	this.podium = podium;
}

//@Override
//public String toString() {
//    return "Item{" +
//            "id=" + id +
//            ", name='" + name + '\'' +
//            ", points='" + points + '\'' +
//            ", imageUrl=" + imageUrl + '\'' +
//            ", podium=" + podium +
//            '}';
//}



}