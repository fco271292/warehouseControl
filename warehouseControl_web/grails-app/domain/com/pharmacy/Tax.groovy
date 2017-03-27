package com.pharmacy

class Tax {

    static constraints = {
    	
    	description blank:false, nullable:false, minSize:1
    	amount blank:false, nullable:false, min:0F
        product blank:true, nullable:true
    	
    }

	Date dateCreated
    Date lastUpdated
    String description
    Float amount

    static belongsTo = [product:Product]

}