package com.webbfontaine.workbook.controller

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import spock.lang.Unroll
import com.webbfontaine.workbook.Workbook
import com.webbfontaine.workbook.WorkbookController
import com.webbfontaine.workbook.WorkbookService

class WorkbookControllerSpec extends Specification implements ControllerUnitTest<WorkbookController>, DataTest {

    def setup() {
        mockDomain Workbook
    }

    def cleanup() {
    }

    void "test edit action with a non exsiting workbook."() {
        given:
        controller.workbookService = Stub(WorkbookService) {
            retrieveWorkbook(_) >> null
        }

        when:
        controller.edit()

        then:
        response.redirectUrl.startsWith('/workbook')

    }

    @Unroll
    void "test edit action with existing workbook"() {
        given:
        controller.workbookService = Stub(WorkbookService) {
            retrieveWorkbook(_) >> new Workbook(firstName: "test") //add other details
        }

        when:
        controller.edit()

        then:
        view.startsWith('/workbook/edit')

    }

    void "Test the index action returns the correct model"() {

        given:
        controller.workbookService = Stub(WorkbookService){
            list() >> [new Workbook(firstName:"test",lastName:"test",dateOfBirth:"test",age: "test",passportNumber: "test",email: "test",phone: "test"),new Workbook(firstName:"test",lastName:"test",dateOfBirth:"test",age: "test",passportNumber: "test",email: "test",phone: "test")]
        }

        when:'The index action is executed'
        controller.index()



        then:
        view.startsWith('/workbook')
//        model.workbookList.size() == 1


    }

    void "Test the index action if returns null model"(){

        given:
        controller.workbookService = Stub(WorkbookService){
            list() >> null
        }
        when:"The index action is executed"
        controller.index()

        then:
        view.startsWith('/workbook')
    }

    void "test save action with new workbook"(){
        given:
        controller.workbookService = Stub(WorkbookService){
            save(_) >> new Workbook(firstName:"test",lastName:"test",dateOfBirth:"test",age: "test",passportNumber: "test",email: "test",phone: "test")
        }

        when:"The save action is executed"
        controller.save()

        then:

        response.redirectUrl.startsWith('/')
    }

    void "test save action with null workbook"(){
        given:
        controller.workbookService = Stub(WorkbookService){
            save(_) >> null
        }

        when:"The save action is executed"
        controller.save()

        then:
        response.redirectUrl.startsWith('/')
        //view.startsWith('/workbook/save')
    }

    void "test delete action with existing workbook"(){
        given:
        controller.workbookService = Stub(WorkbookService){
            delete(_) >> 1
        }
        when: "The delete action is executed"
        controller.delete()

        then:
        response.redirectUrl.startsWith('/')
    }

    void "test delete action with non existing workbook"(){
        given:
        controller.workbookService = Stub(WorkbookService){
            delete(_) >> null
        }
        when: "The delete action is executed"
        controller.delete()

        then:
        response.redirectUrl.startsWith('/')

    }

    void "test create action"(){
        when:"The create action is executed"
        controller.create()

        then:
        view.startsWith('/workbook/create')
    }

}
