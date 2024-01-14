package br.com.study.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.study.model.Customer;
import br.com.study.service.CustomerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/api/customer")
public class CustomerController {
    
    @Inject
    CustomerService customerService;

    @GET
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
    public void addCustomer(Customer customer){
        try {
            customerService.addCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
