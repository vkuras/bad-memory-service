package app.dtos;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class CountDownDTO {
    private List<Integer> countDown;
    public CountDownDTO(int size){
        countDown=new ArrayList<>(size);
    }

    public void add(Integer number){
      countDown.add(number);
    }
    public List<Integer> getCountDown(){
        return countDown;
    }
}
