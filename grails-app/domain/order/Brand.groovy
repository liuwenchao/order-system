package order

class Brand {
    static hasMany = [stores:Store]
    String name
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
