package rest;

public interface EndPoint {

    String SELF = "self";
    String USERS_PATH = "/u";

    String CONSUMABLES = EndPoint.USERS_PATH + "/consumables";
    String CONSUMABLE_ITEMS = EndPoint.USERS_PATH + "/consumable_items";
    String LEGAL_ENTITIES = EndPoint.USERS_PATH + "/legal_entities";
    String ENTERPRISES = EndPoint.USERS_PATH + "/enterprises";
}
