package com.dealerhub.customer.resource;

import com.dealerhub.customer.dto.CreateCustomerRequest;
import com.dealerhub.customer.dto.CustomerResponse;
import com.dealerhub.customer.service.CustomerService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.UUID;

@Path("/customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private final CustomerService service;

    public CustomerResource(CustomerService service) {
        this.service = service;
    }

    @POST
    public CustomerResponse create(@Valid CreateCustomerRequest request) {
        return service.create(request);
    }

    @GET
    public List<CustomerResponse> list() {
        return service.listAll();
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") UUID id) {
        service.deleteById(id);
    }

}
