package bit.cms.core.helper;

import bit.cms.core.controller.Controller;

import java.io.Serializable;

/**
 * Created by bito4ek on 23.11.14.
 */
public interface Helper extends Serializable {
    public Controller getController();
}
