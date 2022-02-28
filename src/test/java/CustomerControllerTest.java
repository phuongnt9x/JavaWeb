

import cg.wbd.grandemonstration.controller.CustomerController;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.ProvinceService;
import cg.wbd.grandemonstration.service.impl.CustomerServiceImplWithSpringData;
import cg.wbd.grandemonstration.service.impl.ProvinceServiceImplWithSpringData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringJUnitJupiterConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebAppConfiguration
@SpringJUnitJupiterConfig(CustomerControllerTestConfig.class)
public class CustomerControllerTest {
    private MockMvc mockMvc;
    private CustomerService customerService = Mockito.mock(CustomerServiceImplWithSpringData.class);
    private ProvinceService provinceService = Mockito.mock(ProvinceServiceImplWithSpringData.class);

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void customersListPageIsExists() throws Exception {
        mockMvc
                .perform(get("/customers"))
                .andExpect(status().is(200));
    }
}