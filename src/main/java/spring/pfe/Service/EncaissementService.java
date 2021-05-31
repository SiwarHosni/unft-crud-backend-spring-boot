package spring.pfe.Service;

import spring.pfe.entity.Encaissement;

import java.util.List;
import java.util.Optional;

public interface EncaissementService {
    void saveEncaissement(Encaissement encaissement );
    Encaissement UpdateEncaissement(Encaissement encaissement);
    List<Encaissement> listEncaissements();
    void removeEnaissement(Long num_enc );
    public Optional<Encaissement> FindEncaissement(Long num_enc);
}
