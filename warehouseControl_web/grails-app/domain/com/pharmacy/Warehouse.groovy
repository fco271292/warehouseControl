package com.pharmacy

class Warehouse {

    static constraints = {
    }

    Date dateCreated
    Date lastUpdated

    static mapping = {
       customers cascade: "all-delete-orphan"
       inventoryMovements cascade: "all-delete-orphan"
       users cascade: "all-delete-orphan"
    }

    static hasMany = [customers:Customer, users:User, inventoryMovements:InventoryMovement, products:Product]

}
