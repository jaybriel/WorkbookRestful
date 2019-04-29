package com.webbfontaine.workbook

import grails.databinding.BindingFormat
import groovy.json.JsonBuilder
import groovy.transform.EqualsAndHashCode
import groovy.xml.MarkupBuilder
import org.joda.time.LocalDate

import javax.xml.bind.annotation.XmlRootElement
//
@XmlRootElement
@EqualsAndHashCode
class Workbook {
    Integer id
    String firstName
    String lastName
    LocalDate dateOfBirth
    int age
    String passportNumber
    String email
    String phone
//    String image

    static hasMany = [workplaces: Workplace]


    static constraints = {
        firstName nullable: false
        lastName nullable: false
        dateOfBirth nullable: false
        age range: 18..65,nullable: false
        passportNumber unique: true,nullable: false
        email email: true,nullable: false,unique: true
        phone nullable: false
<<<<<<< Updated upstream
       image nullable:true,blank:true
//
//        firstName nullable: true
//        lastName nullable: true
=======
//       image nullable:true,blank:true
>>>>>>> Stashed changes
    }


    static mapping = {
        workplaces cascade: 'all-delete-orphan'
    }


}
