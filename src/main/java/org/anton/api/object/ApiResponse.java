package org.anton.api.object;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ApiResponse {
    Integer code;
    String type;
    String message;
}
