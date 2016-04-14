package pl.lech.samples.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("say")
public class SayResource {

	@GET
	@Produces("text/html")
	public String sayHello() {
		return "Hello World";
	}

	@GET
	@Path("/{text}")
	@Produces("text/html")
	public String saySomething(@PathParam("text") String text) {
		return "Hello " + text;
	}

}
