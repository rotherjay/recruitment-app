

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'asti.csd.recruitment.acl.AdminAccount'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'asti.csd.recruitment.acl.AdminAccountRole'
grails.plugin.springsecurity.authority.className = 'asti.csd.recruitment.acl.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']],
	[pattern: '/**', 			 access: ['permitAll']],
	[pattern: '/application/index', access: ['permitAll']],
	[pattern: '/api/logout', access: ['isAuthenticated()']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/api/application/testSecureJSON', filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter' ],
	[
        pattern: '/api/**',
        filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
    ],
    [pattern: '/**', filters:'JOINED_FILTERS']

]

grails.plugin.springsecurity.rest.login.active=true
grails.plugin.springsecurity.rest.login.endpointUrl='/api/login'
grails.plugin.springsecurity.rest.login.failureStatusCode=401
grails.plugin.springsecurity.rest.login.useJsonCredentials=true
grails.plugin.springsecurity.rest.login.usernamePropertyName='username'
grails.plugin.springsecurity.rest.login.passwordPropertyName='password'

grails.plugin.springsecurity.rest.logout.endpointUrl='/api/logout'
grails.plugin.springsecurity.logout.postOnly = false

grails.plugin.springsecurity.rest.token.validation.useBearerToken = false
grails.plugin.springsecurity.rest.token.validation.headerName = 'X-Auth-Token'
grails.plugin.springsecurity.rest.token.validation.active=true
grails.plugin.springsecurity.rest.token.validation.endpointUrl='/api/validate'

grails.plugin.springsecurity.rest.token.storage.useGorm=true
grails.plugin.springsecurity.rest.token.storage.gorm.tokenDomainClassName='asti.csd.recruitment.acl.AuthenticationToken'
grails.plugin.springsecurity.rest.token.storage.gorm.tokenValuePropertyName='tokenValue'
grails.plugin.springsecurity.rest.token.storage.gorm.usernamePropertyName='username'
grails.plugin.springsecurity.rest.token.storage.jwt.expiration=20

grails.plugin.springsecurity.rest.token.generation.useSecureRandom=true
grails.plugin.springsecurity.rest.token.generation.useUUID=false