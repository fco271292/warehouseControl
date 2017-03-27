package com.pharmacy

class InventoryMovement {

    static constraints = {

    	movementType blank:false, nullable:false, minSize:1
    	warehouse blank:true, nullable:true
    	
    }

    Date dateCreated
    Date lastUpdated
    String movementType

    static belongsTo = [warehouse:Warehouse]
}
