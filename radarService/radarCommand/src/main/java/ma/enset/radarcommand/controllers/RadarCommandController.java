package ma.enset.radarcommand.controllers;

import commands.CreateRadarCommand;
import commands.CreateVehiculeCommand;
import dtos.CreateRadarRequestDTO;
import dtos.CreateVehiculeRequestDTO;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;


@RestController
@RequestMapping(path = "/commands/radar")
@AllArgsConstructor
public class RadarCommandController {
        private CommandGateway commandGateway;
        private EventStore eventStore;
        @PostMapping("/create")
        public CompletableFuture<String> createRadar(@RequestBody CreateRadarRequestDTO request){
                CompletableFuture<String> commandResponse = commandGateway.send(new CreateRadarCommand(
                        UUID.randomUUID().toString(),
                        request.getVMax(),
                        request.getLongi(),
                        request.getLat()
                ));

                return commandResponse;
        }

        @ExceptionHandler(Exception.class)
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