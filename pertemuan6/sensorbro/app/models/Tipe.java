package models;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.Constraints;
import play.db.ebean.*;

import java.util.*;

@Entity
public class Tipe {
public String tipe;
	
	public String toString(){
	    return "tipe: " + tipe;
	}
	 
	public Tipe() {
	}
	
	// -- Queries  
	public static Model.Finder<Long,Tipe> find = new Model.Finder(Long.class, Tipe.class);
	 
	// Find by id:
	public static Tipe findById(Long _id){
	   return find.where()
	   .eq( "id", _id )
       .findUnique();
	}
	

}
