package rest;

public interface EndPoint {

    String SELF = "self";
    String USERS_PATH = "/u";

    String CONSUMABLES = EndPoint.USERS_PATH + "/consumables";
    String CONSUMABLE_TYPES = EndPoint.USERS_PATH + "/consumable_types";
    String CONSUMABLE_PROPERTIES = EndPoint.USERS_PATH + "/consumable_properties";
    String CONSUMABLE_ITEMS = EndPoint.USERS_PATH + "/consumable_items";
    String LEGAL_ENTITIES = EndPoint.USERS_PATH + "/legal_entities";
    String ENTERPRISES = EndPoint.USERS_PATH + "/enterprises";
    String MONEY_MOVEMENTS = EndPoint.USERS_PATH + "/money_movements";

    String ORDER_SUBJECTS = EndPoint.USERS_PATH + "/order_subjects";
    String ORDER_SUBJECTS_TYPES = EndPoint.USERS_PATH + "/order_subjects_types";


    String FINANCIAL_TRANSACTIONS = EndPoint.USERS_PATH + "/financial_transactions";
}
