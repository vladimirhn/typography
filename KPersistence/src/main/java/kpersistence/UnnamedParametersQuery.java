package kpersistence;

import java.util.List;

public class UnnamedParametersQuery {

    private String query;
    private List<Object> params;

    public UnnamedParametersQuery() {
    }

    public UnnamedParametersQuery(String query, List<Object> params) {
        this.query = query;
        this.params = params;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<Object> getParams() {
        return params;
    }

    public void setParams(List<Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "UnnamedParametersQuery{" + "query=" + query + ", params=" + params + '}';
    }
}
