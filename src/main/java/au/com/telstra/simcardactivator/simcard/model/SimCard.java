package au.com.telstra.simcardactivator.simcard.model;

import javax.persistence.*;

@Entity
public class SimCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String iccId;

    @Column(nullable = false)
    String customerEmail;

    @Column(nullable = false)
    boolean active;

    // No-arg constructor required by JPA
    public SimCard() {}

    // Convenience constructor
    public SimCard(String iccId, String customerEmail, boolean active) {
        this.iccId = iccId;
        this.customerEmail = customerEmail;
        this.active = active;
    }

    // Getters and setters
    public Long getId() { return id; }

    public String getIccId() { return iccId; }
    public void setIccId(String iccId) { this.iccId = iccId; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
