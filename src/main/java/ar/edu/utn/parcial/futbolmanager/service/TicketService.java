package ar.edu.utn.parcial.futbolmanager.service;

import ar.edu.utn.parcial.futbolmanager.client.dolar.DolarClient;
import ar.edu.utn.parcial.futbolmanager.client.dolar.DolarResponse;
import ar.edu.utn.parcial.futbolmanager.client.euro.EuroClient;
import ar.edu.utn.parcial.futbolmanager.client.euro.EuroResponse;
import ar.edu.utn.parcial.futbolmanager.dto.TicketDTO;
import ar.edu.utn.parcial.futbolmanager.exception.NotFoundException;
import ar.edu.utn.parcial.futbolmanager.models.Party;
import ar.edu.utn.parcial.futbolmanager.models.Person;
import ar.edu.utn.parcial.futbolmanager.models.Player;
import ar.edu.utn.parcial.futbolmanager.models.enums.Currency;
import ar.edu.utn.parcial.futbolmanager.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private static final Integer AMOUNT_TICKET_PESOS = 25000;

    private DolarClient dolarClient;
    private EuroClient euroClient;
    private PartyRepository partyRepository;
    private PersonService personService;

    @Autowired
    public TicketService(DolarClient dolarClient, EuroClient euroClient, PartyRepository partyRepository, PersonService personService) {
        this.dolarClient = dolarClient;
        this.euroClient = euroClient;
        this.partyRepository = partyRepository;
        this.personService = personService;
    }


    public List<TicketDTO> getTickets( Long idManager ){

        Person manager = this.personService.getById(idManager);
        Party party = this.partyRepository.findByBirthdayPerson(manager)
                .orElseThrow(()-> new NotFoundException("Manager Not Found"));
        return buildTicket(party);
    }

    public List<TicketDTO> buildTicket(Party party){

        Set<Player> invitados = party.getInvitados();
        List<TicketDTO> tickets = new ArrayList<>();
        invitados.forEach(
                i -> {
                    tickets.add(TicketDTO.builder()
                            .fullName(i.getFirstName() + " " + i.getLastName())
                            .currency(i.getMarketValue().getCurrency())
                            .amount(this.getAmountTicket(i.getMarketValue().getCurrency()))
                            .build());
                }
        );

        return tickets;
    }

    private String getAmountTicket(Currency currency){

        // 25.000 / cotizacion del dolar oficial precio de compra = 265""
        //25.000 / cotizacion del euro precio de compra = 231
        StringBuilder str = new StringBuilder();

        str = str.append("25.000 / cotizacion del ");

        Double totalAmount;

        DolarResponse dolarOficial = this.dolarClient.getDolarEnchages().get(0);
        EuroResponse euro = this.euroClient.getEuroEnchages().get(0);

        if(Currency.USD.name().equals(currency)){

            totalAmount = AMOUNT_TICKET_PESOS * dolarOficial.getCurrencyConverter().getSale();
            str.append("dolar precio venta = " + totalAmount );

        } else if(Currency.EUR.name().equals(currency)){
            totalAmount = AMOUNT_TICKET_PESOS * euro.getCurrencyConverter().getSale();
            str.append("euro precio venta = " + totalAmount );
        }

        return str.toString();
    }

}
