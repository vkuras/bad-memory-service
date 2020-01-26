package app.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDTO {
    private int purchasePrice;
    private int customerPrice;
    private String vin;
}
