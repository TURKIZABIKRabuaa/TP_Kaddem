package tn.esprit.spring.kaddem.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.kaddem.config.LoggingAspect;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.repository.ContratRepository;
import tn.esprit.spring.kaddem.repository.EquipeRepository;
import tn.esprit.spring.kaddem.repository.EtudiantRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
@AllArgsConstructor
@Slf4j
public class ContratService implements IContratService {

    private static final Logger LOGGER = LogManager.getLogger(LoggingAspect.class);
    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;

    EquipeRepository equipeRepository;

    @Override
    public List<Contrat> retrieveAllContrat() {
        return (List<Contrat>) contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat e) {
        return contratRepository.save(e);
    }

    @Override
    public Contrat updateContrat(Contrat e) {
        return contratRepository.save(e);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return contratRepository.findById(idContrat).get();
    }

    @Override
    public void addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Etudiant etudiant = etudiantRepository.save(e);
        Equipe u = equipeRepository.findById(idEquipe).get();
        Contrat d = contratRepository.findById(idContrat).get();

    }

    @Override
    @Scheduled(cron = "0 0 1 ? * *")
    public void retrieveAndUpdateStatusContrat() {
        List<Contrat> C = retrieveAllContrat();
        LocalDate localDate = LocalDate.now();
        for (int d = 0; d < C.size(); d++) {
            Contrat S = C.get(d);
            long diff = localDate.getDayOfMonth() - S.getDateFinContrat().getTime();
            long diffs = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            if (diffs <= 0) {
                LOGGER.info("Contrat " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
                S.setArchive(true);
                contratRepository.save(S);
            } else if (diffs <= 15) {
                LOGGER.info("Contrat expirer " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
            }
        }
    }

}
