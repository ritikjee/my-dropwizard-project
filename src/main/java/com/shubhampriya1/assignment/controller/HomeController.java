package com.shubhampriya1.assignment.controller;

import com.shubhampriya1.assignment.dto.ResponseDTO;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/home")
@Produces(MediaType.APPLICATION_JSON)
public class HomeController {

    @GET
    public Response home() {
        return Response.ok()
                .entity(new ResponseDTO(200, "Welcome Home"))
                .build();
    }

    @GET
    @Path("/{userName}")
    public Response homeWithName(@PathParam("userName") String userName) {
        return Response.ok()
                .entity(new ResponseDTO(200, "Welcome :" + userName))
                .build();
    }

}
