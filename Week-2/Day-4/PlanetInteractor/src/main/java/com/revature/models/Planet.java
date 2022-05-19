package com.revature.models;


import java.util.Objects;

public class Planet{
	
	private int id;
	private String name;
	private boolean rings;
	public Planet() {
		super();
		
	}
	public Planet(int id, String name, boolean rings) {
		super();
		this.id = id;
		this.name = name;
		this.rings = rings;
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
	public boolean isRings() {
		return rings;
	}
	public void setRings(boolean rings) {
		this.rings = rings;
	}
	@Override
	public String toString() {
		return "Planet [id=" + id + ", name=" + name + ", rings=" + rings + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, rings);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planet other = (Planet) obj;
		return id == other.id && Objects.equals(name, other.name) && rings == other.rings;
	}
	
	

}
