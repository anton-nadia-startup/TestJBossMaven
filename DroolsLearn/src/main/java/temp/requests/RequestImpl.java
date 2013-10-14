package temp.requests;

import temp.items.parameters.Parameter;

import java.util.*;

/**
 * User: Anton Krupnov
 * Date: 24.09.13
 * Time: 23:55
 */
public class RequestImpl implements Request {

    private List<Parameter> parameters = new ArrayList<Parameter>();

    public RequestImpl(Parameter... parameters) {
        this.parameters.addAll(Arrays.asList(parameters));
    }

    public RequestImpl addParameter(Parameter parameter) {
        this.parameters.add(parameter);
        return this;
    }

    @Override
    public Collection<Parameter> getParameters() {
        return Collections.unmodifiableList(parameters);
    }
}
