package tn.esprit.spring.kaddem.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repository.ContratRepository;
import tn.esprit.spring.kaddem.repository.EquipeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
@Slf4j
    public class EquipeService implements IEquipeService{
        EquipeRepository equipeRepository;
        ContratRepository contratRepository;
        @Override
        public List<Equipe> retrieveAllEquipes() {
            return (List<Equipe>) equipeRepository.findAll();
        }

        @Override
        public Equipe addEquipe(Equipe e) {
            return equipeRepository.save(e) ;
        }

        @Override
        public Equipe updateEquipe(Equipe e) {
            return equipeRepository.save(e) ;
        }

        @Override
        public Equipe retrieveEquipe(Integer idEquipe) {
            return equipeRepository.findById(idEquipe).get();
        }


    @Override
    @Scheduled(cron = "0 0 0 1 1 ?")
    public void faireEvoluerEquipes() {
        List<Equipe> E = retrieveAllEquipes();
        LocalDate localDate = LocalDate.now();
        for (int d = 0; d < E.size(); d++) {
            int c = 0;
            Equipe S = E.get(d);
            List<Etudiant> et = S.getEtudiantList();
            for (int j = 0; d < E.size(); j++) {
                Etudiant t = et.get(j);
                List<Contrat> ct = t.getContratList();
                for (int k = 0; d < ct.size(); k++) {
                    Contrat cc = ct.get(k);

                    long diff = localDate.getDayOfMonth() - cc.getDateFinContrat().getTime();
                    long diffs = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    if (diffs >= 0) {
                        c++;
                    }
                }
                if (c > 3) {

                    if (S.getNiveau() == Niveau.SENIOR) {
                        S.setNiveau(Niveau.EXPERT);
                    }
                    if (S.getNiveau() == Niveau.JUNIOR) {
                        S.setNiveau(Niveau.SENIOR);
                    }
                }
            }
        }
    }

    }


