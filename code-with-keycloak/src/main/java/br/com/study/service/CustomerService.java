package br.com.study.service;

import java.util.List;

import br.com.study.model.Customer;
import br.com.study.repository.CustomerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CustomerService {
    
    @Inject
    CustomerRepository customerRepository;

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll().list();
    }

    @Transactional
    public void addCustomer(Customer customer){
        customerRepository.persist(customer);
    }
}
