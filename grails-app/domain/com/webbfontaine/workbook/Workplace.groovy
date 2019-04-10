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
        cmpCode nullable:false, unique: true
        cmpName nullable:false,unique: true

        id nullable:false
        ctyDesc nullable:false
        startDate nullable:false,unique: true
        endDate nullable:false,unique: true

    }

    static belongsTo = [workbook:Workbook]

}
