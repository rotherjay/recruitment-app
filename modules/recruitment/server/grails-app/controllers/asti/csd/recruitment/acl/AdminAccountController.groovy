package asti.csd.recruitment.acl


import grails.rest.*
import grails.converters.*
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class AdminAccountController extends RestfulController {
    static responseFormats = ['json', 'xml']
    AdminAccountController() {
        super(AdminAccount)
    }

    def index() {
        render AdminAccount.list() as JSON
	}
}
