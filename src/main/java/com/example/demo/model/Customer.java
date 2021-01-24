package com.example.demo.model;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class Customer implements Comparable<Customer> {

    //Assuming id will not be larger than max int value
    private int id;
    private String name;
    private DateTime duetime;
    private DateTime jointime;

    @Override
    public int compareTo(Customer o) {
        if(this.getDuetime() == null)
            if(o.getDuetime() == null)
                return 0; //equal
            else
                return -1; // null is before other strings
        else // this.member != null
            if(o.getDuetime() == null)
                return 1;  // all other strings are after null
            else {
                return this.getDuetime().compareTo(o.getDuetime());
            }
    }
}
