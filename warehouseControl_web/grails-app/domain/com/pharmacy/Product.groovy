package com.pharmacy

class Product {

    static constraints = {

    	barcode blank:false, nullable:false, minSize:1, unique:true
    	description blank:false, nullable:false, minSize:1
		purchasePrice blank:false, nullable:false, min:0F
		maximumPrice blank:false, nullable:false, min:0F
		salePrice blank:true, nullable:true, min:0F
		discount blank:true, nullable:true, min:0F
		expirationDate blank:false, nullable:false
		activeComponent blank:true, nullable:true, minSize:1

	}

    String barcode
    String description
    Float purchasePrice
    Float maximumPrice
    Float salePrice
    Float discount
    Date expirationDate
    String activeComponent

	static mapping = {
    	taxes cascade: "all-delete-orphan"
    }

    static belongsTo = [Warehouse, Laboratory, Provider]
    static hasMany = [warehouses:Warehouse, taxes:Tax, providers:Provider, laboratories: Laboratory]

}
