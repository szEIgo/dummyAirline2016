package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import entity.Flight;
import facades.AirlineFacade;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("flights")
//@RolesAllowed("Admin")
public class AirlineFlights {
  
    Gson gson;
     AirlineFacade af;
    
     public AirlineFlights() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        af = new AirlineFacade();
    }
  
  @GET
  @Path("/{from}/{date}/{tickets}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getFlightsFrom(@PathParam("from") String from, 
          @PathParam("date") String date, @PathParam("tickets") int tickets){
       JsonObject jb = new JsonObject();
       jb.addProperty("airline", "Flight-Hunter Airlines");
       jb.add("flights", gson.toJsonTree(af.getFlightsFrom(from, date, tickets)));
            
      return gson.toJson(jb);
  }
  
  @GET
  @Path("/{from}/{to}/{date}/{tickets}")
  @Produces(MediaType.APPLICATION_JSON)
  public String getFlightsFromTo(@PathParam("from") String from, @PathParam("to") String to,
          @PathParam("date") String date, @PathParam("tickets") int tickets){
      
       
      return gson.toJson(af.getFlightsFromTo(from, to, date, tickets));
  }
  
  
 
}
