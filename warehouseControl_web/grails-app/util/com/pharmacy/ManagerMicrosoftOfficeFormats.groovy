package com.pharmacy

import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class ManagerMicrosoftOfficeFormats {

	def readExcel(){
		String pathFile = System.getProperty("user.dir","empty")
		File excel = new File("${pathFile}\\src\\test\\source\\libro.xlsx")
		println "Archivo: ${excel.path}"	
	}	
	
}