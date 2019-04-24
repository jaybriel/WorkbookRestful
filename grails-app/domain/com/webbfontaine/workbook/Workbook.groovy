package com.webbfontaine.workbook

import grails.databinding.BindingFormat
import groovy.json.JsonBuilder
import groovy.transform.EqualsAndHashCode
import groovy.xml.MarkupBuilder

import javax.xml.bind.annotation.XmlRootElement
//
@XmlRootElement
@EqualsAndHashCode
class Workbook {
    Integer id
    String firstName
    String lastName
    @BindingFormat('yyyy-MM-dd')
    Date dateOfBirth
    int age
    String passportNumber
    String email
    String phone
    String image

    static hasMany = [workplaces: Workplace]


    static constraints = {
        firstName nullable: false
        lastName nullable: false
        dateOfBirth nullable: false
        age range: 18..65,nullable: false
        passportNumber unique: true,nullable: false
        email email: true,nullable: false,unique: true
        phone nullable: false
       image nullable:true,blank:true
//
//        firstName nullable: true
//        lastName nullable: true
    }


    static mapping = {
        workplaces cascade: 'all-delete-orphan'
    }

    String toString(){
        "$firstName $lastName $dateOfBirth $age $passportNumber $email $phone $image"
    }

    String toXML(){
        StringWriter writer = new StringWriter()
        def builder = new MarkupBuilder(writer)
        builder.person(id:id){
            id id
            firstName firstName
            lastName lastName
            dateOfBirth dateOfBirth
            age age
            passportNumber passportNumber
            email email
            phone phone
            image image
        }
        writer.toString()
    }

    Map toJson(){
        def builder = new JsonBuilder()
        def root = builder{
            id id
            firstName firstName
            lastName lastName
            dateOfBirth dateOfBirth
            age age
            passportNumber passportNumber
            email email
            phone phone
            image image

        }
    }

    String toJsonString(){
        def builder = new JsonBuilder()
        def root = builder{
            id id
            firstName firstName
            lastName lastName
            dateOfBirth dateOfBirth
            age age
            passportNumber passportNumber
            email email
            phone phone
            image image
        }
        builder.toString()
    }
}
