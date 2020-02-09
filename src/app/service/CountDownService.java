package app.service;

import app.dtos.CountDownDTO;
import org.springframework.stereotype.Component;

@Component
public class CountDownService {

    public CountDownDTO countDown(Integer number){
        CountDownDTO countDownDTO=new CountDownDTO(number+1);
        decrement(countDownDTO, number);
        return countDownDTO;
    }

    private void decrement(CountDownDTO countDownDTO, Integer number) {
        while (number >= 0){
            countDownDTO.add(number);
            number--;
        }
    }


}
