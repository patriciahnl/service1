package service1.service;

import org.springframework.stereotype.Service;
import service1.model.Model1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by ahiticas on
 * 9/25/2017.
 */

@Service
public class HttpCommunicationService {

    public Model1 getAddress() throws UnknownHostException {
        return new Model1(InetAddress.getLocalHost().toString());
    }

}
