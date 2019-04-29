package com.webbfontaine.workbook

import grails.converters.JSON
import grails.gorm.transactions.*
import groovy.json.JsonSlurper
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import org.springframework.http.HttpStatus


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
<<<<<<< Updated upstream
        flash.message = "Welcome!"
        def workbookList = workbookService.list()
//        respond Workbook.list(params), model:[workbookCount: Workbook.count()]

//        render(model: [workbookList: workbookList], view: 'index') as JSON
        respond(workbookList,model:[workbookList:workbookList], view:"index")

    }

    def show(Workbook workbook) {
        if(workbook == null) {
            render status:404
        }
        else {
            return [workbook: workbook]
        }
    }

    def view(Long id) {
        def workbook = workbookService.retrieveWorkbookById(id)

//        render(view: '/workbook/show', model: [workbook: workbook, workplaceList: workbook.workplaces, actionName: actionName])
        respond(workbook.errors,model: [workplaceList: workbook.workplaces, workbook: workbook,actionName: actionName], view: '/workbook/show')

=======
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
>>>>>>> Stashed changes
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
        def sid = session.id
        sessionService.addToSessionStore(sid, workbook)
        sessionService.getObjectFromSession(sid)
        params.sessionId = sid
<<<<<<< Updated upstream
        if (workbook) {
//            render(view: '/workbook/create', model: [workbook: workbook, workplaceList: workbook.workplaces, actionName: actionName, sessionId: params.sessionId], id: sid)
              respond(workbook.errors,model: [workplaceList: workbook.workplaces, workbookList: workbook.findAll(),errorBean: workbook,actionname:actionName, sessionId: sessionId], view: '/workbook/create')

        } else {
            redirect action: 'index'
        }
=======

        render(view: '/workbook/create', model: [workbook: workbook, workplaceList: workbook.workplaces, actionName: actionName])
>>>>>>> Stashed changes
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
        def workbook = workbookService.retrieveWorkbookBySessionId(params.sessionId)
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-mm-dd")
        workbook.dateOfBirth= LocalDate.parse(params.dateOfBirth,formatter)
        bindData(workbook,params)

        def respond = restClientService.postHttpMethod("/save", workbook)

<<<<<<< Updated upstream
        workbook.clearErrors()
        bindData(workbook, params)
        workbookService.save(workbook,request)
        if (!workbook.hasErrors()) {
//            render(model: [workplaceList: workbook.workplaces, workbookList: workbook.findAll(), errorBean: workbook, sessionId: sessionId], view: '/workbook/index')
              respond(workbook.errors,model: [workplaceList: workbook.workplaces, workbookList: workbook.findAll(),errorBean: workbook, sessionId: sessionId], view: '/workbook/index')

        } else {
//            render(model: [workbook: workbook, errorBean: workbook, actionName: 'createWorkbook', sessionId: sessionId], view: '/workbook/create')
            respond(workbook.errors,model: [workplaceList: workbook.workplaces, workbookList: workbook.findAll(),errorBean: workbook, sessionId: sessionId], view: '/workbook/create')
=======
        if(respond.getStatus()==HttpStatus.OK.value()){

//            render(model: [workplaceList: workbook.workplaces, workbookList: workbook.findAll(), errorBean: workbook, sessionId: sessionId], view: '/workbook/index')
//            redirect(action:"index")
            redirect(action:"index")

        }else{
            workbook= new Workbook(JSON.parse(respond.body))
            bindData(workbook,params)
            workbook.validate()
            render(model: [workbook: workbook, errorBean: workbook, actionName: 'createWorkbook', sessionId: sessionId], view: '/workbook/create')




>>>>>>> Stashed changes
        }

    }


}



