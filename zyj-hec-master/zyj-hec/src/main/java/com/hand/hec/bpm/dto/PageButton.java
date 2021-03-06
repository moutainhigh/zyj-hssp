package com.hand.hec.bpm.dto;

/**
 * Auto Generated By Code Generator
 * Description:
 */

import com.hand.hap.mybatis.annotation.ExtensionAttribute;
import com.hand.hap.mybatis.common.query.Comparison;
import com.hand.hap.mybatis.common.query.JoinCode;
import com.hand.hap.mybatis.common.query.Where;
import com.hand.hap.system.dto.BaseDTO;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Component
@ExtensionAttribute(disable = true)
@Table(name = "bpm_page_button")
public class PageButton extends BaseDTO {

    public static final String FIELD_BUTTON_ID = "buttonId";
    public static final String FIELD_PAGE_ID = "pageId";
    public static final String FIELD_BUTTON_SEQUENCE = "buttonSequence";
    public static final String FIELD_BUTTON_CODE = "buttonCode";
    public static final String FIELD_BUTTON_DESC = "buttonDesc";
    public static final String FIELD_TEMPLATE_FLAG = "templateFlag";
    public static final String FIELD_ID = "id";
    public static final String FIELD_TEXT = "text";
    public static final String FIELD_CLICK = "click";
    public static final String FIELD_BUTTON_TYPE = "buttonType";
    public static final String FIELD_WIDTH = "width";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_ICON = "icon";
    public static final String FIELD_DISABLED = "disabled";
    public static final String FIELD_HIDDEN = "hidden";
    public static final String FIELD_STYLE = "style";
    public static final String FIELD_BTNSTYLE = "btnstyle";
    public static final String FIELD_OPERATION_TYPE = "operationType";
    public static final String FIELD_OPERATION_TYPE_DESC = "operationTypeDesc";
    public static final String FIELD_BUTTON_TYPE_DESC = "buttonTypeDesc";
    public static final String FIELD_TEXT_DISPLAY = "textDisplay";


    @Id
    @GeneratedValue
    @Where
    private Long buttonId;//按钮ID

    @Where
    private Long pageId;//所属页面ID

    private Long buttonSequence;//组件顺序

    @NotEmpty
    @Length(max = 200)
    @Where(comparison = Comparison.LIKE)
    private String buttonCode;//组件代码

    @Length(max = 200)
    @Where(comparison = Comparison.LIKE)
    private String buttonDesc;//组件描述

    @Length(max = 200)
    private String templateFlag;//模板标志

    @Length(max = 200)
    private String id;//ID

    @Length(max = 200)
    private String text;//按钮文本

    @Length(max = 200)
    private String click;//点击触发方法

    @Length(max = 200)
    private String buttonType;//按钮类型

    private Long width;//宽度

    private Long height;//高度

    @Length(max = 200)
    private String icon;//图标地址

    @Length(max = 200)
    private String disabled;//失效

    @Length(max = 200)
    private String hidden;//隐藏

    @Length(max = 200)
    private String style;//样式

    @Length(max = 200)
    private String btnstyle;//按钮样式

    @NotEmpty
    @Length(max = 200)
    private String operationType;//操作类别 按钮的操作属性（操作/查看）

    @Transient
    @JoinCode(code = "BPM.BUTTON_OPERATOR_TYPE", joinKey = PageButton.FIELD_OPERATION_TYPE)
    private String operationTypeDesc;//

    @Transient
    @JoinCode(code = "BPM.BUTTON_TYPE",joinKey = PageButton.FIELD_BUTTON_TYPE)
    private String buttonTypeDesc;//

    @Transient
    private String textDisplay;//

    public PageButton() {

    }

    public PageButton(TpltButton tpltButton, Long pageId) {
        this.setPageId(pageId);
        this.setTemplateFlag("Y");
        this.setButtonSequence(tpltButton.getButtonSequence());
        this.setButtonCode(tpltButton.getButtonCode());
        this.setButtonDesc(tpltButton.getButtonDesc());
        this.setOperationType(tpltButton.getOperationType());
        this.setId(tpltButton.getId());
        this.setText(tpltButton.getText());
        this.setClick(tpltButton.getClick());
        this.setButtonType(tpltButton.getButtonType());
        this.setWidth(tpltButton.getWidth());
        this.setHeight(tpltButton.getHeight());
        this.setIcon(tpltButton.getIcon());
        this.setDisabled(tpltButton.getDisabled());
        this.setHidden(tpltButton.getHidden());
        this.setStyle(tpltButton.getStyle());
        this.setBtnstyle(tpltButton.getBtnstyle());
    }

    public void setButtonId(Long buttonId) {
        this.buttonId = buttonId;
    }

    public Long getButtonId() {
        return buttonId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setButtonSequence(Long buttonSequence) {
        this.buttonSequence = buttonSequence;
    }

    public Long getButtonSequence() {
        return buttonSequence;
    }

    public void setButtonCode(String buttonCode) {
        this.buttonCode = buttonCode;
    }

    public String getButtonCode() {
        return buttonCode;
    }

    public void setButtonDesc(String buttonDesc) {
        this.buttonDesc = buttonDesc;
    }

    public String getButtonDesc() {
        return buttonDesc;
    }

    public void setTemplateFlag(String templateFlag) {
        this.templateFlag = templateFlag;
    }

    public String getTemplateFlag() {
        return templateFlag;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public String getClick() {
        return click;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }

    public String getButtonType() {
        return buttonType;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getWidth() {
        return width;
    }

    public void setHeight(Long height) {
        this.height = height;
    }

    public Long getHeight() {
        return height;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    public String getDisabled() {
        return disabled;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    public String getHidden() {
        return hidden;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyle() {
        return style;
    }

    public void setBtnstyle(String btnstyle) {
        this.btnstyle = btnstyle;
    }

    public String getBtnstyle() {
        return btnstyle;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getOperationTypeDesc() {
        return operationTypeDesc;
    }

    public void setOperationTypeDesc(String operationTypeDesc) {
        this.operationTypeDesc = operationTypeDesc;
    }

    public String getButtonTypeDesc() {
        return buttonTypeDesc;
    }

    public void setButtonTypeDesc(String buttonTypeDesc) {
        this.buttonTypeDesc = buttonTypeDesc;
    }

    public String getTextDisplay() {
        return textDisplay;
    }

    public void setTextDisplay(String textDisplay) {
        this.textDisplay = textDisplay;
    }

}
