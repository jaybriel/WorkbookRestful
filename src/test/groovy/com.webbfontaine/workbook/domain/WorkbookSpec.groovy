package com.webbfontaine.workbook.domain

import grails.testing.gorm.DomainUnitTest
import groovy.json.JsonSlurper
import spock.lang.Specification
import com.webbfontaine.workbook.Workbook

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
        "jaybriel"| "somcio" | "11/02/1997"| 21  | "12345"        | "jaybrielsomcio@gmail.com" | "09151324733" | true
        null      | null     | null        | 0   |      null      |         null               |    null       | false
        "jaybriel"| null     | "11/02/1997"| 0   |      null      |         null               |    null       | false

    }


    void "Test that email should have proper format"() {
        expect: "Customer instance is valid/invalid"
        new Workbook(firstName:"customer",lastName: "customer",dateOfBirth: new Date().parse('yyyy-MM-dd','1997-11-02'),age: 21, email:validEmail,passportNumber:"E1232131",phone: "09452995267").validate()
        !new Workbook(firstName:"customer",lastName: "customer",dateOfBirth: new Date().parse('yyyy-MM-dd','1997-11-02'),age: 21, email:invalidEmail,passportNumber:"E1232131",phone: "09452995267").validate()

        where: "Given valid/invalid emails"
        validEmail << ["customer@email.com", "1234567890@example.com", "email@test.museum"]
        invalidEmail << ["plainaddress", "@example.com", "#@%^%x!.com"]
    }

    void "Test that email should be unique"() {
        when: "The first customer is saved"
        String firstName = 'First Name'
        String firstEmail  = 'first@email.com'
        Workbook firstWorkbook = new Workbook(id:1,firstName:firstName,lastName: firstName,dateOfBirth: new Date().parse('yyyy-MM-dd','1997-11-02'),age: 21, email:firstEmail,passportNumber:"E1232131",phone: "09151324733")
//        Workbook firstWorkbook = new Workbook(firstName:firstName,email:firstEmail)
        firstWorkbook.save(flush:true)

        String secondName = 'Second Name'
        Workbook workbookWithSameEmail = new Workbook(id:2,firstName:secondName,lastName: secondName,dateOfBirth: new Date().parse('yyyy-MM-dd','1998-11-02'),age: 22, email:firstEmail,passportNumber:"E1111111",phone: "09452995267")
//        Workbook workbookWithSameEmail = new Workbook(firstName:secondName,email:firstEmail)
        then: "Another customer with same customerName is invalid"
        Workbook.count() == 1
        !workbookWithSameEmail.save(flush:true)
    }


    void 'transform workbook into json string'(){
        given: 'a person with a first and last name'
        Workbook w = new Workbook(firstName:'customer',lastName: 'customer',dateOfBirth: new Date().parse('yyyy-MM-dd','1997-11-02'),age: 21,passportNumber:'E1232131', email:'jaybrielsomcio@gmail.com',phone: '09452995267',image:null)

        when: 'convert person to JSON string'
        String s = w.toJsonString()

        then: 'can convert string back to person'
//        s == '{"id":null,"firstName":"Jonathan","lastName":"Archer"}'
        s == '{"id":null,"firstName":"customer","lastName":"customer","dateOfBirth":"1997-11-01T16:00:00+0000","age":21,"passportNumber":"E1232131","email":"jaybrielsomcio@gmail.com","phone":"09452995267","image":null}'
        def json = new JsonSlurper().parseText(s)
        Workbook w1 = new Workbook(json)
        w1 == w
    }

    void 'transform person into json()'(){
        given: 'a workbook with a first and last name'
        Workbook w = new Workbook(id:99,firstName: 'Jonathan',lastName: 'Archer')

        expect: 'convert person to JSON'
        w.toJson() == [id:null,firstName: 'Jonathan',lastName: 'Archer']
    }
}
