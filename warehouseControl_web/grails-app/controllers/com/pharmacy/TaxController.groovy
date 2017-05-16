package com.pharmacy

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TaxController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Tax.listOrderByDescription(), model:[taxCount: Tax.count()]
    }

    def show(Tax tax) {
        respond tax
    }

    def create() {
        respond new Tax(params)
    }

    @Transactional
    def save(Tax tax) {
        if (tax == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tax.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tax.errors, view:'create'
            return
        }

        tax.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'tax.label', default: 'Tax'), tax.id])
                redirect tax
            }
            '*' { respond tax, [status: CREATED] }
        }
    }

    def edit(Tax tax) {
        respond tax
    }

    @Transactional
    def update(Tax tax) {
        if (tax == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (tax.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond tax.errors, view:'edit'
            return
        }

        tax.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'tax.label', default: 'Tax'), tax.id])
                redirect tax
            }
            '*'{ respond tax, [status: OK] }
        }
    }

    @Transactional
    def delete(Tax tax) {

        if (tax == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        tax.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'tax.label', default: 'Tax'), tax.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'tax.label', default: 'Tax'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
