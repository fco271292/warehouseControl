function filterItems(idTable,idInputSearch) {
	
	var rowTable = document.getElementById(idTable).rows
	var patterSearchTax = document.getElementById(idInputSearch).value 
	var row = new Object()
	var contentCell = ""
	//console.log("In "+patterSearchTax.value)
	
	for(var rowItem = 0; rowItem < rowTable.length; rowItem++){
		row = rowTable[rowItem].cells
		for (var columnItem = 0; columnItem < row.length; columnItem++) {
			contentCell = row[columnItem].innerHTML
			//Se hace la busqueda en la tabla, si se encuentra se presenta la informacion, caso contrario se oculta
			row[columnItem].style.display = contentCell.toLowerCase().indexOf(patterSearchTax.toLowerCase()) != -1 ? "" : "none"
			
		}
	}
	
}