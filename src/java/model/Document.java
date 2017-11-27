/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
public class Document {
	private int id;
	public String desc;
	public String location;
	public int folder;
	private BoardMember create_User;
	
	public Document(){
		
		
	}
	
	public Document(int id, String desc, String location, int folder, BoardMember create_User) {
		super();
		this.id = id;
		this.desc = desc;
		this.location = location;
		this.folder = folder;
		this.create_User = create_User;
	}
	public int getId() {
		return id;
	}
	
	
	public BoardMember getCreate_User() {
		return create_User;
	}
	
	
}
