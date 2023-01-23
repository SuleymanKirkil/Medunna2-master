package pojos.US016;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class US016_RoomPost {

    private String description;
    private String createdBy;
    private String createdDate;
    private int price;
    private int roomNumber;
    private String roomType;
    private boolean status;

    /*
    {
    "createdBy": "defne",
    "createdDate": "2022-08-19T07:41:20.070105Z",
    "id": 203046,
    "roomNumber": 99,
    "roomType": "SUITE",
    "status": false,
    "price": 600.00,
    "description": "team50_16_Defne"
}
     */

    public US016_RoomPost() {
    }

    public US016_RoomPost(String description, String createdBy, String createdDate, int price, int roomNumber, String roomType, boolean status) {
        this.description = description;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.price = price;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.status = status;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "US016_RoomPost{" +
                "description='" + description + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", price=" + price +
                ", roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", status=" + status +
                '}';
    }
}
