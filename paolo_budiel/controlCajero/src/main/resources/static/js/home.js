$( document ).ready(function() {
	$.get('https://cajero-back.herokuapp.com/main/cajeros',function(data){
		cajeros = data
		data.forEach(el => {
			var e = (el.tipoE=='a')? '<a class="btn btn-warning" >Activo</a>' : '<a class="btn btn-light disabled" >Inactivo</a>'
			var n = (el.tipoN=='a')? '<a class="btn btn-success" >Activo</a></td>' : '<a class="btn btn-light disabled">Inactivo</a></td>'
			var ap = (el.tipoAP=='a')? '<a class="btn btn-info" >Activo</a></td>' : '<a class="btn btn-light disabled">Inactivo</a></td>'
			$('#cajerosTbl tbody').append('<tr><td>'+el.id+'</td><td>'+el.nom+'</td>'+
					'<td onclick="estadoE('+el.id+')" id='+el.id+'BtnE>'+e+'</td>'+
					'<td onclick="estadoN('+el.id+')" id='+el.id+'BtnN>'+n+'</td>'+
					'<td onclick="estadoAP('+el.id+')" id='+el.id+'BtnAP>'+ap+'</td></tr>'
			)
		})
		
	})
	
	
	function asigF(){
		console.log('asig')
	}
});
var timer = 15000
/*
 var cajeros =	[
	{ id:1, nom:"Susan E.", tipoE:"i" , tipoN:"i", tipoAP:"a"	 ,cola:[]},
	{ id:2, nom:"Lizbet F.", tipoE:"i" , tipoN:"a", tipoAP:"i"	 ,cola:[]},
	{ id:3, nom:"Michael G.", tipoE:"i" , tipoN:"a", tipoAP:"i"  ,cola:[]},
	{ id:4, nom:"Alex H.", tipoE:"i" , tipoN:"a", tipoAP:"i"	 ,cola:[]},
	{ id:5, nom:"Marco I.", tipoE:"a" , tipoN:"i", tipoAP:"i"	 ,cola:[]},
	{ id:6, nom:"Christian J.", tipoE:"i" , tipoN:"i", tipoAP:"i",cola:[]},
	{ id:7, nom:"Jean K.", tipoE:"i" , tipoN:"i", tipoAP:"i"	 ,cola:[]},
	{ id:8, nom:"Lucas L.", tipoE:"i" , tipoN:"i", tipoAP:"i"	 ,cola:[]}
	]
 */

var cajeros
var clientes = []

function estadoE(a){
	if($('.btn-warning').size()>1 || $('#'+a+'BtnE .btn').attr('class') == 'btn btn-light disabled'){
		var nc= ($('#'+a+'BtnE .btn').attr('class') == 'btn btn-warning')? 'btn btn-light disabled' : 'btn btn-warning'
		var nt= ($('#'+a+'BtnE .btn').attr('class') == 'btn btn-warning')? 'Inactivo' : 'Activo'
		var ne= ($('#'+a+'BtnE .btn').attr('class') == 'btn btn-warning')? cajeros.find(({id}) => id==a).tipoE='i' : cajeros.find(({id}) => id==a).tipoE= 'a'
		$('#'+a+'BtnE .btn').attr('class', nc).html(nt);
	}else{
		alert('¡DEBE DE HABER POR LO MENOS UNA CAJA EXCLUSIVA!')
	}	
}
function estadoN(a){
	if($('.btn-success').size()>1 || $('#'+a+'BtnN .btn').attr('class') == 'btn btn-light disabled'){
		var nc= ($('#'+a+'BtnN .btn').attr('class') == 'btn btn-success')? 'btn btn-light disabled' : 'btn btn-success'
		var nt= ($('#'+a+'BtnN .btn').attr('class') == 'btn btn-success')? 'Inactivo' : 'Activo'
		var ne= ($('#'+a+'BtnN .btn').attr('class') == 'btn btn-success')? cajeros.find(({id}) => id==a).tipoN='i' : cajeros.find(({id}) => id==a).tipoN= 'a'
		$('#'+a+'BtnN .btn').attr('class', nc).html(nt);
	}else{
		alert('¡DEBE DE HABER POR LO MENOS UNA CAJA NORMAL!')
	}	
}
function estadoAP(a){
	if($('.btn-info').size()>1 || $('#'+a+'BtnAP .btn').attr('class') == 'btn btn-light disabled'){
		var nc= ($('#'+a+'BtnAP .btn').attr('class') =='btn btn-info')? 'btn btn-light disabled' : 'btn btn-info'
		var nt= ($('#'+a+'BtnAP .btn').attr('class') =='btn btn-info')? 'Inactivo' : 'Activo'
		var ne= ($('#'+a+'BtnAP .btn').attr('class') == 'btn btn-info')? cajeros.find(({id}) => id==a).tipoAP='i' : cajeros.find(({id}) => id==a).tipoAP= 'a'
		$('#'+a+'BtnAP .btn').attr('class', nc).html(nt);
	}else{
		alert('¡DEBE DE HABER POR LO MENOS UNA CAJA PREFERENCIAL!')
	}
}
function progCajero(id){
	$('#'+cajeros.find(el => el.id== id).cola[0]).remove()
	cajeros.find(el => el.id== id).cola.shift()
	//cajeros.find(cajeros.findIndex(el => el.id== id),1)
	if(cajeros.find(el => el.id== id).cola[0]>0){
		$('#'+cajeros.find(el => el.id== id).cola[0]+' td:last').html('Atendiendo')
		setTimeout(()=>(progCajero(id)), timer);
	}
}

