package recruitment

import grails.core.GrailsApplication
import grails.util.Environment
import grails.plugins.*
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured(['ROLE_ADMIN'])
class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    def index() {
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }

    def testSecureJSON() {
        def ret = [hello: 'world secure']
        println 'in testJSecureSON ' + params
        render ret as JSON
	}
}
