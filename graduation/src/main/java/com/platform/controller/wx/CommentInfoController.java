package com.platform.controller.wx;

import com.platform.controller.ApplicationController;
import com.platform.service.ICommentInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @description:
 * @author: Air
 * @date: 2019-03-22 13:37
 */
@Controller
@RequestMapping(value = "wx/comment")
@ResponseBody
public class CommentInfoController extends ApplicationController {

    @Resource
    private ICommentInfoService commentInfoService;

    @RequestMapping(value = "list")
    public Object list(@RequestBody HashMap<String,Object> search){
        return commentInfoService.list(search);
    }

}
