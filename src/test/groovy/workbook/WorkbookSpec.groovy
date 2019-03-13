package workbook

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class WorkbookSpec extends Specification implements DomainUnitTest<Workbook> {

    def setup() {
    }

    def cleanup() {
    }



    void "Constraints: #firstName,#lastName,#dateOfBirth,#age,#passportNumber,#email,#phone isValid:#isValid"(){
        setup:
        def workbook = new Workbook()


        when:
        domain.firstName = firstName
        domain.lastName = lastName
        domain.dateOfBirth = dateOfBirth
        domain.age = age
        domain.passportNumber = passportNumber
        domain.email = email
        domain.phone = phone

        then:
        domain.validate() == isValid

        where:
        firstName | lastName | dateOfBirth | age | passportNumber |         email              | phone         | isValid
        "jaybriel"| "somcio" | "11/02/1997"| "21"| "12345"        | "jaybrielsomcio@gmail.com" | "09151324733" | true
        null      | null     | null        | null|      null      |         null               |    null       | false
        "jaybriel"| null     | "11/02/1997"| null|      null      |         null               |    null       | false

    }
}
