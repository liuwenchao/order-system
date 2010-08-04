package order

class DishController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [dishInstanceList: Dish.list(params), dishInstanceTotal: Dish.count()]
    }

    def create = {
        def dishInstance = new Dish()
        dishInstance.properties = params
        return [dishInstance: dishInstance]
    }

    def save = {
        def dishInstance = new Dish(params)
        if (dishInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'dish.label', default: 'Dish'), dishInstance.id])}"
            redirect(action: "show", id: dishInstance.id)
        }
        else {
            render(view: "create", model: [dishInstance: dishInstance])
        }
    }

    def show = {
        def dishInstance = Dish.get(params.id)
        if (!dishInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dish.label', default: 'Dish'), params.id])}"
            redirect(action: "list")
        }
        else {
            [dishInstance: dishInstance]
        }
    }

    def edit = {
        def dishInstance = Dish.get(params.id)
        if (!dishInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dish.label', default: 'Dish'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [dishInstance: dishInstance]
        }
    }

    def update = {
        def dishInstance = Dish.get(params.id)
        if (dishInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (dishInstance.version > version) {
                    
                    dishInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'dish.label', default: 'Dish')] as Object[], "Another user has updated this Dish while you were editing")
                    render(view: "edit", model: [dishInstance: dishInstance])
                    return
                }
            }
            dishInstance.properties = params
            if (!dishInstance.hasErrors() && dishInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'dish.label', default: 'Dish'), dishInstance.id])}"
                redirect(action: "show", id: dishInstance.id)
            }
            else {
                render(view: "edit", model: [dishInstance: dishInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dish.label', default: 'Dish'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def dishInstance = Dish.get(params.id)
        if (dishInstance) {
            try {
                dishInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'dish.label', default: 'Dish'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'dish.label', default: 'Dish'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dish.label', default: 'Dish'), params.id])}"
            redirect(action: "list")
        }
    }
}
