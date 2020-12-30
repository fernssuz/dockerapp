package sg.docker.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import sg.docker.service.CustomResponseErrorHandler;

import java.util.Collections;

/**
 * CustomClientHttpRequestInterceptor interceptor is doing basic logging of the request:
 */

@Slf4j
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(CustomResponseErrorHandler customResponseErrorHandler) {
        //Create a new instance of the HttpComponentsClientHttpRequestFactory with a default HttpClient based on system properties.
        RestTemplate restTemplate = new RestTemplate();
        //add the custom response Handler
        restTemplate.setErrorHandler(customResponseErrorHandler);
        ObjectMapper om = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        for (HttpMessageConverter converter : restTemplate.getMessageConverters() )
        {
            /**
             * Implementation of org.springframework.http.converter.HttpMessageConverter that can read and write JSON using Jackson 2.x's  ObjectMapper.
             * This converter can be used to bind to typed beans, or untyped HashMap instances.
             * By default, this converter supports application/json and application/*+json with UTF-8 character set.
             */
            if ( converter instanceof MappingJackson2HttpMessageConverter)
            {
                MappingJackson2HttpMessageConverter m =
                        (MappingJackson2HttpMessageConverter)converter;
                om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Ignore unknown properties
                m.setObjectMapper(om);
            }
        }

        //// Add one interceptor
        restTemplate.setInterceptors(Collections.singletonList((request, body, execution) -> {

            log.info("Intercepting...");
            log.info("Headers: {}", request.getHeaders());
            log.info("Request Method: {}", request.getMethod());
            log.info("Request URI: {}", request.getURI());
            return execution.execute(request, body);
        }));

        return restTemplate;
    }
}
