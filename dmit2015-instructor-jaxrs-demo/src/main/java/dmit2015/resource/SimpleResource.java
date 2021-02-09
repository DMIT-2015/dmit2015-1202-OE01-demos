package dmit2015.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;

/**
 *  URI						    Http Method     Request Body		                            Description
 *  ----------------------      -----------		-------------------------------------------     ------------------------------------------
 *  /webapi/simple/hello	GET			                                                    Return "Hello, World" in plain text format
 *  /webapi/simple/hello    GET                                                             Return "Hello, <strong>World</strong>" in HTML format
 *
 curl -i -X GET http://localhost:8080/dmit2015-instructor-jaxrs-demo/webapi/simple/hello \
   -H 'Content-Type:text/plain'

 curl -i -X GET http://localhost:8080/dmit2015-instructor-jaxrs-demo/webapi/simple/hello \
 -H 'Content-Type:text/html'

 */

@ApplicationScoped
@Path("/simple")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public class SimpleResource {

    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    @GET
    public String helloText() {
        return "Hello, World";
    }

    @Path("/hello")
    @Produces(MediaType.TEXT_HTML)
    @GET
    public String helloHtml() {
        return "Hello, <strong>World</strong>";
    }

}
