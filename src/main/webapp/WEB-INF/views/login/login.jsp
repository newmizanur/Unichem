<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<div class="row">
    <div class="col-md-4 col-md-offset-4">
        <div class="login-panel panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Please Sign In</h3>
            </div>
            <div class="panel-body">
                <form role="form" name='f' action="j_spring_security_check" method='POST'>
                    <fieldset>
                        <c:if test="${not empty param.error}">
                            <div class="alert alert-warning" role="alert">
                                <c:out value='${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}'></c:out>
                            </div>
                        </c:if>
                        <div class="form-group">
                            <input class="form-control" placeholder="E-mail" name="j_username" type="text" autofocus>
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Password" name="j_password" type="password" value="">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input name="_spring_security_remember_me" type="checkbox" value="Remember Me">Remember Me
                            </label>
                        </div>

                        <input class="btn btn-lg btn-success btn-block" name="submit" type="submit" value="Login"/>

                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>