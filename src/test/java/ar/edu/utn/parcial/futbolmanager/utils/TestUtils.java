package ar.edu.utn.parcial.futbolmanager.utils;

import ar.edu.utn.parcial.futbolmanager.dto.TicketDTO;

public class TestUtils {

    public static String aTicketJSON(){
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(aTicket());
    }

    public static TicketDTO aTicket(){
        TicketDTO ticketDTO = new TicketDTO();
        ticketDTO.setFullName("Lionel Messi");
        ticketDTO.setCurrency();
        ticketDTO.setAmount("100000");
    }
}
