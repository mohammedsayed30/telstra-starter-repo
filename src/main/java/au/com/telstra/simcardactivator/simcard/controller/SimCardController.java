package au.com.telstra.simcardactivator.simcard.controller;


import au.com.telstra.simcardactivator.simcard.dto.ActuateRequest;
import au.com.telstra.simcardactivator.simcard.dto.ActuatorRequest;
import au.com.telstra.simcardactivator.simcard.dto.ActuatorResponse;
import au.com.telstra.simcardactivator.simcard.model.SimCard;
import au.com.telstra.simcardactivator.simcard.service.SimCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class SimCardController {

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private SimCardService simCardService;

    //receive post end point that call the actuator microservice
    @PostMapping("/api/v1/actuator")
    public ResponseEntity<SimCard> actuator(@RequestBody ActuatorRequest actuatorRequest){
        //api endpoint  URL
        String url = "http://localhost:8444/actuate";

        ActuateRequest request = new ActuateRequest(actuatorRequest.getIccId());

        //required headers for rest call
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //http request with body of type ActuateRequest
        HttpEntity<ActuateRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<ActuatorResponse> response = restTemplate.postForEntity(
                url,
                entity,
                ActuatorResponse.class
        );

        boolean status = response.getBody().isSuccess();

        //save the response to the database
        SimCard simCard= simCardService.save(actuatorRequest.getIccId(),actuatorRequest.getCustomerEmail(),status);


        //return the body
        return ResponseEntity.ok(simCard);

    }
}
