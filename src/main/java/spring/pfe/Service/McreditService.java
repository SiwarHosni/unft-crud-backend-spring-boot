package spring.pfe.Service;

import spring.pfe.entity.Mcredit;

import java.util.List;
import java.util.Optional;

public interface McreditService {
    void saveMcredit(Mcredit mcredit);
    Mcredit UpdateMcredit(Mcredit mcredit);
    List<Mcredit> listMcredits();
    void removeMcredit(Long num_dossier );
    public Optional<Mcredit> FindMcredit(Long num_dossier);
}
