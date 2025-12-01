package ma.ensam.spring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EtudiantModuleKey implements Serializable {

    @Column(name = "etudiant_id")
    private Long etudiantId;

    @Column(name = "module_id")
    private Long moduleId;

    // Constructeurs
    public EtudiantModuleKey() {}

    public EtudiantModuleKey(Long etudiantId, Long moduleId) {
        this.etudiantId = etudiantId;
        this.moduleId = moduleId;
    }

    // Getters/Setters
    public Long getEtudiantId() { return etudiantId; }
    public void setEtudiantId(Long id) { this.etudiantId = id; }

    public Long getModuleId() { return moduleId; }
    public void setModuleId(Long id) { this.moduleId = id; }

    // equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EtudiantModuleKey)) return false;
        EtudiantModuleKey that = (EtudiantModuleKey) o;
        return Objects.equals(etudiantId, that.etudiantId) &&
               Objects.equals(moduleId, that.moduleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etudiantId, moduleId);
    }
}
