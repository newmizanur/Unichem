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
                    Accounts Summary
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="dataTable_wrapper">
                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>Username</th>
                                <th>Full Name</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>Role</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${accounts}" var="account" varStatus="loopStatus">

                                <tr class="<c:if test='${loopStatus.index mod 2 eq 0}'>even</c:if><c:if test='${loopStatus.index mod 2 ne 0}'>odd</c:if>">
                                    <td><c:out value="${account.username}"/></td>
                                    <td><c:out value="${account.fullName}"/></td>
                                    <td><c:out value="${account.email}"/></td>
                                    <td><c:out value="${account.phone}"/></td>
                                    <td><c:forEach items="${account.roles}" var="role">
                                        <c:out value="${role}"/>&nbsp;
                                    </c:forEach></td>
                                    <td><a class="btn btn-outline btn-success"
                                           href='<c:url value="/account/edit/${account.id}"/>'>
                                        <i class="fa fa-edit fa-fw"></i>Edit
                                    </a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.table-responsive -->
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