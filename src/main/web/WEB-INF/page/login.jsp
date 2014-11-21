<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/page/composite/header.jsp"/>
<link rel="stylesheet" href="/static/bootstrap/css/signin.css"/>
<div class="container">
    <form class="form-signin" role="form" action="/sign" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputLogin" class="sr-only">Login</label>
        <input type="text" id="inputLogin" name="login" class="form-control" placeholder="Login" required
               autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>

        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me" name="remember"> Remember me
            </label>
        </div>
        <div><center><font color="red">${requestScope.loginException}</font></center></div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <input type="hidden" name="url" value="${requestScope.url}"/>
    </form>
</div>
<jsp:include page="/WEB-INF/page/composite/footer.jsp"/>