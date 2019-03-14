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

    def delete(Long id)
    {
        workbookService.delete(id)
        redirect action:"index", method:"GET"


    }

    def edit(Long id){
        def workbook = workbookService.retrieveWorkbook(id)
        if (workbook) {
            render(view:'edit',model:[workbook: workbook] )
        } else {
            redirect action: 'index'
        }
    }

    def save() {
        def workbook = new Workbook()
        bindData(workbook,params)
        workbookService.save(workbook)
        redirect action:"index"
    }


    def update(Long id) {
       def workbook =  workbookService.retrieveWorkbook(id)
        bindData(workbook,params)
        workbookService.save(workbook)
        redirect action:'index'
    }


}
