package com.maven.restapi;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("dbop")
public class DBServlet {

    @Path("insert")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String insertStudent() throws SQLException, ClassNotFoundException {
        DBOperations.getDBConnection();
        DBOperations.insert(1, "xyz", "IT", "A", "ReactJS");
        DBOperations.insert(2,"abc", "CSE", "B", "AngularJS");
        DBOperations.insert(3,"def", "IT", "B", "Spring");
        DBOperations.insert(4,"ijk", "CSE", "A", "Maven");
        return "Insertion successful..!!";
    }

    @Path("display")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public void displayAll() throws SQLException, ClassNotFoundException {
        DBOperations.getDBConnection();
        DBOperations.display();
    }

    @Path("update")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String updateRecord() throws SQLException, ClassNotFoundException {
        DBOperations.getDBConnection();
        DBOperations.update("NodeJS", 2);
        return "Record updated successfully..!!";
    }

    @Path("delete")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteRecord() throws SQLException, ClassNotFoundException {
        DBOperations.getDBConnection();
        DBOperations.delete(3);
        return "Record deleted successfully..!!";
    }

}
