package fnui.adminlte.security

import grails.plugin.springsecurity.annotation.Secured
import groovy.util.logging.Log4j
import org.codehaus.groovy.grails.commons.GrailsClass
import org.codehaus.groovy.grails.commons.GrailsControllerClass

import java.lang.reflect.Method

@Log4j
class PermissionsInitializer {
    static void initializePermission(GrailsClass[] controllers) {
        def dbRoles = getDatabaseRoles()
        def controllerRoles = getAnnotatedRoles(controllers)

//        for (String role:dbRoles) {
//            boolean unusedRole = !controllerRoles.contains(role)
//
//            if (unusedRole) {
//                // LOG?
//            }
//        }

        for (String role:controllerRoles) {
            boolean unavailableRole = !dbRoles.contains(role)

            if (unavailableRole) {
                new SecurityRole(authority: role).save(failOnError: true)
            }
        }
    }

    private static Set<String> getDatabaseRoles() {
        SecurityRole.list().collect { role ->
            role.authority
        }
    }

    private static Set<String> getAnnotatedRoles(GrailsClass[] controllers) {
        Set<String> roles = new LinkedHashSet<>()
        for (GrailsControllerClass controller:controllers) {
            collectRolesFromController(controller, roles)
        }

        return roles
    }

    private static Set<String> collectRolesFromController(GrailsControllerClass controllerClass, Set<String> roles) {
        Class<?> clazz = controllerClass.getClazz()
        Secured securedAnnotation = clazz.getAnnotation(Secured)

        if (securedAnnotation) {
            collectRolesInto(securedAnnotation, roles)
        }

        for (Method method : clazz.getDeclaredMethods()) {
            def methodAnnotation = method.getAnnotation(Secured)
            if (methodAnnotation) {
                collectRolesInto(methodAnnotation, roles)
            }
        }

        return roles
    }

    private static void collectRolesInto(Secured secured, Set<String> roles) {
        for (String securedValue:secured.value()) {
            if (securedValue.startsWith('ROLE_')) {
                roles.add(securedValue)
            }
        }
    }
}
