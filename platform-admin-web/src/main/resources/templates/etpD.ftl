<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <title></title>
    <style type="text/css">

        body {
            font-family: pingfang sc light;
        }


        .center{
            text-align: center;
            width: 100%;
        }


        .aa
        {
            position: fixed;
            top: 0px;
            left: 0px;
            right: 0px;
            margin-left:auto;
            margin-right:auto;
        }



    </style>
</head>

<body>
<div class="center">
    企业评估报告
</div>

<div class="aa">
    ${read.entName}
</div>

<div class="center">
    非财务风险数字解读
</div>

<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <td style="width:320px">法律安全:</td>
            <td style="width:320px">${read.legalScore!''}</td>
        </tr>
        <tr>
            <td >行业能力:</td>
            <td>${read.industryScore!''}</td>
        </tr>
        <tr>
            <td >金融供给:</td>
            <td>${read.finScore!''}</td>
        </tr>
        <tr>
            <td >企业能力:</td>
            <td>
                ${read.etpScore!''}
            </td>
        </tr>
        <tr>
            <td >区域经济:</td>
            <td>
                ${read.areaScore!''}
            </td>
        </tr>

    </table>
</div>

<div class="center">
    工商信息
</div>

<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <td style="width:160px">统一社会信用代码:</td>
            <td style="width:160px">${basic.creditCode!''}</td>
            <td style="width:160px">经营状态:</td>
            <td style="width:160px">${basic.regState!''}</td>
        </tr>

        <tr>
            <td >所属行业:</td>
            <td >${basic.industry!''}</td>
            <td >成立日期:</td>
            <td >${basic.regDate?string('yyyy-MM-dd')}</td>
        </tr>

        <tr>
            <td >公司类型:</td>
            <td >${basic.type!''}</td>
            <td >经营期限:</td>
            <td >${basic.businessStartFinish!''}</td>
        </tr>

        <tr>
            <td >法定代表人:</td>
            <td >${basic.legalRep!''}</td>
            <td >核准日期:</td>
            <td >${basic.checkDate?string('yyyy-MM-dd')}</td>
        </tr>

        <tr>
            <td >注册资本:</td>
            <td >${basic.regCapital!''}</td>
            <td >登记机关:</td>
            <td >${basic.regOffice!''}</td>
        </tr>

        <tr>
            <td >企业地址:</td>
            <td colspan="3">${basic.address!''}</td>

        </tr>

        <tr>
            <td >经营范围:</td>
            <td colspan="3">${basic.businessScope!''}</td>

        </tr>

    </table>
</div>

<div class="center">
    股东信息
</div>

<div class="center">

    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width:128px">股东</th>
            <th style="width:128px">持股比例</th>
            <th style="width:128px">认缴出资金额(万元)</th>
            <th style="width:128px">认缴出资日期</th>
            <th style="width:128px">股东类型</th>
        </tr>

        <#list basic.etpShareholder as item>
            <tr>
                <td >${item.etpId!''}</td>
                <td >${item.rate!''}</td>
                <td >${item.confusingAmount!''}</td>
                <td >${item.confusingDate?string('yyyy-MM-dd')}</td>
                <td >${item.holderTypeName!''}</td>
            </tr>
        </#list>



    </table>
</div>

<div class="center">
    成员信息
</div>
<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width:320px">姓名</th>
            <th style="width:320px">职位</th>
        </tr>
        <#list basic.etpSeniorManager as item>
            <tr>
                <td >${item.name!''}</td>
                <td >${item.position!''}</td>
            </tr>
        </#list>


    </table>
</div>


<div class="center">
    对外投资
</div>
<div class="center">

    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width:105px">被投资企业名称</th>
            <th style="width:105px">被投资企业法定代表人</th>
            <th style="width:105px">出资资本</th>
            <th style="width:105px">出资比例</th>
            <th style="width:105px">成立日期</th>
            <th style="width:105px">状态</th>
        </tr>

        <#list basic.outward as item>
            <tr>
                <td >${item.etpName!''}</td>
                <td >${item.legalRep!''}</td>
                <td >${item.confusingAmount!''}</td>
                <td >${item.rate!''}</td>
                <td >${item.regDate?string('yyyy-MM-dd')}</td>
                <td >${item.regStateCN!''}</td>
            </tr>
        </#list>

    </table>

</div>

<div class="center">
    变更信息
</div>
<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width:160px">变更时间</th>
            <th style="width:160px">变更事项</th>
            <th style="width:160px">变更前</th>
            <th style="width:160px">变更后</th>
        </tr>

        <#list basic.etpAlter as item>
            <tr>
                <td >${item.changeDate?string('yyyy-MM-dd')}</td>
                <td >${item.changeEvent!''}</td>
                <td >${item.preChange!''}</td>
                <td >${item.aftChange!''}</td>
            </tr>
        </#list>

    </table>
</div>


<div class="center">
    裁判文书
</div>


