class FnuiAdminlteSecurityGrailsPlugin {
    def version = "0.1"
    def grailsVersion = "2.4 > *"

    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def loadAfter = ['fnui-generator','fnui-adminlte']

    def title = "Fnui Adminlte Security Plugin" // Headline display name of the plugin
    def author = "Florian Freudenberg"
    def authorEmail = "flo@freudenberg.berlin"
    def description = '''\
This plugin adds spring-security-core to the fnui-adminlte templates.
'''

    def documentation = "http://grails.org/plugin/fnui-adminlte-security"

    def license = "APACHE"

    def scm = [ url: "https://github.com/fnui/fnui-model" ]

    def doWithSpring = {
        application.config.fnui.ui.template.provider << 'fnui-adminlte-security'

        def secConfig = application.config.grails.plugin.springsecurity
        // Added by the Spring Security Core plugin:
        if (!secConfig.userLookup.userDomainClassName) {
            secConfig.userLookup.userDomainClassName = 'fnui.adminlte.security.SecurityUser'
            secConfig.userLookup.authorityJoinClassName = 'fnui.adminlte.security.SecurityUserSecurityRole'
        }

        if (!secConfig.authority.className) {
            secConfig.authority.className = 'fnui.adminlte.security.SecurityRole'
        }
    }

    def configureFnuiGenerator = {
        uiGenerator.addExtensionPointTemplate('ControllerAnnotations', 'security/ControllerSecuredAnnotation.groovy')
        uiGenerator.addExtensionPointTemplate('ActionAnnotations', 'security/ActionSecuredAnnotation.groovy')
        uiGenerator.addExtensionPointTemplate('BeforePropertyDisplay', 'security/PropertyPermissionStart.gsp')
        uiGenerator.addExtensionPointTemplate('AfterPropertyDisplay', 'security/PropertyPermissionEnd.gsp')
        uiGenerator.addExtensionPointTemplate('BeforeFormInput', 'security/PropertyPermissionStart.gsp')
        uiGenerator.addExtensionPointTemplate('AfterFormInput', 'security/PropertyPermissionEnd.gsp')
    }
}
