package com.pharmacy

import grails.test.mixin.*
import spock.lang.*

import com.pharmacy.ManagerMicrosoftOfficeFormats

class ManagerMicrosoftOfficeFormatsSpec extends Specification {
	void "Read book excel" () {
		given:
			String pathFile = System.getProperty("user.dir","empty")
			pathFile = "${pathFile}\\src\\test\\source\\libro.xlsx"
			ManagerMicrosoftOfficeFormats managerMicrosoftOfficeFormats = new ManagerMicrosoftOfficeFormats()
		when:
			managerMicrosoftOfficeFormats.openExcel(pathFile)
		then:
			true == false
	}
}