<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 180px">裁判文书/判决结果</th>
            <th style="width: 120px">案由</th>
            <th style="width: 110px">案件身份</th>
            <th style="width: 120px">案件号</th>
            <th style="width: 110px">审结时间</th>
        </tr>


         <#list risk.crdCourt as item>
            <tr>
                <td >${item.approvalReslut!''}</td>
                <td >${item.caseCause!''}</td>
                <td >
                    <#if item.text=='defendant'>
							被告
                    <#elseif item.text=='plaintiff'>
							原告
                    <#else>
                        无
                    </#if>

                </td>
                <td >${item.caseNum!''}</td>
                <td >${item.approvalDateYM!''}</td>
            </tr>
         </#list>

    </table>
</div>

<div class="center">
    法院公告
</div>
<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 210px">发布时间</th>
            <th style="width: 210px">公告类型</th>
            <th style="width: 210px">公告内容</th>
        </tr>
        <#list risk.crdCourtPub as item>
            <tr>
                <td >${item.pubDate?string('yyyy-MM-dd')}</td>
                <td >${item.pubType!''}</td>
                <td >${item.pubContent!''}</td>
            </tr>
        </#list>

    </table>
</div>

<div class="center">
    被执行人
</div>
<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 140px">被执行人或组织机构</th>
            <th style="width: 120px">案号</th>
            <th style="width: 120px">执行标的</th>
            <th style="width: 140px">执行法院</th>
            <th style="width: 120px">立案时间</th>
        </tr>
        <#list risk.crdExecuted as item>
            <tr>
                <td >${item.executed!''}</td>
                <td >${item.caseNum!''}</td>
                <td >${item.subjectMatter!''}</td>
                <td >${item.courtName!''}</td>
                <td >${item.openTime?string('yyyy-MM-dd')}</td>
            </tr>
        </#list>
    </table>
</div>



<div class="center">
    经营异常
</div>
<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 100px">列入时间</th>
            <th style="width: 100px">作出决定机关（列入）</th>
            <th style="width: 120px">列入经营异常名录原因</th>
            <th style="width: 100px">移除时间</th>
            <th style="width: 100px">作出决定机关（移出）</th>
            <th style="width: 120px">移出经营异常名录原因</th>
        </tr>
        <#list risk.etpAbnormal as item>
            <tr>
                <td >${item.enrolDate?string('yyyy-MM-dd')}</td>

                <td >${item.enrolOffice!''}</td>
                <td >${item.enrolReason!''}</td>
                <td >${item.removeDate?string('yyyy-MM-dd')}</td>
                <td >${item.removeOffice!''}</td>
                <td >${item.removeReason!''}</td>
            </tr>
        </#list>

    </table>
</div>

<div class="center">
    行政处罚
</div>
<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 120px">处罚决定日期</th>
            <th style="width: 120px">决定文书号</th>
            <th style="width: 100px">违法行为类型</th>
            <th style="width: 120px">决定机关名称</th>
            <th style="width: 160px">行政处罚内容</th>
        </tr>

        etpPunish

        <#list risk.etpPunish as item>
            <tr>
                <td >${item.punishDate?string('yyyy-MM-dd')}</td>
                <td >${item.decisionNum!''}</td>
                <td >${item.ilegalType!''}</td>
                <td >${item.officeName!''}</td>
                <td >${item.content!''}</td>
            </tr>
        </#list>

    </table>
</div>

<div class="center">
    股权出质
</div>

<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 100px">登记日期</th>
            <th style="width: 100px">登记编号</th>
            <th style="width: 100px">出质人</th>
            <th style="width: 100px">出质股权数额</th>
            <th style="width: 100px">质权人</th>
            <th style="width: 100px">状态</th>
        </tr>

        <#list risk.etpStock as item>
            <tr>
                <td >${item.regDate?string('yyyy-MM-dd')}</td>
                <td >${item.regNum!''}</td>
                <td >${item.pledgor!''}</td>
                <td >${item.stockAmount!''}</td>
                <td >${item.pledgee!''}</td>
                <td >${item.state!''}</td>
            </tr>
        </#list>


    </table>
</div>



<div class="center">
    动产抵押
</div>

<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 120px">登记日期</th>
            <th style="width: 160px">登记机关</th>
            <th style="width: 120px">被担保债券</th>
            <th style="width: 120px">公式日期</th>
            <th style="width: 100px">状态</th>
        </tr>


        <#list risk.etpChattel as item>
            <tr>
                <td >${item.recordDate?string('yyyy-MM-dd')}</td>
                <td >${item.regAuthority!''}</td>
                <td >${item.claimsAmount!''}</td>
                <td >${item.publicityDate?string('yyyy-MM-dd')}</td>
                <td >${item.state!''}</td>
            </tr>
        </#list>


    </table>
</div>

<div class="center">
    关系企业风险矩阵
</div>

<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 120px">企业名称</th>
            <th style="width: 100px">失信</th>
            <th style="width: 120px">裁判文书</th>
            <th style="width: 100px">法院公告</th>
            <th style="width: 100px">被执行人</th>
            <th style="width: 100px">涉税</th>
        </tr>

         <#list risk.legalScore as item>
            <tr>
                <td >${item.entName!''}</td>
                <td >${item.breakFaithCount!''}</td>
                <td >${item.pubCount!''}</td>
                <td >${item.courtCount!''}</td>
                <td >${item.executedCount!''}</td>
                <td >${item.legalCount!''}</td>
            </tr>
         </#list>
    </table>
