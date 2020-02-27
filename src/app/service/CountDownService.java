package app.service;
​
import app.dtos.CountDownDTO;
import org.springframework.stereotype.Component;
/* Problem 1 : running Application for 5 mins:
After analyzing the gc logs, I could notice that heap memory was keep being increased, this meaning that garbage collector
could not clean the memory. This can happen when garbage collector fails to clean the objects that are not being used
anymore by the application, because they are still being referenced somehwere.
 */
@Component
public class CountDownService {
​
    public CountDownDTO countDown(Integer number){
        CountDownDTO countDownDTO=new CountDownDTO(number+1);
        decrement(countDownDTO, number);
        return countDownDTO;
    }
​
    private void decrement(CountDownDTO countDownDTO, Integer number) {
​
        while (number>=0){
            countDownDTO.add(number);
            number--;
        }
/*
Problem 2: Internal server error - Stack Overflow.
It occurred to me when calling the countdown application with value of 100000, not 10000 as mentioned in the slide.
However, after checking the logs, and navigating to the method, I noticed that it was a recursion. The method was keep
calling itself until a point where it crashed.
 */
​
//        if(number==0){
//            return;
//        }
//        else {
//            decrement(countDownDTO, number-1);
//        }
    }
}