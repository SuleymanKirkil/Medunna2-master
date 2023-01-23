package pojos.Us001;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class US001_US002_RegistrationPojo {
    /*
      {
    "activated": true,
    "authorities": [
      "string"
    ],
    "createdBy": "string",
    "createdDate": "2022-08-15T20:40:53.554Z",
    "email": "string",
    "firstName": "string",
    "id": 0,
    "imageUrl": "string",
    "langKey": "string",
    "lastModifiedBy": "string",
    "lastModifiedDate": "2022-08-15T20:40:53.554Z",
    "lastName": "string",
    "login": "string",
    "ssn": "string"
  }
     */
    public US001_US002_RegistrationPojo() {
    }

    public US001_US002_RegistrationPojo(String ssn, String firstName, String lastName, String login, String email) {

        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;  //username
        this.email = email;


    }


    private String email;
    private String firstName;
    private String lastName;
    private String login; //username
    private String ssn;



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "US001_US002_RegistrationPojo{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
