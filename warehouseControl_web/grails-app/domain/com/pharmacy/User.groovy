package com.pharmacy

class User {

    static constraints = {

    	name blank:false, nullable:false, minSize:1
    	lastName blank:false, nullable:false, minSize:1
    	secondSurname blank:true, nullable:true,minSize:0
    	birthDate blank:true, nullable:true
    	position blank:false, nullable:false
    	email blank:true, nullable:true, email:true
    	address blank:false, nullable:false, minSize:1
    	phone blank:false, nullable:false, minSize:10
    	rfc blank:true, nullable:true

    }

	Date dateCreated
    Date lastUpdated
    String name
    String lastName
    String secondSurname
    Date birthDate
    String position
    String email
	String address
	String phone
	String rfc

}
