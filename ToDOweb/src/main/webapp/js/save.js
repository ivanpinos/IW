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