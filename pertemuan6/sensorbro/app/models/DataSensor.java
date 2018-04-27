package models;
import java.util.*;
import javax.persistence.*;

import play.data.Form;
import play.db.ebean.*;
import play.mvc.Content;
@SuppressWarnings("serial")
@Entity
public class DataSensor extends Model {
	@Id
	public Long id;
	
	@Basic
	public int value; 
	
	@Basic
	public int jumlah; 
	
	@Basic
	public int input; 
	
	@Basic
	public int output;
	
	@Basic
	public String node; 
	
	@Basic
	public String tipe;
	
	public DataSensor() {
		
	}
	
	public String toString() {
		String result = "ID : " + id +" | ";
		result += "Value : " + value + " | ";
		result += "Jumlah : " + jumlah + " | ";
		result += "Input : " + input + " | ";
		result += "Output : " + output + " | ";
		result += "Node : " + node + " | ";
		result += "Tipe : " + tipe + " | ";
		return result;
	}


	public static Finder<Long, DataSensor> find = new Finder<Long, DataSensor>(Long.class, DataSensor.class);
	public static DataSensor findById( Long _id) {
		return find.where()
		.eq("id", _id)
		.findUnique();
	}
	
	public static List<DataSensor> findAll(){
		return find.all();
	}

	public  Content render(Form<DataSensor> fill, List<DataSensor> findAll, String string) {
		// TODO Auto-generated method stub
		return null;
	}


}
