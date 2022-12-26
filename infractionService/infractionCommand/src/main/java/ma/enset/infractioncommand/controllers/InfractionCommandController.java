package ma.enset.infractioncommand.controllers;

import commands.CreateInfractionCommand;
import dtos.CreateInfractionRequestDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;


@RestController
@RequestMapping(path = "/commands/infraction")
@AllArgsConstructor
public class InfractionCommandController {
        private CommandGateway commandGateway;
        private EventStore eventStore;
        @PostMapping("/create")
        public CompletableFuture<String> createInfraction(@RequestBody CreateInfractionRequestDTO request){
                CompletableFuture<String> commandResponse = commandGateway.send(new CreateInfractionCommand(
                        UUID.randomUUID().toString(),
                        request.getDate(),
                        request.getNumRadar(),
                        request.getNumMat(),
                        request.getVitesse(),
                        request.getVMax(),
                        request.getMontant()

                ));

                return commandResponse;
        }

        @ExceptionHandler(payloadType = Exception.class)
        public ResponseEntity<String> exceptionHandler(Exception exception){
                ResponseEntity<String> responseEntity = new ResponseEntity<>(
                        exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
                );

                return responseEntity;
        }

        @GetMapping("/eventStore/{id}")
        public Stream eventStore(@PathVariable String id){
                return eventStore.readEvents(id).asStream();
        }

}