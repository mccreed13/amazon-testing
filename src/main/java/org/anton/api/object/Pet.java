package org.anton.api.object;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class Pet {
    Integer id;
    String name;
    Category category;
    Status status;
    List<Tag> tags;
    List<String> photoUrls;
}
