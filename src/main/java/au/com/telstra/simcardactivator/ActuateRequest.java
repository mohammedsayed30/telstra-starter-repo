package au.com.telstra.simcardactivator;

public class ActuateRequest {
    public String iccId;

    public ActuateRequest(String iccId) {
        this.iccId = iccId;
    }

    public String getIccId() {
        return iccId;
    }


}
