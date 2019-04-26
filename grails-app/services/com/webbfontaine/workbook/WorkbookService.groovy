package com.webbfontaine.workbook

import grails.gorm.transactions.Transactional

import javax.servlet.http.HttpServletRequest

@Transactional
class WorkbookService {

    def sessionService

    def list(){
        Workbook.list()
    }

    def save(Workbook workbook,HttpServletRequest request)
    {

        workbook.save(flush:true)
        uploadImage(workbook,request)

    }

    def delete(id)
    {
        Workbook.get(id).delete(flush:true)
    }

    def retrieveWorkbookById(id){
       def workbook = Workbook.findById(id)
        workbook
    }

    def retrieveWorkbookBySessionId(id)
    {
        Workbook workbook = (Workbook) sessionService.getObjectFromSession(id)
        workbook
    }

    def uploadImage(Workbook workbook, HttpServletRequest request){
        if (request.getFile("contactImage") && !request.getFile("contactImage").filename.equals("")){
            String image = FileUtil.uploadContactImage(workbook.id, request.getFile("contactImage"))
            if (!image.equals("")){
                workbook.image = image
                workbook.save(flush:true)
            }
        }
    }
}
