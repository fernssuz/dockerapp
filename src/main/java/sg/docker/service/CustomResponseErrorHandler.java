package sg.docker.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;

@Service
public class CustomResponseErrorHandler extends DefaultResponseErrorHandler {
}
