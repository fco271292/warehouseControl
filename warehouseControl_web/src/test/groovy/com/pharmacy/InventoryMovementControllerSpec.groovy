package com.pharmacy

import grails.test.mixin.*
import spock.lang.*

@TestFor(InventoryMovementController)
@Mock(InventoryMovement)
class InventoryMovementControllerSpec extends Specification {

    @Ignore
    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    @Ignore
    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.inventoryMovementList
            model.inventoryMovementCount == 0
    }

    @Ignore
    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.inventoryMovement!= null
    }

    @Ignore
    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def inventoryMovement = new InventoryMovement()
            inventoryMovement.validate()
            controller.save(inventoryMovement)

        then:"The create view is rendered again with the correct model"
            model.inventoryMovement!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            inventoryMovement = new InventoryMovement(params)

            controller.save(inventoryMovement)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/inventoryMovement/show/1'
            controller.flash.message != null
            InventoryMovement.count() == 1
    }

    @Ignore
    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def inventoryMovement = new InventoryMovement(params)
            controller.show(inventoryMovement)

        then:"A model is populated containing the domain instance"
            model.inventoryMovement == inventoryMovement
    }

    @Ignore
    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def inventoryMovement = new InventoryMovement(params)
            controller.edit(inventoryMovement)

        then:"A model is populated containing the domain instance"
            model.inventoryMovement == inventoryMovement
    }

    @Ignore
    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/inventoryMovement/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def inventoryMovement = new InventoryMovement()
            inventoryMovement.validate()
            controller.update(inventoryMovement)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.inventoryMovement == inventoryMovement

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            inventoryMovement = new InventoryMovement(params).save(flush: true)
            controller.update(inventoryMovement)

        then:"A redirect is issued to the show action"
            inventoryMovement != null
            response.redirectedUrl == "/inventoryMovement/show/$inventoryMovement.id"
            flash.message != null
    }

    @Ignore
    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/inventoryMovement/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def inventoryMovement = new InventoryMovement(params).save(flush: true)

        then:"It exists"
            InventoryMovement.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(inventoryMovement)

        then:"The instance is deleted"
            InventoryMovement.count() == 0
            response.redirectedUrl == '/inventoryMovement/index'
            flash.message != null
    }
}
