package com.rodrigogqueiroz.controllers;

import org.bson.types.ObjectId;

import com.rodrigogqueiroz.domain.product.ProductDTO;
import com.rodrigogqueiroz.services.ProductService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/api/product")
public class ProductController {
    
    @Inject
    private ProductService productService;

    @GET
    @Path("/retrieve")
    public Response retrieve() {
        var product = productService.retrieveAll();
        return Response.ok(product).build();
    }

    @POST
    @Path("/insert")
    public Response insert(ProductDTO productData) {
        var product = productService.insert(productData);
        return Response.status(Response.Status.CREATED).entity(product).build();
    }

    @PUT
    @Path("/update/{id}")
    public Response update(@PathParam("id") ObjectId id, ProductDTO productData) {
        var productUpdated = productService.update(id, productData);
        return Response.ok(productUpdated).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") ObjectId id) {
        productService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
