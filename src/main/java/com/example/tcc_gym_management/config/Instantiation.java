package com.example.tcc_gym_management.config;

import com.example.tcc_gym_management.dto.UserDTO;
import com.example.tcc_gym_management.entities.*;
import com.example.tcc_gym_management.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private GymRepository gymRepository;
    @Autowired
    private MaintenanceRepository maintenanceRepository;
    @Autowired
    private MaintenanceRequestRepository maintenanceRequestRepository;
    @Autowired
    private EquipmentTypeRepository equipmentTypeRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MaintenanceRepairServiceRepository maintenanceRepairServiceRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        userRepository.deleteAll();
        equipmentRepository.deleteAll();
        gymRepository.deleteAll();
        maintenanceRepository.deleteAll();
        maintenanceRequestRepository.deleteAll();
        equipmentTypeRepository.deleteAll();
        maintenanceRepairServiceRepository.deleteAll();


        Gym bioCorpo = new Gym(null, "BioCorpo", "12456789000110", "18 998765432", "biocorpo@gmail.com", "Rua maneira, 42");

        gymRepository.save(bioCorpo);


        EquipmentType esteiraTipo = new EquipmentType(null, "Esteira Philco", "Esteiras Philco");
        EquipmentType haltereTipo = new EquipmentType(null, "Haltere Growth", "Halteres da Growth");

        equipmentTypeRepository.saveAll((Arrays.asList(esteiraTipo, haltereTipo)));


        User ronery = new User(null, "Ronery Filho", "roneryfilho", "t1qegFfH.2T21Qa", "44992603882", "roneryteste@gmail.com", "18996072317", bioCorpo);
        User otavio = new User(null, "Otavio Marin", "12345678910", "otavioteste@gmail.com","ermac", "12345gsgHUiueh", "18998765432", bioCorpo);
        User matheus = new User(null, "Matheus Celestino", "theuz", "TGAFI92.Gsdg.", "10987654321", "matheusteste@gmail.com", "18992345678", bioCorpo);

        userRepository.saveAll(Arrays.asList(ronery, otavio, matheus));


        Equipment haltere = new Equipment(null,"Haltere 5kg", "Haltere 5kg preto da Growth","123ABC", sdf.parse("15/08/2020"),
                75.00, 50.00, 10.00, 5.0, haltereTipo, bioCorpo);

        Equipment esteira = new Equipment(null,"Esteira Elétrica Philco", "Esteira elétrica da Philco prateada","456DEF", sdf.parse("05/07/2023"),
                1900.00, 1500.00, 15.00, 1000000.0, esteiraTipo, bioCorpo);

        Equipment esteira2 = new Equipment(null,"Esteira Elétrica Philco", "Esteira elétrica da Philco Branca","789GHI", sdf.parse("05/07/2023"),
                1900.00, 1500.00, 15.00, 1000000.0, esteiraTipo, bioCorpo);

        Equipment haltere2 = new Equipment(null,"Haltere 10kg", "Haltere 10kg Growth","101JKL", sdf.parse("15/08/2022"),
                90.00, 60.00, 10.00, 5.0, haltereTipo, bioCorpo);

        equipmentRepository.saveAll(Arrays.asList(haltere, esteira));


        Maintenance joseConsertos = new Maintenance(null, "José Consertos", "12456789000110", "14998762345", "joseconsertos@gmail.com",
                "Rua braba, 24", "José dono");

        Maintenance mauricioConsertos = new Maintenance(null, "Mauricio Consertos", "43216789000110", "14996782345", "joseconsertos@gmail.com",
                "Rua calma, 35", "Marcela atendente");


        maintenanceRepository.saveAll(Arrays.asList(joseConsertos,mauricioConsertos));

        MaintenanceRequest pedido01 = new MaintenanceRequest(null, (mongoTemplate.count(new Query(), "maintenance-request") + 1),"Esteiras contém correias desgastadas e Haltere triscado",
                "", joseConsertos, sdf2.format(new Date()), new UserDTO(ronery), Arrays.asList(esteira, esteira2, haltere), Arrays.asList("1500 KM", "2800 KM", ""));

        MaintenanceRepairService servico1 = new MaintenanceRepairService(null, joseConsertos, pedido01, Arrays.asList(esteira, esteira2, haltere), "Descrição teste", 1500.00);

        pedido01.setServices(Arrays.asList(servico1));
        maintenanceRepairServiceRepository.save(servico1);

        maintenanceRequestRepository.save(pedido01);

        MaintenanceRequest pedido02 = new MaintenanceRequest(null, (mongoTemplate.count(new Query(), "maintenance-request") + 1), "Necessário soldar haltere trincado",
                "",mauricioConsertos , sdf2.format(new Date()), new UserDTO(ronery), Arrays.asList(haltere2), Arrays.asList(""));

        MaintenanceRepairService servico2 = new MaintenanceRepairService(null, mauricioConsertos, pedido02, Arrays.asList(haltere2), "Descrição teste", 1976.50);

        maintenanceRepairServiceRepository.save(servico2);

        pedido02.setServices(Arrays.asList(servico2));

        maintenanceRequestRepository.save(pedido02);
    }
}
