package rest.enterprises;

import domain.models.enterprises.FinancialTransaction;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.abstracts.TypoViewController;
import service.AbstractViewService;

@RestController
@RequestMapping(EndPoint.FINANCIAL_TRANSACTIONS)
public class FinancialTransactionsViewController extends TypoViewController<FinancialTransaction> implements TypoServiceUser {

    @Override
    protected AbstractViewService<FinancialTransaction> getService() {
        return financialTransactionsViewService;
    }
}
