package fnui.adminlte.security

import fnui.adminlte.fnui.adminlte.AdminLteDisplayTagLib
import grails.plugin.springsecurity.SpringSecurityUtils

class AdminLteSecurityTagLib extends AdminLteDisplayTagLib {
    static namespace = 'adminlte'
    static defaultEncodeAs = [taglib:'none']

    /**
     * General linking to controllers, actions etc. Examples:<br/>
     *
     * &lt;g:link action="myaction"&gt;link 1&lt;/gr:link&gt;<br/>
     * &lt;g:link controller="myctrl" action="myaction"&gt;link 2&lt;/gr:link&gt;<br/>
     *
     * @attr controller The name of the controller to use in the link, if not specified the current controller will be linked
     * @attr action The name of the action to use in the link, if not specified the default action will be linked
     * @attr uri relative URI
     * @attr url A map containing the action,controller,id etc.
     * @attr base Sets the prefix to be added to the link target address, typically an absolute server URL. This overrides the behaviour of the absolute property, if both are specified.
     * @attr absolute If set to "true" will prefix the link target address with the value of the grails.serverURL property from Config, or http://localhost:&lt;port&gt; if no value in Config and not running in production.
     * @attr id The id to use in the link
     * @attr fragment The link fragment (often called anchor tag) to use
     * @attr params A map containing URL query parameters
     * @attr mapping The named URL mapping to use to rewrite the link
     * @attr event Webflow _eventId parameter
     * @attr elementId DOM element id
     * @attr requirements Class name of closure class
     * @attr requirementsParams List of parameters for requirements closure
     * @attr alwaysPrintBody Should the Body be printed if the link is not available?
     * @attr permissions List of permissions for this link
     */
    def securedLink = { attrs, body ->
        boolean alwaysPrintBody = readAsBoolean(attrs, 'alwaysPrintBody')
        boolean mayGeneratedLink = true

        def permissions = attrs.remove('permissions')
        if (!permissions) {
            mayGeneratedLink = SpringSecurityUtils.ifAllGranted(permissions)
        }

        if (mayGeneratedLink) {
            out << adminlte.link(attrs, body)
        } else if (alwaysPrintBody) {
            out << body()
        }
    }
}
