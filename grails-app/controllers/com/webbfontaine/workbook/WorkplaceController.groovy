package com.webbfontaine.workbook

class WorkplaceController {

    def workplaceService
    def sessionService


    def showList() {
        Workbook workbook = (Workbook) sessionService.getObjectFromSession(params.sessionId)
        render(template: '/workbook/template/workplacelist', model: [workbook: workbook, workplaceList: workbook.workplaces, sessionId: params.sessionId])
    }

    def createWorkplace() {
        def workplace = new Workplace()
        render(template: '/workbook/template/workplaceform', model: [workplace: workplace, sessionId: params.sessionId])

    }

    def edit() {
        Workbook workbook = (Workbook) sessionService.getObjectFromSession(params.sessionId)
        def workplace = workplaceService.retrieveWorkplace(workbook, params)
        if (workplace) {
            render(template: '/workbook/template/workplaceform', model: [workplace: workplace, sessionId: params.sessionId])
        }
    }

    def update() {
        Workbook workbook = (Workbook) sessionService.getObjectFromSession(params.sessionId)
        workplaceService.updateWorkplace(workbook, params)
        render(template: '/workbook/template/workplacelist', model: [workbook: workbook, workplaceList: workbook.workplaces, sessionId: params.sessionId])

    }

    def viewWorkplace() {
        Workbook workbook = (Workbook) sessionService.getObjectFromSession(params.sessionId)
        def workplace = workplaceService.retrieveWorkplace(workbook, params)
        if (workplace) {
            render(template: '/workbook/template/workplacelist', model: [workplace: workplace, sessionId: params.sessionId])
        }

    }

    def delete() {

        Workbook workbook = (Workbook) sessionService.getObjectFromSession(params.sessionId)
            workplaceService.deleteWorkplace(workbook, params)
            sessionService.addToSessionStore(params.sessionId,workbook)
            render(template: '/workbook/template/workplacelist', model: [workbook: workbook, workplaceList: workbook.workplaces, sessionId: params.sessionId])
    }

    def save() {
        def rank
        Workbook workbook = (Workbook) sessionService.getObjectFromSession(params.sessionId)
        if (workbook.workplaces == null) {
            rank = 1
        } else {
            rank = workbook.workplaces.size() + 1
        }

        def workplace = new Workplace(params)
        workplace.workbook = workbook
        workplace.rank = rank


        if (workplaceService.validateWorkplace(workbook, workplace)) {
            workbook.addToWorkplaces(workplace)
            sessionService.addToSessionStore(params.sessionId, workbook)
            render(template: '/workbook/template/workplacelist', model: [errorBean: workplace,workbook: workbook,workplace: workplace, workplaceList: workbook.workplaces, sessionId: params.sessionId])
        } else {
            render(template: '/workbook/template/workplaceform', model: [errorBean: workplace,workbook: workbook, workplace: workplace, workplaceList: workbook.workplaces, sessionId: params.sessionId, actionName: 'createWorkplace'])
        }

    }


}
