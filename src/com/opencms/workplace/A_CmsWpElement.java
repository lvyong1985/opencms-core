package com.opencms.workplace;

import com.opencms.core.*;
import com.opencms.file.*;

public abstract class A_CmsWpElement implements I_CmsWpElement, I_CmsWpConstants {
    
    protected static CmsXmlWpButtonsDefFile m_buttondef = null;
    
    /**
     * Reference to the label defintion file
     */
    protected static CmsXmlWpLabelDefFile m_labeldef = null;
    
    protected static String m_workplaceElementPath = null;
    
    
    public CmsXmlWpButtonsDefFile getButtonDefinitions(A_CmsObject cms) throws CmsException {
        if(m_buttondef == null) {
            if(m_workplaceElementPath == null) {
                CmsXmlWpConfigFile configFile = new CmsXmlWpConfigFile(cms);
                m_workplaceElementPath = configFile.getWorkplaceElementPath();
            }
            m_buttondef = new CmsXmlWpButtonsDefFile(cms, m_workplaceElementPath + C_BUTTONTEMPLATE);
        }
        return m_buttondef;
    }
    
    /**
     * Reads the label definition file.
     * @param cms The actual cms object
     * @return Reference to the label defintion file.
     */
     public CmsXmlWpLabelDefFile getLabelDefinitions(A_CmsObject cms) throws CmsException {
        if(m_labeldef == null) {
            if(m_workplaceElementPath == null) {
                CmsXmlWpConfigFile configFile = new CmsXmlWpConfigFile(cms);
                m_workplaceElementPath = configFile.getWorkplaceElementPath();
            }
            m_labeldef = new CmsXmlWpLabelDefFile(cms, m_workplaceElementPath + C_LABELTEMPLATE);
        }
        return m_labeldef;
    }
}