function genCli(){
	var edad = Math.floor(Math.random() * (70 - 18)) + 18;
	var dni = Math.floor(10000000 + Math.random() * 90000000);
	var tipo
	var est = 'Asignado'
	var caja
	var css
	if(edad >60){
		tipo='Preferencial'
		alert('edad es preferencial ('+edad+')')
		css='background-color: #17a2b8;color:white'
		var arrFl=cajeros.filter(({tipoAP}) => tipoAP=='a')
		if(arrFl.length>1){
			var minSz = arrFl[0].cola.length
			var id = arrFl[0].id
			arrFl.forEach(el=>{
				if(el.cola.length<minSz) {minSz=el.cola.length; id=el.id};
			})
			cajeros.find(el => el.id==id).cola.push(dni)
		}else{
			cajeros.find(({tipoAP}) => tipoAP=='a').cola.push(dni)
			var id = cajeros.find(({tipoAP}) => tipoAP=='a').id		
		}
		
		var caja = id
		if(cajeros.find(el => el.id==id).cola.length == 1){
			est='Atendiendo'
			setTimeout(()=>(progCajero(id)), timer);
		}
	}else if(parseInt(edad / 3)*3 == edad){
		tipo='Exclusivo'
		alert('edad es exclusivo ('+edad+')')	
		css='background-color: #ffc107;color:black'
		
		var arrFl=cajeros.filter(({tipoE}) => tipoE=='a')
		if(arrFl.length>1){
			var minSz = arrFl[0].cola.length
			var id = arrFl[0].id
			arrFl.forEach(el=>{
				if(el.cola.length<minSz) {minSz=el.cola.length; id=el.id};
			})
			cajeros.find(el => el.id==id).cola.push(dni)
		}else{
			cajeros.find(({tipoE}) => tipoE=='a').cola.push(dni)
			var id = cajeros.find(({tipoE}) => tipoE=='a').id			
		}
		
		var caja = id
		
		if(cajeros.find(el => el.id==id).cola.length == 1){
			est='Atendiendo'
			setTimeout(()=>(progCajero(id)), timer);
		}
		
	}else{
		tipo='Normal'
		alert('edad es normal ('+edad+')')
		css='background-color: #28a745;color:white'
		
		var arrFl=cajeros.filter(({tipoN}) => tipoN=='a')
		if(arrFl.length>1){
			var minSz = arrFl[0].cola.length
			var id = arrFl[0].id
			arrFl.forEach(el=>{
				if(el.cola.length<minSz) {minSz=el.cola.length; id=el.id};
			})
			cajeros.find(el => el.id==id).cola.push(dni)
		}else{
			cajeros.find(({tipoN}) => tipoN=='a').cola.push(dni)
			var id = cajeros.find(({tipoN}) => tipoN=='a').id			
		}
		
		var caja = id
		
		if(cajeros.find(el => el.id==id).cola.length == 1){
			est='Atendiendo'
			setTimeout(()=>(progCajero(id)), timer);
		}
	}
	
	
	//clientes.push({dni: dni, edad: edad, asig:})
	$('#clientesTbl tbody').append('<tr id='+dni+' ><td>'+dni+'</td><td>'+edad+'</td><td style="font-weight: 900;">'+caja+'</td><td style="'+css+'">'+tipo+'</td><td>'+est+'</td></tr>')
}