package acl

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='emailAddress')
@ToString(includes='emailAddress', includeNames=true, includePackage=false)
class AdminAccount implements Serializable {

    private static final long serialVersionUID = 1

    String emailAddress
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Set<Role> getAuthorities() {
        (AdminAccountRole.findAllByUser(this) as List<AdminAccountRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        emailAddress nullable: false, blank: false, unique: true
    }

    static mapping = {
	    password column: '`password`'
    }
}
