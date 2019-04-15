package com.webbfontaine.workbook

import java.time.LocalDate

class Workbook {
    long id
    String firstName
    String lastName
//    String dateOfBirth
    String dateOfBirth
    int age
    String passportNumber
    String email
    String phone

    static hasMany = [workplaces: Workplace]


    static constraints = {
        firstName blank: false,nullable: false
        lastName blank: false,nullable: false
        dateOfBirth blank: false,nullable: false
        age blank: false, range: 18..65,nullable: false
        passportNumber blank: false, unique: true,nullable: false
        email blank: false, email: true, unique: true,nullable: false
        phone blank: false,nullable: false
    }


    static mapping = {
        workplaces cascade: 'all-delete-orphan'
    }
}
