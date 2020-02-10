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

    private void decrement(CountDownDTO countDownDTO, int number) {
        for (int i = 0; i <= number; i++)
        {
            countDownDTO.add(i);
        }
    }


}
