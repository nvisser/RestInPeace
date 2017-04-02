package nl.bcome.iac.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/DistrictService")
public class DistrictService {
    @GET
    @Path("/districts/{name}/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public InhabitantResponse getInhabitants(
            @PathParam(value = "name") String name,
            @PathParam(value = "year") int year) {
        return ServiceProvider.getParkingService().calcInhabitants(name, year);
    }
}
