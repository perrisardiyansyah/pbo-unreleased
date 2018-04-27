package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Constraint;

import play.db.ebean.Model;

@Entity
public class Finder extends Model {
	
		
		@Id
		@GeneratedValue
		public Long id;
		//@Constraint.Required
		public String namadepan;
		//@Constraint.Required
		public String namabelakang;
		public Integer umur;
		public String role;
		
		public void identitas() {		
		}
		
		public String toString() {
			return "id: " + id + "namadepan:" + namadepan + "namabelakang:" + namabelakang + "umur:" + umur + "role" + role;
		}
}
		
		//public static Model.Finders<Long.identitas>
		//find = new Model.Finder(Long.class.identitas.class);
		
		//public static identitas findById(long _id) {
			//return find.where()
					//.eq ( "id", _id)
					//.findUnique();
		//}
		
		//public static List<identitas> findAll(){
			//return find.all();
		//}
	//}

//}
