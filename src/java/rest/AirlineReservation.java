package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("reservation")
//@RolesAllowed("Admin")
public class AirlineReservation {

    @POST
    @Path("/flightId")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postReservation(@PathParam("flightId") String flightId) {

        return "hej";
    }

}
