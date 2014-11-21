package bit.cms.bean;

import java.io.Serializable;

/**
 * @author Artem.Telizhenko
 *         Date: 19.11.2014
 *         Time: 11:11
 */
public class ParameterBean implements Serializable {
    private static final long serialVersionUID = 5529007207587142214L;

    private String parameterName;
    private Object parameterValue;

    public ParameterBean() {
    }

    public ParameterBean(String parameterName, Object parameterValue) {

        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public Object getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(Object parameterValue) {
        this.parameterValue = parameterValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParameterBean that = (ParameterBean) o;

        if (parameterName != null ? !parameterName.equals(that.parameterName) : that.parameterName != null)
            return false;
        if (parameterValue != null ? !parameterValue.equals(that.parameterValue) : that.parameterValue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = parameterName != null ? parameterName.hashCode() : 0;
        result = 31 * result + (parameterValue != null ? parameterValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ParameterBean{");
        sb.append("parameterName='").append(parameterName).append('\'');
        sb.append(", parameterValue=").append(parameterValue);
        sb.append('}');
        return sb.toString();
    }
}
