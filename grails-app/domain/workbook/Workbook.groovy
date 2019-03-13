package workbook

class Workbook {
    long id
    String firstName
    String lastName
    String dateOfBirth
    String age
    String passportNumber
    String email
    String phone
    static constraints = {
        firstName nullable: false
        lastName nullable: false
        dateOfBirth nullable: false
        age nullable: false
        passportNumber nullable: false
        email nullable: false
        phone nullable: false
    }
}
