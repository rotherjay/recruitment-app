package recruitment

import acl.*

class BootStrap {

    def init = { servletContext ->
    	Role admin = new Role(authority:"ROLE_ADMIN").save flush:true
		AdminAccount user = new AdminAccount(emailAddress:"user", password:"pass").save flush:true
		AdminAccountRole.create(user, admin, true)
    }
    def destroy = {
    }
}
