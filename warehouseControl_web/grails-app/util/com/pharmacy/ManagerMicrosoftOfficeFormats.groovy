package com.pharmacy

import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class ManagerMicrosoftOfficeFormats {

	Workbook workbook

	ManagerMicrosoftOfficeFormats(){}

	XSSFWorkbook openExcel(String pathFile){
		
		File excel = new File(pathFile)
		println "Archivo: ${excel.path}"	
		workbook = new XSSFWorkbook(excel)
		def list = new ManagerMicrosoftOfficeFormats().getAllSheetNames(workbook)
		println "Lista de nombre de hojas: ${list}"
		new ManagerMicrosoftOfficeFormats().readSheets(workbook)
	}	

	def readSheets(XSSFWorkbook workbook){
		
		String sheetName = ""
		workbook.eachWithIndex{sheet,index->
			sheetName = sheet.getSheetName()
			sheet.each{row->
				row.each{cell->
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