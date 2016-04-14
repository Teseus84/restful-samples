package pl.lech.samples.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("say")
public class SayResource {

	@GET
	public String sayHello() {
		return "Hello World";
	}

	@GET
	@Path("/{text}")
	public String saySomething(@PathParam("text") String text) {
		return "Hello " + text;
	}

}
