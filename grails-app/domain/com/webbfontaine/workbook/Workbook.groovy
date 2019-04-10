package com.webbfontaine.workbook

import java.time.LocalDate

class Workbook {
    long id
    String firstName
    String lastName
    String dateOfBirth
    int age
    String passportNumber
    String email
    String phone

    static hasMany = [workplaces:Workplace]


    static constraints = {
        firstName  blank: false
        lastName blank: false
        dateOfBirth blank: false
        age blank: false,range:18..65
        passportNumber blank: false,unique: true
        email blank: false,email:true, unique: true
        phone blank: false
    }
}
