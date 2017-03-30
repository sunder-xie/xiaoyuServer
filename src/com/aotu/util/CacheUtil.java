package com.aotu.util;

import java.net.URL;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.aotu.entity.MerchantSet;
import com.aotu.service.IMerchantSetService;
import com.aotu.service.IParamService;

@SuppressWarnings("all")
public class CacheUtil {

	@Autowired
	private IParamService iParamService;
	
    private static Log log = LogFactory.getLog(CacheUtil.class);

    private static final String PATH = "/ehcache.xml";

    private static URL url;

    private static CacheManager manager;

    public static CacheManager getCacheManager() {
        if (manager == null) {
            url = CacheUtil.class.getResource(PATH);
            manager = CacheManager.create(url);
        }
        return manager;
    }

    public static Cache getParamCache() {
        return getCacheManager().getCache("paramCache");
    }

    public static String getParamValueByName(String name) {
        String comment = "";
        Element element = getParamCache().get(name);
        if (element == null) {
        	 IParamService paramService = (IParamService)ApplicationContextUtil.getContext().getBean("paramService");
            if (paramService != null) {
                comment = paramService.getParamValueByName(name);
                if (StringUtils.isNotEmpty(comment)) {
                    getParamCache().put(new Element(name, comment));
                }
            }
        }  else {
            comment = (String) element.getObjectValue();
        }

        return comment;
    }
    
    public static MerchantSet getMerchantSet() {
    	MerchantSet merchantSet = null;
    	try {
        	Element element = getParamCache().get("merchantSet");
        	if (element == null) {
        		IMerchantSetService merchantSetService = (IMerchantSetService)ApplicationContextUtil.getContext().getBean("merchantSetService");
        		if (merchantSetService != null) {
        			List<MerchantSet> merchantSetList = merchantSetService.queryList(null);
        			if (merchantSetList != null && merchantSetList.size() > 0) {
        				merchantSet = merchantSetList.get(0);
        				if (merchantSet != null) {
        					getParamCache().put(new Element("merchantSet", merchantSet));
        				}
        			}
        		}
        	} else {
        		merchantSet = (MerchantSet) element.getObjectValue();
        	}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return merchantSet;
    }

    public static void refreshParamByValue(String value) {
        getParamCache().remove(value);
    }
 
    
}
