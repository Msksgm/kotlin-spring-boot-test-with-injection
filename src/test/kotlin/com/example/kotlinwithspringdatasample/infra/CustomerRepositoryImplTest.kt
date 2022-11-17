package com.example.kotlinwithspringdatasample.infra

import com.example.kotlinwithspringdatasample.infra.entity.Customer
import com.github.database.rider.core.api.dataset.DataSet
import com.github.database.rider.core.api.dataset.ExpectedDataSet
import com.github.database.rider.junit5.api.DBRider
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

class CustomerRepositoryImplTest {
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DBRider
    @DisplayName("FindByFirstName（firstname から検索）")
    @SpringBootTest
    class FindByFirstName @Autowired constructor(
        val springDataCustomerEntityRepository: SpringDataCustomerEntityRepository
    ) {
        @Test
        @DataSet("datasets/yml/given/customer.yml")
        fun `正常系`() {
            /**
             * given:
             */
            val customerRepository = CustomerRepositoryImpl(springDataCustomerEntityRepository)
            val firstName = "Alice"

            /**
             * when:
             */
            val expected = customerRepository.findByFirstName(firstName)

            /**
             * then:
             */
            val actual = Customer(
                id = 1,
                firstName = "Alice",
                lastName = "Sample1"
            )
            assertThat(expected).isEqualTo(actual)
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @DBRider
    @DisplayName("Save(カスタマーを保存)")
    @SpringBootTest
    class SaveTest @Autowired constructor(
        val springDataCustomerEntityRepository: SpringDataCustomerEntityRepository
    ) {
        @Test
        @DataSet("datasets/yml/given/customer.yml")
        @ExpectedDataSet(
            value = ["datasets/yml/then/save-success.yml"], // 期待値のデータのファイルを指定
            ignoreCols = ["id"], // メタデータを無視する
        )
        // NOTE: 一度データを書き出したら、コメントアウトする
        // @ExportDataSet(
        //     format = DataSetFormat.YML, // テスト完了後にデータを書き出す形式を指定
        //     outputName = "src/test/resources/datasets/yml/then/save-success.yml", // 書き出すファイル先を指定
        //     includeTables = ["customer"] // 含めるカラムを指定
        // )
        fun `正常系`() {
            /**
             * given:
             */
            val customerRepository = CustomerRepositoryImpl(springDataCustomerEntityRepository)
            val customer = Customer(
                id = null,
                firstName = "Carol",
                lastName = "Sample3"
            )

            /**
             * when:
             */
            customerRepository.save(customer)
        }
    }
}
