<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.vehicule.app.model.User" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Purple Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="../static/vendors/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="../static/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="../static/css/style.css">
    <!-- End layout styles -->
    <link rel="shortcut icon" href="../static/images/favicon.ico" />
  </head>
  <body>
    <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth">
          <div class="row flex-grow">
            <div class="col-lg-4 mx-auto">
              <div class="auth-form-light text-left p-5">
                <div class="brand-logo">
                  <img src="../static/images/logo.svg">
                </div>
                <h4>Hello! let's get started</h4>
                <h6 class="font-weight-light">Sign in to continue.</h6>
                  <sf:form method="POST" modelAttribute="User" action="Login" cssClass="pt-3">

                  <div class="form-group">
                    <sf:input path="utilisateur" cssClass="form-control form-control-lg" id="exampleInputEmail" placeholder="Username"/>
                    <sf:errors path="utilisateur"/>
                  </div>
                  <div class="form-group">
                    <sf:input path="mdp" cssClass="form-control form-control-lg" id="exampleInputPassword1" placeholder="Password"/>
                    <sf:errors path="mdp"/>
                  </div>
                  <div class="mt-3">
                    <button class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn" type="submit"> >SIGN IN</button>
                  </div>
                  </sf:form>
                <div style="color: red"> <c:out value="${ erreur }"></c:out> </div>
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    <!-- container-scroller -->
    <!-- plugins:js -->
    <script src="../static/vendors/js/vendor.bundle.base.js"></script>
    <!-- endinject -->
    <!-- Plugin js for this page -->
    <!-- End plugin js for this page -->
    <!-- inject:js -->
    <script src="../static/js/off-canvas.js"></script>
    <script src="../static/js/hoverable-collapse.js"></script>
    <script src="../static/js/misc.js"></script>
    <!-- endinject -->
  </body>
</html>