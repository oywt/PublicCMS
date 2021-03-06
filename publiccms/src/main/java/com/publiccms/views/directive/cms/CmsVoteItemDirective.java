package com.publiccms.views.directive.cms;

// Generated 2016-3-3 17:43:34 by com.sanluan.common.source.SourceGenerator

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.publiccms.common.base.AbstractTemplateDirective;
import com.publiccms.entities.cms.CmsVoteItem;
import com.publiccms.logic.service.cms.CmsVoteItemService;
import com.sanluan.common.handler.RenderHandler;

@Component
public class CmsVoteItemDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        Long id = handler.getLong("id");
        if (notEmpty(id)) {
            handler.put("object", service.getEntity(id)).render();
        } else {
            Long[] ids = handler.getLongArray("ids");
            if (notEmpty(ids)) {
                List<CmsVoteItem> entityList = service.getEntitys(ids);
                Map<String, CmsVoteItem> map = new LinkedHashMap<String, CmsVoteItem>();
                for (CmsVoteItem entity : entityList) {
                    map.put(String.valueOf(entity.getId()), entity);
                }
                handler.put("map", map).render();
            }
        }
    }

    @Autowired
    private CmsVoteItemService service;

}
