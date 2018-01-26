package recruitment

import asti.csd.recruitment.acl.*

class BootStrap {

    def init = { servletContext ->
    	def role1 = new Role(authority:"ROLE_ADMIN").save flush:true
	    def user1 = new AdminAccount(username:"admin",password:"admin").save flush:true
	    AdminAccountRole.create(user1,role1)

    }
    def destroy = {
    }
}
