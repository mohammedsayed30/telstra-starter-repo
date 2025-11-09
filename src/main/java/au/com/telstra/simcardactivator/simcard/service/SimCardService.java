package au.com.telstra.simcardactivator.simcard.service;

import au.com.telstra.simcardactivator.simcard.model.SimCard;
import au.com.telstra.simcardactivator.simcard.repository.SimCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

@Service
public class SimCardService {

    @Autowired
    private SimCardRepository simCardRepository;
    @Autowired
    private  Validator validator;


    public SimCard save(String iccId, String email, boolean isSuccess) {
        SimCard simCard = new SimCard();

        simCard.setIccId(iccId);
        simCard.setCustomerEmail(email);
        simCard.setActive(isSuccess);


        //record the raw
        return simCardRepository.save(simCard);

    }

}
