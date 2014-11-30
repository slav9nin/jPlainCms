<%@ page import="static bit.cms.core.Constants.SIGN_SERVLET" %>
<%@ page import="static bit.cms.core.Constants.LOGIN_PARAMETER" %>
<%@ page import="static bit.cms.core.Constants.PASSWD_PARAMETER" %>
<%@ page import="static bit.cms.core.Constants.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/page/composite/header.jsp"/>
<link rel="stylesheet" href="/static/bootstrap/css/signin.css"/>
<div class="container">
    <form class="form-signin" role="form" action="<%=SIGN_SERVLET%>" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputLogin" class="sr-only">Login</label>
        <input type="text" id="inputLogin" name="<%=LOGIN_PARAMETER%>" class="form-control" placeholder="Login" required
               autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="<%=PASSWD_PARAMETER%>" class="form-control"
               placeholder="Password" required>

        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me" name="<%=RM_ME_PARAMETER%>"> Remember me
            </label>
        </div>
        <div style="text-align: center;"><span style="color: red; ">${requestScope.loginException}</span></div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <input type="hidden" name="url" value="${requestScope.url}"/>
    </form>
</div>
<jsp:include page="/WEB-INF/page/composite/footer.jsp"/>