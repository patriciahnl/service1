package service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service1.model.Model1;
import service1.service.HttpCommunicationService;
import service1.service.RabbitCommunicationService;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

/**
 * Created by ahiticas on
 * 9/25/2017.
 */

@RestController
public class controler1 {

    @Autowired
    private HttpCommunicationService service;
    @Autowired
    private RabbitCommunicationService rabbitCommunicationService;

    @RequestMapping (method = RequestMethod.GET, value = "/getAddress", produces = "application/json")
    public ResponseEntity<?> getAddress() {
        try {
            return new ResponseEntity<Model1>(service.getAddress(),HttpStatus.OK);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Error!!!", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping (method = RequestMethod.POST, value = "/publishMessage")
    public void publishResponse() {
        try {
            rabbitCommunicationService.publishMessage();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
