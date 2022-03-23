package MSGUserService.config.beans;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DtoMapper {

    @Bean(name = "mapper")
    public ModelMapper mapper() {
        return new ModelMapper();
    }

}
