package fnui.adminlte.security

class SecurityUser {

	transient springSecurityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static transients = ['springSecurityService', 'authorities']

	static constraints = {
		username blank: false, unique: true
		password blank: false
//        authorities displayList: false
	}

	static mapping = {
		password column: '`password`'
	}

	Set<SecurityRole> getAuthorities() {
		SecurityUserSecurityRole.findAllBySecurityUser(this).collect { it.securityRole }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
}
