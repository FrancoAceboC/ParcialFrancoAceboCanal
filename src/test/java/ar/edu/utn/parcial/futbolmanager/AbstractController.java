package ar.edu.utn.parcial.futbolmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public abstract class AbstractController {

    @Autowired
    private WebApplicationContext webApplicationContext;

    public MockMvc mockMvc;

    protected MockMvc givenController(){
        return MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
}
