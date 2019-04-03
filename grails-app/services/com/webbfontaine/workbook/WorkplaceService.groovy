package com.webbfontaine.workbook

import grails.gorm.transactions.Transactional

import java.text.SimpleDateFormat

@Transactional
class WorkplaceService {

    def list(){
        Workplace.list()
    }

    def save(workplace){
        workplace.save()
    }

    def delete(id){
        Workplace.get(id).delete()
    }

    def retrieveWorkplace(id){
        def workplace = Workplace.findById(id)
        workplace

    }


    def validateWorkplace(Workbook workbook,Workplace workplace)
    {
        Date date1 = convertDateTime(workplace.startDate)
        Date date2 = convertDateTime(workplace.endDate)
        boolean correctDate = compareDateTimes(date1,date2)
        correctDate
    }



    def deleteWorkplace(Workbook workbook, def params) {
//        int rank =
        int rank =  params.rank.toInteger()
        def workplaceToRemove = workbook.workplaces[rank]
        workbook.removeFromWorkplaces(workplaceToRemove)
        workbook
    }


    def convertDateTime(String element){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd")
        return dateFormat.parse(element)
    }

    def compareDateTimes(Date date1,Date date2)
    {
//        if(date1.after(date2))
//            return "date1 is after date2"
        if(date1.before(date2))
            return true
//        if(date1.equals(date2))
//            return "date1 is equal to date2"
    }
}
