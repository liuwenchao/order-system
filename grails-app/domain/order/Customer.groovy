package order

class Customer {
    static hasMany = [locations:Location]
    String email
    String pwd
    String fn
    String ln
    String phone
    String membership

    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
