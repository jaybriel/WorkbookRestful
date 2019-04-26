package com.webbfontaine.workbook

import grails.gorm.transactions.Transactional
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse

@Transactional
class RestClientService {


    def getHttpMethod(uri) {
        RestBuilder rest = new RestBuilder()
        RestResponse resp = rest.get("http://localhost:8090${uri}") {
            headers.'X-Stream' = 'true'
            accept("application/json")
//            header 'AUTHORIZATION', initRestClientAuthentication()
        }
        return resp
    }


    def deleteHttpMethod(uri) {
        RestBuilder rest = new RestBuilder()
        RestResponse resp = rest.delete("http://localhost:8090${uri}") {
            headers.'X-Stream' = 'true'
            accept("application/json")
//            header 'AUTHORIZATION', initRestClientAuthentication()
        }
        return resp
    }

    def postHttpMethod(uri, params) {
        RestBuilder rest = new RestBuilder()
        RestResponse resp = rest.post("http://localhost:8090${uri}") {
            headers.'X-Stream' = 'true'
            accept("application/json")
            contentType("application/json")
//            header 'AUTHORIZATION', initRestClientAuthentication()
            json {
                firstName = params.firstName
                lastName = params.lastName
                dateOfBirth = params.dateOfBirth
                age = params.age
                passportNumber = params.passportNumber
                email = params.email
                phone = params.phone
                image = params.contactImage

//                commitOperation = params.commitOperation
            }
        }
        return resp
    }

    def putHttpMethod(uri, params) {
        RestBuilder rest = new RestBuilder()
        RestResponse resp = rest.put("http://localhost:8090${uri}") {
            headers.'X-Stream' = 'true'
            accept("application/json")
            contentType("application/json")
//            header 'AUTHORIZATION', initRestClientAuthentication()
            json {
                firstName = params.firstName
                lastName = params.lastName
                dateOfBirth = params.dateOfBirth
                age = params.age
                passportNumber = params.passportNumber
                email = params.email
                phone = params.phone
                image = params.contactImage
//                commitOperation = params.commitOperation
            }
        }
        return resp
    }
}
