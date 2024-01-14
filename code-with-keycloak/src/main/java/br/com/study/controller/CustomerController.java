package br.com.study.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.study.model.Customer;
import br.com.study.service.CustomerService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/api/customer")
public class CustomerController {
    
    @Inject
    CustomerService customerService;

    @GET
    @RolesAllowed("manager")
    public List<Customer> retrieveCustomers(){
        
        List<Customer> customers = new ArrayList<>();

        try {
            customers = customerService.findAllCustomers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customers;
    }

    @POST
    @RolesAllowed("manager")
    public void addCustomer(Customer customer){
        try {
            customerService.addCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
