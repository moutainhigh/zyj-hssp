package com.hand.hec.csh.controllers;

import org.springframework.stereotype.Controller;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.ResponseData;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.hand.hec.csh.dto.CshCashFlowFormulaLn;
import com.hand.hec.csh.service.ICshCashFlowFormulaLnService;

/**
 *
 * xx控制器
 *
 * @author xxx YYYY-mm-dd
 */

@Controller
@RequestMapping(value = "/csh/cash-flow-formula-ln")
public class CshCashFlowFormulaLnController extends BaseController{

    @Autowired
    private ICshCashFlowFormulaLnService service;

    @RequestMapping(value = "/query",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResponseData query(CshCashFlowFormulaLn dto, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.select(requestContext,dto,page,pageSize));
    }

    @RequestMapping(value = "/submit")
    @ResponseBody
    public ResponseData update(@RequestBody List<CshCashFlowFormulaLn> dto, BindingResult result, HttpServletRequest request){
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
    public ResponseData delete(HttpServletRequest request,@RequestBody List<CshCashFlowFormulaLn> dto){
        service.batchDelete(dto);
        return new ResponseData();
    }

    @RequestMapping(value = "/queryByItemId",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public ResponseData queryByItemId(Long cashFlowItemId, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(service.queryByItemId(requestContext,cashFlowItemId,page,pageSize));
    }
}