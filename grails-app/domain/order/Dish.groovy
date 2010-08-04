package order

class Dish {
    static belongsTo = Store
    String name
    Double price
    String picture
    Recipe recipe
    
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
