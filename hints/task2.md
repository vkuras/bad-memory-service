# Internal server error occurs in count down method

- Run Application.java
- Call the 127.0.0.1:8080/countDown/10000
- Check stack trace in console
- Go to method which causes this issue.
- Put debug point in method and restart application
- Check with debug tool how the application behaves (Have a look at the Stack)

# OOM issue
- Set a break point in one of the controller classes
- Call this endpoint
- Load heap in intellij
- Wait a little bit call endpoint again and check difference between the heap dumps
- Find out which kind  of object occurs a lot
- Check where it’s used and what causes the memory leak.  