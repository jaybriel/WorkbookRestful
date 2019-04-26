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


    void "test retrieveWorkbook action with existing id"(){
        given:
        new Workbook(id:1,firstName:"test",lastName:"test",dateOfBirth:"test",age: 21,passportNumber: "E1234567",email: "jaybrielsomcio@gmail.com",phone: "09452995267").save(flush:true)
        def result

        when:
        result = service.retrieveWorkbookById(1)

        then:
        result.firstName =="test"
    }

    void "test retrieveWorkbook action with non existing id"(){
        given:
        new Workbook(firstName:"test",lastName:"test",dateOfBirth:"test",age: "test",passportNumber: "test",email: "test",phone: "test").save(flush:true)
        def result

        when:
        result = service.retrieveWorkbookById(null)

        then:
        result == null
    }

    void "test list action"(){
        given:
        def workbookList = [new Workbook(firstName:"test",lastName:"test",dateOfBirth:"test",age: 21,passportNumber: "E12334567",email: "jaybrielsomcio@gmail.com",phone: "09452995267").save(flush:true),new Workbook(firstName:"test",lastName:"test",dateOfBirth:"test",age: 21,passportNumber: "E1233344",email: "jaybrielsomcio@yahoo.com",phone: "09452995267").save(flush:true)]
        def result

        when:
        result = service.list()

        then:
        result == workbookList


    }

    void "test save action with existing workbook"(){
        given:
        def workbook = new Workbook(firstName:"test",lastName:"test",dateOfBirth:"test",age: 21,passportNumber: "E1234567",email: "jaybrielsomcio@gmail.com",phone: "09452665267").save(flush:true)
        def result

        when:
        result = service.save(workbook)

        then:
        result == workbook
    }
/*
    void "test save action with non existing workbook"(){
        given:
        def workbook = null
        def result

        when:
        result = service.save(workbook)

        then:
        result == null

    }*/

    void "test delete action with existing id"(){
        given:
        def workbook = new Workbook(id:1,firstName:"test",lastName:"test",dateOfBirth:"test",age: 21,passportNumber: "E1234567",email: "jaybrielsomcio@gmail.com",phone: "09452995267").save(flush:true)
        def result

        when:
        result = service.delete(workbook.id)

        then:
        result ==  null

    }








    /*

    void "test action save with existing workbook"(){
        given:

    }*/
}
