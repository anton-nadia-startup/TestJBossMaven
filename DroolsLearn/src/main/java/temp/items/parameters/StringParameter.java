package temp.items.parameters;

/**
 * User: Anton Krupnov
 * Date: 26.09.13
 * Time: 23:09
 */
public class StringParameter implements Parameter {
    private String name;

    public StringParameter(String parameterName) {
        name = parameterName;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringParameter that = (StringParameter) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
