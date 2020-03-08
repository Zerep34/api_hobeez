package com.api.java_backend.hobeez.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Coupons {

    @Id
    private int id;

    @NotNull
    private String code_value;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date start_date;

    @Temporal(TemporalType.DATE)
    private Date end_date;

    @NotNull
    private String description;

    @NotNull
    private int reduction_amount;

    @NotNull
    private boolean global_value;

    private int nb_utilisation;

    @NotNull
    private String devise;

    public Coupons(){}

    public Coupons(int code, String code_value, @NotNull Date startDate, Date endDate, @NotNull String description, @NotNull int reductionAmount, @NotNull boolean global, int nbUtilisation, @NotNull String devise) {
        this.id = code;
        this.code_value = code_value;
        this.start_date = startDate;
        this.end_date = endDate;
        this.description = description;
        this.reduction_amount = reductionAmount;
        this.global_value = global;
        this.nb_utilisation = nbUtilisation;
        this.devise = devise;
    }

    public Date getStartDate() {
        return start_date;
    }

    public void setStartDate(Date startDate) {
        this.start_date = startDate;
    }

    public Date getEndDate() {
        return end_date;
    }

    public void setEndDate(Date endDate) {
        this.end_date = endDate;
    }

    public int getReductionAmount() {
        return reduction_amount;
    }

    public void setReductionAmount(int reductionAmount) {
        this.reduction_amount = reductionAmount;
    }

    public boolean isGlobal() {
        return global_value;
    }

    public void setGlobal(boolean global) {
        this.global_value = global;
    }

    public int getNbUtilisation() {
        return nb_utilisation;
    }

    public void setNbUtilisation(int nbUtilisation) {
        this.nb_utilisation = nbUtilisation;
    }

    @Override
    public String toString() {
        return "Coupons{" +
                "code=" + id +
                ", startDate=" + start_date +
                ", endDate=" + end_date +
                ", description='" + description + '\'' +
                ", reductionAmount=" + reduction_amount +
                ", global=" + global_value +
                ", nbUtilisation=" + nb_utilisation +
                ", devise='" + devise + '\'' +
                '}';
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public int getCode() {
        return id;
    }

    public void setCode(int code) {
        this.id = code;
    }

    public String getCode_value() {
        return code_value;
    }

    public void setCode_value(String code_value) {
        this.code_value = code_value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
