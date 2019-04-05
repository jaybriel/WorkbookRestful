package com.webbfontaine.workbook

class Workplace {

    long id
    int rank
    long cmpCode
    String cmpName
    int ctyCode
    String ctyDesc
    String startDate
    String endDate
    static constraints = {
        cmpCode unique: true
        cmpName unique: true

        id nullable:false
        ctyDesc nullable:false
        startDate nullable:false
        endDate nullable:false

    }

    static belongsTo = [workbook:Workbook]

}
