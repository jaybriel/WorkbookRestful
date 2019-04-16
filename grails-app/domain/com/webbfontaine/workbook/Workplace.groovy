package com.webbfontaine.workbook

class Workplace {

    long id
    int rank
    String cmpCode
    String cmpName
    String ctyCode
    String ctyDesc
    String startDate
    String endDate
    static constraints = {
        cmpCode blank: false,nullable: false
        cmpName nullable: true
        id nullable: false
        ctyCode nullable: false
        ctyDesc nullable: true
        startDate nullable: false, unique: true
        endDate nullable: false, unique: true

    }

    static belongsTo = [workbook: Workbook]

}
