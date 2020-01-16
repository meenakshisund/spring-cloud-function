package com.function.spring;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class FarenheitToCelsisConvertor implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent request) {
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
        Double celsius = (Double.parseDouble(request.getBody()) - 32)*5/9;
        response.setBody("Converted Celsius : " + String.valueOf(celsius)  + " ");
        response.setStatusCode(HttpStatus.OK.value());
        return response;
    }
}