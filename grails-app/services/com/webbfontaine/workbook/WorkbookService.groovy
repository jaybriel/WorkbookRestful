package com.webbfontaine.workbook

import grails.gorm.transactions.Transactional

@Transactional
class WorkbookService {

    def sessionService

    def list(){
        Workbook.list()
    }

    def save(workbook)
    {
        workbook.save()
    }

    def savetoSession(id,workbook)
    {
        def workbookSession = (Workbook) sessionService.addToSessionStore(id,workbook)
        workbookSession
    }

    def delete(id)
    {
        Workbook.get(id).delete()
    }

    def retrieveWorkbookById(id){
       def workbook = Workbook.findById(id)
        //Workbook workbook = (Workbook) sessionService.getObjectFromSession(id)
        workbook
    }

    def retrieveWorkbookBySessionId(id)
    {
        Workbook workbook = (Workbook) sessionService.getObjectFromSession(id)
        workbook
    }
}
