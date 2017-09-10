package com.tocsyk.messages;

public class ContractMessages {
    protected String GenerationDate;
    protected String FinishingDate;
    protected String ContractType;
    protected String Rate;
    protected String RemainingAmount;
    protected String PaidAmount;
    protected String ContractScore;
    protected String ContractID;

    public String getGenerationDate() {
        return GenerationDate;
    }

    public void setGenerationDate(String generationDate) {
        GenerationDate = generationDate;
    }
}
