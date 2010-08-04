package order

class Recipe {
    static belongsTo = Dish
    String ingredients
    String directions
    String nutrition//TODO
    String pictures
    
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
