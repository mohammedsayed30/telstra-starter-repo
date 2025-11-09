package au.com.telstra.simcardactivator;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class GateWayController {

    private final RestTemplate restTemplate = new RestTemplate();

    //receive post end point that call the actuator microservice
    @PostMapping("/api/v1/actuator")
    public ResponseEntity<ActuatorResponse> actuator(@RequestBody ActuatorRequest actuatorRequest){
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

        //print the response
        System.out.println(response.getBody());

        //return the body
        return ResponseEntity
                .status(response.getStatusCode())
                .body(response.getBody());

    }
}
