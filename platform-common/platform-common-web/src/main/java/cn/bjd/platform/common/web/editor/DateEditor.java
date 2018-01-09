package cn.bjd.platform.common.web.editor;

import cn.bjd.platform.common.utils.DateHelper;

import java.beans.PropertyEditorSupport;

/**
 * @author huqilang
 */
public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        setValue(DateHelper.parseDate(text));
    }

}
