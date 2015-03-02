package fnui.adminlte.security

import grails.validation.Validateable

@Validateable
class CreateUserCommand {
    String username
    String password
    String repeatPassword

    static constraints = {
        username nullable: false, blank: false
        password nullable: false, blank: false, password: true
        repeatPassword nullable: false, blank: false, password: true, validator: { pw, cmd ->
            if (pw == cmd.password) {
                return 'password.mismatch'
            }
        }
    }

    SecurityUser prepareUser() {
        def user = new SecurityUser()
        user.username = username
        user.password = password
    }
}
