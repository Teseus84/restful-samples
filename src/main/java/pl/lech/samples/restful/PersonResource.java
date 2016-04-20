package pl.lech.samples.restful;

import java.net.URI;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

@Path("persons")
public class PersonResource {

	private static final String SPACE_BRACKET = " ";

	@GET
	@Path("{first}-{last}")
	public Response person(@PathParam("first") String firstName, @PathParam("last") String lastName) {

		return Response.status(Status.OK).entity(String.join(SPACE_BRACKET, firstName, lastName)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(JsonObject jsonObj, @Context UriInfo info) {

		String firstName = jsonObj.getString("firstName");
		String lastName = jsonObj.getString("lastName");
		
		URI uri = info.getAbsolutePathBuilder().path("/" + firstName + "-" + lastName).build();

		return Response.created(uri).build();
	}

	@DELETE
	@Path("{id}")
	public Response deletePerson(@PathParam("id") String personId) {

		return Response.status(Status.OK).entity(String.join(SPACE_BRACKET, "Person with id:", personId, "deleted"))
				.build();
	}

}
