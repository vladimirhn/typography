package domain.models.enterprises;

import com.fasterxml.jackson.annotation.JsonFormat;
import kpersistence.mapping.annotations.*;
import repository.tables.UserIdAbstractView;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ALL_FINANCIAL_TRANSACTIONS_VIEW")
public class FinancialTransaction extends UserIdAbstractView {

    @Column(name = "TRANSACTION_DATE")
    @OrderBy(direction = Direction.DESC)
    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDateTime transactionDate;

    @Column(name = "MONEY_AMOUNT")
    BigDecimal moneyAmount;

    @Column(name = "TRANSACTION_TYPE")
    String transactionType;

    @Column(name = "SUMMARY")
    String summary;

    @Column(name = "ITEMS_AMOUNT")
    BigDecimal itemsAmount;

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(BigDecimal moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public BigDecimal getItemsAmount() {
        return itemsAmount;
    }

    public void setItemsAmount(BigDecimal itemsAmount) {
        this.itemsAmount = itemsAmount;
    }
}
