package com.lecture14.homework;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Company {
    protected String name;
    protected String dateEstablished;
    protected String identifier;

    public Company(String name, String dateEstablished, String identifier) {
        this.name = name;
        this.dateEstablished = dateEstablished;
        setIdentifier(identifier);
    }

    public void setIdentifier(String identifier) {
        if (identifier.length() != 10)
            log.error("Please enter a 10 digit number for the identifier!");
        this.identifier = identifier;
    }

}