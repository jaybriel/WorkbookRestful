package com.webbfontaine.workbook

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->new Workbook(firstName:'customer',lastName: 'customer',dateOfBirth: new Date().parse('yyyy-MM-dd','1997-11-02'),age: 21,passportNumber:'E1232131', email:'jaybrielsomcio@gmail.com',phone: '09452995267',image:null).save(flush:true)

    }
    def destroy = {
    }
}
