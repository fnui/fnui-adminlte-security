<%
// end extension point
def constraints = node['constraints']
def permissions = constraints?.get('permissions')
if (permissions) {
%>\
</sec:ifAllGranted>
<% } %>