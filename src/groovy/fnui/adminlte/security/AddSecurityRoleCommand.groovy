package fnui.adminlte.security

import grails.validation.Validateable

@Validateable
class AddSecurityRoleCommand {
    SecurityRole securityRole

    static constraints = {
        securityRole nullable: false
    }
}
