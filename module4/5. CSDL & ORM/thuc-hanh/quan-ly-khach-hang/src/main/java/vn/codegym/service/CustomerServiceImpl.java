package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Customer;
import vn.codegym.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    @Override
    public void remove(Customer customer) {
        customerRepository.remove(customer);
    }
}
