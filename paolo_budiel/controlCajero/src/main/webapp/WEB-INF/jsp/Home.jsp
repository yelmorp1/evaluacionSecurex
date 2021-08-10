<html>
<head>
    <title>Control de cajeros</title>
    <link href="webjars/bootstrap/4.6.0/css/bootstrap.min.css"
        rel="stylesheet">
    <link href="css/home.css"
        rel="stylesheet">
</head>
<body>
    <div class="container">
    	<div class='titulo'>CAJEROS</div>
        <table id="cajerosTbl" class="table table-striped">
            <thead>
                <tr>
                    <th>Id Usuario</th>
                    <th>Nombre Cajeros</th>
                    <th>Exclusivo</th>
                    <th>Normal</th>
                    <th>Atención Preferencial</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
            
     </div>     
     <div class="container">
    	<div class='titulo'>CLIENTES</div>
		<a class="btn btn-block btn-dark" onclick='genCli()'>Ingreso cliente</a>
		</br>
        <table id="clientesTbl" class="table table-striped">
            <thead>
                <tr>
                    <th>DNI</th>
                    <th>Edad</th>
                    <th>Caja</th>
                    <th>Tipo</th>
                    <th>Estado</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
     </div>
     <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
     <script src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
     <script src="js/home.js"></script>
    </div>
</body>
</html>