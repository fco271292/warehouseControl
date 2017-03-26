package com.pharmacy

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class InventoryMovementController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond InventoryMovement.list(params), model:[inventoryMovementCount: InventoryMovement.count()]
    }

    def show(InventoryMovement inventoryMovement) {
        respond inventoryMovement
    }

    def create() {
        respond new InventoryMovement(params)
    }

    @Transactional
    def save(InventoryMovement inventoryMovement) {
        if (inventoryMovement == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (inventoryMovement.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond inventoryMovement.errors, view:'create'
            return
        }

        inventoryMovement.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'inventoryMovement.label', default: 'InventoryMovement'), inventoryMovement.id])
                redirect inventoryMovement
            }
            '*' { respond inventoryMovement, [status: CREATED] }
        }
    }

    def edit(InventoryMovement inventoryMovement) {
        respond inventoryMovement
    }

    @Transactional
    def update(InventoryMovement inventoryMovement) {
        if (inventoryMovement == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (inventoryMovement.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond inventoryMovement.errors, view:'edit'
            return
        }

        inventoryMovement.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'inventoryMovement.label', default: 'InventoryMovement'), inventoryMovement.id])
                redirect inventoryMovement
            }
            '*'{ respond inventoryMovement, [status: OK] }
        }
    }

    @Transactional
    def delete(InventoryMovement inventoryMovement) {

        if (inventoryMovement == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        inventoryMovement.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'inventoryMovement.label', default: 'InventoryMovement'), inventoryMovement.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'inventoryMovement.label', default: 'InventoryMovement'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
