package com.webbfontaine.workbook

import grails.gorm.transactions.*
import static org.springframework.http.HttpStatus.*
import static org.springframework.http.HttpMethod.*

@Transactional(readOnly = true)
class WorkbookController {

    def workbookService
    def sessionService
    def messageSource


    static allowedMethods = [index:"GET",save: "POST", update: "PUT", delete: "DELETE"]
    def index() {
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


    def delete(Long id) {
        workbookService.delete(id)
        redirect action: "index"


    }

    def edit(Long id) {

        def workbook = workbookService.retrieveWorkbookById(id)
        def sid = session.id
        sessionService.addToSessionStore(sid, workbook)
        sessionService.getObjectFromSession(sid)
        params.sessionId = sid
        if (workbook) {
//            render(view: '/workbook/create', model: [workbook: workbook, workplaceList: workbook.workplaces, actionName: actionName, sessionId: params.sessionId], id: sid)
              respond(workbook.errors,model: [workplaceList: workbook.workplaces, workbookList: workbook.findAll(),errorBean: workbook,actionname:actionName, sessionId: sessionId], view: '/workbook/create')

        } else {
            redirect action: 'index'
        }
    }




    def save() {


        def sessionId = params.sessionId
        def workbook = workbookService.retrieveWorkbookBySessionId(params.sessionId)

        workbook.clearErrors()
        bindData(workbook, params)
        workbookService.save(workbook,request)
        if (!workbook.hasErrors()) {
//            render(model: [workplaceList: workbook.workplaces, workbookList: workbook.findAll(), errorBean: workbook, sessionId: sessionId], view: '/workbook/index')
              respond(workbook.errors,model: [workplaceList: workbook.workplaces, workbookList: workbook.findAll(),errorBean: workbook, sessionId: sessionId], view: '/workbook/index')

        } else {
//            render(model: [workbook: workbook, errorBean: workbook, actionName: 'createWorkbook', sessionId: sessionId], view: '/workbook/create')
            respond(workbook.errors,model: [workplaceList: workbook.workplaces, workbookList: workbook.findAll(),errorBean: workbook, sessionId: sessionId], view: '/workbook/create')
        }

    }


}



