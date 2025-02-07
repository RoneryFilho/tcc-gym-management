package com.example.tcc_gym_management.services;

import com.example.tcc_gym_management.entities.Gym;
import com.example.tcc_gym_management.repositories.GymRepository;
import com.example.tcc_gym_management.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GymService {

    @Autowired
    GymRepository gymRepository;

    public List<Gym> findAll() {
        return gymRepository.findAll();
    }

    public Gym findById(String id) {
        Optional<Gym> gym = gymRepository.findById(id);

        return gym.orElseThrow(() -> new ObjectNotFoundException("Objeto Gym não encontrao"));
    }

    public Gym insert(Gym gym) {
        return gymRepository.insert(gym);
    }

    public void delete(String id) {
        findById(id);
        gymRepository.deleteById(id);
    }

    public void update(Gym gym) {
        Gym updatedGym = findById(gym.getId());
        updateData(updatedGym, gym);
        gymRepository.save(updatedGym);
    }

    private void updateData(Gym newGym, Gym gym){
        newGym.setId(gym.getId());
        newGym.setName(gym.getName());
        newGym.setDocument(gym.getDocument());
        newGym.setAddress(gym.getAddress());
        newGym.setEmail(gym.getEmail());
        newGym.setPhoneNumber(gym.getPhoneNumber());
    }
}
