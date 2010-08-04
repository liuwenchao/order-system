package order

class Receipt {
    static hasMany = [dishes: Dish]
    Store store
    Customer buyer
    Date arriveAt
    
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
