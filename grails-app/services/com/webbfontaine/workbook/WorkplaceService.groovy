package com.webbfontaine.workbook

import grails.gorm.transactions.Transactional

import java.text.SimpleDateFormat

@Transactional
class WorkplaceService {
    def sessionService

    def list() {
        Workplace.list()
    }


    def delete(id) {
        Workplace.get(id).delete()
    }


    def retrieveWorkplace(Workbook workbook, def params) {
        int rank = params.rank.toInteger()
        def workplaceToUpdate = workbook.workplaces.find { it.rank == rank }
        workplaceToUpdate

    }

    def updateWorkplace(Workbook workbook, def params) {
        int rank = params.rank.toInteger()
        workbook.workplaces.find { it.rank == rank }.properties = params
        workbook
    }


    def validateDate(Workbook workbook, Workplace workplace) {
        if (workplace.startDate != null && workplace.endDate != null) {
//            Date date1 = convertDateTime(workplace.startDate)
//            Date date2 = convertDateTime(workplace.endDate)
            def date1 = workplace.startDate
            def date2 = workplace.endDate
            if (date1.after(date2)) {
                workplace.errors.rejectValue('startDate', 'workplace.startDate.overlap')
            }
            return !date1.after(date2)
        } else {
            return false
        }

    }


    def checkOverlapDateWithPrevDate(Workbook workbook, Workplace workplace, int i) {
        if (workbook.workplaces.size() > 0) {
//            Date startDate = convertDateTime(workplace.startDate)
//            Date endDate = convertDateTime(workplace.endDate)
//            Date prevStartDate = convertDateTime(workbook.workplaces[i].startDate)
//            Date prevEndDate = convertDateTime(workbook.workplaces[i].endDate)
            def startDate = workplace.startDate
            def endDate = workplace.endDate
            def prevStartDate = workbook.workplaces[i].startDate
            def prevEndDate = workbook.workplaces[i].endDate

            if (startDate.before(prevEndDate) && prevStartDate.before(endDate)) {
                workplace.errors.rejectValue('endDate', 'workplace.endDate.overlap')
                return false
            } else {
                return true
            }

        } else {
            return true
        }

    }

    def validateWorkplace(Workbook workbook, Workplace workplace) {
        workplace.validate()
        if (workbook.workplaces != null) {
            for (int i = 0; workbook.workplaces.size(); i++) {
                if (validateDate(workbook, workplace) || workbook.workplaces.size() > 0) {
                    return checkOverlapDateWithPrevDate(workbook, workplace, i)
                }
            }
        }
        return validateDate(workbook, workplace)
    }

    def deleteWorkplace(Workbook workbook, def params) {
        int rank = params.rank.toInteger()
        def workplaceToRemove = workbook.workplaces.find { it.rank == rank }
        workbook.removeFromWorkplaces(workplaceToRemove)
        workbook
    }


    def convertDateTime(String element) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd")
        return dateFormat.parse(element)
    }

}
