package com.gaeainfo.module.applyforkey.service;

import com.gaeainfo.module.applyforkey.entity.TAuditEntityRequest;
import com.gaeainfo.module.applyforkey.entity.TKfptKeyEntity;

import java.util.Map;

public interface ApplyForKeyService {

    String insert(TKfptKeyEntity obj) throws Exception;

    Map<String, Object> getInfo(String username, String pageInfo) throws Exception;

    void delete(String pid) throws Exception;

    void audit(TAuditEntityRequest obj) throws Exception;

}
