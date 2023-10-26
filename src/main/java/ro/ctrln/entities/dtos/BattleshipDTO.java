package ro.ctrln.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BattleshipDTO {

    private long id;
    private String battleshipName;
    private Integer battleshipCapacity;
}
