package com.pharmacy

import grails.test.mixin.TestFor
import spock.lang.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Customer)
class CustomerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }
    @Ignore
    void "test something"() {
        expect:"fix me"
            true == false
    }
}
