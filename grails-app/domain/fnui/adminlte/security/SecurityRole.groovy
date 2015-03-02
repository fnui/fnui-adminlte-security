package fnui.adminlte.security

import org.codehaus.groovy.grails.commons.GrailsStringUtils

class SecurityRole {

	String authority

	static mapping = {
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}

    String toString() {
        GrailsStringUtils.substringAfter(authority, 'ROLE_').toLowerCase()
    }
}
