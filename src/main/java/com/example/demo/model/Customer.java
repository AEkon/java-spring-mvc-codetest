package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.joda.time.DateTime;

/**
 * Customer - comprised of an id, name, duetime and jointime.
 *
 * @author Alex Ekonomou
 */
@Data
public class Customer implements Comparable<Customer> {
    private long id;
    private String name;
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonProperty("duetime")
    private DateTime dueTime;
    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonProperty("jointime")
    private DateTime joinTime;

    @Override
    public int compareTo(Customer customer) {
        if(this.getDueTime() == null)
            if(customer.getDueTime() == null)
                return 0; //equal
            else
                return -1; // null is before other due times
        else // this.getDueTime() != null
            if(customer.getDueTime() == null)
                return 1;  // all other due times are after null
            else {
                return this.getDueTime().compareTo(customer.getDueTime());
            }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name=" + name +
                ", duetime=" + this.getDueTime() +
                ", jointime=" + this.getJoinTime() +
                '}';
    }
}
