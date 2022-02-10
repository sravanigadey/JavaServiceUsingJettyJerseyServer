package com.maven.restapi;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("myresource")
public class MyResource extends HttpServlet {

    @Path("getmessage")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return "Welcome..!!";
    }

    @Path("msg")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage1() {
        return "Welcome to MyResource..!!";
    }
}
