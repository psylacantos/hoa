/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class Penalties {
	private int id;
	protected int level;
	public String desc;
	public double fee;
	public String action;
	private int document;
	
	
	

	

	public Penalties(int id, int level, String desc, double fee, String action, int document) {
		
		this.id = id;
		this.level = level;
		this.desc = desc;
		this.fee = fee;
		this.action = action;
		this.document = document;
		
	}


	



	public int getId() {
		return id;
	}


	

	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}


	public String getDesc() {
		return desc;
	}


	public int getDocument() {
		return document;
	}


	public void setDocument(int document) {
		this.document = document;
	}
	
}
