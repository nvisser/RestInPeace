package nl.bcome.iac.service;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InhabitantResponse {
    private int amount;

    public InhabitantResponse(int amount) {
        this.amount = amount;
    }

    public int getAmount() {

        return amount;
    }

    @XmlElement
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
