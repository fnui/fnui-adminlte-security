package fnui.adminlte.security

import fnui.core.annotations.UserInterface
import grails.transaction.Transactional

@Transactional
@UserInterface({
    permissions = ['access_management']
    navigation = [category:'Access Management', name:'Security Roles']
})
class SecurityRoleService {
    List<SecurityRole> listRoles() {
        SecurityRole.list()
    }

    SecurityRole createSecurityRole(SecurityRole securityRole) {
        securityRole.save(flush: true)
    }
}
