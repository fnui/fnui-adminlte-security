<%
// start extension point for permission check
def constraints = node['constraints']
def permissions = constraints?.get('permissions')
if (permissions) {
    def permissionsList = permissions.collect { "ROLE_${it.toUpperCase()}" }.join(',')
%>\
<sec:ifAllGranted roles="${permissionsList}">
<% } %>