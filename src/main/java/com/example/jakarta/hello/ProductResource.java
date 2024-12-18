package com.example.jakarta.hello;

import Model.Product;
import Model.Store;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("products")
public class ProductResource {
    private static Store store = new Store();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts() {
        return Response.ok(store.getProducts()).build();
    }
    @GET
    @Path("add/{name}/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(@PathParam("name") String name, @PathParam("price") double price) {
        store.addProduct(name, price);
        return Response.ok().entity("Product " + name + " added successfully!").build();
    }

    @GET
    @Path("delete/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("name") String name) {
        Product product = store.getProduct(name);
        if (product == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Product not found")
                    .build();
        } else {
            store.removeProduct(name);
            return Response.ok()
                    .entity("Product " + name + " deleted successfully!")
                    .build();
        }
    }

    @GET
    @Path("update/{name}/{newprice}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("name") String name, @PathParam("newprice") double newPrice) {

        Product product = store.getProduct(name);
        if (product == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Product not found")
                    .build();
        } else {
            store.updateProduct(name, newPrice);
            return Response.ok()
                    .entity("Product " + name + " Updated successfully!")
                    .build();
        }
    }
}
