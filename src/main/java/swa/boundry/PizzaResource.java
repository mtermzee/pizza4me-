package swa.boundry;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import swa.control.PizzaService;
import swa.entity.Pizza;

@Path("/pizza")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class PizzaResource {
    @Inject
    PizzaService pizzaService;

    @GET
    public Response getAllPizza() {
        return Response.ok(pizzaService.getAllPizza()).build();
    }

    @GET
    @Path("{id}")
    public Response getPizza(@PathParam("id") int id) {
        return Response.ok(pizzaService.getPizza(id)).build();
    }

    @POST
    public Response addPizza(Pizza pizza) {
        return Response.ok(pizzaService.addPizza(pizza)).build();
    }

    @DELETE
    @Path("{id}")
    public Response deletePizza(@PathParam("id") int id) {
        return Response.ok(pizzaService.deletePizza(id)).build();
    }
}
