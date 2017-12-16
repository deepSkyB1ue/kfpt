package com.gaeainfo.module.applyforkey.controller;

import com.gaeainfo.framework.core.basic.dto.BaseRequestDto;
import com.gaeainfo.framework.core.basic.dto.BaseResponseDto;
import com.gaeainfo.module.applyforkey.dao.ApplyForKeyDao;
import com.gaeainfo.module.applyforkey.entity.TAuditEntityRequest;
import com.gaeainfo.module.applyforkey.entity.TKfptKeyEntity;
import com.gaeainfo.module.applyforkey.service.ApplyForKeyService;
import com.gaeainfo.module.base.annotation.CheckRequestToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(value = "applyForKey", description = "申请密钥")
@Controller
@RequestMapping(value = "applyForKey")
public class ApplyForKeyController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApplyForKeyService applyForKeyService;

    @Autowired
    private ApplyForKeyDao applyForKeyDao;

    @ApiOperation(value = "获取申请信息", notes = "返回保存结果")
    @ResponseBody
    @RequestMapping(value = "{username}/{pageInfo}", method = RequestMethod.GET)
    public BaseResponseDto getInfo(@PathVariable("username") String username, @PathVariable("pageInfo") String pageInfo) {
        BaseResponseDto baseResponseDto = new BaseResponseDto();
        baseResponseDto.setTime(System.currentTimeMillis());
        try {
            baseResponseDto.setData(applyForKeyService.getInfo(username, pageInfo));
            baseResponseDto.setSuccess(true);
        } catch (Exception e) {
            baseResponseDto.setSuccess(false);
            e.printStackTrace();
            logger.error("applyForKey.getInfo error:" + e.getMessage());
        }
        return baseResponseDto;
    }

    @ApiOperation(value = "注册密钥", notes = "返回保存结果")
    @ResponseBody
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public BaseResponseDto<String> insert(@RequestBody BaseRequestDto<TKfptKeyEntity> baseRequestDto) {
        BaseResponseDto<String> baseResponseDto = new BaseResponseDto();
        baseResponseDto.setTime(baseRequestDto.getTime());
        try {
            baseResponseDto.setData(applyForKeyService.insert(baseRequestDto.getData()));
            baseResponseDto.setSuccess(true);
        } catch (Exception e) {
            baseResponseDto.setSuccess(false);
            baseResponseDto.setData("注册失败，请检查注册信息！");
            e.printStackTrace();
            logger.error("applyForKey.insert error:" + e.getMessage());
        }
        return baseResponseDto;
    }

    @ApiOperation(value = "删除注册", notes = "返回保存结果")
    @ResponseBody
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseResponseDto<String> delete(@RequestBody BaseRequestDto<String> baseRequestDto) {
        BaseResponseDto<String> baseResponseDto = new BaseResponseDto();
        baseResponseDto.setTime(baseRequestDto.getTime());
        try {
            applyForKeyService.delete(baseRequestDto.getData());
            baseResponseDto.setData("删除成功！");
            baseResponseDto.setSuccess(true);
        } catch (Exception e) {
            baseResponseDto.setSuccess(false);
            baseResponseDto.setData("删除失败，请重试！");
            e.printStackTrace();
            logger.error("applyForKey.delete error:" + e.getMessage());
        }
        return baseResponseDto;
    }

    @ApiOperation(value = "审核注册", notes = "返回保存结果")
    @ResponseBody
    @RequestMapping(value = "audit", method = RequestMethod.POST)
    public BaseResponseDto<String> audit(@RequestBody BaseRequestDto<TAuditEntityRequest> baseRequestDto) {
        BaseResponseDto<String> baseResponseDto = new BaseResponseDto();
        baseResponseDto.setTime(baseRequestDto.getTime());
        try {
            applyForKeyService.audit(baseRequestDto.getData());
            baseResponseDto.setData("审核通过！");
            baseResponseDto.setSuccess(true);
        } catch (Exception e) {
            baseResponseDto.setSuccess(false);
            baseResponseDto.setData("审核失败，请重试！");
            e.printStackTrace();
            logger.error("applyForKey.audit error:" + e.getMessage());
        }
        return baseResponseDto;
    }
}
