package com.maven.restapi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("myresource2")
public class MyResource2 {

    public class Greeting {
        private String message;
        Greeting() {
        }
        public Greeting(String name) {
            this.message = getGreeting(name);
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String name) {
            this.message = name;
        }
        private String getGreeting(String name) {
            return "Hello " + name;
        }
    }

    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting hello(@PathParam("param") String name) {
        return new Greeting(name);
    }

}
