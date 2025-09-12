package com.rodrigogqueiroz.controllers;

import com.rodrigogqueiroz.domain.CategoryDTO;
import com.rodrigogqueiroz.services.CategoryService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/api/category")
public class CategoryController {

    @Inject
    private CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/retrieve/{ownerID}")
    public Response retrieve(String ownerID) {
        try{
            categoryService.retrieveAllFromOwner(ownerID);
            return Response.status(Response.Status.OK).entity("Categories retrieved").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving categories").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/retrieve/all")
    public Response retrieveAll(String ownerID) {
        try{
            categoryService.retrieveAll();
            return Response.status(Response.Status.OK).entity("Categories retrieved").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error retrieving categories").build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response insert(CategoryDTO categoryData) {
        try{
            categoryService.insert(categoryData);
            return Response.status(Response.Status.CREATED).entity(categoryData).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error inserting category").build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update() {
        return Response.ok("Category updated").build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete() {
        return Response.ok("Category deleted").build();
    }
}
