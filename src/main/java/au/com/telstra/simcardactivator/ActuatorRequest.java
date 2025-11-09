package au.com.telstra.simcardactivator;


public class ActuatorRequest {
    public String iccId;
    public String customerEmail;

    public ActuatorRequest(String iccId, String customerEmail) {
        this.iccId = iccId;
        this.customerEmail = customerEmail;
    }

    public String getIccId() {
        return iccId;
    }


    public String getCustomerEmail() {
        return customerEmail;
    }

}
