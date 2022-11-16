package com.example.kotlinwithspringdatasample.infra

import com.example.kotlinwithspringdatasample.infra.entity.Customer
import org.springframework.data.repository.CrudRepository

interface SpringDataCustomerEntityRepository : CrudRepository<Customer, Int> {
    fun findByFirstName(firstName: String): Customer?
}
