package app.controller;

import app.dtos.BusinessReportDTO;
import app.service.BusinessReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessReportController {
    @Autowired
    private BusinessReportService businessReportService;
    @GetMapping("/lastReport")
    public BusinessReportDTO getLastReport() {
        return businessReportService.getLastReport();
    }
}
