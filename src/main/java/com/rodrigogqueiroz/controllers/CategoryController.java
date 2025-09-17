package com.rodrigogqueiroz.controllers;

import com.rodrigogqueiroz.domain.Category.CategoryDTO;
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
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/api/category")
public class CategoryController {

    @Inject
    private CategoryService categoryService;

    @GET
    @Path("/retrieve/{ownerID}")
    public Response retrieve(@PathParam("ownerID") String ownerID) {
        var category = categoryService.retrieveAllFromOwner(ownerID);
        return Response.ok(category).build();
    }

    @GET
    @Path("/retrieve/all")
    public Response retrieveAll() {
        var categories = categoryService.retrieveAll();
        return Response.ok(categories).build();
    }

    @POST
    @Path("/insert")
    public Response insert(CategoryDTO categoryData) {
        var category = categoryService.insert(categoryData);
        return Response.status(Response.Status.CREATED).entity(category).build();
    }

    @PUT
    @Path("/update/{id}")
    public Response update(@PathParam("id") ObjectId id, CategoryDTO categoryData) {
        var categoryUpdated = categoryService.update(id, categoryData);
        return Response.ok(categoryUpdated).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") ObjectId id) {
        categoryService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
