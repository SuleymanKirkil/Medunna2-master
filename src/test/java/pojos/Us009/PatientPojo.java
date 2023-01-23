package pojos.Us009;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/*
    {
    "createdBy": "team02_patient",
    "createdDate": "2022-10-13T00:21:36.662693Z",
    "id": 276238,
    "firstName": "Deniz",
    "lastName": "Zengin",
    "birthDate": null,
    "phone": "555 384 3223",
    "gender": null,
    "bloodGroup": null,
    "adress": null,
    "email": "deniz_zengin@gmail.com",
    "description": null,
    "user": {
        "createdBy": "anonymousUser",
        "createdDate": "2022-10-12T13:28:57.439670Z",
        "id": 276495,
        "login": "team02_patient",
        "firstName": "Deniz",
        "lastName": "Zengin",
        "email": "deniz_zengin@gmail.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null,
        "ssn": "555-22-2345"
    },
    "appointments": null,
    "inPatients": null,
    "country": null,
    "cstate": null
}


 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientPojo {
    private String createdBy;
    private String createdDate;
    private int id;
    private String firstName;
    private String lastName;
    private int birthDate;
    private String phone;
    private String gender;
    private String bloodGroup;
    private String adress;
    private String email;
    private String description;
    private UserPojo user;

    public PatientPojo(String createdBy, String createdDate, int id, String firstName, String lastName, int birthDate, String phone, String gender, String bloodGroup, String adress, String email, String description, UserPojo user) {
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.adress = adress;
        this.email = email;
        this.description = description;
        this.user = user;
    }

    public PatientPojo() {
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserPojo getUser() {
        return user;
    }

    public void setUser(UserPojo user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PatientPojo{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", adress='" + adress + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
