package temp.items;

import temp.items.parameters.Parameter;
import temp.items.parameters.Season;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: Anton Krupnov
 * Date: 24.09.13
 * Time: 23:50
 */
public class ItemImpl implements Item {

    private final List<Parameter> parameters = new ArrayList<Parameter>();
    private final String name;

    public ItemImpl(String name, Parameter... parameters) {
        this.parameters.addAll(Arrays.asList(parameters));
        this.name = name;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ItemImpl{" +
                "name='" + name + '\'' +
                '}';
    }
}
