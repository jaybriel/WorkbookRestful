package workbook

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class WorkbookControllerSpec extends Specification implements ControllerUnitTest<WorkbookController> {

    def setup() {
    }

    def cleanup() {
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
