package acl


import grails.rest.*
import grails.converters.*
import grails.transaction.Transactional
import grails.plugin.springsecurity.annotation.Secured

class AdminAccountController extends RestfulController {
    static responseFormats = ['json', 'xml']
    
    AdminAccountController() {
        super(AdminAccount)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        println "HAHAHAHAHA"
        respond AdminAccount.list(params)
    }
}
