package hilfling.backend.hilfing.repositories;

import hilfling.backend.hilfing.model.PhotoGangBangerPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoGangBangerPositionRepository extends JpaRepository<PhotoGangBangerPosition, Long> {
}
