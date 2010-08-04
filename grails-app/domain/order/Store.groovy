package order

class Store {
    static belongsTo = Brand
    static hasMany = [dishes:Dish]
    
    Location location
    String phone
    String hours//TODO
    String delivery//TODO

    Date dateCreated
    Date lastUpdated
    
    static constraints = {
    }
}
