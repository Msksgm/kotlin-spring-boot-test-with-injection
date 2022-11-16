package com.example.kotlinwithspringdatasample.domain

import com.example.kotlinwithspringdatasample.infra.entity.Customer

interface CustomerRepository {
    fun save(customer: Customer)

    fun findByFirstName(firstName: String): Customer?
}
