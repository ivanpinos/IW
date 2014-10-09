/**
 * implementación de la jqGrid
 */
function loadGrid(){
	var json = httpGet("/load");
	var datos;
	if(json == "")
		datos = [{"task":"task","project":"project","priority":2}];
	else
		datos =JSON.parse(json);
	jQuery("#lista").jqGrid({
		 data: datos,
		 datatype: "local",
		 jsonReader: {repeatitems: false, root: function (obj) { return obj; }},
		 colNames:['task','context', 'project', 'priority'],
		 colModel:[ {name:'task',index:'task',editrules:{required:true}, 
			 			width:120,search:true,stype:'text',align:"center", editable:true}, 
		            {name:'context',index:'context', width:120, align:"center",editable:true}, 
		            {name:'project',index:'project',editrules:{required:true}, 
		            	align:"center",width:120,editable:true}, 
		            {name:'priority',index:'priority',editrules:{required:true},
		            		sorttype:'int',width:80, align:"center",
		            	editrules:{integer:true,required:true},editable:true}
		 ],
		 rowNum:10,
		 rowList:[10,20,30],
		 pager: '#div1',
		 sortname: 'priority',
		 viewrecords: true,
		 sortorder: "desc",
		 caption: "toDO list",
	});
	jQuery("#lista").jqGrid('navGrid',"#div1",{edit:false,add:false,del:false});
	jQuery("#lista").jqGrid('inlineNav',"#div1");
}

/**
 * Hace una petición web y devuelve los datos del .json
 */
function httpGet( url){
	var xmlHttp = null;
    xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", url, false );
    xmlHttp.send( null );
    return xmlHttp.response;
}