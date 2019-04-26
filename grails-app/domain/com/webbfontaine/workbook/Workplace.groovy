package com.webbfontaine.workbook

import grails.databinding.BindingFormat
import grails.rest.Resource

class Workplace {

    long id
    int rank
    String cmpCode
    String cmpName
    String ctyCode
    String ctyDesc
    @BindingFormat('yyyy-MM-dd')
    Date startDate
    @BindingFormat('yyyy-MM-dd')
    Date endDate
    static constraints = {
        cmpCode blank: false,nullable: false
        cmpName nullable: true
        id nullable: false
        ctyCode nullable: false
        ctyDesc nullable: true
        startDate nullable: false
        endDate nullable: false
        workbook nullable: true

    }

    static belongsTo = [workbook: Workbook]

}
