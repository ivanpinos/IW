/**
 * Envia los datos locales al servlet save para que guarde 
 * el resultado en el json del servidor
 */
function Save(url){
	var gridData = jQuery('#lista').getRowData();
	var data = JSON.stringify(gridData);
	var xmlHttp = null;
    xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "POST", url, false );
    xmlHttp.send( data );
}

/**
 * Envia los datos locales al servlet deleteAll para que borre 
 * todos los elementos de la lista.
 */
function DeleteAll(url){
	$.ajax({
	    url: url,
	    type: 'GET',
	    success: function(result) {
	    	alert('Tasks deleted succesfully.');
	    	location.reload(true); 
	    }
	});
}