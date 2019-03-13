package workbook

class WorkbookController {

    def workbookService

    def index()
    {
        def workbookList = workbookService.list()
        render(model:[workbookList:workbookList],view:'index')
    }



    def view(Long id)
    {
        def workbook = workbookService.retrieveWorkbook(id)

        render(view:'show',model:[workbook: workbook])
    }

    def create()
    {
        def workbook = new Workbook()
        render(view:'create', model: [workbook:workbook])
    }

    def save()
    {
        def workbook = new Workbook()
        bindData(workbook,params)
        workbookService.save(workbook)
        redirect action:"index"

    }

    def delete(Long id)
    {
        workbookService.delete(id)
        redirect action:"index", method:"GET"


    }

    def showEdit(Long id){
        def workbook = workbookService.retrieveWorkbook(id)

        render(view:'edit',model:[workbook: workbook] )
    }


    def editWorkbook(Long id){
       def workbook =  workbookService.retrieveWorkbook(id)
        bindData(workbook,params)
        workbookService.save(workbook)
        redirect action:'index'
    }


}
