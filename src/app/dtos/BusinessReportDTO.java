package app.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BusinessReportDTO {
    private List<CarDTO> carDTOS;
    public BusinessReportDTO(){
        carDTOS=new ArrayList<>();
    }

}
