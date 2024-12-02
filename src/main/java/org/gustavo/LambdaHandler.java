package org.gustavo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;

public class LambdaHandler implements RequestHandler<SQSEvent, String> {

    @Override
    public String handleRequest(SQSEvent event, Context context) {
        event.getRecords().forEach(record -> {
            String messageBody = record.getBody();
            // Processar a mensagem
            System.out.println("Mensagem recebida: " + messageBody);
        });
        return "Processado com sucesso";
    }
}