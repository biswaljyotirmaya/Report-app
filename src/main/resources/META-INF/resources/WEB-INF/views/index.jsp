<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Report Generation</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">
</head>

<body class="bg-light">

<div class="container mt-5">

    <div class="card shadow-lg p-4">
        <h3 class="mb-4 text-primary">
            <i class="bi bi-bar-chart-line"></i> Report Generation
        </h3>

        <form:form method="POST" action="search" modelAttribute="search">

            <!-- Row 1 -->
            <div class="row mb-3">

                <div class="col-md-4">
                    <label class="form-label">Plan Name</label>
                    <form:select path="planName" cssClass="form-select">
                        <form:option value="">-Select-</form:option>
                        <form:options items="${names}"/>
                    </form:select>
                </div>

                <div class="col-md-4">
                    <label class="form-label">Plan Status</label>
                    <form:select path="planStatus" cssClass="form-select">
                        <form:option value="">-Select-</form:option>
                        <form:options items="${status}"/>
                    </form:select>
                </div>

                <div class="col-md-4">
                    <label class="form-label">Gender</label>
                    <form:select path="gender" cssClass="form-select">
                        <form:option value="">-Select-</form:option>
                        <form:option value="Male">Male</form:option>
                        <form:option value="Female">Female</form:option>
                    </form:select>
                </div>

            </div>

            <!-- Row 2 -->
            <div class="row mb-3">

                <div class="col-md-4">
                    <label class="form-label">Start Date</label>
                    <form:input type="date" path="startDate" cssClass="form-control"/>
                </div>

                <div class="col-md-4">
                    <label class="form-label">End Date</label>
                    <form:input type="date" path="endDate" cssClass="form-control"/>
                </div>

                <div class="col-md-4 d-flex align-items-end">
                    <form:button cssClass="btn btn-primary w-100">
                        <i class="bi bi-search"></i> Search
                    </form:button>
                </div>

            </div>

        </form:form>

        <hr>

        <!-- Results Section Placeholder -->
        <div class="text-muted text-center py-3">
            <c:if test="${not empty plans}">
                <div class="mt-3">
                    <table class="table table-bordered table-striped">
                        <thead class="table-dark">
                        <tr>
                            <th>#</th>
                            <th>Citizen Id</th>
                            <th>Name</th>
                            <th>Gender</th>
                            <th>Plan Name</th>
                            <th>Status</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Benefit Amt</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${plans}" var="plan" varStatus="index">
                            <tr>
                                <td>${index.count}</td>
                                <td>${plan.citizenId}</td>
                                <td>${plan.citizenName}</td>
                                <td>${plan.gender}</td>
                                <td>${plan.planName}</td>
                                <td>${plan.planStatus}</td>
                                <td>${plan.planStartDate}</td>
                                <td>${plan.planEndDate}</td>
                                <td>${plan.benefitAmount}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
        </div>

        <hr>

        <!-- Export Section -->
        <div class="row align-items-center">

            <div class="col-md-6">
                <h6 class="mb-0">Export Options</h6>
            </div>

            <div class="col-md-6">
                <a href="/excel" class="btn btn-success">
                    <i class="bi bi-file-earmark-excel"></i> Excel
                </a>
                <a href="/pdf" class="btn btn-danger">
                    <i class="bi bi-file-pdf"></i> Pdf
                </a>

            </div>

        </div>

    </div>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>