package gr.ioannis.myosgi.web;

import gr.ioannis.myosgi.api.IoannisService;
import org.ops4j.pax.cdi.api.OsgiService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
public class IoannisResource {

    @OsgiService
    @Inject
    private IoannisService ioannisService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        ioannisService.execute();

        return Response.ok().build();
    }

}
