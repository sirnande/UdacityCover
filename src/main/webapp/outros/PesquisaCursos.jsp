<%--
  Created by IntelliJ IDEA.
  User: Sirnande Dos Santos Lima
  Date: 30/05/17
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>

    <title>Udacity</title>
    <link rel="shortcut icon" href="media/logo-mark.svg">
    <link rel="stylesheet" type="text/css" href="../css/home.css">
    <link rel="stylesheet" type="text/css" href="../css/cadastro2.css">
    <meta  charset=utf-8"/>
    <script type="text/javascript" src="../resource/js/jquery/jquery-3.2.1.min.js"></script>

</head>
<body>
<div class="container">
    <div class="azul">
        <img class="imagen" src="../media/udacity_tranparente.png">
        <div class="amarelo">
            <div class="divmenus">
                <ul class="menus">
                    <li>

                        <a href="#">Olá  <c:out value="${nome}"/></a>
                        <ul class="submenus">
<%--
                                <form action="Upload" method="post" enctype="multipart/form-data">
                                    <label class="customFileInput clearfixc">
                                        <div class="button">Escolha uma Imagem</div>
                                        <input type="file" name="file" >
                                    </label>
                                    <input type="submit" value="OK">
                                </form>--%>

                            <li class="extra"><a href="#">Ferramentas</a></li>
                            <li class="extra"><a href="/Sair">Sair</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <div class="menudiv">
        <ul class="menu">
            <li><a href="../index.html">Udacity</a>
                <ul class="submenu">
                    <li><a href="#">Carreira</a> </li>
                    <li><a href="#">Junte-se à nós</a></li>
                    <li><a href="#">Seja um diferencial</a>

                    </li>
                </ul>
            </li>

            <c:if test="${tipo != 3}">
                 <li><a href="#">Arquivos</a>
                    <ul class="submenu">
                        <li><a href="../outros/Cursos.jsp">Cadastro Curso</a> </li>
                        <li><a href="#">Listar Arquivos</a></li>
                        <li><a href="#">Excluir Arquivos</a></li>
                    </ul>
                </li>
            </c:if>

            <li><a href="#">Time line</a>
                <ul class="submenu">
                    <li><a href="#">Ver minha linha do Tempo</a></li>
                    <li><a href="#">Ir data específica</a></li>
                    <li><a href="#">Imprimir</a></li>
                </ul>
            </li>

            <c:if test="${tipo != 3}">
                <li><a href="#">Relatório</a>
                    <ul class="submenu">
                        <li><a href="#">Emitir relatório</a></li>
                        <li><a href="#">Enviar</a></li>
                        <li><a href="#">Criar um Relatorio</a></li>
                    </ul>
                </li>
            </c:if>

        </ul>


    </div>

    <div id="vermelha">
        <ul id="nav" >

            <li><a href="../index.html">Home</a></li>
            <li><a href="#">Cursos</a></li>
            <li><a href="#">Meu Curso</a>

                <ul>
                    <li><a href="../outros/PesquisaCursos.jsp">Ir ao Curso</a></li>
                    <li><a href="#">Material</a></li>
                    <li><a href="#">Lista de Cursos Matriulado</a></li>
                </ul>

            </li>
            <li><a href="#">Serviços</a>

                <ul>
                    <li><a href="#">Forúm</a></li>
                    <li><a href="#">Palestras</a></li>
                    <li><a href="#">Falar com um instrutor</a></li>
                </ul>

            </li>
            <li><a href="#">Blog</a></li>
            <li><a href="#">Sobre Nós</a></li>
            <li><a href="#">Catálogo</a></li>
            <li><a href="#">Contato</a></li>

        </ul>
    </div>


    <div id="verde">
        <div class="cadastro indice">
            <form action="/Teste" method="post">
                <input type="nome" name="nome" id="nome" placeholder="Nome do Curso" required>

                <button name="submit" value="" type="submit" class="btn btn-primary btn-block btn-flat">Pesquisar </button>

            </form>
        </div>
        <c:forEach var="lista" items="${listatudo}">
            <div class="caixaCurso">
                <a href="#">
                    <img src="${lista.local}" alt="new!">
                <%--  <div class="cursoTexto"> --%>
                    <nav class="cursoSobrepor_video">
                        <h6 class="cursoAzul cursoTamanho">${lista.nome}</h6>
                        <h5 class="cursoTamanho">${lista.descricao}</h5>
                        <p>${lista.duracao}</p>
                <%-- </div> --%>
                    </nav>
                </a>
            </div>
        </c:forEach>
    </div>
    <div class="laranja">
        <div class="caixaLateral">
            <a href="#">
                <img src="../Udacity/slaide1.jpg" alt="new!">
                <div class="texto">
                    <h6 class="azul tamanho">Novo!</h6>
                    <h5 class="tamanho">Nanodegree Robótica</h5>
                    <p>Candidate-se!</p>
                </div>
            </a>
        </div>
        <c:forEach var="lista" items="${curso}">
            <div class="caixaLateral lateralAjuste">
                <a href="#">
                    <img src="${lista.local}" alt="new!">
                    <div class="texto">
                        <h6 class="azul tamanho">${lista.nome}</h6>
                        <h5 class="tamanho">${lista.descricao}</h5>
                        <p>Candidate-se!</p>
                    </div>
                </a>
            </div>
        </c:forEach>
    </div>

</div>
</body>
</html>