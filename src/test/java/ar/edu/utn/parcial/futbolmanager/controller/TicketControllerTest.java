package ar.edu.utn.parcial.futbolmanager.controller;

import ar.edu.utn.parcial.futbolmanager.service.TicketService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static ar.edu.utn.parcial.futbolmanager.utils.TestUtils.aTicketJSON;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TickerController.class)
public class TicketControllerTest {

    @MockBean
    private TicketService ticketService;

    @Test
    public void addTicket() throws Exception{
        final ResultActions resultActions = givenController().perform(MockMvcRequestBuilders
                .post("/tickets")
                .contentType(MediaType.APPLICATION_JSON)
                .content(aTicketJSON()))
                .andExpect(status().isOk());

        assertEquals(HttpStatus.OK.value(), resultActions.andReturn().getResponse().getStatus());
    }


}
