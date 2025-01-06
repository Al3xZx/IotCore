package com.github.al3xzx.iotcore.alexa.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.dispatcher.request.handler.impl.IntentRequestHandler;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.Slot;
import com.amazon.ask.model.User;
import com.github.al3xzx.iotcore.alexa.localization.LocalizationManager;

import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class SensorIntentHandler implements IntentRequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput, IntentRequest intentRequest) {
        return intentRequest.getIntent().getName().equals("SensorIntent");
    }

    @Override
    public Optional<Response> handle(HandlerInput input, IntentRequest intentRequest) {
        User user = input.getRequestEnvelope().getSession().getUser();
//        String speechText = LocalizationManager.getInstance().getMessage("HELLO_MSG");
        Map<String, Slot> slots = intentRequest.getIntent().getSlots();
        String speechText = "La temperatura è 27 gradi";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Temperatura", speechText)
                .build();
    }

}