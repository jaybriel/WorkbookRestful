package com.webbfontaine.workbook

import grails.gorm.transactions.Transactional

@Transactional
class WorkbookService {


    def list(){
        Workbook.list()
    }

    def save(workbook)
    {
        workbook.save()
    }

    def delete(id)
    {
        Workbook.get(id).delete()
    }

    def retrieveWorkbook(id){
       def workbook = Workbook.findById(id)
        workbook
    }
}
