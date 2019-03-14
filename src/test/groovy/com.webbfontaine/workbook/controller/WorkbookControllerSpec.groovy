package com.webbfontaine.workbook.controller

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import spock.lang.Unroll
import workbook.Workbook
import workbook.WorkbookController
import workbook.WorkbookService

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
        response.redirectUrl.startsWith('/workbook/index')

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
        def workbookList = [new Workbook(firstName: 'jaybriel',lastName: 'somcio',dateOfBirth: '11/02/1997',age: '21',passportNumber: '123455',email: 'jaybrielsomcio@gmail.com',phone: '09151324733')]


        when:'The index action is executed'
        controller.index()



        then:'The model is correct'
        model.workbookList
        model.workbookList.find{it.firstName == 'jaybriel'}
//        model.workbookList.size() == 1


    }
}
