package com.pharmacy

class Provider {

    static constraints = {
    	
    	fullName blank:false, nullable:false, minSize:1
		address blank:false, nullable:false, minSize:1
		email blank:true, nullable:true, email:true
		phone blank:true, nullable:true, minSize:10
		
    }

	Date dateCreated
    Date lastUpdated
    String fullName
    String address
    String email
    String phone

    static hasMany = [products:Product]

}
