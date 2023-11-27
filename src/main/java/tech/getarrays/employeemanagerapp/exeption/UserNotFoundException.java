package tech.getarrays.employeemanagerapp.exeption;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}

