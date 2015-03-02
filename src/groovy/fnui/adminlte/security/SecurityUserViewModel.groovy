package fnui.adminlte.security

import fnui.core.annotations.Context
import grails.validation.Validateable

@Validateable
class SecurityUserViewModel {
    Long id
    String username
    Set<SecurityRole> roles

    @Context
    SecurityUser securityUser

    SecurityUserViewModel(SecurityUser user) {
        id = user.id
        username = user.username
        roles = user.authorities
        this.securityUser = user
    }

    static constraints = {
        id identifier: true
        roles displayList: false
        errors display: false
        securityUser display:false
    }
}
