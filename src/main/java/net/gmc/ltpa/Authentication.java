package net.gmc.ltpa;

import javax.json.Json;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.Principal;

import static javax.ws.rs.core.Response.Status.OK;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

/**
 * @author Jaroslav Holan, jaroslav.holan@topmonks.com
 */
@Path("")
public class Authentication {


    @GET
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserInfo(@Context HttpServletRequest request) {
        Principal userPrincipal = request.getUserPrincipal();
        Response response;
        if (userPrincipal == null) {
            response = getErrorResponse();
        } else {
            response = getOkResponse(userPrincipal.getName());
        }
        return response;
    }

    private Response getErrorResponse() {
        String json = Json.createObjectBuilder()
                .add("error", "User is not logged.")
                .build().toString();
        return Response.status(UNAUTHORIZED).entity(json).build();
    }

    private Response getOkResponse(String username) {
        String json = Json.createObjectBuilder()
                .add("username", username)
                .build().toString();
        return Response.status(OK).entity(json).build();
    }

}
