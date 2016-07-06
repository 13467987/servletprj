<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script type="text/javascript">  
    $(document).ready(function(){
    	$("#homec").click(function(){
    		$(this).addClass("active");
    	});
    });
    </script>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1 myTab">
      <ul class="nav navbar-nav" id="menu">
        <li><a href="index.do">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="board.do">Board</a></li>
        <li><a href="customer.do">QnA</a></li>
      </ul>
    </div>
  </div>
</nav>

