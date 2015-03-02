<%
def uiDefinition = node['uiDefinition']
def permissions = fnui.adminlte.security.UiPermissionsUtils.parseControllerPermissions(uiDefinition)

if (permissions) {
    permissionsList = permissions.collect{ permission -> "'ROLE_${permission.toUpperCase()}'"}.join(', ')
%>
@grails.plugin.springsecurity.annotation.Secured([${permissionsList}])
<% } %>