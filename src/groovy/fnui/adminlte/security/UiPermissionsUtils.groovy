package fnui.adminlte.security

import fnui.model.definition.UserInterfaceDefinition

abstract class UiPermissionsUtils {

    static List<String> parseControllerPermissions(UserInterfaceDefinition uiDefinition) {
        return parsePermissions(uiDefinition?.getClassValue('permissions'))
    }

    static List<String> parseMethodPermissions(UserInterfaceDefinition uiDefinition) {
        def controllerPermissions = parseControllerPermissions(uiDefinition)
        def methodPermission = parsePermissions(uiDefinition?.getMethodValue('permissions'))

        boolean differentPermissions = !methodPermission.every { mp -> controllerPermissions.contains(mp) }
        if (differentPermissions) {
            return methodPermission
        } else {
            return []
        }
    }

    static List<String> parseEffectiveMethodPermissions(UserInterfaceDefinition uiDefinition) {
        def methodPermission = parsePermissions(uiDefinition?.getMethodValue('permissions'))

        if (methodPermission) {
            return methodPermission
        } else {
            return parseControllerPermissions(uiDefinition)
        }
    }

    private static List<String> parsePermissions(Object permissions) {
        List<String> permissionList = []

        if (permissions) {
            if (permissions instanceof String) {
                permissionList << permissions
            } else if (permissions instanceof Collection) {
                for (def p:permissions) {
                    if (p instanceof String) {
                        permissionList << p
                    }
                }
            }
        }

        return permissionList
    }
}
