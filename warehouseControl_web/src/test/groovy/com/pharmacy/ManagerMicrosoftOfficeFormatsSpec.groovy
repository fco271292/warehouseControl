package com.pharmacy

import grails.test.mixin.*
import spock.lang.*

import com.pharmacy.ManagerMicrosoftOfficeFormats

class ManagerMicrosoftOfficeFormatsSpec extends Specification {
	void "Read book excel" () {
		given:
			ManagerMicrosoftOfficeFormats managerMicrosoftOfficeFormats = new ManagerMicrosoftOfficeFormats()
		when:
			managerMicrosoftOfficeFormats.readExcel()
		then:
			true == false
	}
}