<%
if (link.kind == 'action') {
    namespace = link.namespace ? " namespace=\"${link.namespace}\"" : ''
    controller = link.controller ? " controller=\"${link.controller}\"" : ''
    action = link.action ? " action=\"${link.action}\"" : ''
    def paramsValue = link.generateParams(contextVar)
    params = paramsValue ? " params=\"$paramsValue\"" : ''
    def reqObject = link.requirements
    requirements = reqObject ? " requirements=\"${reqObject.closureClass.name.replace('$', '\\$')}\"" :''
    if (requirements) {
        def requirementsParams = reqObject ? reqObject.generateParams(contextVar) : ''
        requirements += requirementsParams ? " requirementsParams=\"\${${requirementsParams}}\"" : ''
    }
    attrs = attributes.collect { key, value ->
        " $key=\"$value\""
    }.join('')
    uiDefinition = link.uiDefinition
    permissions = fnui.adminlte.security.UiPermissionsUtils.parseEffectiveMethodPermissions(uiDefinition).collect { "ROLE_${it.toUpperCase()}" }.join(',')
    permissions = permissions ? " permissions=\"$permissions\"" : ''
%>\
<adminlte:securedLink${namespace}${controller}${action}${params}${requirements}${permissions}${attrs}>\
${body}
</adminlte:securedLink>
<%
} else if (link.kind == 'uri') {
    uri = link.uri ? " uri=\"${link.uri}\"" : ''
%>\
<adminlte:link${uri}>
${body}
</adminlte:link>
<%
} else {
%>
${body}
<%
}
%>