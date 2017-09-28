package service1.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;
import org.springframework.util.StringUtils;
import service1.model.Model1;

import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.TimeoutException;

/**
 * Created by ahiticas on
 * 9/26/2017.
 */

@Service
public class RabbitCommunicationService {

    @Value("${rabbit.host}")
    private String rabbitHost;
    @Value("${rabbit.queueName}")
    private String rabbitQueueName;


    public void publishMessage() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitHost);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(rabbitQueueName, true, false, false, null);
        Model1 model1 = new Model1(InetAddress.getLocalHost().toString());
        channel.basicPublish("", rabbitQueueName, null, new ObjectMapper().writeValueAsString(model1).getBytes());

        channel.close();
        connection.close();

    }

}
