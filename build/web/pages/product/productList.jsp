<%-- 
    Document   : listConsultation
    Created on : 5 janv. 2024, 13:44:45
    Author     : chalman
--%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <title>Search IA</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                      <div class="navbar-header">
                        <a class="navbar-brand" href="#">
                          <img alt="Search IA" src="...">
                        </a>
                      </div>
                    </div>
                </nav>
            </div>
            <% if(request.getAttribute("error") != null) { %>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <p class="text-danger"><%=request.getAttribute("error") %></p>
                    </div>
                </div>
            <% } %>
            <div class="row consult">
                <div class="col-md-12">
                    <div class="col-md-12" style="margin-top: 30px">
                    
                        <form class="form-horizontal" action="./SearchIA" method="POST">
                            <div class="form-group">
                                <div class="col-sm-6">
                                    <input type="text" placeholder="Mot cle de recherche" class="form-control" name="keyWord">
                                </div>
                                <div class="col-sm-2">
                                    <button type="submit" class="btn btn-primary">Rechercher</button>
                                </div>
                            </div>
                        </form>        
                    </div>
                </div>
            </div>
            <div class="row consult">
                <div class="col-md-12">
                    <% if(request.getAttribute("requestEnter") != null) { %>
                        <h1>Resultat pour : <%=request.getAttribute("requestEnter") %></h1>
                    <% } else { %>
                    <h1>Liste des produits</h1>
                    <% } %>
                   
                    <table class="table" style="margin-top: 30px">
                        <tr>
                            <th>ID</th>
                            <th>Produit</th>
                            <th>Categorie</th>
                            <th>Prix</th>
                            <th>Qualite</th>
                            <th>Action</th>
                        </tr>
                        <% if(request.getAttribute("products") != null) { 
                            List<VProduct> products = (List<VProduct>)request.getAttribute("products");
                            for(int i = 0; i < products.size(); i++) {
                        %>
                        <tr>
                            <td><%=products.get(i).getIdProduct() %></td>
                            <td><%=products.get(i).getProduct() %></td>
                            <td><%=products.get(i).getCategorie() %></td>
                            <td><%=products.get(i).getPrix() %></td>
                            <td><%=products.get(i).getQualite() %></td>
                            <td>
                                <a href="#" type="button" class="text-danger"><i class="glyphicon glyphicon-trash"></i></a>
                            </td>
                        </tr>
                        <% } } %>
                    </table>
                </div>
            </div>
        </div>
        
        <script src="css/FOU/bootstrap/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
