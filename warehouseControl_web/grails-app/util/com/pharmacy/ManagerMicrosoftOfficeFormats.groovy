package com.pharmacy

import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class ManagerMicrosoftOfficeFormats {

	Workbook workbook

	ManagerMicrosoftOfficeFormats(){}

	XSSFWorkbook openExcel(String pathFile){
		
		File excel = new File(pathFile)
		workbook = new XSSFWorkbook(excel)
		new ManagerMicrosoftOfficeFormats().readSheets(workbook)
		workbook

	}	

	def readSheets(XSSFWorkbook workbook){
		

		String sheetName = ""
		workbook.eachWithIndex{sheet,index->
			sheetName = sheet.getSheetName()
			sheet.each{row->
				row.each{cell->
					if(row.size() > 1 && cell.getCellStyle().getFillBackgroundColor() != 0)
						print cell	
				}
				println ""
			}
		}
		
	}

	List<String> getAllSheetNames(XSSFWorkbook workbook){
		
		String sheetName = ""
		List<String> listSheetName = []
		workbook.each { sheet ->
			sheetName = sheet.getSheetName()
			listSheetName << sheetName
		}
		listSheetName

	}
	
}