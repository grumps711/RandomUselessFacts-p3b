package com.ironhack.t3_ve_ruf.exception;

public class FactNotFoundException extends RuntimeException{
    public FactNotFoundException (Long id){
        super("The fact with ID " + id + " was not found");
    }

}
