package com.webbfontaine.workbook

class WorkbookController {

    def workbookService

    def index()
    {
        def workbookList = workbookService.list()
        render(model:[workbookList:workbookList],view:'/workbook/index')
    }



    def view(Long id)
    {
        def workbook = workbookService.retrieveWorkbook(id)

        render(view:'/workbook/show',model:[workbook: workbook])
    }

    def create()
    {
        def workbook = new Workbook()
        render(view:'/workbook/create', model: [workbook:workbook])
    }

    def delete(Long id)
    {
        workbookService.delete(id)
        redirect action:"index", method:"GET"


    }

    def edit(Long id){
        def workbook = workbookService.retrieveWorkbook(id)
        if (workbook) {
            render(view:'/workbook/edit',model:[workbook: workbook] )
        } else {
            redirect action: 'index'
        }
    }
    /*
    def save()
    {
        def workbook = new Workbook()
        bindData(workbook,params)
        workbookService.save(workbook)
        redirect action:"index"

    }
*/

    def save() {
        def workbook  = workbookService.retrieveWorkbook(params.id)

        if(!workbook)
        {
            workbook = new Workbook()
        }

        bindData(workbook,params)
        workbookService.save(workbook)
        redirect action:"index"

    }

    /*
    def save() {
        def workbook
        if(params.id == workbookService.list().size())
        {
            workbook = workbookService.retrieveWorkbook(params.id)
        }
        else
        {
            workbook = new Workbook()
        }
        bindData(workbook,params)

        if(workbook){
            workbookService.save(workbook)
            redirect action:"index"
        }
        else{
            redirect action:'index'
        }
    }
*/
/*
    def update(Long id) {
       def workbook =  workbookService.retrieveWorkbook(id)
        bindData(workbook,params)
        workbookService.save(workbook)
        redirect action:'index'
    }



        def save() {
        def workbook
        if(params.id)
        {
            workbook = workbookService.retrieveWorkbook(params.id)
        }
        else
        {
            workbook = new Workbook()
        }
        bindData(workbook,params)

        if(workbook){
            workbookService.save(workbook)
            redirect action:"index"
        }
        else{
            redirect action:'save'
        }
    }
*/

}
