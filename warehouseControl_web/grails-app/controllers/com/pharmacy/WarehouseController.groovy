package com.pharmacy

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class WarehouseController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Warehouse.list(params), model:[warehouseCount: Warehouse.count()]
    }

    def show(Warehouse warehouse) {
        respond warehouse
    }

    def create() {
        respond new Warehouse(params)
    }

    @Transactional
    def save(Warehouse warehouse) {
        if (warehouse == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (warehouse.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond warehouse.errors, view:'create'
            return
        }

        warehouse.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'warehouse.label', default: 'Warehouse'), warehouse.id])
                redirect warehouse
            }
            '*' { respond warehouse, [status: CREATED] }
        }
    }

    def edit(Warehouse warehouse) {
        respond warehouse
    }

    @Transactional
    def update(Warehouse warehouse) {
        if (warehouse == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (warehouse.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond warehouse.errors, view:'edit'
            return
        }

        warehouse.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'warehouse.label', default: 'Warehouse'), warehouse.id])
                redirect warehouse
            }
            '*'{ respond warehouse, [status: OK] }
        }
    }

    @Transactional
    def delete(Warehouse warehouse) {

        if (warehouse == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        warehouse.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'warehouse.label', default: 'Warehouse'), warehouse.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'warehouse.label', default: 'Warehouse'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
