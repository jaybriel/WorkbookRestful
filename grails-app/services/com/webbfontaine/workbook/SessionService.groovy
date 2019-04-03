package com.webbfontaine.workbook

import grails.gorm.transactions.Transactional
import org.grails.web.util.WebUtils

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

@Transactional
class SessionService {

    def createSession(){
        HttpServletRequest request = WebUtils.retrieveGrailsWebRequest().currentRequest
        HttpSession session = request.session
        return session
    }

    def addToSessionStore(String key,workbook){
        def session = createSession()
        session.setAttribute(key,workbook)
    }

    def getObjectFromSession(String key){
        createSession().getAttribute(key)
    }

    def removeToSessionStore(String key){
        def session = createSession()
        session.removeAttribute(key)

    }
}
