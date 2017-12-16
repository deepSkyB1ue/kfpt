package com.gaeainfo.module.applyforkey.dao;


import com.gaeainfo.module.applyforkey.entity.TKfptKeyEntity;

import java.util.List;
import java.util.Map;

public interface ApplyForKeyDao {

    Map<String, Object> getInfo(String str, int pageNum) throws Exception;

}
