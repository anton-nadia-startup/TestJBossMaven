package temp.requests;

import temp.items.parameters.Parameter;

import java.util.Collection;

/**
 * User: Anton Krupnov
 * Date: 24.09.13
 * Time: 23:49
 */
public interface Request {

    Collection<Parameter> getParameters();
}
