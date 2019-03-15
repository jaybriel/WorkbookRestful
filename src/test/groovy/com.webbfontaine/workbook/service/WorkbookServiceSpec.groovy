package com.webbfontaine.workbook.service

import com.webbfontaine.workbook.Application
import com.webbfontaine.workbook.Workbook
import grails.test.hibernate.HibernateSpec
import grails.testing.mixin.integration.Integration
import grails.testing.services.ServiceUnitTest
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification
import com.webbfontaine.workbook.WorkbookService

class WorkbookServiceSpec extends  HibernateSpec implements ServiceUnitTest<WorkbookService>{

    @Autowired
    WorkbookService workbookService
    def setup() {

    }

    def cleanup() {
    }


    void "test retrieveWorkbook action"(){
        given:
        new Workbook(firstName:"test",lastName:"test",dateOfBirth:"test",age: "test",passportNumber: "test",email: "test",phone: "test").save(flush:true)
        def result

        when:
        result = service.retrieveWorkbook(1)

        then:
        result.firstName == "test"
    }






    /*

    void "test action save with existing workbook"(){
        given:

    }*/
}
