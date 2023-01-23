package pojos.US016;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)

public class US016_Rest  {

    private String description;
    private String createdBy;
    private String createdDate;
    private int price;
    private int roomNumber;
    private String roomType;
    private boolean status;
    private int id;





}
