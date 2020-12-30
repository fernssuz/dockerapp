package sg.docker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SomeService {

    private final RestTemplate restTemplate;

    @Autowired
    public SomeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callRestService() {
        return restTemplate.getForObject("http://localhost:8080", String.class);
    }
}
