package mzaaenalmustopa.springrestapi.model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    @Size(max = 100)
    private String username;

    @Size(max = 100)
    private String name;
}
