package com.human.springboot.dto;

public class DepartmentDTO {

	int dep_id;
	String dep_name;
	int dep_manager;
	int dep_parent;
	
	// Get, Set
	public int getDep_id() {
		return dep_id;
	}
	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
	}
	public String getDep_name() {
		return dep_name;
	}
	public void setDep_name(String dep_name) {
		this.dep_name = dep_name;
	}
	public int getDep_manager() {
		return dep_manager;
	}
	public void setDep_manager(int dep_manager) {
		this.dep_manager = dep_manager;
	}
	public int getDep_parent() {
		return dep_parent;
	}
	public void setDep_parent(int dep_parent) {
		this.dep_parent = dep_parent;
	}
	
	
	

}
