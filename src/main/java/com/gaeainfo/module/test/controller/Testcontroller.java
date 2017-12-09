package com.gaeainfo.module.test.controller;

import com.gaeainfo.framework.core.basic.dto.BaseRequestDto;
import com.gaeainfo.framework.core.basic.dto.BaseResponseDto;
import com.gaeainfo.module.base.annotation.CheckRequestToken;
import com.gaeainfo.module.base.bo.GaeaToken;
import com.gaeainfo.module.base.service.CheckTokenService;
import com.gaeainfo.module.test.bo.Ouser;
import com.gaeainfo.module.test.service.OracleUserService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Rock on 2017/2/7.
 */
@Controller
@RequestMapping(value = "test",method = RequestMethod.POST)
public class Testcontroller {

    @Autowired
    private OracleUserService oracleUserService;

    @Autowired
    private CheckTokenService checkTokenService;

    @RequestMapping("index")
    @ResponseBody
    @CheckRequestToken(false)
    public String test(HttpServletRequest request){
        if(request.getSession().getAttribute("a") == null){
            String uuid = UUID.randomUUID().toString();
            request.getSession().setAttribute("a", uuid);
            System.out.println("=======写入session: a = " + uuid);
        }
        else
            System.out.println("=======读取session: a = " + request.getSession().getAttribute("a"));
        GaeaToken gaeaToken = new GaeaToken();
        gaeaToken.setLoginName("000456");
        checkTokenService.saveToken("a",gaeaToken);
        return "OK";
    }

    @RequestMapping("index2")
    @ResponseBody
//    @CheckRequestToken(roleName = "ABC",excludeRoleName = {"sss","ssss"})
    @CheckRequestToken(false)
    public String test2(){
        return checkTokenService.getToken("a").getLoginName();
    }

    @ApiOperation(value = "测试",notes = "返回一个数据对象")
    @RequestMapping("index3")
    @ResponseBody
    @CheckRequestToken(false)
    public BaseResponseDto test3(@RequestBody BaseRequestDto baseRequestDto){
        BaseResponseDto baseResponseDto = new BaseResponseDto();
        baseResponseDto.setSuccess(true);
        List<Ouser> list = oracleUserService.getUserList();
        baseResponseDto.setMsg("测试消息");
        baseResponseDto.setData(list.toString());
        return baseResponseDto;
    }

    public ResponseEntity<byte[]> download(String fileName, File file) throws IOException {
        String dfileName = new String(fileName.getBytes("gb2312"), "iso8859-1");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", dfileName);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

}
