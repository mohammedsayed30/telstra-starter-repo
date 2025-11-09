package au.com.telstra.simcardactivator.simcard.dto;

public class ActuateRequest {
    public String iccId;

    public ActuateRequest(String iccId) {
        this.iccId = iccId;
    }

    public String getIccId() {
        return iccId;
    }


}
