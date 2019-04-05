package com.webbfontaine.workbook

class WorkbookController {

    def workbookService
    def sessionService

    def index()
    {
        flash.message ="Welcome!"
        def workbookList = workbookService.list()
        render(model:[workbookList:workbookList],view:'index')

    }

    def view(Long id)
    {
        def workbook = workbookService.retrieveWorkbookById(id)

        render(view:'/workbook/show',model:[workbook: workbook,workplaceList: workbook.workplaces, actionName: actionName])
    }



    def createWorkbook(){
        def workbook = new Workbook()
        def workplace = new Workplace()
        def sid = session.id
        sessionService.addToSessionStore(sid,workbook)
        sessionService.getObjectFromSession(sid)
        params.sessionId = sid
        render(view:'/workbook/create', model: [workbook:workbook,workplace:workplace,actionName:actionName],id:sid)
    }


    def delete(Long id)
    {
        workbookService.delete(id)
        redirect action:"index"


    }

    def edit(Long id){

        def workbook = workbookService.retrieveWorkbookById(id)
        def sid = session.id
        sessionService.addToSessionStore(sid,workbook)
        sessionService.getObjectFromSession(sid)
        params.instId = sid
        if (workbook) {
            render(view:'/workbook/create',model:[workbook: workbook,workplaceList: workbook.workplaces,actionName: actionName],id:sid )
        } else {
            redirect action: 'index'
        }
    }


    def save() {


           def sessionId = params.sessionId
           def workbook  = workbookService.retrieveWorkbookBySessionId(params.sessionId)



        bindData(workbook,params)
        workbookService.save(workbook)
            if(!workbook.hasErrors())
            {


                def workbookList = workbookService.list()
                render(model:[workbookList:workbookList,errorBean:workbook],view:'index')

            }
        else{
                render(model:[workbook:workbook,errorBean:workbook,actionName:'createWorkbook',sessionId:sessionId],view:'/workbook/create')
            }
//             render(model:[workbook:workbook,errorBean:workbook,actionName:'createWorkbook',sessionId:sessionId],view:'/workbook/create')

            }


    }



