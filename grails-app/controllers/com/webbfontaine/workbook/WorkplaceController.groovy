package com.webbfontaine.workbook

class WorkplaceController {

    def workplaceService
    def sessionService


    def showList(){
       // def workplace = new Workplace()
      //  Workbook workbook = getFromSession()
      //  workbook.addToWorkplaces()
       // def workplaceList = workplaceService.list()
        //render(view:'/workbook/template/_workplacelist',model:[workplaceList:workplaceList])
     //  Workbook workbook = (Workbook) sessionService.getObjectFromSession(params.sessionId)
       //def workplaceList = workbook.workplaces.toList()




//        render(view:'/workbook/template/_workplacelist',model:[workbook:workbook,workplaceList:workplaceList])
       render(view:'/workbook/template/_workplacelist')
       // render(view:'/workbook/create',model:[workplaceList:workplaceList])

    }

    def createWorkplace(){
        def workplace = new Workplace()
        //render(template: "/workbook/template/workplaceform",model:[workplace:workplace])
        render(view:'/workbook/template/_workplaceform',model:[workplace:workplace, sessionId: params.sessionId])
    }
    def edit(Long id){
        def workplace = workplaceService.retrieveWorkplace(id)
        if(workplace){
           // render(template: '/workbook/template/workplaceform',model: [workplace:workplace,sessionId: params.sessionId])
            render(view: '/workbook/template/_workplaceform',model: [workplace:workplace,sessionId: params.sessionId])

        }
    }

//    def delete(Long id){
//        workplaceService.delete(id)
//        Workbook workbook = (Workbook) sessionService.getObjectFromSession(params.sessionId)
//        def workplace = workbook.workplaces
//
//        render(template:'/workbook/template/workplacelist',model:[workbook:workbook,workplace:workplace,workplaceList:workbook.workplaces, sessionId: params.sessionId])
//
//    }

    def view(){

    }

    def delete(){
        Workbook workbook = (Workbook) sessionService.getObjectFromSession(params.sessionId)
        workplaceService.deleteWorkplace(workbook,params)
        render(template:'/workbook/template/workplacelist',model:[workbook:workbook,workplaceList:workbook.workplaces, sessionId: params.sessionId])
    }

    def save(){


        Workbook workbook = (Workbook)sessionService.getObjectFromSession(params.sessionId)
        def workplace = new Workplace(params)
        workplace.workbook = workbook
        //workplaceService.save(workplace)





       if(workplaceService.validateWorkplace(workbook,workplace))
        {
            workbook.addToWorkplaces(workplace) // workplace add to session
            sessionService.addToSessionStore(params.sessionId,workbook)
            render(template:'/workbook/template/workplacelist',model:[workbook:workbook,workplace:workplace,workplaceList:workbook.workplaces, sessionId: params.sessionId])
        }





      // bindData(workplace,params)
        //String temp = "/template/workplacelist"
        //redirect action:"showList",model:[workbook:workbook,workplace:workplace]
       // redirect action:"showList"

    }


//    def save(){
//        def workplace = new Workplace(params)
//        Workbook workbook = (Workbook)sessionService.getObjectFromSession(params.sessionId)
//
//        //workplaceService.save(workplace)
//
//
//        workbook.addToWorkplaces(workplace) // workplace add to session
//
//
//        sessionService.addToSessionStore(params.sessionId,workbook)
//      // bindData(workplace,params)
//        //String temp = "/template/workplacelist"
//        //redirect action:"showList",model:[workbook:workbook,workplace:workplace]
//       // redirect action:"showList"
//       render(template:'/workbook/template/workplacelist',model:[workbook:workbook,workplace:workplace,workplaceList:workbook.workplaces, sessionId: params.sessionId])
//    }


}
