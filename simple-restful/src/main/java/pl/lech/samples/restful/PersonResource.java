package pl.lech.samples.restful;

import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("persons")
public class PersonResource {

	private static final String PERSON_ID = "personId";
	private static final String SPACE_BRACKET = " ";
	private static final String LAST_NAME = "lastName";
	private static final String FIRST_NAME = "firstName";

	@PUT
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addPerson(JsonObject obj) {

		String firstName = obj.getString(FIRST_NAME);
		String lastName = obj.getString(LAST_NAME);

		return String.join(SPACE_BRACKET, "Person", firstName, lastName, "added");
	}

	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePerson(@QueryParam(PERSON_ID) String personId) {
		return String.join(SPACE_BRACKET, "Person with id:", personId, "deleted");

	}

}
