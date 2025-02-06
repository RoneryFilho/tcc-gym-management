package com.example.tcc_gym_management.config;

import com.example.tcc_gym_management.entities.Equipment;
import com.example.tcc_gym_management.entities.EquipmentType;
import com.example.tcc_gym_management.entities.User;
import com.example.tcc_gym_management.repositories.EquipmentRepository;
import com.example.tcc_gym_management.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        userRepository.deleteAll();
        equipmentRepository.deleteAll();

        User ronery = new User(null, "Ronery Filho", "44992603882", "roneryteste@gmail.com", "18996072317");
        User otavio = new User(null, "Otavio Marin", "12345678910", "otavioteste@gmail.com", "18998765432");
        User matheus = new User(null, "Matheus Celestino", "10987654321", "matheusteste@gmail.com", "18992345678");

        userRepository.saveAll(Arrays.asList(ronery, otavio, matheus));

        Equipment haltere = new Equipment(null,"Haltere 5kg", "Haltere 5kg preto da Growth","123ABC", sdf.parse("15/08/2020"),
                75.00, 50.00, 10.00, 5.0, new EquipmentType("", "Haltere Growth", "Halteres da Growth"));

        Equipment esteira = new Equipment(null,"Esteira Elétrica Philco", "Esteira elétrica da Philco prateada","456DEF", sdf.parse("05/07/2023"),
                1900.00, 1500.00, 15.00, 1000000.0, new EquipmentType("", "Esteira Philco", "Esteiras Philco"));

        equipmentRepository.saveAll(Arrays.asList(haltere, esteira));
    }
}
