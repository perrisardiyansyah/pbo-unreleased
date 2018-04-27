package controllers;

import models.*;
import static play.data.Form.form;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;
import views.*;
import javax.persistence.*;
import play.db.ebean.*;
import java.util.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result showAddDataSensorForm() {
        Form<DataSensor> theform = form(DataSensor.class).bindFromRequest();
        return ok(addDataSensor.render(theform.fill(new DataSensor()),DataSensor.findAll(),"Test"));
    }
    
    public static Result addDataSensor() {
	    Form<DataSensor> theform = form(DataSensor.class).bindFromRequest();    
	    if(theform.hasErrors()) {
	         Logger.error("Error: " + theform.errorsAsJson() );               
	         return badRequest(addDataSensor.render(theform, DataSensor.findAll(), 
	        		 "Error: " + theform.errorsAsJson()) );
	    }
	    else{ 
	    	DataSensor datasensor = theform.get();
	    	if (datasensor.id == null){
   	           datasensor.save();
   	           Logger.debug( datasensor.toString() );
   	           return ok( addDataSensor.render(theform, DataSensor.findAll(), "success") );
	    	}

	    	else{
   	           datasensor.update();
   	           Logger.debug( datasensor.toString() );
   	           return ok( addDataSensor.render(theform, DataSensor.findAll(), "updated") );
	    	} 
         }	 	    
    }
    
    @play.db.ebean.Transactional
	public static Result tampilkan() {       
		List<DataSensor> daftar = DataSensor.findAll();
    	return ok(tampilkanDataSensor.render(daftar));
    }
    
    public static Result deleteDataSensor(Long _id) {
        Form<DataSensor> theform = form(DataSensor.class).bindFromRequest();
         DataSensor datasensor = DataSensor.findById(_id);
         if (datasensor == null){
              return badRequest(addDataSensor.render(theform.fill(new DataSensor()), DataSensor.findAll(), "Data tak ditemukan" ) );
         }
         else{
              datasensor.delete();
              return ok(addDataSensor.render(theform.fill(new DataSensor()), DataSensor.findAll(), "Data telah dihapus" ) );
         }
	}
    
    public static Result editDataSensor(Long _id) {
        Form<DataSensor> theform = form(DataSensor.class).bindFromRequest();
        DataSensor datasensor = DataSensor.findById(_id);       
        if (datasensor == null){
           return badRequest(addDataSensor.render(theform.fill(new DataSensor()), DataSensor.findAll(), "Karyawan not found" ) );
        }
        else{
           return ok(addDataSensor.render(theform.fill(datasensor), DataSensor.findAll(), "" ) );
        }
	}	

}
