package ar.edu.utn.parcial.futbolmanager.controller;

import ar.edu.utn.parcial.futbolmanager.dto.TicketDTO;
import ar.edu.utn.parcial.futbolmanager.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/tickets")
public class TickerController {


    private TicketService ticketService;

    @Autowired
    public TickerController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("invitaciones")
    public ResponseEntity<List<TicketDTO>> getTickets(Long idManager){

        List<TicketDTO> tickets = this.ticketService.getTickets(idManager);

        return ResponseEntity.ok(tickets);
    }


}
