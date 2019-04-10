package com.webbfontaine.workbook

import grails.gorm.transactions.Transactional

import java.text.SimpleDateFormat

@Transactional
class WorkplaceService {
    def sessionService

    def list(){
        Workplace.list()
    }


    def delete(id){
        Workplace.get(id).delete()
    }


    def retrieveWorkplace(Workbook workbook,def params){
        int rank = params.rank.toInteger()
        def workplaceToUpdate = workbook.workplaces.find{it.rank == rank}
        workplaceToUpdate

    }

    def updateWorkplace(Workbook workbook, def params) {
        int rank = params.rank.toInteger()
        workbook.workplaces.find{it.rank==rank}.properties = params
        workbook
    }

    def validateWorkplace(Workbook workbook,Workplace workplace) {
        boolean correctDate
        if(workplace.validate())
        {
            Date date1 = convertDateTime(workplace.startDate)
            Date date2 = convertDateTime(workplace.endDate)
            correctDate = compareDateTimes(date1,date2)
            correctDate
        }
        else{
            workplace.errors.rejectValue('endDate','end date should be after start date')

        }

    }



    def deleteWorkplace(Workbook workbook, def params) {
            int rank =  params.rank.toInteger()
            def workplaceToRemove = workbook.workplaces.find{it.rank == rank}
            workbook.removeFromWorkplaces(workplaceToRemove)
            workbook
    }




    def convertDateTime(String element){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd")
        return dateFormat.parse(element)
    }

    def compareDateTimes(Date date1,Date date2)
    {
        if(date1.before(date2))
            return true
    }
}
