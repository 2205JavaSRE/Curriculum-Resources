package com.revature.models;


import java.util.List;
import java.util.Objects;

public class Planet{
	
	private int id;
	private String name;
	private List<Moon> myMoons;
	public Planet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Planet(int id, String name, List<Moon> myMoons) {
		super();
		this.id = id;
		this.name = name;
		this.myMoons = myMoons;
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
	public List<Moon> getMyMoons() {
		return myMoons;
	}
	public void setMyMoons(List<Moon> myMoons) {
		this.myMoons = myMoons;
	}
	@Override
	public String toString() {
		return "Planet [id=" + id + ", name=" + name + ", myMoons=" + myMoons + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, myMoons, name);
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
		return id == other.id && Objects.equals(myMoons, other.myMoons) && Objects.equals(name, other.name);
	}
	
	
	
	
	
	

}
