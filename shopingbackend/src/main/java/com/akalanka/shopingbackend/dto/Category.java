package com.akalanka.shopingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String name;
	private String description;
	
	@Column(name="is_active")
	private boolean active = true;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", active=" + active
				+ ", imageUrl=" + imageUrl + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
