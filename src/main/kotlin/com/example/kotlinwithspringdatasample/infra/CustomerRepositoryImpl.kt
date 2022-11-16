package com.example.kotlinwithspringdatasample.infra

import com.example.kotlinwithspringdatasample.domain.CustomerRepository
import com.example.kotlinwithspringdatasample.infra.entity.Customer
import org.springframework.stereotype.Repository

@Repository
class CustomerRepositoryImpl(val springDataCustomerEntityRepository: SpringDataCustomerEntityRepository) :
    CustomerRepository {
    override fun save(customer: Customer) {
        springDataCustomerEntityRepository.save(customer)
    }

    override fun findByFirstName(firstName: String): Customer? {
        return springDataCustomerEntityRepository.findByFirstName(firstName)
    }
}
