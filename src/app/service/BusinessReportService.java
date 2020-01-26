package app.service;

import app.dtos.BusinessReportDTO;
import app.dtos.CarDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
@Component
public class BusinessReportService {
    private List<BusinessReportDTO> reports;
    public BusinessReportService(){
        reports=new ArrayList<>();
    }

    public BusinessReportDTO getLastReport() {
        if(reports.isEmpty()){
            return new BusinessReportDTO();
        }
        return reports.get(reports.size()-1);
    }

    @Scheduled(fixedRate = 500)
    public void createReport(){
        int amountOfCars= getNumberBetween(5000000,9000000);
        BusinessReportDTO reportDTO = new BusinessReportDTO();
        IntStream.range(0, amountOfCars)
                .forEach(index -> {
                    reportDTO.getCarDTOS().add(createCar());
                });
        reports.add(reportDTO);
    }

    private CarDTO createCar() {
        int purchasePrice=getNumberBetween(10000, 100000);
        int priceSold=getNumberBetween(purchasePrice, 110000);
        int vin = getNumberBetween(1000000, 9999999);
        return CarDTO.builder()
                .purchasePrice(purchasePrice)
                .customerPrice(priceSold)
                .vin("V"+vin+"S")
                .build();
    }

    private int getNumberBetween(int min,int max) {
        Random random = new Random();
        int low = 5000;
        int high = 100000;
        return random.nextInt(high-low) + low;
    }


}
