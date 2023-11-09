package ro.ctrln.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ro.ctrln.entities.dtos.BattleshipDTO;
import ro.ctrln.repositories.BattleshipRepository;
import ro.ctrln.services.BattleshipService;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BattleshipTests {

    @InjectMocks
    private BattleshipService battleshipService;

    @Mock
    private BattleshipRepository battleshipRepository;

    @Test
    public void testToStringShouldReturnBattleship() {
        Battleship battleship = new Battleship();
        battleship.setBattleshipName("BattleshipOne");
        battleship.setBattleshipCapacity(1000);
        assertEquals("Battleship(id=0, battleshipName=BattleshipOne, battleshipCapacity=1000)", battleship.toString());
    }

    @Test
    public void testBattleshipId1() {
        Battleship battleship = new Battleship();
        battleship.setBattleshipName("BattleshipOne");
        battleship.setBattleshipCapacity(1000);
        battleship.setId(1L);
        when(battleshipRepository.findById(1L)).thenReturn(Optional.of(battleship));
        BattleshipDTO battleshipDTO = BattleshipDTO.builder()
                .battleshipCapacity(1000)
                .battleshipName("BattleshipOne")
                .id(1L)
                .build();
        assertEquals(battleshipDTO, battleshipService.getBattleship(1L));
    }

    @Test
    public void testBattleshipNull() {
        when(battleshipRepository.findById(1L)).thenReturn(Optional.empty());
        BattleshipDTO battleshipDTO = BattleshipDTO.builder()
                .battleshipCapacity(0)
                .battleshipName("BattleshipNotFound")
                .id(0L)
                .build();
        assertEquals(battleshipDTO, battleshipService.getBattleship(1L));
    }

    @Test
    public void repositoryBehaviorTest() {
        when(battleshipRepository.findById(10L)).thenReturn(Optional.empty());

        battleshipRepository.findById(10L);
        battleshipRepository.findAll();
        battleshipRepository.findAll();
        battleshipRepository.findAll();

        verify(battleshipRepository).findById(ArgumentMatchers.eq(10L));
        verify(battleshipRepository, times(3)).findAll();

        verify(battleshipRepository, never()).count();
        verify(battleshipRepository, atLeastOnce()).findAll();
//        verifyNoInteractions(battleshipRepository);
    }
}
