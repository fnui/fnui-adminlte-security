package fnui.adminlte.security

import fnui.core.annotations.UserInterface
import grails.transaction.Transactional

@Transactional
@UserInterface({
    permissions = ['access_management']
    navigation = [category:'Access Management', name:'User']
})
class UserService {
    List<SecurityUserViewModel> listUsers() {
        SecurityUser.list().collect { new SecurityUserViewModel(it) }
    }

    SecurityUserViewModel showUser(SecurityUser user) {
        new SecurityUserViewModel(user)
    }

    SecurityUser createUser(CreateUserCommand createUserCommand) {
        def user = createUserCommand.prepareUser()
        user.save(flush:true) ?: user
    }

    SecurityUser addSecurityRole(SecurityUser user, AddSecurityRoleCommand addSecurityRoleCommand) {
        SecurityUserSecurityRole.create(user, addSecurityRoleCommand.securityRole)

        return user
    }
}
