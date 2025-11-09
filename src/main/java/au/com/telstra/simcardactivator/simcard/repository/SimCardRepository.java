package au.com.telstra.simcardactivator.simcard.repository;

import au.com.telstra.simcardactivator.simcard.model.SimCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface SimCardRepository extends JpaRepository<SimCard, Long> {
}
