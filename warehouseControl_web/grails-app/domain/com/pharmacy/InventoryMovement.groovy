package com.pharmacy

class InventoryMovement {

    static constraints = {

    	movementType blank:false, nullable:false, minSize:1
    	
    }

    Date dateCreated
    Date lastUpdated
    String movementType
}
