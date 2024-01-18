package mini_projet.PatMedservice;

import mini_projet.PatMedservice.entity.Medecin;
import mini_projet.PatMedservice.entity.Patient;
import mini_projet.PatMedservice.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import mini_projet.PatMedservice.repository.MedecinRepository;

@SpringBootApplication
@EnableFeignClients

public class PatMedServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatMedServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			MedecinRepository medecinRepository, PatientRepository patientRepository){
		return args -> {
			//les medecins
			Medecin c1 = Medecin.builder().id(1L).nom("mourad").email("jabrane11@gmail.com").Specialite("D.general").rndvId(2L).build();
			medecinRepository.save(c1);
			Medecin c2 = Medecin.builder().id(3L).nom("Aminaa").email("elharchaoui11@gmail.com").Specialite("D.general").rndvId(2L).build();
			medecinRepository.save(c2);
			Medecin c3 = Medecin.builder().id(4L).nom("Hasna").email("boutejdir11@gmail.com").Specialite("D.general").rndvId(2L).build();
			medecinRepository.save(c3);


			//les patients
			Patient p1= Patient.builder().id(1L).nom("amina").email("elharchaoui11@gmail.com").rndvId(1L).build();
			patientRepository.save(p1);

			Patient p2= Patient.builder().id(2L).nom("amina").email("elharchaoui11@gmail.com").rndvId(1L).build();
			patientRepository.save(p2);

			Patient p3= Patient.builder().id(3L).nom("amina").email("elharchaoui11@gmail.com").rndvId(1L).build();
			patientRepository.save(p3);

		};

	}
}
