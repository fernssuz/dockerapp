package sg.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v1")
@RestController
public class DockerController {

    @GetMapping("/docker")
    public String home() {
        return "Hello Docker World";
    }
}
