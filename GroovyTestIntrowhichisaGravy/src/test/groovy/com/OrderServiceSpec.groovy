package com.example.demo.service
import spock.lang.Specification

class OrderServiceSpec extends Specification {

    def service = new OrderService()

    def "should apply discount when amount > 5000"() {

        when:
        def result = service.calculateFinalAmount(6000)

        then:
        result == 5400
    }

    def "should not apply discount when amount <= 5000"() {

        when:
        def result = service.calculateFinalAmount(3000)

        then:
        result == 3000
    }

    def "data driven test for multiple values"() {

        expect:
        service.calculateFinalAmount(amount) == expected

        where:
        amount | expected
        6000   | 5400
        7000   | 6300
        3000   | 3000
    }
}
