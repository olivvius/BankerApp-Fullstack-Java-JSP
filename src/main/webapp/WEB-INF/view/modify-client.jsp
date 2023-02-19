<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html xlmns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Modifier un client</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <br />
        <h1> Modifier un client</h1>
        <br />
        <form:form method = "POST" action = "/modify-client" modelAttribute="modify-client">
            <div class="conteiner h100">
                <div class="row h100 justify-content-center align-items-center">
                    <div class="col-10 col-md-8 col-lg-6">
                        <form:hidden path="id" />
                        <div class="form-group div-to-align">
                            <form:label path = "nom">description</form:label>
                            <form:textarea path = "nom" />
                            <form:errors path="nom" />
                        </div>
                        <br>
                        <br>
                        <div class="form-group div-to-align">
                            <form:label path = "prenom">prenom</form:label>
                            <form:textarea class="form-control" path = "prenom" />
                            <form:errors path="prenom" />
                        </div>
                        <br>
                        <div class="form-group div-to-align">
                            <form:label path = "adresse">adresse</form:label>
                            <form:textarea class="form-control" path = "adresse" />
                            <form:errors path="adresse" />
                        </div>
                        <br>  
                        <div class="form-group div-to-align">
                            <form:label path = "zip">code postal</form:label>
                            <form:textarea class="form-control" path = "zip" />
                            <form:errors path="zip" />
                        </div>
                        <br>
                        <div class="form-group div-to-align">
                            <form:label path = "ville">ville</form:label>
                            <form:textarea class="form-control" path = "ville" />
                            <form:errors path="ville" />
                        </div>
                        <br>
                        <div class="form-group div-to-align">
                            <form:label path = "tel">telephone</form:label>
                            <form:textarea class="form-control" path = "tel" />
                            <form:errors path="tel" />
                        </div>
                        <br>                        
                        <div class="form-group div-to-align">
                            <form:label path = "mail">Mail</form:label>
                            <form:textarea class="form-control" path = "mail" />
                            <form:errors path="mail" />
                        </div>
                        <br>
                        <div class="form-group div-to-align">
                            <td colspan = "2">
                                <input type = "submit" value = "Submit" class="btn btn-primary mb-2"/>
                            </td>
                        </div>
                    </div>
                </div>
            </div>
        </form:form>
        <br />  


    </body>
</html>
