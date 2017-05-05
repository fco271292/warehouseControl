function filterItems(idTable,idInputSearch) {
	var rowTable = document.getElementById(idTable).rows
	var patterSearchTax = document.getElementById(idInputSearch).value 
	var row = new Object()
	var contentCell = ""
	//console.log("In "+patterSearchTax.value)
	for(var rowItem = 1; rowItem < rowTable.length; rowItem++){
		
		rowTable[rowItem].id = "table_row"
		
		row = rowTable[rowItem].cells
		for (var columnItem = 0; columnItem < row.length; columnItem++) {
			//console.log(rowTable[rowItem][columnItem].innerHTML+":::")
			contentCell = row[columnItem].innerHTML
			//Se hace la busqueda en la tabla, si se encuentra se presenta la informacion, caso contrario se oculta
			//rowTable[rowItem].style.display = contentCell.toLowerCase().indexOf(patterSearchTax.toLowerCase()) != -1 ? "" : "none"
			if(contentCell.toLowerCase().search(patterSearchTax.toLowerCase()) != -1){
				rowTable[rowItem].id = "show"
			}
			
		}

		if (rowTable[rowItem].id.toLowerCase().search("show") != -1) {
			rowTable[rowItem].style.display  = ""
		}
		else{
			//rowTable[rowItem].id = "hidden"
			rowTable[rowItem].style.display  = "none"	
		}
		

	}

	
}