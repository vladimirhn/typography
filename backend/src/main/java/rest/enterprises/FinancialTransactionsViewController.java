package rest.enterprises;

import domain.models.enterprises.FinancialTransaction;
import domain.services.abstracts.TypoServiceUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rest.EndPoint;
import rest.controllers.AbstractViewController;

@RestController
@RequestMapping(EndPoint.FINANCIAL_TRANSACTIONS)
public class FinancialTransactionsViewController extends AbstractViewController<FinancialTransaction> implements TypoServiceUser {
}
