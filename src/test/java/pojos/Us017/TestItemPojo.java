package pojos.Us017;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestItemPojo {

  /*  {
        "createdBy": "medunnat50",
            "createdDate": "2022-08-23T18:15:25.983593Z",
            "id": 221948,
            "name": "Frances",
            "description": "Schultz",
            "price": 4.00,
            "defaultValMin": "0",
            "defaultValMax": "5"
    }

   */

    private String createdBy;
    private String createdDate;
    private int id;
    private String name;
    private String description;
    private double price;
    private String defaultValMin;
    private String defaultValMax;


}
