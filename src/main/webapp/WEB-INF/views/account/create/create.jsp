<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!-- #page-wrapper -->
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Accounts</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Create Account
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form:form role="form" cssClass="validate-form" commandName="user" enctype="multipart/form-data">
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <label class="control-label">User Name</label>
                                        <form:input required="true" path="username" cssClass="form-control"
                                                    placeholder="Enter user name"/>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label">Password</label>
                                        <form:input path="password" cssClass="form-control"
                                                    placeholder="Enter password"/>
                                    </div>


                                    <div class="form-group">
                                        <label class="control-label">Full Name</label>
                                        <form:input path="fullName" cssClass="form-control"
                                                    placeholder="Enter your full name"/>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label">Secret Question</label>
                                        <form:input path="secretQuestion" cssClass="form-control"
                                                    placeholder="Enter a secret question"/>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label">Secret Answer</label>
                                        <form:input path="secretAnswer" cssClass="form-control"
                                                    placeholder="Enter secret answer"/>
                                    </div>
                                </div>
                                <div class="col-lg-6">

                                    <div class="form-group">
                                        <label class="control-label">Email</label>
                                        <form:input path="email" cssClass="form-control" placeholder="Enter email"/>
                                    </div>
                                    <div class="form-group">
                                        <label class="control-label">Phone</label>
                                        <form:input path="phone" cssClass="form-control"
                                                    placeholder="Enter phone number"/>
                                    </div>


                                    <div class="form-group">
                                        <label class="control-label">Photo</label>
                                        <input type="file" name="file">
                                    </div>

                                    <div class="form-group">
                                        <label>Roles</label>

                                        <c:forEach items="${user.appRoles}" var="role">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" name="roles"
                                                           value='<c:out value="${role}"/>'><c:out value="${role}"/>
                                                </label>
                                            </div>
                                        </c:forEach>

                                    </div>

                                </div>
                                <div class="col-lg-12">
                                    <button type="submit" class="btn btn-outline btn-success">Create</button>
                                    <button type="reset" class="btn btn-outline btn-default">Reset</button>
                                </div>
                            </form:form>
                        </div>
                        <!-- /.col-lg-6 (nested) -->

                    </div>
                    <!-- /.row (nested) -->
                </div>
                <!-- /.panel-body -->
            </div>
            <!-- /.panel -->
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
</div>
<!-- /#page-wrapper -->