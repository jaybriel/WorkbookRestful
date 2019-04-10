package com.webbfontaine.workbook

class WorkplaceController {

    def workplaceService
    def sessionService


    def showList(){
        Workbook workbook = (Workbook) sessionService.getObjectFromSession(params.sessionId)
       render(template:'/workbook/template/workplacelist',model:[workbook: workbook,workplaceList:workbook.workplaces,sessionId: params.sessionId])
//        render(view: '/workbook/template/_workplacelist',model:[workbook: workbook,workplaceList:workbook.workplaces,sessionId: params.sessionId])
    }

    def createWorkplace(){
        def workplace = new Workplace()
//        render(view:'/workbook/template/_workplaceform',model:[workplace:workplace, sessionId: params.sessionId])
        render(template:'/workbook/template/workplaceform',model:[workplace:workplace,sessionId: params.sessionId])

    }
    def edit(){
        Workbook workbook = (Workbook)sessionService.getObjectFromSession(params.sessionId)
        def workplace = workplaceService.retrieveWorkplace(workbook,params)
        if(workplace){
//            render(view: '/workbook/template/_workplaceform',model: [workplace:workplace,sessionId: params.sessionId])
            render(template: '/workbook/template/workplaceform',model: [workplace:workplace,sessionId: params.sessionId])
        }
    }

    def update(){
        Workbook workbook = (Workbook)sessionService.getObjectFromSession(params.sessionId)
        workplaceService.updateWorkplace(workbook,params)
        render(template:'/workbook/template/workplacelist',model:[workbook:workbook,workplaceList:workbook.workplaces, sessionId: params.sessionId])

    }

    def viewWorkplace(){
        Workbook workbook = (Workbook)sessionService.getObjectFromSession(params.sessionId)
        def workplace = workplaceService.retrieveWorkplace(workbook,params)
        if(workplace){
            render(template:'/workbook/template/workplacelist',model: [workplace:workplace,sessionId: params.sessionId])
        }

    }

    def delete(){

            Workbook workbook = (Workbook) sessionService.getObjectFromSession(params.sessionId)
        if(workbook)
        {
            workplaceService.deleteWorkplace(workbook,params)
            render(template:'/workbook/template/workplacelist',model:[workbook:workbook,workplaceList:workbook.workplaces, sessionId: params.sessionId])

        }
        else{

        }
    }

    def save(){
        def rank
        Workbook workbook = (Workbook)sessionService.getObjectFromSession(params.sessionId)
        if(workbook.workplaces == null)
        {
            rank = 1
        }
        else
        {
            rank = workbook.workplaces.size() + 1
        }

        def workplace = new Workplace(params)
        workplace.workbook = workbook
        workplace.rank = rank


       if(workplaceService.validateWorkplace(workbook,workplace))
        {
            workbook.addToWorkplaces(workplace)
            sessionService.addToSessionStore(params.sessionId,workbook)
//            workplaceService.saveWorkplace(workbook,workplace,params.sessionId)
            render(template:'/workbook/template/workplacelist',model:[workbook:workbook,workplaceList:workbook.workplaces, sessionId: params.sessionId])
        }
        else{
//           workplace.errors.rejectValue('cmpCode','fill out company code and should be unique')
//           workplace.errors.rejectValue('cmpName','fill out company name and should be unique')
//           workplace.errors.rejectValue('ctyDesc','fill out city description')
       render(template:'/workbook/template/workplaceform',model:[workbook:workbook,workplace:workplace,workplaceList:workbook.workplaces, sessionId: params.sessionId,actionName: 'createWorkplace'])
       }

    }





}
