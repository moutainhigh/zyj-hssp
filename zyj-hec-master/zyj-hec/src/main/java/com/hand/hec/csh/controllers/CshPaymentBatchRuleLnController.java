package com.hand.hec.csh.controllers;

import org.springframework.stereotype.Controller;

import com.hand.hap.mybatis.common.Criteria;
import com.hand.hap.mybatis.common.query.Comparison;
import com.hand.hap.mybatis.common.query.WhereField;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import com.hand.hec.csh.dto.CshPaymentBatchRuleLn;
import com.hand.hec.csh.service.ICshPaymentBatchRuleLnService;

/**
 *
 * 付款批规则定义-生成规则控制器
 *
 * @author luhui 2019-03-01
 */

@Controller
@RequestMapping(value = "/csh/payment-batch-rule-ln")
public class CshPaymentBatchRuleLnController extends BaseController{

    @Autowired
    private ICshPaymentBatchRuleLnService service;

    @RequestMapping(value = "/query",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResponseData query(CshPaymentBatchRuleLn dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
        @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        Criteria criteria = new Criteria(dto);
        criteria.where(new WhereField(CshPaymentBatchRuleLn.FIELD_RULE_ID,Comparison.EQUAL));
        return new ResponseData(service.selectOptions(requestContext,dto,criteria,page,pageSize));
    }

    @RequestMapping(value = "/submit")
    @ResponseBody
    public ResponseData update(@RequestBody List<CshPaymentBatchRuleLn> dto, BindingResult result, HttpServletRequest request){
        getValidator().validate(dto, result);
        if (result.hasErrors()) {
        ResponseData responseData = new ResponseData(false);
        responseData.setMessage(getErrorMessage(result, request));
        return responseData;
        }
        IRequest requestCtx = createRequestContext(request);
        return new ResponseData(service.batchUpdate(requestCtx, dto));
    }

    @RequestMapping(value = "/remove")
    @ResponseBody
    public ResponseData delete(HttpServletRequest request,@RequestBody List<CshPaymentBatchRuleLn> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }
}