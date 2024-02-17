package portfolio.security;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MyControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @WithUserDetails("user")
    public void whenUserAccessUserSecuredEndpoint_thenOk() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk());        
    }

    @Test
    @WithUserDetails("user")
    public void whenUserAccessRestrictedEndpoint_thenOk() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/admin")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @WithUserDetails("admin")
    public void whenUserAccessAdminSecuredEndpoint_thenIsForbidden() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/admin")).andExpect(MockMvcResultMatchers.status().isForbidden());
    }
}
