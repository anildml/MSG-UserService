package MSGUserService.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private BigDecimal id;

    private String username;

    private String passwordDigest;

    private BigDecimal userCode;

    private String email;

}
