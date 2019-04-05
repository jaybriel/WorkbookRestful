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
        firstName  nullable: false
        lastName nullable: false
        dateOfBirth nullable: false
        age nullable: false,range:18..65
        passportNumber nullable: false,unique: true
        email nullable: false,email:true, unique: true
        phone nullable: false
    }
}
