package app.service;
​
import app.dtos.BusinessReportDTO;
import app.dtos.CarDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
​
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
/*
Problem 3: Out of memory issue. The issue appeared because of a huge list of reports that was keep being created,
 in a condition that did not had any end. I chose to replace the creation of new BusinessReportDTO with method
 createReport as it seems to have a fixed rate of only 500 reports.
 */
@Component
public class BusinessReportService {
    private List<BusinessReportDTO> reports;
    public BusinessReportService(){
        reports=new ArrayList<>();
    }
​
    public BusinessReportDTO getLastReport() {
        if(reports.isEmpty()){
            createReport();
        }
        return reports.get(reports.size()-1);
    }
​
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
​
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
​
    private int getNumberBetween(int min,int max) {
        Random random = new Random();
        int low = 5000;
        int high = 100000;
        return random.nextInt(high-low) + low;
    }
​
        ​
}