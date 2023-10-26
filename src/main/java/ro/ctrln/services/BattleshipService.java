package ro.ctrln.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ro.ctrln.entities.Battleship;
import ro.ctrln.entities.dtos.BattleshipDTO;
import ro.ctrln.repositories.BattleshipRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BattleshipService {

    @Autowired
    private BattleshipRepository battleshipRepository;

    public List<BattleshipDTO> getAllBattleships() {
        return battleshipRepository.findAll().stream()
                .map(battleship -> new BattleshipDTO(battleship.getId(), battleship.getBattleshipName(), battleship.getBattleshipCapacity()))
                .collect(Collectors.toList());
    }

    public BattleshipDTO getBattleship(Long battleshipId) {
        Optional<Battleship> battleshipOptional = battleshipRepository.findById(battleshipId);
        if(battleshipOptional.isPresent()) {
            Battleship battleship = battleshipOptional.get();
            return new BattleshipDTO(battleship.getId(), battleship.getBattleshipName(), battleship.getBattleshipCapacity());
        }
        return new BattleshipDTO(0L, "BattleshipNotFound", 0);
    }

    public void deleteBattleship(Long battleshipId) {
        battleshipRepository.deleteById(battleshipId);
    }

    public void createBattleship(BattleshipDTO battleshipDTO) {
        if(battleshipDTO.getId() != 0) {
            updateBattleship(battleshipDTO);
        } else {
            Battleship battleship = new Battleship();
            battleship.setBattleshipName(battleshipDTO.getBattleshipName());
            battleship.setBattleshipCapacity(battleshipDTO.getBattleshipCapacity());
            battleshipRepository.save(battleship);
        }
    }

    public void updateBattleship(BattleshipDTO battleshipDTO) {
        if(battleshipDTO.getId() != 0) {
            Battleship battleship = battleshipRepository.findById(battleshipDTO.getId()).orElse(null);
            if(battleship != null) {
                battleship.setBattleshipCapacity(battleshipDTO.getBattleshipCapacity());
                battleship.setBattleshipName(battleshipDTO.getBattleshipName());
                battleshipRepository.save(battleship);
            }
        }
    }
}
