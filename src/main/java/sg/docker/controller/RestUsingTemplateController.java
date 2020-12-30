package sg.docker.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sg.docker.service.SomeService;

@RestController
@Slf4j
public class RestUsingTemplateController {


    private final SomeService service;

    @Autowired
    public RestUsingTemplateController(SomeService service) {
        this.service = service;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String testEndpoint() {
        return "hello you are now using the custom restTemplate!";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {

        return service.callRestService();
    }
}
