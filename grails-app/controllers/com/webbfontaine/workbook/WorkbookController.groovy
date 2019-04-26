package com.webbfontaine.workbook

import grails.gorm.transactions.*
import groovy.json.JsonSlurper
import org.omg.PortableInterceptor.SUCCESSFUL
import org.springframework.http.HttpStatus

import static org.springframework.http.HttpStatus.*
import static org.springframework.http.HttpMethod.*

@Transactional(readOnly = true)
class WorkbookController {

    def workbookService
    def sessionService
    def messageSource
    def restClientService

//    static allowedMethods = [index:"GET",save: "POST", update: "PUT", delete: "DELETE"]
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    static responseFormats = ['json', 'xml']
    def index() {
        def respond = restClientService.getHttpMethod("/index")
        println "status : " + respond.getStatus()
        def workbookList = new JsonSlurper().parseText(respond.body)
//        render view: 'restList', model: [workbooklist: workbooklist]

        render(model: [workbookList: workbookList], view: 'index')
    }

    def show(long id) {
        def respond = restClientService.getHttpMethod("/show/${id}")

        def workbook = new JsonSlurper().parseText(respond.body)
        render(view: '/workbook/show', model: [workbook: workbook, workplaceList: workbook.workplaces, actionName: actionName])
    }



    def createWorkbook() {
        def workbook = new Workbook()
        def workplace = new Workplace()
        def sid = session.id
        sessionService.addToSessionStore(sid, workbook)
        sessionService.getObjectFromSession(sid)
        params.sessionId = sid
        render(view: '/workbook/create', model: [workbook: workbook, workplace: workplace, actionName: actionName], id: sid)
    }


    def delete() {
        def respond = restClientService.deleteHttpMethod("/delete/${params.id}")
        if(respond.getStatus()==HttpStatus.OK.value()){
//            def workbook = new JsonSlurper().parseText(respond.body)
//            render(model: [workplaceList: workbook.workplaces, workbookList: workbook.findAll(), errorBean: workbook, sessionId: sessionId], view: '/workbook/index')
            redirect(action:"index")

        }else{
//            render(model: [workbook: workbook, errorBean: workbook, actionName: 'createWorkbook', sessionId: sessionId], view: '/workbook/create')

        }
    }

    def edit(Long id) {
        def respond = restClientService.getHttpMethod("/show/${params.id}")
        def workbook = new JsonSlurper().parseText(respond.body)
        render(view: '/workbook/create', model: [workbook: workbook, workplaceList: workbook.workplaces, actionName: actionName])
    }

    def update(){
        def sessionId = params.sessionId
        def respond = restClientService.putHttpMethod("/update/${params.id}", params)
        if(respond.getStatus()==HttpStatus.OK.value()){
//            def workbook = new JsonSlurper().parseText(respond.body)
//            render(model: [workplaceList: workbook.workplaces, workbookList: workbook.findAll(), errorBean: workbook, sessionId: sessionId], view: '/workbook/index')
            redirect(action:"index")

        }else{
//            render(model: [workbook: workbook, errorBean: workbook, actionName: 'createWorkbook', sessionId: sessionId], view: '/workbook/create')

        }
    }



    def save() {
        def sessionId = params.sessionId
        def respond = restClientService.postHttpMethod("/save", params)

        if(respond.getStatus()==HttpStatus.OK.value()){

//            render(model: [workplaceList: workbook.workplaces, workbookList: workbook.findAll(), errorBean: workbook, sessionId: sessionId], view: '/workbook/index')
//            redirect(action:"index")
            redirect(action:"index")

        }else{
            def workbook = new JsonSlurper().parseText(respond.body)
            render(model: [workbook: workbook, errorBean: workbook, actionName: 'createWorkbook', sessionId: sessionId], view: '/workbook/create')
//             respond(workbook.errors,model: [workplaceList: workbook.workplaces, workbookList: workbook.findAll(),errorBean: workbook, sessionId: sessionId], view: '/workbook/create')


        }

    }


}