</div>


<div class="center">
    关联事件判定
</div>

<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 160px">裁判结果</th>
            <th style="width: 120px">案由</th>
            <th style="width: 140px">案件号</th>
            <th style="width: 120px">案件身份</th>
            <th style="width: 100px">审结时间</th>
        </tr>

        <#list risk.relateCrdCourt as item>
            <tr>
                <td >${item.approvalReslut!''}</td>
                <td >${item.caseCause!''}</td>
                <td >${item.caseNum!''}</td>
                <td >${item.judges!''}</td>
                <td >${item.approvalDateYM!''}</td>
            </tr>
        </#list>


    </table>
</div>


<div class="center">
    行业表现
</div>

<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 160px">应收款账期</th>
            <th style="width: 160px">存货周转时长</th>
            <th style="width: 160px">行业平均税负</th>
            <th style="width: 160px">行业成本/营业收入</th>

        </tr>


            <tr>
                <td >${industry.yszk!''}</td>
                <td >${industry.chzz!''}</td>
                <td >${industry.addedTax!''}</td>
                <td >${industry.rgcb!''}</td>
            </tr>

    </table>
</div>

<div class="center">
    季节性波动
</div>

<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 52px">1月</th>
            <th style="width: 52px">2月</th>
            <th style="width: 52px">3月</th>
            <th style="width: 52px">4月</th>
            <th style="width: 52px">5月</th>
            <th style="width: 52px">6月</th>
            <th style="width: 52px">7月</th>
            <th style="width: 52px">8月</th>
            <th style="width: 52px">9月</th>
            <th style="width: 52px">10月</th>
            <th style="width: 52px">11月</th>
            <th style="width: 52px">2月</th>
        </tr>
        <tr>
            <td>
                ${industry.industrySeason.m1!''}
            </td>
            <td>
                ${industry.industrySeason.m2!''}
            </td>
            <td>
                ${industry.industrySeason.m3!''}
            </td>
            <td>
                ${industry.industrySeason.m4!''}
            </td>
            <td>
                ${industry.industrySeason.m5!''}
            </td>
            <td>
                ${industry.industrySeason.m6!''}
            </td>
            <td>
                ${industry.industrySeason.m7!''}
            </td>
            <td>
                ${industry.industrySeason.m8!''}
            </td>
            <td>
                ${industry.industrySeason.m9!''}
            </td>
            <td>
                ${industry.industrySeason.m10!''}
            </td>
            <td>
                ${industry.industrySeason.m11!''}
            </td>
            <td>
                ${industry.industrySeason.m12!''}
            </td>
        </tr>
    </table>
</div>




<div class="center">
    产业链内部关联特征
</div>

<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 160px">节点主体</th>
            <th style="width: 160px">资金关联特征</th>
            <th style="width: 160px">风险关联特征</th>
            <th style="width: 160px">议价能力</th>

        </tr>
        <#list industry.industryTzList as item>
            <tr>
                <td >${item.tzJdzt!''}</td>
                <td >${item.tzZjgltz!''}</td>
                <td >${item.tzFxgltz!''}</td>
                <td >${item.tzYjnl!''}</td>
            </tr>
        </#list>

    </table>
</div>


<div class="center">
    商标
</div>
<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 160px">商标名称</th>
            <th style="width: 160px">申请时间</th>
            <th style="width: 160px">注册号</th>
            <th style="width: 160px">类别</th>
        </tr>

        <#list aptitude.etpBrandList as item>
            <tr>
                <td >${item.brandName!''}</td>
                <td >${item.regNoticeDate?string('yyyy-MM-dd')}</td>
                <td >${item.regCode!''}</td>
                <td >${item.typeId!''}</td>
            </tr>
        </#list>

    </table>
</div>


<div class="center">
    行政许可
</div>
<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 160px">许可文件编号</th>
            <th style="width: 160px">许可文件名称</th>
            <th style="width: 160px">有效期自</th>
            <th style="width: 160px">有效期至</th>

        </tr>

        <#list aptitude.etpLicenceList as item>
            <tr>
                <td >${item.permissionNumber!''}</td>
                <td >${item.permissionName!''}</td>
                <td >${item.startDate?string('yyyy-MM-dd')}</td>
                <td >${item.finishDate?string('yyyy-MM-dd')}</td>
            </tr>
        </#list>

    </table>
</div>

<div class="center">
    海关税务评级
</div>
<div class="center">
    <table border="1" style="border-collapse:collapse;">
        <tr>
            <th style="width: 320px">税务</th>
            <th style="width: 320px">海关</th>

        </tr>
        <tr>
            <td>
                ${aptitude.taxRate!''}
            </td>
            <td>
                ${aptitude.customRate!''}
            </td>

        </tr>
    </table>
</div>


</body>
</html>