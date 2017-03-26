package com.pharmacy

class Laboratory {

    static constraints = {

    	fullName blank:false, nullable:false, minSize:1
		address blank:false, nullable:false, minSize:1
		email blank:true, nullable:false, email:true
		phone blank:false, nullable:false, minSize:10

    }

    Date dateCreated
    Date lastUpdated
    String fullName
    String address
    String email
    String phone

}
