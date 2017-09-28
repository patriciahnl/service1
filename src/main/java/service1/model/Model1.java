package service1.model;

import java.io.Serializable;

/**
 * Created by ahiticas on
 * 9/25/2017.
 */

public class Model1 implements Serializable {

    private String address;

    public Model1() {
    }

    public Model1(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
